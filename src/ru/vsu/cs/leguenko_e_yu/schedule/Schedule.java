package ru.vsu.cs.leguenko_e_yu.schedule;

import ru.vsu.cs.leguenko_e_yu.exception.ErrorType;
import ru.vsu.cs.leguenko_e_yu.exception.MyException;
import ru.vsu.cs.leguenko_e_yu.patient.Patient;
import ru.vsu.cs.leguenko_e_yu.drug.Drug;
import ru.vsu.cs.leguenko_e_yu.patient.PatientPreferences;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Schedule implements PatientPreferences, ScheduleUtils {

    private Map<Patient, Map<Drug, LocalDateTime>> schedule;

    public Schedule() {
        schedule = new HashMap<>();
    }

    @Override
    public void addDrugToSchedule(Patient patient, Drug drug, LocalDateTime deliveryTime) {
        schedule.putIfAbsent(patient, new HashMap<>());
        if (!patient.getAllergy().contains(drug)) {
            schedule.get(patient).put(drug, deliveryTime);
        }
    }
    public Map<Drug, LocalDateTime> getScheduleForPatient(Patient patient) {
        return schedule.get(patient);
    }

    @Override
    public LocalDateTime getTimeForPatient(Patient patient) throws MyException {
        if (schedule.get(patient).entrySet().isEmpty()) {
            throw new MyException(ErrorType.NULL_VALUE);
        } else {
            for (Map.Entry<Drug, LocalDateTime> drugEntry : schedule.get(patient).entrySet()) {
                return drugEntry.getValue();
            }
        }
        return null;
    }

    @Override
    public void showSchedule() {
        for (Map.Entry<Patient, Map<Drug, LocalDateTime>> entry : schedule.entrySet()) {
            Patient patient = entry.getKey();
            Map<Drug, LocalDateTime> drugs = entry.getValue();
            System.out.println(patient.toString());
            for (Map.Entry<Drug, LocalDateTime> drugEntry : drugs.entrySet()) {
                System.out.println(" Drug: " + drugEntry.getKey() + ", Delivery Time: " + drugEntry.getValue());
            }
        }
    }
    @Override
    public void requireForDrug(Patient patient, Drug drug) throws MyException {
        schedule.get(patient).putIfAbsent(drug, getTimeForPatient(patient));
    }
    @Override
    public void cancelDrug(Patient patient, Drug drug) {
        schedule.get(patient).remove(drug);
    }
    @Override
    public void changeDrug(Patient patient, Drug currentDrug, Drug newDrug) throws MyException {
        cancelDrug(patient, currentDrug);
        requireForDrug(patient, newDrug);
    }
}
