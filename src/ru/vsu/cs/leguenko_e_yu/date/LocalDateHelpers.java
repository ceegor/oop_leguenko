package ru.vsu.cs.leguenko_e_yu.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateHelpers {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy 'год' MM 'месяц' dd 'день'");

    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    public static LocalDate stringToDate(String text) {
        return LocalDate.parse(text);
    }

    public static LocalDate parseFormat(String text) {
        return LocalDate.parse(text, formatter);
    }
}
