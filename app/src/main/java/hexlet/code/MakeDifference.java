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
		for(String key : keysDatabase) {
			if(!dataMap1.containsKey(key)) {  // добавили
				base.add(Utilites.Stat.ADD, key, dataMap2.get(key));
			} else if (!dataMap2.containsKey(key)) { // убрали
				base.add(Utilites.Stat.REMOVE, key, dataMap1.get(key));
			} else {  // если оба содержат этот ключи, проверка изменились ли данные
				Object ValKey1 = dataMap1.get(key);
				Object ValKey2 = dataMap2.get(key);
				if (Objects.equals(ValKey1, ValKey2)) {
					base.add(Utilites.Stat.INVARIABLY, key, ValKey1);
				} else {
					base.add(Utilites.Stat.CHANGEONE, key, ValKey1);
					base.add(Utilites.Stat.CHANGETWO, key, ValKey2);
				}
			}
		}
		return base;
	}
}
