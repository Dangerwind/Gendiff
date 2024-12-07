package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Formatter {

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
	public static String formatter(OutData base, String format) throws JsonProcessingException {
		format = "123";


		StringBuilder OutputString = null;

		format="json";
		if (format.equals("json")) {
			ObjectMapper objectMapper = new ObjectMapper();
			List<Map<String,Object>> jsonMapa = new ArrayList<>();

			// state  add remove change invariable
			// key
			// value1 value2


			for (int i = 0; i < base.getLength(); i++) {
				if ((base.getStatus(i) == Utilites.Stat.CHANGETWO)) continue;
				Map<String, Object> element = new HashMap<>();

				element.put("key",base.getKey(i));
				element.put("value1", base.getValue(i));
				switch (base.getStatus(i)) {
					case ADD:
						element.put("state", Utilites.Stat.ADD);
						break;
					case REMOVE:
						element.put("state", Utilites.Stat.REMOVE);
						break;
					case CHANGEONE: {
						element.put("value2", base.getValue(i+1));
						element.put("state", Utilites.Stat.CHANGE);
					}
						break;
					case INVARIABLY:
						element.put("state", Utilites.Stat.INVARIABLY);
						break;
				}
				jsonMapa.add(element);
			}
			return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonMapa);
		}



		if (format.equals("stylish")) {
			OutputString = new StringBuilder("{\n");
			for (int i = 0; i < base.getLength(); i++) {
				switch (base.getStatus(i)) {
					case ADD, CHANGETWO:
						OutputString.append("  + ");
						break;
					case REMOVE, CHANGEONE:
						OutputString.append("  - ");
						break;
					case INVARIABLY:
						OutputString.append("    ");
						break;
				}
				OutputString.append(base.getKey(i)).append(" ").
						append(base.getValue(i)).append(System.lineSeparator());
			}
			OutputString.append("}").append(System.lineSeparator());
			return OutputString.toString();
		}

		if (format.equals("plain")) {
			OutputString = new StringBuilder();
			for (int i = 0; i < base.getLength(); i++) {
				if ((base.getStatus(i) == Utilites.Stat.INVARIABLY) || (base.getStatus(i) == Utilites.Stat.CHANGETWO))
					continue;

				OutputString.append("Property '").append(base.getKey(i)).append("' was ");
				switch (base.getStatus(i)) {
					case ADD:
						OutputString.append("added with value: ").append(objToPlain(base.getValue(i)));
						break;
					case CHANGEONE:
						OutputString.append("updated. From ").append(objToPlain(base.getValue(i))).append(" to ").
								append(objToPlain(base.getValue(i + 1)));
						break;
					case REMOVE:
						OutputString.append("removed");
						break;
				}
				OutputString.append(System.lineSeparator());
				return OutputString.toString();
			}

		}
		return "";
	}
}
