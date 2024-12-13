package hexlet.code;



import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static hexlet.code.Utilites.STATUS;
import static hexlet.code.Utilites.KEY;
import static hexlet.code.Utilites.VALUE1;
import static hexlet.code.Utilites.VALUE2;

public class MakeDifference {
    public static List<Map<String, Object>> makeDifference(Map<String, Object> dataMap1, Map<String, Object> dataMap2) {

        List<Map<String, Object>> base = new ArrayList<>();

        Set<String> keysDatabase = new TreeSet<>(dataMap1.keySet());
        keysDatabase.addAll(dataMap2.keySet());

        for (String keys : keysDatabase) {
            Map<String, Object> element = new HashMap<>();
            element.put(KEY, keys);
            if (!dataMap1.containsKey(keys)) {  // добавили
                element.put(STATUS, Utilites.Stat.ADD);
                element.put(VALUE1, dataMap2.get(keys));

            } else if (!dataMap2.containsKey(keys)) { // убрали
                element.put(STATUS, Utilites.Stat.REMOVE);
                element.put(VALUE1, dataMap1.get(keys));

            } else {  // если оба содержат этот ключи, проверка изменились ли данные
                Object valKey1 = dataMap1.get(keys);
                Object valKey2 = dataMap2.get(keys);
                if (Objects.equals(valKey1, valKey2)) {
                    element.put(STATUS, Utilites.Stat.INVARIABLY);
                    element.put(VALUE1, valKey1);
                } else {
                    element.put(STATUS, Utilites.Stat.CHANGE);
                    element.put(VALUE1, valKey1);
                    element.put(VALUE2, valKey2);
                }
            }
            base.add(element);
        }
        return base;
    }
}
