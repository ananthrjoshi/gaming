package com.ananth.game.service;

import com.ananth.game.constants.PlayerType;
import com.ananth.game.model.game.Battle;
import com.ananth.game.model.player.Character;

public class BattleService {

    private Battle battle;

    public BattleService(Battle battle) {
        this.battle = battle;
    }

    public void battleItOut(Battle battle) {
        if(battle != null) {
            Character user = battle.getPlayerMap().get(PlayerType.USER.getPlayerType());
            Character opponent = battle.getPlayerMap().get(PlayerType.OPPONENT.getPlayerType());

            user.attack(opponent);
        }
    }
}
