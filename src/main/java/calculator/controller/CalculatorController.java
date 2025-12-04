package calculator.controller;

import calculator.model.Delimiter;
import calculator.model.Numbers;
import calculator.view.Input;
import calculator.view.Output;
import java.util.List;

public class CalculatorController {
    private final Input input;
    private final Output output;
    private final Delimiter delimiter;

    public CalculatorController(Input input, Output output, Delimiter delimiter) {
        this.input = input;
        this.output = output;
        this.delimiter = delimiter;
    }

    public void run() {
        output.printRequestNumber();
        String inputUser = input.inputUser();
        List<String> splitNumbers = delimiter.split(inputUser);
        Numbers numbers = new Numbers(splitNumbers);

        output.printTotalPlusResult(numbers.calculatePlus());
    }
}
