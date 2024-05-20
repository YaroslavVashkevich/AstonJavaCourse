package ru.aston.course.lesson6.task1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BufferedOutputStreamRunner {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("src/main/resources/text3.txt");
        String text = "Hello Java world!";
        byte[] data = text.getBytes();
        try (FileChannel channel = (FileChannel) Files.newByteChannel(path, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            ByteBuffer buffer = ByteBuffer.allocate(data.length);
            buffer.put(data);
            buffer.flip();
            channel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
