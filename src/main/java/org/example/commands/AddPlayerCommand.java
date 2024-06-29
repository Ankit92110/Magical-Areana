package org.example.commands;

import org.example.service.Game;

import java.util.List;

public class AddPlayerCommand implements Icommand{
    private final Game game;

    public AddPlayerCommand(Game game) {
        this.game = game;
    }

    @Override
    public void invoke(List<String> tokens) {
        game.addPlayer(tokens);
    }
}
