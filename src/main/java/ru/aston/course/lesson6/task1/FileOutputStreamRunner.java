package ru.aston.course.lesson6.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileOutputStreamRunner {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/text2.txt");
        String value = "Hello World2!";
        Files.write(path, value.getBytes(), StandardOpenOption.APPEND);
    }
}
