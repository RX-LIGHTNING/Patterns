package com.laba.laba.controller;

import com.laba.laba.Entity.User;
import com.laba.laba.HelloApplication;
import com.laba.laba.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginController {
    @FXML
    private TextField loginField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField regLogin;
    @FXML
    private TextField regPassword;

    @FXML
    protected void login() throws IOException {
        if(UserService.isLoggedIn(loginField.getText(),passwordField.getText())){
            HelloApplication.showMainMenu(HelloApplication.st);
        }
    }
    @FXML
    protected void register() {
        UserService.addUser(new User(regLogin.getText(),regPassword.getText()));
    }
}
