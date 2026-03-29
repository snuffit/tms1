package main.clinic;

import main.doctor.Doctor;
import main.patient.Patient;

/**
 * @author Pstyga Stas
 * @created 29.03.2026
 */
public class Clinic {

    Doctor[] doctors;

    public Clinic(Doctor ...doctors){
        this.doctors = doctors;
    }

    public void getHealing(Patient patient) {
        for (Doctor doctor : doctors) {
            if(doctor.getHealingPlan() == patient.getHealingPlan()) {
                doctor.heal(patient);
                return;
            }
        }
        System.out.println("В клинике нет врача, который может помочь");
    }
}
