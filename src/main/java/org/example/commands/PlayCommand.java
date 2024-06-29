package org.example.commands;

import org.example.service.Game;

import java.util.List;

public class PlayCommand implements Icommand{
    private final Game game;

    public PlayCommand(Game game) {
        this.game = game;
    }

    @Override
    public void invoke(List<String> tokens) {
        game.play();
    }
}
