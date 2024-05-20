package ru.aston.course.lesson4.task1;

import java.util.*;

public class Collect {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(0, 4);
        arrayList.add(2, 5);
        System.out.println(arrayList.get(0));
        arrayList.remove(0);
        arrayList.removeAll(List.of(1, 2));
        arrayList.addAll(List.of(1, 2));
        arrayList.addAll(2, List.of(9, 9));
        arrayList.set(1, 7);
        System.out.println(arrayList.contains(9));
        System.out.println(arrayList.isEmpty());
        List<Integer> arrayList2 = arrayList.subList(2, 5);
        System.out.println(arrayList.size());
        System.out.println(arrayList.containsAll(arrayList2));
        System.out.println(arrayList.indexOf(5));
        System.out.println(arrayList.lastIndexOf(5));
        arrayList2.clear();
        Integer[] arrayFromArrayList = arrayList.toArray(new Integer[]{});
        System.out.println(Arrays.toString(arrayFromArrayList));
        System.out.println(arrayList);
        System.out.println(arrayList2);



        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(0, 4);
        linkedList.add(2, 5);
        System.out.println(linkedList.get(0));
        linkedList.remove(0);
        linkedList.removeAll(List.of(1, 2));
        linkedList.addAll(List.of(1, 2));
        linkedList.addAll(2, List.of(9, 9));
        linkedList.set(1, 7);
        System.out.println(linkedList.contains(9));
        System.out.println(linkedList.isEmpty());
        List<Integer> linkedList2 = linkedList.subList(2, 5);
        System.out.println(linkedList.size());
        System.out.println(linkedList.containsAll(linkedList2));
        System.out.println(linkedList.indexOf(5));
        System.out.println(linkedList.lastIndexOf(5));
        linkedList2.clear();
        Integer[] arrayFromLinkedList = linkedList.toArray(new Integer[]{});
        System.out.println(Arrays.toString(arrayFromLinkedList));
        System.out.println(linkedList);
        System.out.println(linkedList2);

        LinkedList<Integer> linkedList3 = new LinkedList<>();
        linkedList3.add(1);
        linkedList3.add(2);
        linkedList3.add(3);
        System.out.println(linkedList3);
        linkedList3.addFirst(8);
        linkedList3.addLast(9);
        System.out.println(linkedList3.getFirst());
        System.out.println(linkedList3.getLast());
        Integer a = linkedList3.removeFirst();
        Integer b = linkedList3.removeLast();
        System.out.println(linkedList3);
        Integer c =  linkedList3.peekFirst();
        Integer d = linkedList3.peekLast();
        Integer e = linkedList3.pollFirst();
        Integer f = linkedList3.pollLast();
        System.out.println(linkedList3);



        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "1");
        hashMap.put(2, "2");
        hashMap.put(3, "3");
        hashMap.put(4, "4");
        hashMap.put(5, "5");
        hashMap.remove(5, "5");
        hashMap.remove(4);
        hashMap.values().remove("1");
        System.out.println(hashMap.get(3));
        System.out.println(hashMap.getOrDefault(7, "NO"));
        System.out.println(hashMap.containsKey(2));
        hashMap.replace(2, "2", "9");
        hashMap.replace(2, "8");
        System.out.println(hashMap.isEmpty());
        System.out.println(hashMap.size());
        hashMap.putAll(Map.of(4, "4", 5, "5"));
        System.out.println(hashMap.containsValue("8"));
        hashMap.putIfAbsent(6, "6");
        Set<Integer> setKeys = hashMap.keySet();
        Collection<String> collectionValues = hashMap.values();
        for (Map.Entry<Integer, String> kv : hashMap.entrySet()) {
            Integer key = kv.getKey();
            String value = kv.getValue();
            System.out.println(key + " = " + value);
        }
        hashMap.clear();
        System.out.println(hashMap);
    }
}
