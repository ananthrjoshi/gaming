package com.ananth.game.model.game;

import com.ananth.game.constants.GameStage;
import com.ananth.game.model.player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FightGame implements Game,Runnable {

    private Map<String,Player> playerMap;
    private String gameStage;

    public Map<String, Player> getPlayerMap() {
        if(playerMap == null) {
            playerMap = new HashMap<>();
        }
        return playerMap;
    }

    public void setPlayerMap(Map<String, Player> playerMap) {
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
        FightGameStartService fightGameStartService = new FightGameStartService(this);
        fightGameStartService.setup();

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
        return "FightGame{" +
                "playerMap=" + playerMap +
                ", gameStage='" + gameStage + '\'' +
                '}';
    }
}
