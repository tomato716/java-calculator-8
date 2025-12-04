package calculator.model;

import java.util.List;
import java.util.regex.Pattern;

public class Delimiter {
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final Integer CUSTOM_DELIMITER_START = 2;
    private static final Integer CUSTOM_DELIMITER_END = 3;
    private static final Integer CUSTOM_DELIMITER_PREFIX = 5;
    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("^/{2}.\\\\n.*");

    public List<String> split(String input) {
        if (input.isEmpty()) {
            return List.of();
        }
        if (validateCustomDelimiter(input)) {
            String customDelimiter = findCustomDelimiter(input);
            String removeCustomDelimiterInput = input.substring(CUSTOM_DELIMITER_PREFIX);

            return List.of(
                    removeCustomDelimiterInput.split(COMMA + "|" + COLON + "|" + Pattern.quote(customDelimiter), -1));
        }
        return List.of(input.split(COMMA + "|" + COLON, -1));
    }

    private String findCustomDelimiter(String input) {
        return input.substring(CUSTOM_DELIMITER_START, CUSTOM_DELIMITER_END);
    }

    private boolean validateCustomDelimiter(String input) {
        return CUSTOM_DELIMITER.matcher(input).matches();
    }
}
