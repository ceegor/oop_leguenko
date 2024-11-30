package ru.vsu.cs.leguenko_e_yu.drug;

import java.util.Objects;

public class Syrup extends Drug {
    private Color color;
    private Taste taste;

    public Syrup(Integer id, String name, Integer strength, Double price, Double allergicLevel, Color color, Taste taste) {
        super(id, name, strength, price, allergicLevel);
        this.color = color;
        this.taste = taste;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Taste getTaste() {
        return taste;
    }

    public void setTaste(Taste taste) {
        this.taste = taste;
    }

    @Override
    public String takeMedicine() {
        if (!this.getTaken())
            this.setTaken(true);
        else {
            return "Сироп уже был выпит";
        }
        return "Сироп выпит";
    }

    @Override
    public String toString() {
        return "Syrup{" + super.toString() +
                "color=" + color +
                ", taste=" + taste +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Syrup syrup)) return false;
        if (!super.equals(o)) return false;
        return color == syrup.color && taste == syrup.taste;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color, taste);
    }

    public enum Color {
        BLACK,
        WHITE,
        BROWN,
        YELLOW;
    }
    public enum Taste {
        HONEY,
        LEMON,
        STRAWBERRY,
        ORANGE;
    }
}
