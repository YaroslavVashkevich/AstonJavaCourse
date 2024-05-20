package ru.aston.course.lesson4.task2;

import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<T> implements MyList<T> {

    private Object[] array = new Object[10];
    private int size = 0;

    public MyArrayList() {
    }

    public MyArrayList(Collection<? extends T> elements) {
        Object[] arrayFromElements = elements.toArray();
        if (size + arrayFromElements.length > array.length) {
            array = Arrays.copyOf(array, size + arrayFromElements.length);
        }
        System.arraycopy(arrayFromElements, 0, array, size, arrayFromElements.length);
        size += arrayFromElements.length;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

//    @Override
//    public void add(T element) {
//        if (size >= array.length) {
//            Object[] newArray = new Object[3*array.length/2+1];
//            for (int i = 0; i < array.length; i++) {
//                newArray[i] = array[i];
//            }
//            array = newArray;
//        }
//        array[size] = element;
//        size++;
//    }

    @Override
    public boolean add(T element) {
        increaseArray();
        array[size] = element;
        size++;
        return true;
    }

//    @Override
//    public void add(T element, int index) {
//        increaseArray();
//        if (index < 0 || index > size) {
//            throw new IndexOutOfBoundsException();
//        }
//        for (int i = size; i < index; i--) {
//            array[i] = array[i - 1];
//        }
//        array[index] = element;
//        size++;
//    }

    @Override
    public boolean add(T element, int index) {
        increaseArray();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
        return true;
    }

    @Override
    public boolean addAll(Collection<T> elements) {
        Object[] arrayFromElements = elements.toArray();
        if (size + arrayFromElements.length > array.length) {
            array = Arrays.copyOf(array, size + arrayFromElements.length);
        }
        System.arraycopy(arrayFromElements, 0, array, size, arrayFromElements.length);
        size += arrayFromElements.length;
        return true;
    }

    @Override
    public boolean set(int index, T element) {
        checkIndex(index);
        array[index] = element;
        return true;
    }

    @Override
    public boolean remove(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
//        for (int i = index; i < size - 1; i++) {
//            array[i] = array[i + 1];
//        }
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
        size--;
        return true;
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Object[10];
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseArray() {
        if (size >= array.length) {
            array = Arrays.copyOf(array, (3 * array.length) / 2 + 1);
        }
    }

    @Override
    public String toString() {
        Object[] arrayToString = Arrays.copyOf(array, size);
        return Arrays.toString(arrayToString);
    }

    @Override
    public MyIterator iterator() {
        return new MyIterator() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return (T) array[index++];
            }

            @Override
            public boolean remove() {
                boolean result = removeAt(index - 1);
                index--;
                return result;
            }
        };
    }
}
