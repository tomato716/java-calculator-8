package calculator;

import java.util.ArrayList;
import java.util.List;

public class Analyzer {
    private final String input;

    public Analyzer(String input) {
        this.input = input;
    }

    private String findCustomDelimiter() {
        if ((input.startsWith("//")) && (input.contains("\n"))) {
            return input.substring(2, input.indexOf('\n'));
        }
        return null;
    }

    public List<Integer> splitString() {
        String newInput = input.substring(input.indexOf('\n') + 1);
        List<String> splitString = List.of(newInput.split(",|:|" + findCustomDelimiter()));

        return convertStringToInteger(splitString);
    }

    private List<Integer> convertStringToInteger(List<String> splitString) {
        List<Integer> numbers = new ArrayList<>();

        for (String string : splitString) {
            int number = Integer.parseInt(string);
            numbers.add(number);
        }

        return numbers;
    }

}
