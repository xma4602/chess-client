package com.xma.chess.client.net;

import java.util.UUID;

public interface IUserService {

    AuthorizeResult authorize(String login, String password);

    RegisterResult register(String login, String password);

    UUID getUserID();

    enum AuthorizeResult{
        NOT_EXIST,
        CORRECT,
        INCORRECT,
        DISCONNECT
    }

    enum RegisterResult{
        ALREADY_EXIST,
        DISCONNECT,
        CORRECT
    }
}
