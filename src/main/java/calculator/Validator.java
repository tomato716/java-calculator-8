package calculator;

import java.util.List;

public class Validator {

    public void validateInput(List<String> splitString) {
        for (String string : splitString) {
            checkNumber(string);
        }
    }

    private void checkNumber(String string) {
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("올바른 문자열 입력이 아닙니다.");
            }
        }
    }
}