package main;

import main.animals.*;
import main.food.Food;

/**
 * @author Pstyga Stas
 * @created 29.03.2026
 */
public class Main {
    public static void main(String[] args) {
        //Задача 1:
        //Создать логически верную иерархию следующих классов: Animal, Dog, Tiger, Rabbit.
        //Переопределить методы voice(), eat(String food) чтобы они выводили верную
        //информацию. Метод eat может принимать “Meat”, “Grass” и другие строки.
        //Например, если мы создадим объект класса Rabbit, вызовем метод eat() и передадим
        //туда “Grass” он должен написать в консоли что любит есть травку. Если передадим “Meat”
        //или другую строку то он будет недоволен.

        Animal[] animals = new Animal[] {new Rabbit(), new Tiger(), new Dog()};
        for (Animal animal : animals) {
            animal.voice();
            animal.eat(Food.getBONE());
            animal.eat(Food.getMEAT());
            animal.eat(Food.getGRASS());
            System.out.println();
        }

        //Задача *:
        //Написать такой конструктор, который запретит создание объекта класса Dog в других
        //классах; Найти способ вызывать методы voice(), eat() класса Dog, который позволит
        //обойти ограничение, наложенное конструктором выше. Объяснить, как работают оба
        //способа.

        PrivateDog.getInstance().voice();
        PrivateDog.getInstance().eat(Food.getBONE());
    }
}
