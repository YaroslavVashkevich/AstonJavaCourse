package ru.aston.course.lesson4.task2;

import java.util.List;

public class Sort {

    public static void bubbleSort1(List<Integer> list) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    int temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
    }

    public static void bubbleSort2(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            boolean sorted = true;
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }
}