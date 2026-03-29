package main.doctor;

import main.patient.Patient;

/**
 * @author Pstyga Stas
 * @created 29.03.2026
 */
public abstract class Doctor {

    private String name;
    private int healingPlan;

    public Doctor(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getHealingPlan(){
        return this.healingPlan;
    }

    public void setHealingPlan(int healingPlan) {
        this.healingPlan = healingPlan;
    }

    public abstract void heal(Patient patient);
}
