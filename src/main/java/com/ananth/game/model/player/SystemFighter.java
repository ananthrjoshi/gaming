package com.ananth.game.model.player;

import com.ananth.game.application.GameApplication;
import com.ananth.game.constants.PlayerConstants;
import com.ananth.game.service.BattleUtils;

public class SystemFighter extends Fighter{

    public SystemFighter(String playerName) {
        super(playerName);
    }

    @Override
    public void initialize() {
        //randomly choose the weapon to be added to the SYSTEM opponent
        int randomOption = GameApplication.getRandom().nextInt(1)+1;
        BattleUtils.initializeFighterWithWeapon(this,randomOption);
    }

    @Override
    public void attack(Character opponent) {
        if(this.isAlive() && opponent.isAlive()) {
            //both are alive
            BattleUtils.logConsole("============================================");
            BattleUtils.logConsole(this.getPlayerName() + " attacks " + opponent.getPlayerName());
            this.gainFightExperience(PlayerConstants.FIGHT_ACT_ATTACK);

            if(opponent.defend(this.getAttackPower())) {
                //opponent
                opponent.gainFightExperience(PlayerConstants.FIGHT_ACT_DEFEND);
            } else {
                //opponent lost
                BattleUtils.logConsole(opponent.getPlayerName() + " is dead");
                BattleUtils.logConsole("============================================");
                opponent.setHealth(0);
            }
        }
    }
}
