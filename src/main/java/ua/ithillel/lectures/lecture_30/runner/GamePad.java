package ua.ithillel.lectures.lecture_30.runner;

import ua.ithillel.lectures.lecture_30.game.Game;

public class GamePad {
    public Button pressButton(Button button, Game game) {
        switch (button) {
            case UP -> game.up();
            case LEFT -> game.left();
            case RIGHT -> game.right();
            case DOWN -> game.down();
        }
        return button;

    }

    public enum Button {
        UP,
        LEFT,
        RIGHT,
        DOWN;
    }
}
