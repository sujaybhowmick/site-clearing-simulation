package com.sujay.simulator;

import com.sujay.simulator.command.*;
import com.sujay.simulator.event.SimulationEvent;
import com.sujay.simulator.sitemap.SiteMap;
import com.sujay.simulator.sitemap.reader.MapReader;
import com.sujay.simulator.sitemap.reader.SiteMapReader;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    private static final String HELP_PROMPT = "(l)eft, (r)ight, (a)dvance <n>, (q)uit: ";

    public static void main(String[] args) {
        if(args.length < 2 && !args[0].equals("--file")) {
            printUsage();
        }
        final String fileName = args[1];
        FileReader fileReader = null;
        try {
            fileReader = readFile(fileName);
        } catch (FileNotFoundException e) {
            printFileReadingErrorMessage(String.format("Cannot read file %s", fileName));
        }
        assert fileReader !=  null;

        SiteMapReader.Builder builder = new SiteMapReader.Builder();

        final MapReader<SiteMap> reader = builder.reader(fileReader).build();
        final SiteMap siteMap = reader.readMap();

        final BlockingQueue<SimulationEvent> eventQueue = new LinkedBlockingQueue<>();

        Simulator simulator = new Simulator(eventQueue);
        BullDozer bullDozer = new BullDozer(siteMap, eventQueue);

        Queue<Command> commandQueue = getCommands(bullDozer);
        bullDozer.setCommandQueue(commandQueue);

        Thread bullDozerThread = new Thread(bullDozer);
        Thread simulatorThread = new Thread(simulator);
        simulatorThread.start();
        bullDozerThread.start();
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

    private static void printUsage() {
        System.out.println("java <program> --file <filename>");
        System.exit(-1);
    }

    private static Queue<Command> getCommands(BullDozer bullDozer) {
        Scanner input = new Scanner(System.in);
        final Expression expression = new CommandExpression();
        final Queue<Command> commandQueue = new LinkedList<>();
        while (true) {
            printHelp();
            Command command = expression.interpret(new CommandContext(bullDozer, input.nextLine()));
            commandQueue.add(command);
            if (checkIfQuitCommand(command)) break;
        }
        return commandQueue;
    }

    private static boolean checkIfQuitCommand(Command command) {
        return command instanceof QuitCommand;
    }

    private static void printHelp() {
        System.out.print(HELP_PROMPT);
    }
}
