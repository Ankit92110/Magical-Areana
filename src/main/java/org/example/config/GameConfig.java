package org.example.config;

import org.example.commands.AddPlayerCommand;
import org.example.commands.CommandKeyword;
import org.example.commands.CommandRegistry;
import org.example.commands.PlayCommand;
import org.example.repository.PlayerRepo;
import org.example.service.Game;
import org.example.service.GameService;
import org.example.util.AttackingDice;
import org.example.util.DefendingDice;
import org.example.util.Dice;

public class GameConfig {

    // Singleton Design Pattern
    private static GameConfig instance;
    private GameConfig() {
    }
    public static GameConfig getInstance(){
         if(instance==null) instance=new GameConfig();
         return instance;
    }
    // Initialize repositories
    private final PlayerRepo playerRepository=new PlayerRepo();

    // Initialize utils
    private final Dice attackingDice=new AttackingDice();
    private final Dice defendingDice=new DefendingDice();

    // Initialize services
    private final Game game=new GameService(playerRepository,attackingDice,defendingDice);


    // Initialize commands
   private final AddPlayerCommand addPlayerCommand=new AddPlayerCommand(game);
   private final PlayCommand playCommand=new PlayCommand(game);
    // Initialize commandRegistery
    private final CommandRegistry commandRegistry=new CommandRegistry();

    // Register commands
    private void registerCommands(){
       commandRegistry.registerCommand(CommandKeyword.PLAY_COMMAND.getName(),playCommand);
       commandRegistry.registerCommand(CommandKeyword.ADD_PLAYER_COMMAND.getName(),addPlayerCommand);

    }
    public CommandRegistry getCommandRegistry(){
        registerCommands();
        return commandRegistry;
    }

}
