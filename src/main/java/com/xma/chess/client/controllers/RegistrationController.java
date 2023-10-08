package com.xma.chess.client.controllers;

import com.xma.chess.client.IUserService;
import com.xma.chess.client.SceneService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationController implements Initializable {

    @FXML
    private Label errors;

    @FXML
    private TextField login;

    @FXML
    private TextField pass1;

    @FXML
    private TextField pass2;

    private IUserService userService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errors.setText("");
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        SceneService<AuthorizationController> service = new SceneService<>(AuthorizationController.class);
        SceneService.switchScene(login.getScene().getWindow(), service.getNewScene());
    }

    @FXML
    void register(ActionEvent event) {
        errors.setText("");
        if (verifyLogin(login.getText()) && verifyPassword(pass1.getText(), pass2.getText())) {
            IUserService.RegisterResult result = userService.register(login.getText(), pass1.getText());
            switch (result) {
                case ALREADY_EXIST -> errors.setText("Пользователь с данным логином уже существует");
                case DISCONNECT -> errors.setText("Нет ответа сервера. Проверьте подключение в интернету");
                case CORRECT -> errors.setText("Вы успешно зарегистрированы! Вернитесь и повторите попытку входа");
            }
        }
    }

    private boolean verifyLogin(String login) {
        if (login.isEmpty()) {
            errors.setText("Поле логина пусто");
            return false;
        }
        if (login.length() < 4 || login.length() > 20) {
            errors.setText("Длина логина должна быть от 4 до 20 символов");
            return false;
        }
        return true;
    }

    private boolean verifyPassword(String pass1, String pass2) {
        if (pass1.isEmpty()) {
            errors.setText("Поле пароля пусто");
            return false;
        }
        if (pass1.length() < 4 || pass1.length() > 12) {
            errors.setText("Длина пароля должна быть от 4 до 20 символов");
            return false;
        }
        if (!pass1.equals(pass2)) {
            errors.setText("Поля паролей не совпадают");
            return false;
        }
        return true;
    }


}