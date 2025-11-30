package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Integer> digitNumbers;

    public Numbers(List<String> numbers) {
        this.digitNumbers = changeNumberType(numbers);
    }

    private List<Integer> changeNumberType(List<String> splitNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String splitNumber : splitNumbers) {
            Integer number = isDigit(splitNumber);
            isNotNegativeNumber(number);
            numbers.add(number);
        }

        return numbers;
    }

    private Integer isDigit(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("[ERROR] 입력 문자열이 숫자가 아닙니다.");
        }
    }

    private void isNotNegativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("[ERROR] 음수값은 입력할 수 없습니다.");
        }
    }

    public Integer calculatePlus() {
        int totalResult = 0;
        for (Integer number : digitNumbers) {
            totalResult += number;
        }

        return totalResult;
    }
}
