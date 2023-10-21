package com.xma.chess.client.net;

import com.xma.chess.client.GameData;

import java.util.UUID;

public interface IGameService {
    PublishResult publish(GameData gameData);

    UUID getRoomID();

    enum PublishResult {
        CORRECT,
        DISCONNECT,
        DENIED
    }
}
