package com.xma.chess.client;

public interface IUserService {

    AuthorizeResult authorize(String login, String password);

    RegisterResult register(String login, String password);

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
