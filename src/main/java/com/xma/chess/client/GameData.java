package com.xma.chess.client;

import lombok.Value;

import java.util.UUID;

@Value
public class GameData {
    UUID roomID;
    String creatorLogin;
    FigureColor figureColor;
    int moveTime;

    String getFigureColor() {
        return figureColor.getName();
    }
}
