package ru.aston.course.lesson4.task2;

import java.util.Collection;

public interface MyList<T> {
    T get(int index);

    boolean add(T element);

    boolean add(T element, int index);

    boolean addAll(Collection<T> elements);

    boolean set(int index, T element);

    boolean remove(T element);

    boolean removeAt(int index);

    boolean contains(T element);

    int size();

    void clear();

    MyIterator iterator();
}
