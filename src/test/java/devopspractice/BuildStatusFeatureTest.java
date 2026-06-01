package devopspractice;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuildStatusFeatureTest {

    @Test
    void runPrintsBuildStatus() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {
            System.setOut(new PrintStream(output));
            BuildStatusFeature.run();
        } finally {
            System.setOut(originalOut);
        }

        String result = output.toString();

        assertTrue(result.contains("[Build Status]"));
        assertTrue(result.contains("Jenkins CI demo is ready."));
    }
}
