package calculator.model;

import java.util.List;
import java.util.regex.Pattern;

public class Delimiter {
    private static final String COMMA = ",";
    private static final String COLON = ":";

    public List<String> separateNumbers(String input) {
        if (validateCustomDelimiter(input)) {
            String customDelimiter = findCustomDelimiter(input);
            String removeCustomDelimiterInput = input.substring(5);

            return List.of(removeCustomDelimiterInput.split(COMMA + "|" + COLON + "|" + customDelimiter, -1));
        }
        return List.of(input.split(COMMA + "|" + COLON, -1));
    }

    private String findCustomDelimiter(String input) {
        return input.substring(2, 3);
    }

    private boolean validateCustomDelimiter(String input) {
        String regex = "^/{2}.\\\\n.*";
        return Pattern.matches(regex, input);
    }
}
