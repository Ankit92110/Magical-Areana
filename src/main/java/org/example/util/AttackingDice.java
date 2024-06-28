package org.example.util;

public class AttackingDice implements Dice{

    @Override
    public int roll() {
        return (int)(Math.random()*6)+1;
    }
}
