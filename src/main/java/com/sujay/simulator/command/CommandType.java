package com.sujay.simulator.command;

public enum CommandType {
    ADVANCE('a', "advance"),
    LEFT('l', "turn left"),
    RIGHT('r', "turn right"),
    QUIT('q', "quit");

    private final char commandType;
    private String description;

    CommandType(char commandType, String description) {
        this.commandType = commandType;
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
