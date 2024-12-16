package ru.vsu.cs.leguenko_e_yu.disease;

import java.util.Comparator;

public class DiseaseDurationComparator implements Comparator<Disease> {
    @Override
    public int compare(Disease o1, Disease o2) {
        return o1.duration().compareTo(o2.duration());
    }
}
