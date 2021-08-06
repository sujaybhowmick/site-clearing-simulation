package com.sujay.simulator.command;

import com.sujay.simulator.BullDozer;
import com.sujay.simulator.sitemap.SiteMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;
import static org.assertj.core.api.Assertions.*;

class CommandExpressionTest {
    private Expression expression;
    private BullDozer bullDozer;

    @BeforeEach
    void setUp() {
        this.expression = new CommandExpression();
        this.bullDozer = new BullDozer(new SiteMap(0, 0), new LinkedBlockingQueue<>());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void advanceCommandInterpretation() {
        final String commandString = "a 2";
        Command advanceCommand = getInterpretedCommand(commandString);
        assertThat(advanceCommand).isInstanceOf(AdvanceCommand.class);
        assertThat(advanceCommand.getCommandType()).isEqualTo(CommandType.ADVANCE);
        assertThat(advanceCommand.getArg()).isEqualTo(2);
    }

    @Test
    void turnLeftCommandInterpretation() {
        final String commandString = "l";
        Command advanceCommand = getInterpretedCommand(commandString);
        assertThat(advanceCommand).isInstanceOf(TurnLeftCommand.class);
        assertThat(advanceCommand.getCommandType()).isEqualTo(CommandType.LEFT);
        assertThat(advanceCommand.getArg()).isEqualTo(0);
    }

    @Test
    void turnRightCommandInterpretation() {
        final String commandString = "r";
        Command advanceCommand = getInterpretedCommand(commandString);
        assertThat(advanceCommand).isInstanceOf(TurnRightCommand.class);
        assertThat(advanceCommand.getCommandType()).isEqualTo(CommandType.RIGHT);
        assertThat(advanceCommand.getArg()).isEqualTo(0);
    }

    @Test
    void quitCommandInterpretation() {
        final String commandString = "q";
        Command advanceCommand = getInterpretedCommand(commandString);
        assertThat(advanceCommand).isInstanceOf(QuitCommand.class);
        assertThat(advanceCommand.getCommandType()).isEqualTo(CommandType.QUIT);
        assertThat(advanceCommand.getArg()).isEqualTo(0);
    }

    private Command getInterpretedCommand(String commandString) {
        return expression.interpret(new CommandContext(bullDozer, commandString));
    }
}
