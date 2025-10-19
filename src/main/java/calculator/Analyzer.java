package calculator;

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

    public List<String> splitString() {
        String newInput = input.substring(input.indexOf('\n') + 1);
        return List.of(newInput.split(",|:|" + findCustomDelimiter()));
    }

}
