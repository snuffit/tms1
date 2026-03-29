package main.doctor;

import main.patient.Patient;

/**
 * @author Pstyga Stas
 * @created 29.03.2026
 */
public class Surgeon extends Doctor{

    public Surgeon(String name) {
        super(name);
        super.setHealingPlan(1);
    }

    @Override
    public void heal(Patient patient) {
        if(patient.getHealingPlan() == super.getHealingPlan()) {
            System.out.printf(
                    "Хирург с именем %s вправил ногу пациенту с именем %s\n", super.getName(), patient.getName());
        } else {
            System.out.println("План лечения пациента не соответствует навыкам Хирурга");
        }
    }
}
