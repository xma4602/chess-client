package com.xma.chess.client.controllers;

import com.xma.chess.client.Context;
import com.xma.chess.client.FigureColor;
import com.xma.chess.client.GameData;
import com.xma.chess.client.SceneService;
import com.xma.chess.client.net.IGameService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class CreateController implements Initializable {
    @FXML
    private ComboBox<String> figureColor;

    @FXML
    private Spinner<Integer> timeSpinner;

    IGameService gameService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        figureColor.setItems(
                FXCollections.observableList(Arrays.stream(FigureColor.values()).map(FigureColor::getName).collect(Collectors.toList()))
        );

        timeSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 3600, 300, 10));
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        var service = new SceneService<>(MenuController.class);
        SceneService.switchScene(figureColor.getScene().getWindow(), service.getNewScene());
    }

    @FXML
    void next(ActionEvent event) throws IOException {
        String creatorLogin = Context.getUserLogin();
        FigureColor color = FigureColor.valueOf(figureColor.getSelectionModel().getSelectedItem());
        int moveTime = timeSpinner.getValue();
        GameData data = new GameData(null, creatorLogin, color, moveTime);

        IGameService.PublishResult result = gameService.publish(data);
        switch (result) {
            case CORRECT -> {
                var service = new SceneService<>(GuestRoomController.class);
                service.getController().setRoomID(gameService.getRoomID());
                SceneService.switchScene(timeSpinner.getScene().getWindow(), service.getNewScene());
            }
            case DISCONNECT -> {
                //TODO: что делать, когда нет инета?
            }
            case DENIED -> {
                //TODO: что делать, когда отказ?
            }
        }
    }
}
