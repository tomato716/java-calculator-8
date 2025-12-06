package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DelimiterTest {
    private Delimiter delimiter;

    private static Stream<Arguments> provideSplitNumbers() {
        return Stream.of(
                Arguments.of("1,2:3", List.of("1", "2", "3")),
                Arguments.of("//;\\n1,2:3;4", List.of("1", "2", "3", "4")),
                Arguments.of("//abs\\n1abs2abs3abs4", List.of("1", "2", "3", "4")),
                Arguments.of("//+\\n1+2+3+4", List.of("1", "2", "3", "4")),
                Arguments.of("", List.of())
        );
    }

    @BeforeEach
    void reset() {
        delimiter = new Delimiter();
    }

    @DisplayName("구분자로 문자열 올바른 분리를 하는지 테스트")
    @ParameterizedTest(name = "입력 문자열 : \"{0}\" -> 결과 리스트 : {1}")
    @MethodSource("provideSplitNumbers")
    void splitNumbersSuccess(String input, List<String> expected) {
        List<String> splitNumbers = delimiter.split(input);

        assertThat(splitNumbers).containsExactlyElementsOf(expected);
    }
}
