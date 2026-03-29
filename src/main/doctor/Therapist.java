package main.doctor;

import main.patient.Patient;

/**
 * @author Pstyga Stas
 * @created 29.03.2026
 */
public class Therapist extends Doctor{

    public Therapist(String name) {
        super(name);
        super.setHealingPlan(3);
    }

    @Override
    public void heal(Patient patient) {
        if(patient.getHealingPlan() >= super.getHealingPlan()) {
            System.out.printf(
                    "Терапевт с именем %s вылечил пациент с именем %s\n", super.getName(), patient.getName());
        } else {
            System.out.println("План лечения пациента не соответствует навыкам Терапевта");
        }
    }
}
