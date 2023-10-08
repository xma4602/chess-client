package com.xma.chess.client.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class ChessboardController implements Initializable {
    private static final String[] rows = {"8", "7", "6", "5", "4", "3", "2", "1"};
    private static final String[] columns = {"A", "B", "C", "D", "E", "F", "G", "H"};

    @FXML
    private GridPane board;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int row = 0; row <= 7; row++) {
            board.add(getRow(row), 0, row + 1);
            board.add(getRow(row), 9, row + 1);
        }

        for (int column = 0; column <= 7; column++) {
            board.add(getColumn(column), column + 1, 0);
            board.add(getColumn(column), column + 1, 9);
        }

        for (int row = 1; row <= 8; row++) {
            for (int column = 1; column <= 8; column++) {
                board.add(getCell(row, column), row, column);
            }
        }
    }

    private static Label getRow(int row) {
        Label label = new Label(rows[row]);
        label.prefWidth(10);
        label.setMaxWidth(Double.MAX_VALUE);
        label.setAlignment(Pos.CENTER);
        return label;
    }

    private static Label getColumn(int column) {
        Label label = new Label(columns[column]);
        label.prefWidth(100);
        label.setMaxWidth(Double.MAX_VALUE);
        label.setAlignment(Pos.CENTER);

        return label;
    }

    private static Pane getCell(int row, int column) {
        Pane cell = new Pane();
        if ((row % 2 + column % 2) == 1) {
            cell.setBackground(Background.fill(Color.BLACK));
        } else {
            cell.setBackground(Background.fill(Color.WHITE));
        }
        return cell;
    }


    public void reverse() {
        Label a, b;
        String s;
        for (int i = 0; i < rows.length / 2; i++) {
            s = rows[i];
            rows[i] = rows[rows.length - 1 - i];
            rows[rows.length - 1 - i] = s;

            s = columns[i];
            columns[i] = columns[columns.length - 1 - i];
            columns[columns.length - 1 - i] = s;
        }
        for (int row = 1; row <= 8; row++) {
            a = (Label) getNodeByIndex(row, 0);
            b = (Label) getNodeByIndex(row, 9);
            a.setText(rows[row - 1]);
            b.setText(rows[row - 1]);
        }

        for (int col = 1; col <= 8; col++) {
            a = (Label) getNodeByIndex(0, col);
            b = (Label) getNodeByIndex(9, col);
            a.setText(columns[col - 1]);
            b.setText(columns[col - 1]);
        }
    }

    public Node getNodeByIndex(final int row, final int column) {
        Node result = null;

        ObservableList<Node> children = board.getChildren();
        for (Node node : children) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }
}