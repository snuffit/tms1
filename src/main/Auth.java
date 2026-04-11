package main;

import main.exception.WrongLoginException;
import main.exception.WrongPasswordException;

/**
 * @author Pstyga Stas
 * @created 11.04.2026
 */
public class Auth {

    public static boolean registration(String login, String password, String confirmPassword) {
        try {
            if (validateLogin(login) && validatePassword(password, confirmPassword)) {
                return true;
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    private static boolean validateLogin(String login) {
        if (login.length() < 3 || login.length() > 20 || login.contains(" ")) {
            throw new WrongLoginException("Логин введен не корректно");
        }
        return true;
    }

    private static boolean validatePassword(String password, String confirmPassword) {
        try {
            if (validatePassword(password) && validateConfirmationPassword(password, confirmPassword)) {
                return true;
            }
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    private static boolean validateConfirmationPassword(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не равны");
        }
        return true;
    }

    private static boolean validatePassword(String password) {
        if (password.length() > 20 || password.length() < 3 || password.contains(" ") || !password.matches(".*\\d.*")) {
            throw new WrongPasswordException("Пароль введен не корректно");
        }
        return true;
    }
}
