package com.devproserv.courses.form;

public class LoginValidation implements Validation {

    private final String login;
    private final String password;
    private String message;

    LoginValidation(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean validated() {
        boolean result = true;
        message = "ok";
        if (login == null || password == null) {
            message = "Username and password should not be empty!";
            result = false;
        } else if (login.isEmpty() || password.isEmpty()) {
            message = "Username and password should not be empty!";
            result = false;
        } else if (login.matches("^[^a-zA-Z]+.*")) {
            message = "Username should not start with a digit or non letter!";
            result = false;
        } else if (login.matches(".*\\W+.*")) {
            message = "Username should contain only letters and digits!";
            result = false;
        }
        return result;
    }

    @Override
    public String errorMessage() {
        return message;
    }
}
