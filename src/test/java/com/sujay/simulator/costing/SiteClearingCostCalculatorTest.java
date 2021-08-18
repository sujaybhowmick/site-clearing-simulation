package com.sujay.simulator.costing;

import com.sujay.simulator.BullDozer;
import com.sujay.simulator.command.Command;
import com.sujay.simulator.command.CommandContext;
import com.sujay.simulator.command.CommandExpression;
import com.sujay.simulator.command.Expression;
import com.sujay.simulator.sitemap.Cell;
import com.sujay.simulator.sitemap.SiteMap;
import com.sujay.simulator.sitemap.reader.MapReader;
import com.sujay.simulator.sitemap.reader.SiteMapReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.StringReader;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

import static org.assertj.core.api.Assertions.assertThat;

class SiteClearingCostCalculatorTest {
    private BullDozer bullDozer;
    private Expression expression;
    private CostCalculator costCalculator;

    @BeforeEach
    void setUp() {
        this.expression = new CommandExpression();
        final String input = "oooo\noror\ntooT";
        final MapReader reader = new SiteMapReader(new StringReader(input));
        this.bullDozer = new BullDozer(reader.readMap(), new LinkedBlockingQueue<>());
        this.costCalculator = new SiteClearingCostCalculator();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculate() {
        simulate();
        List<Command> commands = this.bullDozer.getCommandHistory();
        Set<Cell> visitedCells = this.bullDozer.getVisitedCells();
        Map<Cell, Integer> visitedCellsCount = this.bullDozer.getVisitedCellsCount();
        SiteMap siteMap = bullDozer.getSiteMap();
        CalculatorContext context = new CalculatorContext(commands, visitedCells, visitedCellsCount, siteMap);
        CostReport costReport = costCalculator.calculate(context);
        assertThat(costReport.getItems().size()).isEqualTo(5);
        int totalCost = costReport.getItems().stream()
                .map(CostReportItem::getCost)
                .reduce(0, Integer::sum);
        assertThat(totalCost).isEqualTo(41);
    }

    private void simulate() {
        Command a4 = getCommand("a 4");
        this.bullDozer.moveBullDozer(a4);
        Command r = getCommand("r");
        this.bullDozer.turnRight(r);
        this.bullDozer.moveBullDozer(a4);
        Command l = getCommand("l");
        this.bullDozer.turnLeft(l);
        Command a2 = getCommand("a 2");
        this.bullDozer.moveBullDozer(a2);
        this.bullDozer.moveBullDozer(a4);
        this.bullDozer.moveBullDozer(l);
    }

    private Command getCommand(String commandString) {
        return expression.interpret(getCommandContext(commandString));
    }

    private CommandContext getCommandContext(String commandString) {
        return new CommandContext(bullDozer, commandString);
    }
}