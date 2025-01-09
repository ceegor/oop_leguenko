import ru.vsu.cs.leguenko_e_yu.date.LocalDateHelpers;
import ru.vsu.cs.leguenko_e_yu.disease.Disease;
import ru.vsu.cs.leguenko_e_yu.drug.*;
import ru.vsu.cs.leguenko_e_yu.patient.*;
import ru.vsu.cs.leguenko_e_yu.exception.MyException;
import ru.vsu.cs.leguenko_e_yu.stream.*;
//import ru.vsu.cs.leguenko_e_yu.disease.DiseaseDurationComparator;

public class Main {
    public static void main(String[] args) throws MyException {
        MyStream stream = new MyStream();
        stream.action().forEach((patient, drugMap) -> {
            System.out.println(patient + " -> " + drugMap);
        });
    }
}