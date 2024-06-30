package org.example;

import org.example.commands.CommandRegistry;
import org.example.config.GameConfig;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // For running the application use the command:
        // ./gradlew run --args="sample_input/input1.txt"

        // Game Setup
        GameConfig gameConfig = GameConfig.getInstance();
        CommandRegistry commandRegistry = gameConfig.getCommandRegistry();
        // Determine the filename
        String fileName = args.length > 0 ? args[0] : "sample_input/input1.txt";
        // Read the file and execute commands
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                commandRegistry.invokeCommand(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

