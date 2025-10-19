package calculator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @DisplayName("커스텀 구분자 및 구분자로 분리된 문자열에 다른 문자가 포함되어있으면 예외 발생")
    @Test
    void validateOtherCharacter() {
        List<String> splitString = List.of("a", "1", "2");
        Validator validator = new Validator();

        assertThrows(IllegalArgumentException.class, () -> validator.validateInput(splitString));
    }

    @DisplayName("커스텀 구분자 및 구분자로 분리된 문자열에 다른 문자가 포함되어있으면 예외 발생")
    @Test
    void validatePlusMinus() {
        List<String> splitString = List.of("+1", "2", "-3");
        Validator validator = new Validator();

        assertThrows(IllegalArgumentException.class, () -> validator.validateInput(splitString));
    }

}
