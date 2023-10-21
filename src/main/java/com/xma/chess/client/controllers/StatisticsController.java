package com.xma.chess.client.controllers;

import com.xma.chess.client.net.IStatisticService;
import com.xma.chess.client.SceneService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StatisticsController implements Initializable {

    @FXML
    private Label gamesCount;

    @FXML
    private TableView<IStatisticService.StatisticsData.GameData> table;

    @FXML
    private Label totalTime;

    @FXML
    private Label wins;

    IStatisticService statisticService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        IStatisticService.StatisticsData statisticsData = statisticService.getStatisticsData();
//
//        totalTime.setText("Время в игре: %f".formatted(statisticsData.getTotalTime()));
//        gamesCount.setText("Количество игр: %d".formatted(statisticsData.getGameCount()));
//        wins.setText("Процет побед/поражений/ничей: %f.2/%f.2/%f.2".formatted(
//                statisticsData.getWins(),
//                statisticsData.getLosses(),
//                statisticsData.getDraws()
//        ));

        //TODO: заполнение табилицы
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        var service = new SceneService<>(MenuController.class);
        SceneService.switchScene(table.getScene().getWindow(), service.getNewScene());
    }


}
