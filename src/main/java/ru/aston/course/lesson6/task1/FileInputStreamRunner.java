package ru.aston.course.lesson6.task1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileInputStreamRunner {
    public static void main(String[] args) throws IOException {

        readEachByteNio();
        System.out.println("--------------------");
        readAllBytesNio();
    }

    private static void readAllBytesNio() throws IOException {
        Path path = Paths.get("src/main/resources/text.txt");
        String stringValue = new String(Files.readAllBytes(path));
        System.out.println(stringValue);
    }

    private static void readEachByteNio() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get("src/main/resources/text.txt"), StandardOpenOption.READ, StandardOpenOption.CREATE)) {
            ByteBuffer buf = ByteBuffer.allocate(4);
            while (fileChannel.read(buf) != -1) {
                buf.flip();
                while (buf.hasRemaining()){
                    stringBuilder.append((char) buf.get());
                }
                buf.clear();
            }
            String stringValue = stringBuilder.toString();
            System.out.println(stringValue);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        Path path = Paths.get("src/main/resources/text.txt");
        String stringValue2 = Files.readString(path);
        System.out.println("*************************");
        System.out.println(stringValue2);
    }

}
