package com.xma.chess.client.controllers;

import com.xma.chess.client.SceneService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    private Label label;

    @FXML
    void create(ActionEvent event) throws IOException {
        var service = new SceneService<>(CreateController.class);
        SceneService.switchScene(label.getScene().getWindow(), service.getNewScene());
    }

    @FXML
    void invite(ActionEvent event) throws IOException {
        var service = new SceneService<>(InviteController.class);
        SceneService.switchScene(label.getScene().getWindow(), service.getNewScene());
    }

    @FXML
    void search(ActionEvent event) throws IOException {
        var service = new SceneService<>(GamesController.class);
        SceneService.switchScene(label.getScene().getWindow(), service.getNewScene());
    }

    @FXML
    void statistic(ActionEvent event) {

    }

    @FXML
    void exit(ActionEvent event) {
        ((Stage) label.getScene().getWindow()).close();
    }


}
