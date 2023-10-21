package com.xma.chess.client.net;

import com.xma.chess.client.GameData;
import lombok.Value;

import java.util.UUID;

public interface IGamesService {

    GamesResult requestGames();

    GameData[] getGamesData();

    ConnectResult connectTo(UUID roomID);

    enum GamesResult {
        CORRECT,
        DISCONNECT
    }

    enum ConnectResult {
        NOT_EXIST,
        CORRECT,
        DISCONNECT,
        TAKEN
    }
}
