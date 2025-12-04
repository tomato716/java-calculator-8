package calculator.model;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("^/{2}(.*?)\\\\n(.*)");

    public List<String> split(String input) {
        if (input.isBlank()) {
            return List.of();
        }

        Matcher matcher = CUSTOM_DELIMITER.matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String inputInfo = matcher.group(2);

            return List.of(inputInfo.split(COMMA + "|" + COLON + "|" + Pattern.quote(customDelimiter), -1));
        }
        return List.of(input.split(COMMA + "|" + COLON, -1));
    }
}
