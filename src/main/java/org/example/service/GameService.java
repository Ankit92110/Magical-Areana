package org.example.service;

import org.example.entity.Player;
import org.example.repository.PlayerRepo;
import org.example.util.Dice;

import java.util.List;

public class GameService implements Game{
    private final PlayerRepo playerRepo;
    private final Dice attackingDice;
    private final Dice defendingDice;

    public GameService(PlayerRepo playerRepo, Dice attackingDice, Dice defendingDice) {
        this.playerRepo = playerRepo;
        this.attackingDice = attackingDice;
        this.defendingDice = defendingDice;
    }

    @Override
    public void addPlayer(List<String> token) {

    }

    @Override
    public void play() {

    }
}
