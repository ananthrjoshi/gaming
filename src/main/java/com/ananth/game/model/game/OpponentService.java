package com.ananth.game.model.game;

import com.ananth.game.model.player.Fighter;
import com.ananth.game.model.player.Player;

public class OpponentService {

    private FightGame fightGame;

    public FightGame getFightGame() {
        return fightGame;
    }

    public void setFightGame(FightGame fightGame) {
        this.fightGame = fightGame;
    }

    public Player createOpponent() {
        Fighter opponent = new Fighter();
        opponent.setPlayerName("SYSTEM");
        FightUtils.addFireBallWeapon(opponent);

        return opponent;
    }
}
