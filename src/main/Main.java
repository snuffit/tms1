package main;

import main.user.CloneableUser;
import main.user.User;

/**
 * @author Pstyga Stas
 * @created 05.04.2026
 */
public class Main {
    public static void main(String[] args) {
        //Задача 1:
        //Создать класс для описания пользователя системы. Переопределить в классе методы
        //toString,hashcode и equals. Создать несколько экземпляров класса с одним и тем же
        //значением полей и сравнить с помощью метода equals.

        User fUser = new User("Tom2009", 17, 222222222);
        User sUser = new User("Grisha2011", 17, 222222222);
        User tUser = new User("Tom2009", 17, 33333333);

        isUserEquals(fUser, sUser);
        isUserEquals(fUser, tUser);

        //Задача *:
        //Создать программу для реализации поверхностного и глубокого клонирования объекта
        //класса User. Пусть на вход программе будет передаваться тип операции клонирования
        //(поверхностное клонирование или глубокое), а также id юзера для клонирования.
        try {
            User cloneDefaultUser = fUser.clone();
            System.out.println(cloneDefaultUser);
            CloneableUser cloneableUser = new CloneableUser("Yui", 99, 12412423);
            User cloneUser = cloneableUser.clone();
            System.out.println(cloneUser);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void isUserEquals(User fUser, User sUser) {
        if(fUser.equals(sUser)) {
            System.out.println(fUser + " равно " + sUser);
        } else {
            System.out.println(fUser + " не равно " + sUser);
        }
    }
}
