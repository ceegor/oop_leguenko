package ru.vsu.cs.leguenko_e_yu.drug;

import ru.vsu.cs.leguenko_e_yu.disease.Disease;
import ru.vsu.cs.leguenko_e_yu.exception.MyException;
import ru.vsu.cs.leguenko_e_yu.patient.Patient;

import java.util.Objects;

public class Drug {
    private Integer id;
    private String name;
    private Integer strength;
    private Double price;
    private Double allergicLevel;
    private Boolean isTaken = false;
    private static Integer expiryDays;

    {
        System.out.println("Создано новое лекарство");
    }

    public Drug(Integer id, String name, Integer strength, Double price) {
        this(id, name, strength, price, 0.0);
    }

    public Drug(Integer id, String name, Integer strength, Double price, Double allergicLevel) {
        this.id = id;
        this.name = name;
        this.strength = strength;
        this.price = price;
        this.allergicLevel = allergicLevel;
    }

    static {
        expiryDays = 700;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAllergicLevel() {
        return allergicLevel;
    }

    public void setAllergicLevel(Double allergicLevel) {
        this.allergicLevel = allergicLevel;
    }

    public Boolean getTaken() {
        return isTaken;
    }

    public void setTaken(Boolean taken) {
        isTaken = taken;
    }

    public String takeMedicine() {
        if (!this.getTaken()) {
            this.setTaken(true);
            return "Лекарство принято";
        }
        return "Лекарство уже было принято";
    }

    public boolean canTreat(Patient patient, Disease disease) {
        if (patient.getDiseases().contains(disease)) {
            int diseaseIndex = patient.getDiseases().indexOf(disease);
            return this.strength >= patient.getDiseases().get(diseaseIndex).getDegree() &&
                    disease.getTreatment().contains(this) &&
                    !patient.getAllergy().contains(this);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", strength=" + strength +
                ", price=" + price +
                ", allergicLevel=" + allergicLevel +
                ", isTaken=" + isTaken +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drug drug)) return false;
        return Objects.equals(id, drug.id) && Objects.equals(name, drug.name) && Objects.equals(strength, drug.strength) && Objects.equals(price, drug.price) && Objects.equals(allergicLevel, drug.allergicLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, strength, price, allergicLevel);
    }
}
