package org.example.util;

public class DefendingDice implements Dice{
    @Override
    public int roll() {
        return (int)(Math.random()*6)+1;
    }
}
