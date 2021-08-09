package com.sujay.simulator;

import com.sujay.simulator.command.Command;
import com.sujay.simulator.command.CommandType;
import com.sujay.simulator.costing.CalculatorContext;
import com.sujay.simulator.costing.CostCalculator;
import com.sujay.simulator.costing.CostReportRender;
import com.sujay.simulator.event.SimulationEvent;
import com.sujay.simulator.sitemap.Cell;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;

public class Simulator implements Runnable {
    private final BlockingQueue<SimulationEvent> eventQueue;
    private final boolean extraInfo;
    private final CostCalculator costCalculator;
    private final CostReportRender reportGenerator;
    private volatile boolean finished = false;


    public Simulator(CostCalculator costCalculator,
                     CostReportRender reportGenerator,
                     BlockingQueue<SimulationEvent> eventQueue,
                     boolean extraInfo) {
        this.eventQueue = eventQueue;
        this.extraInfo = extraInfo;
        this.costCalculator = costCalculator;
        this.reportGenerator = reportGenerator;
    }

    public Simulator(CostCalculator costCalculator,
                     CostReportRender reportGenerator,
                     BlockingQueue<SimulationEvent> eventQueue) {
        this(costCalculator, reportGenerator, eventQueue, false);
    }


    @Override
    public void run() {
        while (!finished) {
            try {
                SimulationEvent event = this.eventQueue.take();

                Command command = event.getCommand();
                if (command.getCommandType() == CommandType.QUIT) {
                    this.finished = true;
                    printSimulationFinishedMessage(event);
                    printCost(event);
                    printGoodByMessage();
                }
                printIfExtraInfoEnabled(event);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printCost(SimulationEvent event) {
        final BullDozer bullDozer = event.getCommand().getContext().getBullDozer();
        CalculatorContext context = new CalculatorContext(bullDozer.getCommandHistory(),
                bullDozer.getVisitedCells(), bullDozer.getVisitedCellsCount(), bullDozer.getSiteMap());
        this.reportGenerator.renderReport(this.costCalculator.calculate(context));
    }

    private void printIfExtraInfoEnabled(SimulationEvent event) {
        if (extraInfo) {
            printSimulationState(event);
            printVisitedCells(event);
        }
    }

    private void printSimulationState(SimulationEvent event) {
        BullDozer bullDozer = event.getCommand().getContext().getBullDozer();
        System.out.println(bullDozer.getCurrentPosition() +
                ", Orientation: " + bullDozer.getOrientation());
    }

    private void printVisitedCells(SimulationEvent event) {
        BullDozer bullDozer = event.getCommand().getContext().getBullDozer();
        List<String> visitedCells = bullDozer.getVisitedCells().stream()
                .map(Cell::toString).collect(Collectors.toList());
        System.out.println(visitedCells);
    }

    private void printSimulationFinishedMessage(SimulationEvent event) {
        String commandHistory = event.getCommand().getContext().getBullDozer().getCommandHistory().stream()
                .map(Command::toString).collect(Collectors.joining(", "));
        System.out.println(commandHistory);
    }

    private void printGoodByMessage() {
        System.out.println("Thank you for using Aconex site clearing simulator");
    }
}

