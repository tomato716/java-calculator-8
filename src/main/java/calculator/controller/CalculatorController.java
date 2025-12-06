package calculator.controller;

import calculator.model.Delimiter;
import calculator.model.Numbers;
import calculator.view.InputView;
import calculator.view.Output;
import java.util.List;

public class CalculatorController {
    private final InputView input;
    private final Output output;
    private final Delimiter delimiter;

    public CalculatorController(InputView input, Output output, Delimiter delimiter) {
        this.input = input;
        this.output = output;
        this.delimiter = delimiter;
    }

    public void run() {
        output.printRequestNumber();
        String inputUser = input.readString();
        List<String> splitNumbers = delimiter.split(inputUser);
        Numbers numbers = new Numbers(splitNumbers);

        output.printTotalPlusResult(numbers.calculatePlus());
    }
}
