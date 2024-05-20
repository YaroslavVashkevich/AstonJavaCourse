package ru.aston.course.lesson6.task1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class DataIoStreamRunner {
    public static void main(String[] args) {

        Person tom = new Person("Tom", 34, 1.68, true);
        // запись в файл
        writeDataToFile(tom);
        // обратное считывание из файла
        readDataFromFile();
    }

    private static void writeDataToFile(Person tom) {

        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get("src/main/resources/data.bin"), StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            ByteBuffer buf = ByteBuffer.allocate(100);
            buf.putInt(tom.age);
            buf.putDouble(tom.height);
            buf.putInt(tom.married ? 1 : 0);
            buf.put(tom.name.getBytes());
            buf.flip();
            fileChannel.write(buf);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void readDataFromFile() {

        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get("src/main/resources/data.bin"), StandardOpenOption.READ, StandardOpenOption.CREATE)) {
            ByteBuffer buf = ByteBuffer.allocate(100);
            StringBuilder stringBuilder = new StringBuilder();
            while (fileChannel.read(buf) != -1) {
                buf.flip();
                int age = buf.getInt();
                double height = buf.getDouble();
                boolean married = buf.getInt() == 1;
                while (buf.hasRemaining()) {
                    stringBuilder.append((char) buf.get());
                }
                String name = stringBuilder.toString();
                System.out.printf("Name: %s  Age: %d  Height: %f  Married: %b", name, age, height, married);
                buf.clear();
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class Person {
    public String name;
    public int age;
    public double height;
    public boolean married;

    public Person(String n, int a, double h, boolean m) {
        this.name = n;
        this.height = h;
        this.age = a;
        this.married = m;
    }
}