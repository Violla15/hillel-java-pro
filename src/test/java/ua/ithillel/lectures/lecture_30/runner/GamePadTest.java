package ua.ithillel.lectures.lecture_30.runner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.ithillel.lectures.lecture_30.game.TetrisGame;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GamePadTest {
    private static GamePad gamePad;

    @BeforeAll
    public static void setup() {
        System.out.println("Initializing gamepad tests...");
        gamePad = new GamePad();

    }

    @Test
    @DisplayName("Gamepad buttons pressed correctly")
    public void gamePadBottomsPress() {
        TetrisGame tetrisGame = new TetrisGame();
        GamePad.Button buttonUp = gamePad.pressButton(GamePad.Button.UP, tetrisGame);
        GamePad.Button buttonDown = gamePad.pressButton(GamePad.Button.DOWN, tetrisGame);
        GamePad.Button buttonLeft = gamePad.pressButton(GamePad.Button.LEFT, tetrisGame);
        GamePad.Button buttonRight = gamePad.pressButton(GamePad.Button.RIGHT, tetrisGame);

        assertEquals(buttonUp, GamePad.Button.UP);
        assertEquals(buttonLeft, GamePad.Button.LEFT);
        assertEquals(buttonRight, GamePad.Button.RIGHT);
        assertEquals(buttonDown, GamePad.Button.DOWN);
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Finishing gamepad tests");
    }
}
