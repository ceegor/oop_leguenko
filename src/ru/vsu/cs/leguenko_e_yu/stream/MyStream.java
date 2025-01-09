package ru.vsu.cs.leguenko_e_yu.stream;

import ru.vsu.cs.leguenko_e_yu.drug.*;
import ru.vsu.cs.leguenko_e_yu.patient.Patient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyStream {
    private Drug drug1 = new Drug(1,"Препарат1", 100, 400.0, 5.0);
    private Drug drug2 = new Pills(2, "Препарат2", 300, 500.0, 4.0,"Таблетка");
    private Drug drug3 = new Syrup(3, "Препарат3", 200, 300.0, 4.0, Syrup.Color.WHITE, Syrup.Taste.STRAWBERRY);
    private Drug drug4 = new Ointment(4, "Препарат4", 100, 350.0, 2.0, "Рука");
    private Drug drug5 = new Spray(5, "Препарат5", 200, 450.0, 7.0, "Нос");
    private Drug drug6 = new Pills(6, "Препарат6", 400, 300.0, 4.0, "Капсула");
    private Drug drug7 = new Drug(7, "Препарат7", 200, 175.0, 1.0);
    private Drug drug8 = new Syrup(8, "Препарат8", 250, 500.0, 5.0, Syrup.Color.YELLOW, Syrup.Taste.LEMON);
    private Drug drug9 = new Drug(9, "Препарат9", 100, 100.0, 2.0);
    private Drug drug10 = new Drug(10, "Препарат10", 500, 500.0, 4.0);
    private Patient patient1 = new Patient(1,"Егор", "Легуенко", "2005 год 07 месяц 15 день", Patient.Gender.MALE, List.of(drug3,drug5));
    private Patient patient2 = new Patient(2,"Максим", "Жаринов", "2005 год 10 месяц 18 день", Patient.Gender.MALE, List.of(drug1));
    private Patient patient3 = new Patient(3, "Иван", "Шамаев", "2005 год 09 месяц 06 день", Patient.Gender.MALE, List.of(drug3, drug4));
    private Patient patient4 = new Patient(4,"Владимир", "Красов", "2005 год 07 месяц 05 день", Patient.Gender.MALE, List.of(drug2));
    private Patient patient5 = new Patient(5,"Кирилл", "Соловьёв", "2005 год 08 месяц 23 день", Patient.Gender.MALE, List.of(drug8, drug7, drug10));
    private Patient patient6 = new Patient(6, "Алексей", "Ольшанников", "2005 год 08 месяц 11 день", Patient.Gender.MALE, List.of(drug5, drug6));
    private Patient patient7 = new Patient(7,"Игорь", "Легуенко", "2001 год 09 месяц 27 день", Patient.Gender.MALE, List.of(drug8));
    private Patient patient8 = new Patient(8,"Георгий", "Оболенский", "2005 год 11 месяц 09 день", Patient.Gender.MALE, List.of(drug4, drug7));
    private Patient patient9 = new Patient(9, "Андрей", "Мещеряков", "2005 год 11 месяц 09 день", Patient.Gender.MALE, List.of(drug3, drug4, drug9));
    private Patient patient10 = new Patient(10,"Александр", "Джура", "2005 год 11 месяц 14 день", Patient.Gender.MALE, List.of(drug3));
    private Patient patient11 = new Patient(11,"Никита", "Карлов", "2005 год 01 месяц 13 день", Patient.Gender.MALE, List.of(drug1));
    private Patient patient12 = new Patient(12, "Юрий", "Легуенко", "1974 год 11 месяц 02 день", Patient.Gender.MALE, List.of(drug2, drug5));
    private Patient patient13 = new Patient(13,"Артур", "Белокуров", "2006 год 01 месяц 19 день", Patient.Gender.MALE, List.of(drug8));
    private Patient patient14 = new Patient(14,"Ярослав", "Аксанов", "2005 год 11 месяц 09 день", Patient.Gender.MALE, List.of(drug7, drug4, drug1, drug10));
    private Patient patient15 = new Patient(15, "Рахим", "Рахимов", "2005 год 10 месяц 05 день", Patient.Gender.MALE, List.of(drug6));

    private ArrayList<Patient> data = new ArrayList<>(Arrays.asList(patient1, patient2, patient3, patient4, patient5, patient6, patient7, patient8, patient9, patient10, patient11, patient12, patient13, patient14, patient15));

    public Map<Patient, Map<Integer, Drug>> action () {
        return data.stream().
                collect(Collectors.toMap(patient -> patient,
                        patient -> patient.getAllergy().stream().collect(Collectors.toMap(Drug::getId, drug -> drug))));
    }
}
