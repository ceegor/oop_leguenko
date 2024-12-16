package ru.vsu.cs.leguenko_e_yu.disease;

import ru.vsu.cs.leguenko_e_yu.date.LocalDateHelpers;
import ru.vsu.cs.leguenko_e_yu.drug.Drug;

import java.time.Period;
import java.util.List;
import java.util.Objects;

public class Disease {
    private Integer id;
    private Double degree;
    private String startDate;
    private List<Drug> treatment;

    public Disease(Integer id, Double degree, String startDate, List<Drug> treatment) {
        this.id = id;
        this.degree = degree;
        this.startDate = startDate;
        this.treatment = treatment;
    }

    public Disease(Integer id, Double degree, String startDate) {
        this.id = id;
        this.degree = degree;
        this.startDate = startDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getDegree() {
        return degree;
    }

    public void setDegree(Double degree) {
        this.degree = degree;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public List<Drug> getTreatment() {
        return treatment;
    }

    public void setTreatment(List<Drug> treatment) {
        this.treatment = treatment;
    }

    public Integer duration() {
        return Period.between(LocalDateHelpers.parseFormat(startDate), LocalDateHelpers.getCurrentDate()).getDays();
    }

    @Override
    public String toString() {
        return "Disease{" +
                "id=" + id +
                ", degree=" + degree +
                ", startDate=" + startDate +
                ", treatment=" + treatment +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Disease disease)) return false;
        return Objects.equals(id, disease.id) && Objects.equals(degree, disease.degree) && Objects.equals(startDate, disease.startDate) && Objects.equals(treatment, disease.treatment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, degree, startDate, treatment);
    }
}
