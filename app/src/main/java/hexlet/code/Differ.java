package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static hexlet.code.Formatter.formatter;
import static hexlet.code.MakeDifference.makeDifference;


public class Differ {
    public static String generate(String fileName1, String fileName2, String format) throws Exception {
        String fullFileData1 = readFile(fileName1).trim();
        String fullFileData2 = readFile(fileName2).trim();

        if ((fullFileData1.isEmpty()) || (fullFileData2.isEmpty())) {
            throw new Error("File is empty!");
        }


        String dataType1 = getFileType(fileName1);
        String dataType2 = getFileType(fileName2);

        Map<String, Object> dataMap1 = Parser.parser(fullFileData1, dataType1);
        Map<String, Object> dataMap2 = Parser.parser(fullFileData2, dataType2);
        List<Map<String, Object>> base = makeDifference(dataMap1, dataMap2);

        return formatter(base, format);
    }
    private static Path getFixturePath(String fileName) {
        return Paths.get("app", "src", "test", "resources", "fixtures", fileName).toAbsolutePath().normalize();
    }
    public static String generate(String fileName1, String fileName2) throws Exception {
        return generate(fileName1, fileName2, "stylish");
    }
    public static String readFile(String fileName) throws Exception {
        if (fileName.charAt(0) == '/') {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        }
        return new String(Files.readAllBytes(getFixturePath(fileName)));
    }

    public static String getFileType(String fileName) {
        String[] ext = fileName.split("\\.");
        return ext[ext.length - 1];
    }
}

