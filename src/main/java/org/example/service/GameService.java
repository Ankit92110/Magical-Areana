package org.example.service;

import org.example.entity.Player;
import org.example.exception.InvalidGame;
import org.example.repository.PlayerRepo;
import org.example.util.Dice;

import java.util.List;

public class GameService implements Game {
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
        if (token.size() != 4) {
            throw new InvalidGame("Please include all 3 player attributes");
        }

        int health = Integer.parseInt(token.get(1));
        int strength = Integer.parseInt(token.get(2));
        int attack = Integer.parseInt(token.get(3));
        playerRepo.addPlayer(new Player(health, strength, attack));
    }

    @Override
    public void play() {
        List<Player> playerList = playerRepo.getPlayerList();
        validatePlayers(playerList);

        Player player1 = playerList.get(0);
        Player player2 = playerList.get(1);

        String winner = decideWinner(player1, player2);
        System.out.println(winner);
    }

    private void validatePlayers(List<Player> playerList) {
        if (playerList.size() < 2) {
            throw new InvalidGame("Please add two player details to start the game");
        }
    }

    private String decideWinner(Player player1, Player player2) {
        int player1Health = player1.getHealth();
        int player1Strength = player1.getStrength();
        int player1Attack = player1.getAttack();

        int player2Health = player2.getHealth();
        int player2Strength = player2.getStrength();
        int player2Attack = player2.getAttack();

        boolean isPlayer1Turn = player1Health < player2Health;

        while (player1Health > 0 && player2Health > 0) {
            if (isPlayer1Turn) {
                player2Health -= calculateDamage(player1Attack, player2Strength);
            } else {
                player1Health -= calculateDamage(player2Attack, player1Strength);
            }
            isPlayer1Turn = !isPlayer1Turn;
        }

        return player1Health <= 0 ? "WINNER IS PLAYER2" : "WINNER IS PLAYER1";
    }

    private int calculateDamage(int attack, int defense) {
        int damage = attack * attackingDice.roll() - defense * defendingDice.roll();
        return Math.max(damage, 0); // Ensure that damage is not negative
    }
}
