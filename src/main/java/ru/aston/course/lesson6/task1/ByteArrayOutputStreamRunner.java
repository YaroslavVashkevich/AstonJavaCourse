package ru.aston.course.lesson6.task1;

import java.nio.ByteBuffer;

public class ByteArrayOutputStreamRunner {

    public static void main(String[] args) {

        String text = "Hello world!";
        byte[] buffer = text.getBytes();
        ByteBuffer buf = ByteBuffer.allocate(buffer.length);
        buf.put(buffer);
        buf.flip();
        while (buf.hasRemaining()) {
            System.out.print((char) buf.get());
        }
    }
}