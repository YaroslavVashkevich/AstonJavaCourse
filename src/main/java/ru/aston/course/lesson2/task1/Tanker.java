package ru.aston.course.lesson2.task1;

public abstract class Tanker implements Transport, SeaTransport {
    private String propeller;

    @Override
    public void sail() {
        System.out.println("To sail on the water");
    }

    @Override
    public void transport() {
        System.out.println("To transport cargo");
    }
}
