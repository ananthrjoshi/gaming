package com.ananth.game.service;

import com.ananth.game.application.GameApplication;
import com.ananth.game.model.game.Battle;
import com.ananth.game.model.player.Fighter;
import com.ananth.game.model.player.Character;
import com.ananth.game.model.player.SystemFighter;

public class OpponentService {

    private Battle battle;

    public Battle getBattle() {
        return battle;
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }

    public Character createOpponent() {
        SystemFighter opponent = new SystemFighter("SYSTEM");
        opponent.initialize();
        return opponent;
    }
}
