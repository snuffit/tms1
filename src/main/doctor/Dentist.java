package main.doctor;

import main.patient.Patient;

/**
 * @author Pstyga Stas
 * @created 29.03.2026
 */
public class Dentist extends Doctor{

    public Dentist(String name) {
        super(name);
        super.setHealingPlan(2);
    }

    @Override
    public void heal(Patient patient) {
        if(patient.getHealingPlan() == super.getHealingPlan()) {
            System.out.printf(
                    "Дантист с именем %s вылечил зубы пациенту с именем %s\n", super.getName(), patient.getName());
        } else {
            System.out.println("План лечения пациента не соответствует навыкам Дантиста");
        }
    }
}
