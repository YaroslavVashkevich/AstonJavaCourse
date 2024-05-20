package ru.aston.course.lesson3.task1;

public abstract class Mammal extends Animal {
    private String spine;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Mammal mammal = (Mammal) obj;
        if (spine == null) {
            if (mammal.spine != null) return false;
        } else if (!spine.equals(mammal.spine)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (spine != null ? spine.hashCode() : 0);
        return result;
    }
}
