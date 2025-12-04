package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Delimiter;
import calculator.view.Input;
import calculator.view.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorController game = new CalculatorController(new Input(), new Output(), new Delimiter());
        game.run();
    }
}
