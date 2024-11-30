package ru.vsu.cs.leguenko_e_yu.drug;

import java.util.Objects;

public class Ointment extends Drug {
    private String organToWipe;
    public Ointment(Integer id, String name, Integer strength, Double price, Double allergicLevel, String organToWipe) {
        super(id, name, strength, price, allergicLevel);
        this.organToWipe = organToWipe;
    }

    public String getOrganToWipe() {
        return organToWipe;
    }

    public void setOrganToWipe(String organToWipe) {
        this.organToWipe = organToWipe;
    }

    @Override
    public String takeMedicine() {
        if (!this.getTaken())
            this.setTaken(true);
        else {
            return "Мазь уже была намазана";
        }
        return "Мазь намазана";
    }

    @Override
    public String toString() {
        return "Ointment{" + super.toString() +
                "organToWipe='" + organToWipe + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ointment ointment)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(organToWipe, ointment.organToWipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), organToWipe);
    }
}
