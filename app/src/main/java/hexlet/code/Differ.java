package hexlet.code;

import java.util.Map;

import static hexlet.code.FilesLoading.getFileType;
import static hexlet.code.FilesLoading.readFile;
import static hexlet.code.Formatter.formatter;

import static hexlet.code.MakeDifference.makeDifference;

public class Differ {
    public static String generate(String fileName1, String fileName2, String format) throws Exception {
        String fullFileData1 = readFile(fileName1);
        String fullFileData2 = readFile(fileName2);
        String dataType1 = getFileType(fileName1);
        String dataType2 = getFileType(fileName2);
        Map<String, Object> dataMap1 = Parser.parser(fullFileData1, dataType1);
        Map<String, Object> dataMap2 = Parser.parser(fullFileData2, dataType2);
        OutData base = makeDifference(dataMap1, dataMap2);
        return formatter(base, format);
    }
}

