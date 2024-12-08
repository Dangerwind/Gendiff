package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;

import static hexlet.code.formats.MakeFormats.makePlain;
import static hexlet.code.formats.MakeFormats.makeStylish;
import static hexlet.code.formats.MakeFormats.makeJson;

public class Formatter {
    public static String formatter(OutData base, String format) throws JsonProcessingException {
        return switch (format) {
            case "json" -> makeJson(base);
            case "stylish" -> makeStylish(base);
            case "plain" -> makePlain(base);
            default -> throw new IllegalArgumentException("Unsupported format");
        };
    }



}
