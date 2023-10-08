package com.xma.chess.client.controllers;

import com.xma.chess.client.IUserService;
import com.xma.chess.client.SceneService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AuthorizationController implements Initializable {

    @FXML
    private Label errors;

    @FXML
    private TextField login;

    @FXML
    private PasswordField pass;

    private IUserService userService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errors.setText("");
    }
    @FXML
    void register(ActionEvent event) throws IOException {
        SceneService<RegistrationController> service = new SceneService<>(RegistrationController.class);
        SceneService.switchScene(login.getScene().getWindow() ,service.getNewScene());
    }

    @FXML
    void signIn(ActionEvent event) {
        errors.setText("");
        if (verifyLogin(login.getText()) && verifyPassword(pass.getText())) {
            IUserService.AuthorizeResult result = userService.authorize(login.getText(), pass.getText());
            switch (result) {
                case NOT_EXIST -> errors.setText("Пользователя с данным логином не существует");
                case INCORRECT -> errors.setText("Неверные логин и/или пароль");
                case DISCONNECT -> errors.setText("Нет ответа сервера. Проверьте подключение в интернету");
                case CORRECT -> {
                    //переход в главное меню
                }
            }
        }
    }

    private boolean verifyLogin(String login) {
        if (login.isEmpty()) {
            errors.setText("Поле логина пусто");
            return false;
        }
        return true;
    }

    private boolean verifyPassword(String pass) {
        if (pass.isEmpty()) {
            errors.setText("Поле пароля пусто");
            return false;
        }
        return true;
    }

}
