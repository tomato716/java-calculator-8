package calculator;

import java.util.List;

public class PlusNumber {
    private final List<Integer> splitNumber;

    public PlusNumber(List<Integer> splitNumber) {
        this.splitNumber = splitNumber;
    }

    public int calculate() {
        int result = 0;

        for (Integer number : splitNumber) {
            result += number;
        }

        return result;
    }

}
