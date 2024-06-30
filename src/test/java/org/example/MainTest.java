package org.example;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class MainTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }


    @Test
    @DisplayName("Health Of Player1 is Already 0")
    void player1health0Test() {
        Main.main(new String[]{"sample_input/input1.txt"});
        String expectedOutput = "WINNER IS PLAYER2";
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
    }
    @Test
    @DisplayName("Health Of Player2 is Already 0")
    void player2health0Test() {
        Main.main(new String[]{"sample_input/input2.txt"});
        String expectedOutput = "WINNER IS PLAYER1";
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
    }
    @Test
    @DisplayName("Health Of Player1 is less than Player2")
    void heathOfPlayer1LessthanPlayer2Test() {
        Main.main(new String[]{"sample_input/input3.txt"});
        String expectedOutput = "WINNER IS PLAYER2";
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
    }
    @Test
    @DisplayName("Health Of Player2 is less than Player2")
    void heathOfPlayer2LessthanPlayer1Test() {
        Main.main(new String[]{"sample_input/input4.txt"});
        String expectedOutput = "WINNER IS PLAYER1";
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
    }


    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }


}