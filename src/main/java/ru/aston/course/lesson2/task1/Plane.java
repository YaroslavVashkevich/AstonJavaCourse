package ru.aston.course.lesson2.task1;

public abstract class Plane implements Transport, AirTransport {
    private String wings;
    private String propeller;
    private String wheels;

    @Override
    public void fly() {
        System.out.println("Flying through the air");

    }

    @Override
    public void transport() {
        System.out.println("To transport cargo and passengers");
    }
}
