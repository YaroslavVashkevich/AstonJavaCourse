package ru.aston.course.lesson3.task1;

public class Bear extends Mammal {
    private String wool;
    private double weight;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Bear bear = (Bear) obj;
        if (Double.compare(weight, bear.weight) != 0) return false;
        if (wool == null) return bear.wool == null;
        return wool.equals(bear.wool);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (wool != null ? wool.hashCode() : 0);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

}
