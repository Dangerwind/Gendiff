import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

import hexlet.code.Differ;

public class DifferTest {
    private static String compareStylish;
    private static String compareJson;
    private static String comparePlain;

    private static final String FILE_STYLISH = "src/test/resources/fixtures/result.stylish";
    private static final String FILE_JSON = "src/test/resources/fixtures/result.json";
    private static final String FILE_PLAIN = "src/test/resources/fixtures/result.plain";
    private static final String PATH_FIXTURES = "src/test/resources/fixtures/file";


    @BeforeAll
    public static void readAllAnswers() throws Exception {
        compareStylish = new String(Files.readAllBytes(Paths.get(FILE_STYLISH)));
        compareJson = new String(Files.readAllBytes(Paths.get(FILE_JSON)));
        comparePlain = new String(Files.readAllBytes(Paths.get(FILE_PLAIN)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yaml"})
    public void testStylishResult(String format) throws Exception {
        String actual = Differ.generate(PATH_FIXTURES + "1." + format, PATH_FIXTURES + "2." + format, "stylish");
        assertEquals(compareStylish, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yaml"})
    public void testPlainResult(String format) throws Exception {
        String actual = Differ.generate(PATH_FIXTURES + "1." + format, PATH_FIXTURES + "2." + format, "plain");
        assertEquals(comparePlain, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yaml"})
    public void testJsonResult(String format) throws Exception {
        String actual = Differ.generate(PATH_FIXTURES + "1." + format, PATH_FIXTURES + "2." + format, "json");
        assertEquals(compareJson, actual);
    }
}
