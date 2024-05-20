package ru.aston.course.lesson6.task1;

import java.nio.ByteBuffer;

public class ByteArrayInputStreamRunner {

    public static void main(String[] args) {

        readAllBytes();
        readFiveChars();
    }

    private static void readAllBytes() {
        byte[] array1 = new byte[]{1, 3, 5, 7};

        ByteBuffer buf = ByteBuffer.allocate(array1.length);
        buf.put(array1);
        buf.flip();
        while (buf.hasRemaining()) {
            System.out.println(buf.get());
        }
    }

    private static void readFiveChars() {
        String text = "Hello world!";
        byte[] array2 = text.getBytes();

        ByteBuffer buf = ByteBuffer.allocate(array2.length);
        buf.put(array2, 0, 5);
        buf.flip();
        while (buf.hasRemaining()) {
            System.out.println((char) buf.get());
        }
    }
}
