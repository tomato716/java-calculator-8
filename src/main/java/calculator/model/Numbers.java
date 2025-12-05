package calculator.model;

import java.util.List;

public class Numbers {
    private final List<Integer> digitNumbers;

    public Numbers(List<String> numbers) {
        this.digitNumbers = parseAndValidateAll(numbers);
    }

    private List<Integer> parseAndValidateAll(List<String> splitNumbers) {
        return splitNumbers.stream()
                .map(this::parseAndValidate)
                .toList();
    }

    private int parseAndValidate(String splitNumber) {
        int number = parseInt(splitNumber);
        validateNegativeNumber(number);

        return number;
    }

    private int parseInt(String inputNumber) {
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
