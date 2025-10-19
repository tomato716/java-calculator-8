package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class PlusNumberTest {

    @Test
    void calculateTest() {
        List<Integer> splitString = List.of(1, 2, 3, 4);
        PlusNumber plusNumber = new PlusNumber(splitString);

        int calculateResult = plusNumber.calculate();
        assertEquals(10, calculateResult);
    }
}
