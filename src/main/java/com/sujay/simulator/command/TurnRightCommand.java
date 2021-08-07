package com.sujay.simulator.command;

public class TurnRightCommand extends AbstractCommand {
    public final CommandType commandType = CommandType.RIGHT;

    public TurnRightCommand(CommandContext context) {
        super(context);
    }

    @Override
    public void execute() {
        context.getBullDozer().turnRight(this);
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
