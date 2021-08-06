package com.sujay.simulator.command;

public class CommandExpression implements Expression {

    @Override
    public Command interpret(CommandContext context) {
        assert context != null;
        final String commandString = context.getCommandString();
        String[] commandParts = commandString.split(" ");

        switch (commandParts[0].charAt(0)) {
            case 'a':
                return new AdvanceCommand(context, Integer.parseInt(commandParts[1]));
            case 'l':
                return new TurnLeftCommand(context);
            case 'r':
                return new TurnRightCommand(context);
            case 'q':
                return new QuitCommand(context);
            default:
                throw new IllegalArgumentException(String.format("Command %s not supported", commandString));
        }
    }
}
