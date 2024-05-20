package ru.aston.course.lesson4.task2;

public interface MyIterator {
    boolean hasNext();

    <T> T next();

    boolean remove();
}
