package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {

	public static Map<String, Object> parser(String rawData, String dataType) throws Exception {
		ObjectMapper objectMapper = null;

		if (dataType.equals("json")) {
			objectMapper = new ObjectMapper();
		} else if (dataType.equals("yaml") || dataType.equals("yml")) {
			objectMapper = new YAMLMapper();
		} else {
			throw new IllegalArgumentException("Unsupported format");
		}
		return objectMapper.readValue(rawData, Map.class);
	}

}
