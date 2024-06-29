package org.example.commands;

import org.example.exception.InvalidGame;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommandRegistry {
    private static final Map<String, Icommand> commands = new HashMap<>();

    public void registerCommand(String commandKeyword, Icommand command) {
        commands.putIfAbsent(commandKeyword,command);
    }
    
    private Icommand get(String commandName){
        return commands.get(commandName);
    }

    private List<String> parse(String input){
        return Arrays.stream(input.split(" ")).collect(Collectors.toList());
    }


    public void invokeCommand(String input) {
        List<String> tokens = parse(input);
        Icommand command = get(tokens.get(0));
        if(command == null){
            // Handle Exception
            throw new InvalidGame("INVALID COMMAND 🛑");
        }
        command.invoke(tokens);
        return;
    }
}
