package ru.aston.course.lesson2.task2;

public class Fish extends Animal implements Habitat {
    @Override
    public void inhabit() {
        System.out.println("Lives in water");
    }
}
