package devopspractice;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MemberSummaryFeatureTest {

    @Test
    void runPrintsMemberSummary() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {
            System.setOut(new PrintStream(output));
            MemberSummaryFeature.run();
        } finally {
            System.setOut(originalOut);
        }

        String result = output.toString();

        assertTrue(result.contains("[Member Summary]"));
        assertTrue(result.contains("Team leader: sumnunus"));
        assertTrue(result.contains("Team members: 2"));
    }
}
