package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnalyzerTest {

    @DisplayName("기존 테스트 코드 형식에 맞게 테스트")
    @Test
    void sampleTest() {
        String input = "//;\\n1";
        Analyzer analyzer = new Analyzer(input, new Validator());
        List<Integer> numbers = analyzer.splitString();

        assertEquals(List.of(1), numbers);
    }

    @DisplayName("커스텀 구분자 및 구분자로 분리가 잘되는지")
    @Test
    void analyzeTest() {
        String input = "//;\n1,2:3;4";
        Analyzer analyzer = new Analyzer(input);
        List<Integer> numbers = analyzer.splitString();

        assertEquals(List.of(1, 2, 3, 4), numbers);
    }

    @DisplayName("0으로 시작하는 숫자가 0을 제거하고 올바르게 분리되는지")
    @Test
    void startZeroNumberTest() {
        String input = "01,05:09";
        Analyzer analyzer = new Analyzer(input);
        List<Integer> numbers = analyzer.splitString();

        assertEquals(List.of(1, 5, 9), numbers);
    }
}
