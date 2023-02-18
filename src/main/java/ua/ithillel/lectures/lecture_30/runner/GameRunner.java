package ua.ithillel.lectures.lecture_30.runner;

import lombok.Getter;
import lombok.Setter;
import ua.ithillel.lectures.lecture_30.game.Game;

import java.util.Random;

public class GameRunner {
    @Getter
    private boolean isRunning;
    private GamePad gamePad;
    public GameRunner(){
        gamePad = new GamePad();
    }
    @Setter
    private Game game;

    private void gameSimulation(){
        Random random = new Random();
        int randomPressCount = random.ints(0,10)
        .findFirst()
                .orElse(1);

        for (int i = 0; i<randomPressCount;i++){
            int randomPressIndex = random.ints(0,GamePad.Button.values().length)
                    .findFirst()
                    .orElse(1);
            gamePad.pressButton(GamePad.Button.values()[randomPressIndex],game);
        }
    }

    public void run() {
        isRunning = true;
        game.up();
        game.down();
        game.left();
        game.right();
    }

    public void stop() {
        isRunning = false;
    }
}
