package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersTest {

    @DisplayName("올바른 계산을 하는지 테스트")
    @Test
    public void correctCalculate() {
        Numbers numbers = new Numbers(List.of("1", "2", "3"));

        Integer result = numbers.calculatePlus();

        assertThat(result).isEqualTo(6);
    }

    @DisplayName("음수값을 입력할 경우 예외 발생하는지 테스트")
    @Test
    public void validateNegativeNumber() {
        assertThatThrownBy(() -> new Numbers(List.of("-1", "2", "3")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 값을 입력할 경우 예외 발생하는지 테스트")
    @Test
    public void isNotDigit() {
        assertThatThrownBy(() -> new Numbers(List.of("a", "b", "3")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
