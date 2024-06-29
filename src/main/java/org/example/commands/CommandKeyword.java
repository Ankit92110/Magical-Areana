package org.example.commands;

public enum CommandKeyword {
    // Register Command Keywords
    ADD_PLAYER_COMMAND("ADD_PLAYER"),
    PLAY_COMMAND ("PLAY");

    private final String name;
    private CommandKeyword(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
