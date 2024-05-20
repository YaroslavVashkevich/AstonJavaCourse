package ru.aston.course.lesson2.task1;

public abstract class Taxi implements Transport, LandTransport {
    private String wheels;

    @Override
    public void drive() {
        System.out.println("Driving along the road");
    }

    @Override
    public void transport() {
        System.out.println("To transport passengers");
    }
}
