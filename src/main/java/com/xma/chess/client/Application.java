package com.xma.chess.client;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        var service = new SceneService<>(ChessboardController.class);
        var controller = service.getController();
        controller.reverse();
        Scene scene = service.getNewScene();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}