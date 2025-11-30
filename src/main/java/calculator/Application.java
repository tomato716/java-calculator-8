package calculator;

import calculator.controller.Game;
import calculator.model.Delimiter;
import calculator.view.Input;
import calculator.view.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game(new Input(), new Output(), new Delimiter());
        game.play();
    }
}
