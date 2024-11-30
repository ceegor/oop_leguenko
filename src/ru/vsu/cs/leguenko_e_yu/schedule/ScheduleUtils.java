package ru.vsu.cs.leguenko_e_yu.schedule;

import ru.vsu.cs.leguenko_e_yu.drug.Drug;
import ru.vsu.cs.leguenko_e_yu.exception.MyException;
import ru.vsu.cs.leguenko_e_yu.patient.Patient;

import java.time.LocalDateTime;

public interface ScheduleUtils {
    void addDrugToSchedule(Patient patient, Drug drug, LocalDateTime deliveryTime);
    LocalDateTime getTimeForPatient(Patient patient) throws MyException;
    void showSchedule();
}
