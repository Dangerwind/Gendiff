package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesLoading {
    public static String readFile(String fileName) throws Exception {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static String getFileType(String fileName) {
        String[] ext = fileName.split("\\.");
        return ext[ext.length - 1];
    }
}
