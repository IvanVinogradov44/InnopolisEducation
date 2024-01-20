package ru.learningJava.homework12.securityValidation;

public class User {

    public static boolean checkUserCreds(String login, String password, String confirmPassword) {
        try {
            checkLogin(login);
        } catch (WrongLoginException loginException) {
            System.out.println(loginException.getMessage());
            return false;
        }

        try {
            checkPassword(password, confirmPassword);
        } catch (WrongPasswordException passwordException){
            System.out.println(passwordException.getMessage());
            return false;
        }




        return true;
    }

    public static void checkLogin(String login){
        String regex = "^([A-Za-z0-9_]{0,20})$";
        if (!login.matches(regex)) {
            throw new WrongLoginException("Логин не соответствует формату");
        }
    }

    public static void checkPassword(String password, String confirmPassword){
        String regex = "^([A-Za-z0-9_]{0,20})$";
        if (!password.matches(regex)) {
            throw new WrongPasswordException("Пароль не соответствует формату");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}
