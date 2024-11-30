import ru.vsu.cs.leguenko_e_yu.disease.Disease;
import ru.vsu.cs.leguenko_e_yu.exception.MyException;
import ru.vsu.cs.leguenko_e_yu.patient.Patient;
import ru.vsu.cs.leguenko_e_yu.schedule.Schedule;
import ru.vsu.cs.leguenko_e_yu.disease.DiseaseDurationComparator;
import ru.vsu.cs.leguenko_e_yu.drug.Drug;
import ru.vsu.cs.leguenko_e_yu.drug.Pills;
import ru.vsu.cs.leguenko_e_yu.drug.Spray;
import ru.vsu.cs.leguenko_e_yu.drug.Syrup;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws MyException {
        DiseaseDurationComparator comp1 = new DiseaseDurationComparator();
        PriorityQueue<Disease> pqDisease = new PriorityQueue<>(comp1);
        Drug drug1 = new Drug(1,"ААА", 100, 400.0, 5.0);
        Drug acyclovir = new Pills(2, "Ацикловир", 300, 500.0, 4.0,"Таблетка");
        Drug acc = new Syrup(3, "АЦЦ", 200, 300.0, 4.0, Syrup.Color.WHITE, Syrup.Taste.STRAWBERRY);
        //Паценты
        Patient patient1 = new Patient(1,"Егор", "Легуенко", 19, Patient.Gender.MALE, Arrays.asList(acyclovir));
        Patient patient2 = new Patient(2,"Максим", "Жаринов", 18, Patient.Gender.MALE);
        Patient patient3 = new Patient(3, "Иван", "Шамаев", 19, Patient.Gender.MALE);
        //
        Schedule schedule = new Schedule();
        schedule.addDrugToSchedule(patient1, acc, LocalDateTime.of(2024, 9, 29, 9, 0));
        schedule.addDrugToSchedule(patient1, acyclovir, LocalDateTime.of(2024, 9, 29, 18, 0));
        schedule.addDrugToSchedule(patient2, acyclovir, LocalDateTime.of(2024, 9, 29, 10, 0));
        Disease disease1 = new Disease(1,44.0, 50, new ArrayList<>());
        Disease disease2 = new Disease(2,30.0, 51, new ArrayList<>());
        Disease disease3 = new Disease(3, 30.00, 60, new ArrayList<>());
        patient1.setDiseases(Arrays.asList(disease2, disease1));
        patient1.sortDiseases(comp1);

        patient3.sortDiseases(comp1);

        schedule.showSchedule();
        System.out.println(patient1.getAllergy());
        System.out.println("---------");

        Drug drug2 = new Spray(4,"привет", 200, 400.0, 4.0, "Рука");

        schedule.requireForDrug(patient1, drug1);
        schedule.showSchedule();
        System.out.println("---------");
        schedule.cancelDrug(patient1, drug1);
        schedule.showSchedule();
    }
}