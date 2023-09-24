package com.xma.chess.client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneService<T>  {
    private Parent parent;
    private T controller;

    private static final Map<Class<?>, String> files = new HashMap<>();

    static {
        files.put(ChessboardController.class, "chessboard.fxml");
    }

    public SceneService(Class<T> clas) throws IOException {
        String file = files.get(clas);
        FXMLLoader loader = new FXMLLoader(Application.class.getResource(file));
        parent = loader.load();
        controller = loader.getController();
    }

    public Parent getRoot() {
        return parent;
    }

    public Scene getNewScene() {
        return new Scene(parent);
    }

    public T getController() {
        return controller;
    }

    public static void switchScene(Stage stage, Scene scene) throws IOException {
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}
