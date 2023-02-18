package ua.ithillel.lectures.lecture_30.runner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import ua.ithillel.lectures.lecture_30.game.TetrisGame;


import static org.junit.jupiter.api.Assertions.*;

public class GameRunnerTest {
    @Test
    @DisplayName("Game runner runs game successfully")
    public void gameRunnerIsRunning() {
        GameRunner gameRunner = new GameRunner();
        TetrisGame tetrisGame = new TetrisGame();
        gameRunner.setGame(tetrisGame);
        gameRunner.run();

        assertTrue(gameRunner.isRunning());
    }

    @Test
    @DisplayName("Game runner stops game successfully")
    public void gameIsStopping() {
        GameRunner gameRunner = new GameRunner();
        TetrisGame tetrisGame = new TetrisGame();
        gameRunner.setGame(tetrisGame);
        gameRunner.run();
        gameRunner.stop();

        assertFalse(gameRunner.isRunning());
    }

    @Test
    @DisplayName("Game runner throws null pointer without game")
    public void gameRunnerThrowExceptionWithoutGame() {
        GameRunner gameRunner = new GameRunner();
        Executable runGame = gameRunner::run;

        assertThrows(NullPointerException.class, runGame);
    }
}
