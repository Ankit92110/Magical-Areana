package org.example;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@DisplayName("Main Test Suite")
public class MainTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        // Redirects System.out to a ByteArrayOutputStream for testing output
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Health of Player1 is already 0")
    void player1Health0Test() {
        // Act
        Main.main(new String[]{"sample_input/input1.txt"});

        // Assert
        String expectedOutput = "WINNER IS PLAYER2";
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Health of Player2 is already 0")
    void player2Health0Test() {
        // Act
        Main.main(new String[]{"sample_input/input2.txt"});

        // Assert
        String expectedOutput = "WINNER IS PLAYER1";
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Health of Player1 is less than Player2")
    void healthOfPlayer1LessThanPlayer2Test() {
        // Act
        Main.main(new String[]{"sample_input/input3.txt"});

        // Assert
        String expectedOutput = "WINNER IS PLAYER2";
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Health of Player2 is less than Player1")
    void healthOfPlayer2LessThanPlayer1Test() {
        // Act
        Main.main(new String[]{"sample_input/input4.txt"});

        // Assert
        String expectedOutput = "WINNER IS PLAYER1";
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        // Restore System.out to its original state
        System.setOut(standardOut);
    }
}
