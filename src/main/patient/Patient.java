package main.patient;

import main.doctor.Doctor;

/**
 * @author Pstyga Stas
 * @created 29.03.2026
 */
public class Patient {

    int healingPlan;
    String name;

    public Patient(int healingPlan, String name) {
        this.healingPlan = healingPlan;
        this.name = name;
    }

    public int getHealingPlan() {
        return healingPlan;
    }

    public String getName() {
        return name;
    }
}
