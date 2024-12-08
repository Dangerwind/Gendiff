package hexlet.code;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class MakeDifference {
    public static OutData makeDifference(Map<String, Object> dataMap1, Map<String, Object> dataMap2) {

        var base = new OutData();

        Set<String> keysDatabase = new TreeSet<>(dataMap1.keySet());
        keysDatabase.addAll(dataMap2.keySet());

        for (String key : keysDatabase) {
            if (!dataMap1.containsKey(key)) {  // добавили
                base.add(Utilites.Stat.ADD, key, dataMap2.get(key));
            } else if (!dataMap2.containsKey(key)) { // убрали
                base.add(Utilites.Stat.REMOVE, key, dataMap1.get(key));
            } else {  // если оба содержат этот ключи, проверка изменились ли данные
                Object valKey1 = dataMap1.get(key);
                Object valKey2 = dataMap2.get(key);
                if (Objects.equals(valKey1, valKey2)) {
                    base.add(Utilites.Stat.INVARIABLY, key, valKey1);
                } else {
                    base.add(Utilites.Stat.CHANGEONE, key, valKey1);
                    base.add(Utilites.Stat.CHANGETWO, key, valKey2);
                }
            }
        }
        return base;
    }
}
