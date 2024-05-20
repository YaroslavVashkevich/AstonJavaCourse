package ru.aston.course.lesson4.task2;

import java.util.Collection;

public class MyLinkedList<T> implements MyList<T>, MyQueue<T> {
    private Node first;
    private Node last;
    private int size = 0;

    public MyLinkedList() {
    }

    public MyLinkedList(Collection<? extends T> elements) {
        Object[] arrayFromElements = elements.toArray();
        for (int i = 0; i < arrayFromElements.length; i++) {
            add((T) arrayFromElements[i]);
        }
    }

    @Override
    public T get(int index) {
        return getNode(index).value;
    }

    @Override
    public boolean add(T element) {
        if (size == 0) {
            first = new Node(null, element, null);
            last = first;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, element, null);
            secondLast.next = last;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            return add(element);
        }
        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.previous;
        Node newNode = new Node(nodePrevious, element, nodeNext);
        nodeNext.previous = newNode;
        if (nodePrevious != null) {
            nodePrevious.next = newNode;
        } else {
            first = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean addAll(Collection<T> elements) {
        Object[] arrayFromElements = elements.toArray();
        for (int i = 0; i < arrayFromElements.length; i++) {
            add((T) arrayFromElements[i]);
        }
        return true;
    }

    @Override
    public boolean set(int index, T element) {
        getNode(index).value = element;
        return true;
    }

    @Override
    public T peek() {
        return size > 0 ? get(0) : null;
    }

    @Override
    public T poll() {
        T element = get(0);
        removeAt(0);
        return element;
    }

    @Override
    public boolean remove(T element) {
        int index = findElement(element);
        if (index != -1) {
            return removeAt(index);
        }
        return false;
    }

    @Override
    public boolean contains(T element) {
        return findElement(element) != -1;
    }

    @Override
    public boolean removeAt(int index) {
        Node node = getNode(index);
        Node nodeNext = node.next;
        Node nodePrevious = node.previous;
        if (nodeNext != null) {
            nodeNext.previous = nodePrevious;
        } else {
            last = nodePrevious;
        }
        if (nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            first = nodeNext;
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public MyIterator iterator() {
        return new MyIterator() {
            private Node node = first;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public boolean remove() {
                return false;
            }

            @Override
            public T next() {
                T element = node.value;
                node = node.next;
                return element;
            }
        };
    }

    private int findElement(T element) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(element)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private class Node {
        private Node previous;
        private T value;
        private Node next;

        public Node(Node previous, T value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        MyIterator iterator = iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next().toString()).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).insert(0, "[").append("]");
        return stringBuilder.toString();
    }
}

