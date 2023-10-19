package com.xma.chess.client.controllers;

import com.xma.chess.client.SceneService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class CreateController implements Initializable {
    @FXML
    private ComboBox<String> figureColor;

    @FXML
    private Spinner<Integer> timeSpinner;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        figureColor.setItems(
                FXCollections.observableList(Arrays.stream(Colors.values()).map(Colors::getName).collect(Collectors.toList()))
        );

        timeSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 3600, 300, 10));
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        var service = new SceneService<>(MenuController.class);
        SceneService.switchScene(figureColor.getScene().getWindow(), service.getNewScene());
    }

    @FXML
    void next(ActionEvent event) {

    }

    public enum Colors{
        WHITE("Белый"),
        BLACK("Черный"),
        RANDOM("Случайный");

        private final String name;

        Colors(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}
