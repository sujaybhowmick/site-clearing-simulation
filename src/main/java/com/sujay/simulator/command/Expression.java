package com.sujay.simulator.command;

public interface Expression {
    Command interpret(CommandContext commandContext);
}
