package ru.aston.course.lesson3.task1;

public class Whale extends Mammal implements Habitat {
    private int weight;

    @Override
    public void inhabit() {
        System.out.println("Lives in water");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Whale whale = (Whale) obj;
        return weight == whale.weight;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + weight;
        return result;
    }
}
