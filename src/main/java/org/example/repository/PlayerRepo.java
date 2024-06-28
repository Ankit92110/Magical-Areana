package org.example.repository;

import org.example.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepo {
    private final List<Player> playerList;

    public PlayerRepo() {
        playerList=new ArrayList<>();
    }
    public void addPlayer(Player player){
        this.playerList.add(player);
    }
    public List<Player>getPlayerList(){
        return this.playerList;
    }

}
