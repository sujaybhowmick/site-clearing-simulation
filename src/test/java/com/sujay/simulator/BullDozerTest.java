package com.sujay.simulator;

import com.sujay.simulator.command.Command;
import com.sujay.simulator.command.CommandContext;
import com.sujay.simulator.command.CommandExpression;
import com.sujay.simulator.command.Expression;
import com.sujay.simulator.sitemap.*;
import com.sujay.simulator.sitemap.reader.MapReader;
import com.sujay.simulator.sitemap.reader.SiteMapReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.StringReader;
import java.util.concurrent.LinkedBlockingQueue;

import static org.assertj.core.api.Assertions.assertThat;

class BullDozerTest {
    private BullDozer bullDozer;
    private Expression expression;

    @BeforeEach
    void setUp() {
        this.expression = new CommandExpression();
        final String input = "oooo\noror\ntooT";
        final MapReader reader = new SiteMapReader(new StringReader(input));
        this.bullDozer = new BullDozer(reader.readMap(), new LinkedBlockingQueue<>());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void moveBullDozer() {
        bullDozer.moveBullDozer(getAdvanceCommand());
        Cell cell = bullDozer.getCurrentPosition();
        assertThat(cell).isEqualTo(new Cell(CellType.CLEAR, new Coordinate(0, 3)));
        assertThat(bullDozer.getVisitedCells().contains(cell)).isTrue();
    }

    @Test
    void turnLeft() {
        bullDozer.moveBullDozer(getAdvanceCommand());
        Cell cell = bullDozer.getCurrentPosition();
        bullDozer.turnLeft(getTurnLeftCommand());
        assertThat(cell).isEqualTo(new Cell(CellType.CLEAR, new Coordinate(0, 3)));
        assertThat(bullDozer.getVisitedCells().contains(cell)).isTrue();
        assertThat(bullDozer.getOrientation()).isEqualTo(Orientation.NORTH);
    }

    @Test
    void turnRight() {
        bullDozer.moveBullDozer(getAdvanceCommand());
        Cell cell = bullDozer.getCurrentPosition();
        bullDozer.turnRight(getTurnLeftCommand());
        assertThat(cell).isEqualTo(new Cell(CellType.CLEAR, new Coordinate(0, 3)));
        assertThat(bullDozer.getVisitedCells().contains(cell)).isTrue();
        assertThat(bullDozer.getOrientation()).isEqualTo(Orientation.SOUTH);
    }

    @Test
    void quit() {
        bullDozer.moveBullDozer(getAdvanceCommand());
        Cell cell = bullDozer.getCurrentPosition();
        bullDozer.quit(getQuitCommand());
        assertThat(bullDozer.getCommandHistory().size()).isEqualTo(1);
    }

    private Command getAdvanceCommand() {
        return expression.interpret(getCommandContext("a 4"));
    }

    private Command getTurnLeftCommand() {
        return expression.interpret(getCommandContext("l"));
    }

    private Command getQuitCommand() {
        return expression.interpret(getCommandContext("q"));
    }

    private CommandContext getCommandContext(String commandString) {
        return new CommandContext(bullDozer, commandString);
    }
}