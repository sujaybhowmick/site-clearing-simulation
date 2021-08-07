package com.sujay.simulator.command;

public class QuitCommand extends AbstractCommand {
    public final CommandType commandType = CommandType.QUIT;

    public QuitCommand(CommandContext context) {
        super(context);
    }

    @Override
    public void execute() {
        context.getBullDozer().quit(this);
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
