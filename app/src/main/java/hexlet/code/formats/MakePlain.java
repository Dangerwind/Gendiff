package hexlet.code.formats;

import hexlet.code.Utilites;

import java.util.List;
import java.util.Map;

import static hexlet.code.Utilites.Stat;
import static hexlet.code.Utilites.STATUS;
import static hexlet.code.Utilites.KEY;
import static hexlet.code.Utilites.VALUE1;
import static hexlet.code.Utilites.VALUE2;

public class MakePlain {

    public static String makePlain(List<Map<String, Object>> base) {
        var outputString = new StringBuilder();
        boolean firstFlag = false;
        for (var i : base) {
            if (i.get(STATUS).equals(Utilites.Stat.INVARIABLY)) {
                continue;
            }
            if (firstFlag) {
                outputString.append(System.lineSeparator());
            }
            firstFlag = true;
            outputString.append("Property '").append(i.get(KEY)).append("' was ");
            switch (i.get(STATUS)) {
                case Stat.ADD: outputString.append("added with value: ").append(objToPlain(i.get(VALUE1)));
                    break;
                case Stat.CHANGE:
                    outputString.append("updated. From ").append(objToPlain(i.get(VALUE1))).append(" to ").
                            append(objToPlain(i.get(VALUE2)));
                    break;
                case Stat.REMOVE:  outputString.append("removed");
                    break;
                default: break;
            }
        }
        return outputString.toString().trim();
    }

    public static String objToPlain(Object data) {
        if ((data instanceof Number) || (data instanceof Boolean)) {
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
}
