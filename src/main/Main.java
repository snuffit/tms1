package main;

import main.shapes.Circle;
import main.shapes.Shape;
import main.shapes.Square;
import main.shapes.Triangle;
import main.sheep.BadCloneableSheep;
import main.sheep.GoodCloneableSheep;
import main.workers.Accountant;
import main.workers.Director;
import main.workers.Worker;
import main.workers.WorkerInfo;

/**
 * @author Pstyga Stas
 * @created 18.03.2026
 */
public class Main {
    public static void main(String[] args) {
        //Задача 1:
        //Создать классы "Директор", "Рабочий", "Бухгалтер". Реализовать интерфейс с методом,
        //который печатает название должности и имплементировать этот метод в созданные
        //классы.
        WorkerInfo[] workers = new WorkerInfo[]{new Accountant(), new Director(), new Worker()};
        for (WorkerInfo worker : workers) {
            worker.printInfo();
        }
        System.out.println();

        //Задача 2:
        //Написать иерархию классов Фигура, Треугольник, Прямоугольник, Круг. Реализовать
        //функцию подсчета площади для каждого типа фигуры и подсчет периметра(используя
        //абстрактный класс/методы). Создать массив из 5 разных фигур. Вывести на экран сумму
        //периметра всех фигур в массиве.

        Shape[] shapes = new Shape[]{
                new Triangle(2, 6, 6),
                new Square(4, 5),
                new Circle(4)};
        for (Shape shape : shapes) {
            System.out.println(shape.getPerimeter() + " " + shape.getSquare());
        }
        System.out.println();

        //Задача *:
        //Самостоятельно изучить и показать пример работы интерфейса-маркера Cloneable.

        System.out.println("Эксперимент с овцами");
        BadCloneableSheep sheepBen = new BadCloneableSheep("Ben", "Grey");
        BadCloneableSheep sheepBenClone;
        try {
            sheepBenClone = (BadCloneableSheep) sheepBen.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sheepBen + " и его клон " + sheepBenClone + "\n");
        System.out.println("Но при изменении шерсти и имени у клона стало");
        sheepBenClone.setName("Oleg");
        sheepBenClone.setCoatColor("Black");
        System.out.println("Клон " + sheepBenClone + "\n" +
                "Оригинал тоже изменился\n" +
                "Оригинал " + sheepBen + "\n" +
                "Оба объекта ссылаются на один и тот же объект\n");
        GoodCloneableSheep sheepDolly = new GoodCloneableSheep("Dolly", "White");
        GoodCloneableSheep sheepDollyClone = (GoodCloneableSheep) sheepDolly.clone();
        System.out.println(sheepDolly + " и его клон " + sheepDollyClone + "\n");
        System.out.println("Но при изменении шерсти и имени у клона стало");
        sheepDollyClone.setName("Pups");
        sheepDollyClone.setCoatColor("Black");
        System.out.println("Клон " + sheepDollyClone + "\n" +
                "Оригинал не изменился\n" +
                "Оригинал " + sheepDolly + "\n" +
                "Оба объекта создали копии использующихся объектов\n");
    }
}
