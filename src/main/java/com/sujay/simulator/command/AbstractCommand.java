package com.sujay.simulator.command;

import com.sujay.simulator.BullDozer;

public abstract class AbstractCommand implements Command {
    protected final BullDozer bullDozer;
    protected final int numberOfSquares;

    public AbstractCommand(BullDozer bullDozer, int numberOfSquares) {
        this.bullDozer = bullDozer;
        this.numberOfSquares = numberOfSquares;
    }

    public AbstractCommand(BullDozer bullDozer) {
        this(bullDozer, 0);
    }
}
