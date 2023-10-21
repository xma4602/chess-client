package com.xma.chess.client;

public enum FigureColor {
    WHITE("Белые"),
    BLACK("Черные"),
    RANDOM("Случайный");

    private final String name;

    FigureColor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
