package ru.vsu.cs.leguenko_e_yu.patient;

import ru.vsu.cs.leguenko_e_yu.drug.Drug;
import ru.vsu.cs.leguenko_e_yu.exception.MyException;

public interface PatientPreferences {
    void requireForDrug(Patient patient, Drug drug) throws MyException;
    void cancelDrug(Patient patient, Drug drug);
    void changeDrug(Patient patient, Drug currentDrug, Drug newDrug) throws MyException;
}
