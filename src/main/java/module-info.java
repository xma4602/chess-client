module com.xma.chessclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.xma.chess.client to javafx.fxml;
    exports com.xma.chess.client;
    exports com.xma.chess.client.controllers;
    opens com.xma.chess.client.controllers to javafx.fxml;
    exports com.xma.chess.client.net;
    opens com.xma.chess.client.net to javafx.fxml;
}