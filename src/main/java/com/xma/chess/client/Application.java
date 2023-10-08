package com.xma.chess.client;

import com.xma.chess.client.controllers.AuthorizationController;
import com.xma.chess.client.controllers.ChessboardController;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        var service = new SceneService<>(AuthorizationController.class);
        var controller = service.getController();
        Scene scene = service.getNewScene();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}