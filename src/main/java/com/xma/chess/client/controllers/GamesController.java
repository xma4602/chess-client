package com.xma.chess.client.controllers;

import com.xma.chess.client.SceneService;
import com.xma.chess.client.net.IGamesService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GamesController implements Initializable {

    @FXML
    private TableView<IGamesService.GameData> table;

    IGamesService gamesService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableColumn<IGamesService.GameData, String> creatorColumn = new TableColumn<>("Соперник");
        creatorColumn.setCellValueFactory(new PropertyValueFactory<>("creatorLogin"));

        TableColumn<IGamesService.GameData, String> figureColorColumn = new TableColumn<>("Цвет фигуры");
        figureColorColumn.setCellValueFactory(new PropertyValueFactory<>("figureColor"));

        TableColumn<IGamesService.GameData, String> moveTimeColumn = new TableColumn<>("Время хода");
        creatorColumn.setCellValueFactory(new PropertyValueFactory<>("moveTime"));
    }

    private void getAvailableGames(){
        IGamesService.GameData[] data = gamesService.getGamesData();
        //TODO: заполнение таблицы игр
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        var service = new SceneService<>(MenuController.class);
        SceneService.switchScene(table.getScene().getWindow(), service.getNewScene());
    }

    @FXML
    void selectGame(ActionEvent event) {
        //TODO: переход по выделенной игре в гостевую комнату
    }
}
