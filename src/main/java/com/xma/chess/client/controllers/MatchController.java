package com.xma.chess.client.controllers;

import com.xma.chess.client.SceneService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SubScene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MatchController implements Initializable {

    @FXML
    private SubScene board;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            var service = new SceneService<>(ChessboardController.class);
            board.setRoot(service.getRoot());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
