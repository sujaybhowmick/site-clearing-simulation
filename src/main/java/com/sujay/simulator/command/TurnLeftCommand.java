package com.sujay.simulator.command;

public class TurnLeftCommand extends AbstractCommand {
    public final CommandType commandType = CommandType.LEFT;

    public TurnLeftCommand(CommandContext context) {
        super(context);
    }

    @Override
    public void execute() {
        context.getBullDozer().turnLeft(this);
    }

    @Override
    public CommandType getCommandType() {
        return commandType;
    }

    @Override
    public String toString() {
        return commandType.toString();
    }
}

