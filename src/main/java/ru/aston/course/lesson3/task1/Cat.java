package ru.aston.course.lesson3.task1;

public class Cat extends Mammal {
    private String wool;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Cat cat = (Cat) obj;
        if (wool == null) return cat.wool == null;
        return wool.equals(cat.wool);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (wool != null ? wool.hashCode() : 0);
        return result;
    }
}
