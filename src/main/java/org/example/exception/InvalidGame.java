package org.example.exception;

public class InvalidGame extends RuntimeException {
    // Default constructor
    public InvalidGame() {
        super();
    }

    // Constructor that accepts a custom error message
    public InvalidGame(String msg) {
        super(msg);
    }
}

