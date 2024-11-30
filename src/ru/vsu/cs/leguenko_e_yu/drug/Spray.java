package ru.vsu.cs.leguenko_e_yu.drug;

import java.util.Objects;

public class Spray extends Drug {
    private String organToSpray;

    public Spray(Integer id, String name, Integer strength, Double price, Double allergicLevel, String organToSpray) {
        super(id, name, strength, price, allergicLevel);
        this.organToSpray = organToSpray;
    }

    public String getOrganToSpray() {
        return organToSpray;
    }

    public void setOrganToSpray(String organToSpray) {
        this.organToSpray = organToSpray;
    }

    @Override
    public String takeMedicine() {
        if (!this.getTaken())
            this.setTaken(true);
        else {
            return "Спрей уже был разбрызган";
        }
        return "Спрей разбрызган";
    }

    @Override
    public String toString() {
        return "Drops{" + super.toString() +
                "organ='" + organToSpray + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Spray spray)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(organToSpray, spray.organToSpray);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), organToSpray);
    }
}
