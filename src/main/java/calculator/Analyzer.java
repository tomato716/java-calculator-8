package calculator;

import java.util.ArrayList;
import java.util.List;

public class Analyzer {
    private final String input;
    private final Validator validator;

    public Analyzer(String input, Validator validator) {
        this.input = input;
        this.validator = validator;
    }

    private String findCustomDelimiter() {
        if ((input.startsWith("//")) && (input.contains("\\n"))) {
            return input.substring(2, input.indexOf("\\n"));
        }
        return null;
    }

    private boolean checkCustomDelimiter() {
        if ((input.startsWith("//")) && (input.contains("\\n"))) {
            return true;
        }
        return false;
    }

    public List<Integer> splitString() {
        String newInput = input;
        if (checkCustomDelimiter()) {
            newInput = input.substring(input.indexOf("n") + 1);
        }

        String regex = findCustomDelimiter();
        String newRegex = findMetaChar(regex);
        List<String> splitString = List.of(newInput.split(",|:|" + newRegex));

        validator.validateInput(splitString);

        return convertStringToInteger(splitString);
    }

    private String findMetaChar(String regex) {
        String metaChar = "^$.*+?[]{}()|\\";

        if (metaChar.contains(regex)) {
            regex = "\\" + regex;
        }
        return regex;
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
