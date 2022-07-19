package ua.ithillel.lectures.lecture_10.txtfilereader;

import ua.ithillel.lectures.lecture_10.exception.IncorrectFileNameException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TxtFileReader {

    private final String filePath;

    public TxtFileReader(String path) {
        this.filePath = path;
    }

    public String readFileContent() throws IncorrectFileNameException, IOException {
        if (!filePath.endsWith(".txt")) {
            throw new IncorrectFileNameException("File extension is not .txt");
        }
        String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
        return fileContent;
    }

}

