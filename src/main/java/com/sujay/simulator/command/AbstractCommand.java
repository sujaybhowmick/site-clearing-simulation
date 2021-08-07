package com.sujay.simulator.command;

public abstract class AbstractCommand implements Command {
    protected final CommandContext context;
    protected final int arg;

    public AbstractCommand(CommandContext context, int arg) {
        this.context = context;
        this.arg = arg;
    }

    public AbstractCommand(CommandContext context) {
        this(context, 0);
    }


    @Override
    public CommandContext getContext() {
        return context;
    }

    @Override
    public int getArg() {
        return this.arg;
    }
}

