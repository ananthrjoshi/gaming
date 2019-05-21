package com.ananth.game.model.player;

import com.ananth.game.service.BattleUtils;

public class CustomFighter extends Fighter{

    public CustomFighter(String playerName) {
        super(playerName);
    }

    @Override
    public void initialize() {
        System.out.println("CHOOSE THE WEAPON FROM THE FOLLOWING LIST:");
        //method that shows menu options
        int option = BattleUtils.showWeaponOptions();

        BattleUtils.initializeFighterWithWeapon(this,option);
    }

    @Override
    public void attack(Character opponent) {

    }
}
