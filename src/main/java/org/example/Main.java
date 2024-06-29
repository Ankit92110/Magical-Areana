package org.example;
import org.example.commands.CommandRegistry;
import org.example.config.GameConfig;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Game Setup
        GameConfig gameConfig=GameConfig.getInstance();
        CommandRegistry commandRegistry=gameConfig.getCommandRegistry();

        // now read the file and follow the command
       // String fileName = "sample_input/input1.txt";
        String fileName=args[0];
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
