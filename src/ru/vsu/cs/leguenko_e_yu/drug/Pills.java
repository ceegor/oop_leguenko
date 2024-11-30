package ru.vsu.cs.leguenko_e_yu.drug;

import java.util.Objects;

public class Pills extends Drug {
    private String form;

    public Pills(Integer id, String name, Integer strength, Double price, Double allergicLevel, String form) {
        super(id, name, strength, price, allergicLevel);
        this.form = form;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    @Override
    public String takeMedicine() {
        if (!this.getTaken())
            this.setTaken(true);
        else {
            return "Таблетка уже была выпита";
        }
        return "Таблетка выпита";
    }

    @Override
    public String toString() {
        return "Pills{" + super.toString() +
                "form='" + form + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pills pills)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(form, pills.form);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), form);
    }
}
