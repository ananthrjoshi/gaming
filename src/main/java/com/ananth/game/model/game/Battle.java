package com.ananth.game.model.game;

import com.ananth.game.constants.GameStage;
import com.ananth.game.model.player.Character;
import com.ananth.game.service.BattleInitService;
import com.ananth.game.service.BattleService;

import java.util.HashMap;
import java.util.Map;

public class Battle implements Game,Runnable {

    private Map<String,Character> playerMap;
    private String gameStage;

    public Map<String, Character> getPlayerMap() {
        if(playerMap == null) {
            playerMap = new HashMap<>();
        }
        return playerMap;
    }

    public void setPlayerMap(Map<String, Character> playerMap) {
        this.playerMap = playerMap;
    }

    public String getGameStage() {
        return gameStage;
    }

    public void setGameStage(String gameStage) {
        this.gameStage = gameStage;
    }

    @Override
    public void start() {
        gameStage = GameStage.GAME_START.getStage();
        System.out.println("Game Started");
        BattleInitService battleInitService = new BattleInitService(this);
        battleInitService.setup();

        BattleService battleService = new BattleService(this);
        battleService.battleItOut(this);
    }

    @Override
    public void resume() {
        gameStage = GameStage.GAME_RESUME.getStage();
    }

    @Override
    public void pause() {
        gameStage = GameStage.GAME_PAUSE.getStage();
    }

    @Override
    public void save() {
    }

    @Override
    public void exit() {
        gameStage = GameStage.GAME_END.getStage();
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        start();
    }


    @Override
    public String toString() {
        return "Game is being played between \n {" +
                "Players: " + playerMap +
                ", Stage: '" + gameStage + '\'' +
                '}';
    }
}
