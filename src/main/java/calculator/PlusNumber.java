package calculator;

import java.util.ArrayList;
import java.util.List;

public class PlusNumber {
    private final List<String> splitString;

    public PlusNumber(List<String> splitString) {
        this.splitString = splitString;
    }

    public int calculate() {
        List<Integer> numbers = convertStringToInteger();
        int result = 0;

        for (Integer number : numbers) {
            result += number;
        }

        return result;
    }

    private List<Integer> convertStringToInteger() {
        List<Integer> numbers = new ArrayList<>();

        for (String string : splitString) {
            int number = Integer.parseInt(string);
            numbers.add(number);
        }

        return numbers;
    }
}
