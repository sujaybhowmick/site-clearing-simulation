package com.sujay.simulator;

import com.sujay.simulator.command.*;
import com.sujay.simulator.costing.ConsoleRender;
import com.sujay.simulator.costing.CostCalculator;
import com.sujay.simulator.costing.CostReportRender;
import com.sujay.simulator.costing.SiteClearingCostCalculator;
import com.sujay.simulator.event.SimulationEvent;
import com.sujay.simulator.sitemap.SiteMap;
import com.sujay.simulator.sitemap.reader.MapReader;
import com.sujay.simulator.sitemap.reader.SiteMapReader;
import org.apache.commons.cli.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    private static final String HELP_PROMPT = "(l)eft, (r)ight, (a)dvance <n>, (q)uit: ";

    public static void main(String[] args) {
        CommandLine cmd = null;
        try {
            cmd = parseCmdArgs(args);
        } catch (ParseException e) {
            printProgramHelp();
        }

        FileReader fileReader = null;
        assert cmd != null;

        String fileName = cmd.getOptionValue("file");

        try {
            fileReader = readFile(fileName);
        } catch (FileNotFoundException e) {
            printFileReadingErrorMessage(String.format("Cannot read file %s", fileName));
        }
        assert fileReader != null;

        SiteMapReader.Builder builder = new SiteMapReader.Builder();

        final MapReader<SiteMap> reader = builder.reader(fileReader).build();
        final SiteMap siteMap = reader.readMap();

        final BlockingQueue<SimulationEvent> eventQueue = new LinkedBlockingQueue<>();

        Simulator simulator = createSimulatorInstance(eventQueue, cmd.hasOption("extraInfo"));
        BullDozer bullDozer = new BullDozer(siteMap, eventQueue);
        Thread simulatorThread = new Thread(simulator);
        simulatorThread.start();
        printSiteMap(siteMap);
        readCommands(bullDozer);
    }

    private static Simulator createSimulatorInstance(BlockingQueue<SimulationEvent> queue, boolean extraInfo) {
        final CostCalculator costCalculator = new SiteClearingCostCalculator();
        final CostReportRender reportGenerator = new ConsoleRender();
        return extraInfo ?
                new Simulator(costCalculator, reportGenerator, queue, true) :
                new Simulator(costCalculator, reportGenerator, queue);
    }

    private static CommandLine parseCmdArgs(String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        return parser.parse(getOptions(), args);
    }

    private static void printProgramHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("java Main --file <file path> [--extraInfo]", getOptions());
        System.exit(-1);
    }

    private static Options getOptions() {
        Options options = new Options();
        Option fileOption = new Option("f", "file", true, "Site Map file absolute path");
        fileOption.setRequired(true);
        Option extraInfoOption = new Option("e", "extraInfo", false, "Show extra information during simulation");
        options.addOption(fileOption);
        options.addOption(extraInfoOption);
        return options;
    }

    private static FileReader readFile(String fileName) throws FileNotFoundException {
        checkFile(fileName);
        return new FileReader(fileName);
    }

    private static void checkFile(String fileName) {
        final File file = new File(fileName);
        if (!file.exists() && !file.isFile()) {
            printFileReadingErrorMessage(String.format("File %s not found", fileName));
        }
    }

    public static void printFileReadingErrorMessage(String message) {
        System.out.println(message);
        System.exit(-1);
    }

    private static void readCommands(BullDozer bullDozer) {
        System.out.println();
        Scanner input = new Scanner(System.in);
        final Expression expression = new CommandExpression();
        while (true) {
            printSimulatorCommandHelp();
            Command command = expression.interpret(new CommandContext(bullDozer, input.nextLine()));
            bullDozer.execute(command);
            if (checkIfQuitCommand(command)) break;
        }
    }

    private static boolean checkIfQuitCommand(Command command) {
        return command instanceof QuitCommand;
    }

    private static void printSimulatorCommandHelp() {
        System.out.print(HELP_PROMPT);
    }

    private static void printSiteMap(SiteMap siteMap) {
        System.out.println("Site Map Loaded...");
        siteMap.printMap();
    }
}
