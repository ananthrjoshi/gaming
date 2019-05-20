package com.ananth.game.service;

import com.ananth.game.constants.PlayerType;
import com.ananth.game.model.game.Battle;
import com.ananth.game.model.player.Character;

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
        Character user = chooseCharacter();
        Character opponent = createOpponent();

        System.out.println("USER: " + user.toString());
        System.out.println("OPPONENT: " + opponent.toString());

        battle.getPlayerMap().put(PlayerType.USER.getPlayerType(),user);
        battle.getPlayerMap().put(PlayerType.OPPONENT.getPlayerType(),opponent);
        //System.out.println(battle);
    }

    private Character createOpponent() {
        return new OpponentService().createOpponent();
    }

    private Character chooseCharacter() {
        System.out.println("=====================================");
        System.out.println("|   CHOOSE A FIGHTER (CHARACTER)    |");
        System.out.println("=====================================");

        System.out.println("CHOOSE A CHARACTER FROM THE FOLLOWING LIST:");
        //method that shows menu options
        int option = CharacterUtils.showCharacterOptions();
        return CharacterUtils.createCharacter(option);
    }
}
