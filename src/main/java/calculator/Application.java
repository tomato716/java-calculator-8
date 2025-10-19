package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();
        Analyzer analyzer = new Analyzer(input, new Validator());
        List<Integer> numbers = analyzer.splitString();
        PlusNumber plusNumber = new PlusNumber(numbers);
        int result = plusNumber.calculate();

        System.out.println("결과 : " + result);
    }
}
