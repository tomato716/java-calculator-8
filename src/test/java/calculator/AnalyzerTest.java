package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class AnalyzerTest {

    @Test
    void analyzeTest() {
        String input = "//;\n1,2:3;4";
        Analyzer analyzer = new Analyzer(input);
        List<String> newInput = analyzer.analyze();

        String testString = "1,2,3,4";
        assertEquals(List.of(testString.split(",")), newInput);
    }

}
