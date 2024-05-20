package ru.aston.course.lesson3.task1;

import java.util.Objects;

public class Fish extends Animal implements Habitat {
    private String type;
    private double weight;
    private int length;

    @Override
    public void inhabit() {
        System.out.println("Lives in water");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fish fish = (Fish) o;
        return Double.compare(fish.weight, weight) == 0 && length == fish.length && Objects.equals(type, fish.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, weight, length);
    }
}
