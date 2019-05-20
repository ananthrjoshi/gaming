package com.ananth.game.service;

import com.ananth.game.constants.PlayerType;
import com.ananth.game.model.game.Battle;
import com.ananth.game.model.player.Fighter;
import com.ananth.game.model.player.Player;

import java.util.Scanner;

public class BattleInitService {

    private Battle battle;

    public BattleInitService(Battle battle) {
        this.battle = battle;
    }

    public Battle getBattle() {
        return battle;
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }

    public void setup() {
        Player user = createCharacter();
        Player opponent = createOpponent();

        System.out.println("USER: " + user.toString());
        System.out.println("OPPONENT: " + opponent.toString());

        battle.getPlayerMap().put(PlayerType.USER.getPlayerType(),user);
        battle.getPlayerMap().put(PlayerType.OPPONENT.getPlayerType(),opponent);
        //System.out.println(battle);
    }

    private Player createOpponent() {
        return new OpponentService().createOpponent();
    }

    private Player createCharacter() {
        System.out.println("=====================================");
        System.out.println("|   CREATE A FIGHTER (CHARACTER)    |");
        System.out.println("=====================================");

        Player player = new Fighter();
        System.out.println("NAME YOUR FIGHTER: ");
        player.setPlayerName(characterName());

        System.out.println("CHOOSE THE WEAPON FROM THE FOLLOWING LIST:");
        //method that shows menu options
        int option = BattleUtils.showWeaponOptions();

        BattleUtils.initializeFighterWithWeapon((Fighter)player,option);

        return player;
    }


    private String characterName() {
        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }


}
