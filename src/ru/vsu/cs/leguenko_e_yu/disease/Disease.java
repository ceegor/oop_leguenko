package ru.vsu.cs.leguenko_e_yu.disease;

import ru.vsu.cs.leguenko_e_yu.drug.Drug;

import java.util.List;
import java.util.Objects;

public class Disease {
    private Integer id;
    private Double degree;
    private Integer duration;
    private List<Drug> treatment;

    public Disease(Integer id, Double degree, Integer duration, List<Drug> treatment) {
        this.id = id;
        this.degree = degree;
        this.duration = duration;
        this.treatment = treatment;
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public List<Drug> getTreatment() {
        return treatment;
    }

    public void setTreatment(List<Drug> treatment) {
        this.treatment = treatment;
    }

    @Override
    public String toString() {
        return "Disease{" +
                "id=" + id +
                ", degree=" + degree +
                ", duration=" + duration +
                ", treatment=" + treatment +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Disease disease)) return false;
        return Objects.equals(id, disease.id) && Objects.equals(degree, disease.degree) && Objects.equals(duration, disease.duration) && Objects.equals(treatment, disease.treatment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, degree, duration, treatment);
    }
}