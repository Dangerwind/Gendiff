import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

import hexlet.code.Differ;

public class AppTests {
    private static String CompareStylish;
    private static String CompareJson;
    private static String ComparePlain;

    private static final String resultStylish = "src/test/resources/fixtures/result.stylish";
    private static final String resultJson = "src/test/resources/fixtures/result.json";
    private static final String resultPlain = "src/test/resources/fixtures/result.plain";
    private static final String pathToFixtures = "src/test/resources/fixtures/file";


    @BeforeAll
    public static void readAllAnswers() throws Exception {
       CompareStylish = new String(Files.readAllBytes(Paths.get(resultStylish)));
       CompareJson = new String(Files.readAllBytes(Paths.get(resultJson)));
       ComparePlain = new String(Files.readAllBytes(Paths.get(resultPlain)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yaml"})
    public void testStylishResult(String format) throws Exception {
        String actual = Differ.generate(pathToFixtures + "1." + format, pathToFixtures + "2." + format, "stylish");
        assertEquals(CompareStylish, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yaml"})
    public void testPlainResult(String format) throws Exception {
        String actual = Differ.generate(pathToFixtures + "1." + format, pathToFixtures + "2." + format, "plain");
        assertEquals(ComparePlain, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yaml"})
    public void testJsonResult(String format) throws Exception {
        String actual = Differ.generate(pathToFixtures + "1." + format, pathToFixtures + "2." + format, "json");
        assertEquals(CompareJson, actual);
    }
}
