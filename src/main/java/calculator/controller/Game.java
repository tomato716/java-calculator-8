package calculator.controller;

import calculator.view.Input;
import calculator.view.Output;

public class Game {
    private final Input input;
    private final Output output;

    public Game(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void play() {
        output.printRequestNumber();
        String inputUser = input.inputUser();

    }
}
