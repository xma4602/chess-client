package com.xma.chess.client;


import java.util.UUID;

public class Context {

    private static UUID userID;
    private static String userLogin;

    public static UUID getUserID() {
        return userID;
    }

    public static String getUserLogin() {
        return userLogin;
    }

    public static void setUserID(UUID userID) {
        Context.userID = userID;
    }

    public static void setUserLogin(String userLogin) {
        Context.userLogin = userLogin;
    }
}
