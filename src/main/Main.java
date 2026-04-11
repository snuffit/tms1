package main;

/**
 * @author Pstyga Stas
 * @created 11.04.2026
 */
public class Main {

    public static void main(String[] args) {
        //Задача 1:
        //Создать класс, в котором будет статический метод. Этот метод принимает на вход три
        //параметра: login, password, confirmPassword. Все поля имеют тип данных String. Длина
        //login должна быть меньше 20 символов и не должен содержать пробелы. Если login не
        //соответствует этим требованиям, необходимо выбросить WrongLoginException. Длина
        //password должна быть меньше 20 символов, не должен содержать пробелом и должен
        //содержать хотя бы одну цифру. Также password и confirmPassword должны быть равны.
        //Если password не соответствует этим требованиям, необходимо выбросить
        //WrongPasswordException. WrongPasswordException и WrongLoginException -
        //пользовательские классы исключения с двумя конструкторами – один по умолчанию,
        //второй принимает сообщение исключения и передает его в конструктор класса Exception.
        //Метод возвращает true, если значения верны, false в противном случае.

        if (Auth.registration("login", "ff1", "ff1")) {
            System.out.println("Вы зарегистрированы");
        } else {
            System.out.println("Вы не зарегистрированы");
        }
        //Задача *:
        //Написать try/catch/finally, в котором finally вызван не будет.
        try {

            System.out.println("try видно");
            System.out.println(10 / 0);

        } catch (Exception e) {
            System.out.println("И catch");
            System.exit(0);
        } finally {
            System.out.println("а finally нет");
        }
    }
}
