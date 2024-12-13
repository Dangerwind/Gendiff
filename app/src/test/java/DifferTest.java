import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

import hexlet.code.Differ;

public final class DifferTest {
    private static String compareStylish;
    private static String compareJson;
    private static String comparePlain;

    private static final String FILE_STYLISH = "/Users/andreikokorev/java-project-71/app/src/test/resources/fixtures/result.stylish";
    private static final String FILE_JSON = "/Users/andreikokorev/java-project-71/app/src/test/resources/fixtures/result.json";
    private static final String FILE_PLAIN = "/Users/andreikokorev/java-project-71/app/src/test/resources/fixtures/result.plain";
    private static final String PATH_FIXTURES = "/Users/andreikokorev/java-project-71/app/src/test/resources/fixtures/file";

    @BeforeAll
    public static void readAllAnswers() throws Exception {
        compareStylish = new String(Files.readAllBytes(Paths.get(FILE_STYLISH)));
        compareJson = new String(Files.readAllBytes(Paths.get(FILE_JSON)));
        comparePlain = new String(Files.readAllBytes(Paths.get(FILE_PLAIN)));
    }
// 1 и 2 тесты - json и yaml в stylish
    @ParameterizedTest
    @ValueSource(strings = {"json", "yaml"})
    public void testStylishResult(String format) throws Exception {
        String actual = Differ.generate(PATH_FIXTURES + "1." + format, PATH_FIXTURES + "2."
                + format, "stylish");
        assertEquals(compareStylish, actual);
    }
// 3 и 4 тесты - json и yaml в plain
    @ParameterizedTest
    @ValueSource(strings = {"json", "yaml"})
    public void testPlainResult(String format) throws Exception {
        String actual = Differ.generate(PATH_FIXTURES + "1." + format, PATH_FIXTURES + "2."
                + format, "plain");
        assertEquals(comparePlain, actual);
    }
// 5 и 6 тесты - json и yaml в json
    @ParameterizedTest
    @ValueSource(strings = {"json", "yaml"})
    public void testJsonResult(String format) throws Exception {
        String actual = Differ.generate(PATH_FIXTURES + "1." + format, PATH_FIXTURES + "2."
                + format, "json");
        assertEquals(compareJson, actual);
    }
// 7 и 8 тесты - json и yaml в формат по умолчанию
    @ParameterizedTest
    @ValueSource(strings = {"json", "yaml"})
    public void testDefaultResult(String format) throws Exception {
        String actual = Differ.generate(PATH_FIXTURES + "1." + format, PATH_FIXTURES + "2." + format);
        assertEquals(compareStylish, actual);
    }
// если файлы окажутся пустыми
    /*
    @Test
    public void testEmpty () throws Exception {
        String actual = Differ.generate(PATH_FIXTURES + "empty.json", PATH_FIXTURES + "empty.json", "json");
        assertEquals(compareStylish, actual);
    }

*/

}
