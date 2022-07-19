package ua.ithillel.lectures.lecture_10;

import ua.ithillel.lectures.lecture_10.exception.IncorrectFileNameException;
import ua.ithillel.lectures.lecture_10.txtfilereader.TxtFileReader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lecture10 {
    public final static String FILE_PATH = "src/main/java/ua/ithillel/lectures/lecture_10/text.txt";

    public static void main(String[] args) {
        // exceptionExamples();
        // checkedException();
        // customException();
        tryWithResources();
    }

    private static void tryWithResources() {
        try (FileOutputStream fileOutputStream = new FileOutputStream("src/main/java/ua/ithillel/lectures/lecture_10/text.txt")) {
            String greetings = "Hello world";
            fileOutputStream.write(greetings.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void customException() {
        TxtFileReader txtFileReader = new TxtFileReader(FILE_PATH);
        try {
            String content = txtFileReader.readFileContent();
            System.out.println("File content = " + content);
        } catch (IncorrectFileNameException | IOException e) {
            if (e instanceof IncorrectFileNameException) {
                System.out.println("incorrect file name");
            } else {
                e.printStackTrace();
            }
        }
    }

    private static void checkedException() {
        String path = "src/main/java/ua/ithillel/lectures/lecture_10/text.txt";
        Path txtFilePath = Paths.get(path);
        try {
            String fileContent = new String(Files.readAllBytes(txtFilePath));
            System.out.println("File content " + fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }

    private static void exceptionExamples() {
        int[] myArray = new int[2];
        myArray[0] = 1;
        System.out.println(Arrays.toString(myArray));
        try {
            myArray[2] = 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR");
        }


        List<String> myList = new ArrayList<>();
        myList.add("a");
        myList.add("b");
        myList.add("z");
        // myList.add(null);

        for (String s : myList) {
            System.out.println(s.toUpperCase());
        }
    }
}

