package devopspractice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreAverageFeatureTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testRunPrintsHeader() {
        ScoreAverageFeature.run();
        assertTrue(outContent.toString().contains("[Score Average]"));
    }

    @Test
    void testRunPrintsCorrectAverage() {
        ScoreAverageFeature.run();
        // (90 + 85 + 100) / 3 = 91.666...
        assertTrue(outContent.toString().contains("91.6"),
                "Average of 90, 85, 100 should be approximately 91.6");
    }

    @Test
    void testRunDoesNotThrow() {
        assertDoesNotThrow(ScoreAverageFeature::run);
    }
}
