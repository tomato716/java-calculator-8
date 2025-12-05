package calculator.model;

import java.util.List;

public class Numbers {
    private final List<Integer> digitNumbers;

    public Numbers(List<String> numbers) {
        this.digitNumbers = List.copyOf(convertToInts(numbers));
    }

    private List<Integer> convertToInts(List<String> splitNumbers) {
        return splitNumbers.stream()
                .map(this::toInteger)
                .peek(this::validateNegativeNumber)
                .toList();
    }

    private int toInteger(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 문자열이 숫자가 아닙니다. input: " + inputNumber);
        }
    }

    private void validateNegativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("[ERROR] 음수값은 입력할 수 없습니다.");
        }
    }

    public int calculatePlus() {
        return digitNumbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
