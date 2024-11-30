package ru.vsu.cs.leguenko_e_yu.patient;

import ru.vsu.cs.leguenko_e_yu.disease.Disease;
import ru.vsu.cs.leguenko_e_yu.disease.DiseaseDurationComparator;
import ru.vsu.cs.leguenko_e_yu.drug.Drug;
import ru.vsu.cs.leguenko_e_yu.exception.ErrorType;
import ru.vsu.cs.leguenko_e_yu.exception.MyException;

import java.util.*;

public class Patient {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private Gender gender;
    private List<Drug> allergy;
    private static String country;
    private List<Disease> diseases;

    public Patient(Integer id, String name, String surname, Integer age, Gender gender) {
        this(id, name, surname, age, gender, new ArrayList<>(), new ArrayList<>());
    }

    public Patient(Integer id, String name, String surname, Integer age, Gender gender, List<Drug> allergy) {
        this(id, name, surname, age, gender, allergy, new ArrayList<>());
    }

    public Patient(Integer id, String name, String surname, Integer age, Gender gender, List<Drug> allergy, List<Disease> diseases) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.allergy = allergy;
        this.diseases = diseases;
    }

    static {
        country = "Russia";
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Drug> getAllergy() {
        return allergy;
    }

    public void setAllergy(List<Drug> allergy) {
        this.allergy = allergy;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }

    public String takeThisDrug(Drug drug) {
        if (!this.getAllergy().contains(drug) && !drug.getTaken()) {
            drug.setTaken(true);
            return "%s был(о) принят(о)".formatted(drug.getName());
        }
        return "%s уже был(о) принят(о) или у %s на него аллергия".formatted(drug.getName(), this.name);
    }

    public void treat(Drug drug, Disease disease) {
        System.out.println(takeThisDrug(drug));
        if (drug.canTreat(this, disease)) {
            this.diseases.remove(disease);
        }
    }

    public void sortDiseases(DiseaseDurationComparator comparator) throws MyException {
        if (this.diseases.isEmpty()) {
            throw new MyException(ErrorType.NULL_VALUE);
        }
        this.diseases.sort(comparator.reversed());
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", allergy=" + allergy +
                ", diseases=" + diseases +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient patient)) return false;
        return Objects.equals(id, patient.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public enum Gender {
        MALE,
        FEMALE;
    }
}
