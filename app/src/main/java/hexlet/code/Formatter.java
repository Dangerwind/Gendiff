package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatter(OutData base, String format) throws JsonProcessingException {
        return switch (format) {
            case "json" -> makeJson(base);
            case "stylish" -> makeStylish(base);
            case "plain" -> makePlain(base);
            default -> throw new IllegalArgumentException("Unsupported format");
        };
    }


    public static String objToPlain(Object data) {
        if (data instanceof Number) {
            return data.toString();
        }
        if (data instanceof Boolean) {
            return data.toString();
        }
        if (data instanceof String) {
            return "'" + data.toString() + "'";
        }
        if (data == null) {
            return null;
        }
        return "[complex value]";
    }

    public static String makeJson(OutData base) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> jsonMapa = new ArrayList<>();
        for (int i = 0; i < base.getLength(); i++) {
            if ((base.getStatus(i) == Utilites.Stat.CHANGETWO)) {
                continue;
            }
            Map<String, Object> element = new HashMap<>();
            element.put("key", base.getKey(i));
            element.put("value1", base.getValue(i));

            switch (base.getStatus(i)) {
                case ADD:
                    element.put("state", Utilites.Stat.ADD);
                    break;
                case REMOVE:
                    element.put("state", Utilites.Stat.REMOVE);
                    break;
                case CHANGEONE:
                    element.put("value2", base.getValue(i + 1));
                    element.put("state", Utilites.Stat.CHANGE);
                    break;
                case INVARIABLY:
                    element.put("state", Utilites.Stat.INVARIABLY);
                    break;
                default: break;
            }
            jsonMapa.add(element);
        }
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonMapa);
    }

    public static String makeStylish(OutData base) {
        StringBuilder outputString = null;

        outputString = new StringBuilder("{");
        outputString.append(System.lineSeparator());
        for (int i = 0; i < base.getLength(); i++) {
            switch (base.getStatus(i)) {
                case ADD, CHANGETWO:
                    outputString.append("  + ");
                    break;
                case REMOVE, CHANGEONE:
                    outputString.append("  - ");
                    break;
                case INVARIABLY:
                    outputString.append("    ");
                    break;
                default:
                    break;
            }
            outputString.append(base.getKey(i)).append(" ").
                    append(base.getValue(i)).append(System.lineSeparator());
        }

        return outputString.append("}").toString();
    }

    public static String makePlain(OutData base) {
        StringBuilder outputString = null;
        outputString = new StringBuilder();
        for (int i = 0; i < base.getLength(); i++) {
            if ((base.getStatus(i) == Utilites.Stat.INVARIABLY) || (base.getStatus(i) == Utilites.Stat.CHANGETWO)) {
                continue;
            }
            outputString.append("Property '").append(base.getKey(i)).append("' was ");
            switch (base.getStatus(i)) {
                case ADD:
                    outputString.append("added with value: ").append(objToPlain(base.getValue(i)));
                    break;
                case CHANGEONE:
                    outputString.append("updated. From ").append(objToPlain(base.getValue(i))).append(" to ").
                            append(objToPlain(base.getValue(i + 1)));
                    break;
                case REMOVE:
                    outputString.append("removed");
                    break;
                default: break;
            }
            outputString.append(System.lineSeparator());
        }
        return outputString.toString();
    }


}
