package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DelimiterTest {
    private Delimiter delimiter;

    @BeforeEach
    void reset() {
        delimiter = new Delimiter();
    }

    @DisplayName("구분자로 문자열 올바른 분리를 하는지 테스트")
    @Test
    void correctSeparateNumbers() {
        String input = "1,2:3";

        List<String> splitNumber = delimiter.separateNumbers(input);

        assertThat(splitNumber).isEqualTo(List.of("1", "2", "3"));
    }

    @DisplayName("커스텀 구분자가 있을 경우 올바른 분리를 하는지 테스트")
    @Test
    void correctSeparateCustomDelimiter() {
        String input = "//;\\n1,2:3;4";

        List<String> splitNumber = delimiter.separateNumbers(input);

        assertThat(splitNumber).isEqualTo(List.of("1", "2", "3", "4"));
    }
}
