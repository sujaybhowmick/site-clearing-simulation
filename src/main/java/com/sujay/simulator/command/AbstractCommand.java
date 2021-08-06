package com.sujay.simulator.command;

import com.sujay.simulator.sitemap.Cell;
import com.sujay.simulator.sitemap.Orientation;

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

    protected Cell getCurrentPosition() {
        return this.context.getBullDozer().getCurrentPosition();
    }

    protected Orientation getOrientation() {
        return this.context.getBullDozer().getOrientation();
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

