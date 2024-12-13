package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Map;

import static hexlet.code.formats.MakePlain.makePlain;
import static hexlet.code.formats.MakeStylish.makeStylish;
import static hexlet.code.formats.MakeJson.makeJson;

public class Formatter {
    public static String formatter(List<Map<String, Object>> base, String format) throws JsonProcessingException {
        return switch (format) {
            case "json" -> makeJson(base);
            case "stylish" -> makeStylish(base);
            case "plain" -> makePlain(base);
            default -> throw new IllegalArgumentException("Unsupported format");
        };
    }



}
