package main;

import main.clinic.Clinic;
import main.doctor.Dentist;
import main.doctor.Surgeon;
import main.doctor.Therapist;
import main.patient.Patient;

import java.lang.reflect.Field;

/**
 * @author Pstyga Stas
 * @created 25.03.2026
 */
public class Main {

    public static void main(String[] args) {
        //Задача 1:
        //Создать программу для имитации работы клиники. Пусть в клинике будет три врача:
        //хирург, терапевт и дантист. Каждый врач имеет метод «лечить», но каждый врач лечит
        //по-своему. Так же предусмотреть класс «Пациент» с полем «План лечения» и полем
        //«Доктор». Создать объект класса «Пациент» и добавить пациенту план лечения. У
        //терапевта создать метод, который будет назначать врача пациенту согласно плану
        //лечения:
        //Если план лечения имеет код 1 – назначить хирурга и выполнить метод лечить.
        //Если план лечения имеет код 2 – назначить дантиста и выполнить метод лечить.
        //Если план лечения имеет любой другой код – назначить терапевта и выполнить метод
        //лечить.
        Clinic clinic = new Clinic(
                new Surgeon("Алексей"), new Dentist("Анатолий"), new Therapist("Тимофей"));
        Patient patient = new Patient(2, "Гриша");
        clinic.getHealing(patient);

        //Задача *:
        //Создать класс Apple и добавить в него поле color с модификатором доступа private и
        //инициализировать его. В методе main другого класса создать объект Apple, и не
        //используя сеттеры изменить значение поля color.

        Apple apple = new Apple("Green");
        System.out.println(apple);

        try {
            Field field = apple.getClass().getDeclaredField("color");
            field.setAccessible(true);
            field.set(apple, "Black");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        System.out.println(apple);
    }
}
