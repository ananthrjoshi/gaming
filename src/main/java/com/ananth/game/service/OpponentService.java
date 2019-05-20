package com.ananth.game.service;

import com.ananth.game.application.GameApplication;
import com.ananth.game.model.game.Battle;
import com.ananth.game.model.player.Fighter;
import com.ananth.game.model.player.Character;

public class OpponentService {

    private Battle battle;

    public Battle getBattle() {
        return battle;
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }

    public Character createOpponent() {
        Fighter opponent = new Fighter();
        opponent.setPlayerName("SYSTEM");

        //randomly choose the weapon to be added to the SYSTEM opponent
        int randomOption = GameApplication.getRandom().nextInt(1)+1;
        BattleUtils.initializeFighterWithWeapon(opponent,randomOption);;

        return opponent;
    }
}
