package com.ananth.game.model.game;

import com.ananth.game.constants.GameStage;
import com.ananth.game.model.player.Character;
import com.ananth.game.service.BattleInitService;
import com.ananth.game.service.BattleService;
import com.ananth.game.service.BattleUtils;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Battle implements Game,Runnable,Serializable {

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

        BattleUtils.logConsole("===============\n"
                                +"Battle it Out\n");

        BattleService battleService = new BattleService(this);
        battleService.battleItOut(this);
    }

    @Override
    public void resume() {
        gameStage = GameStage.GAME_RESUME.getStage();
        Thread.currentThread().notify();
    }

    @Override
    public void pause() {
        gameStage = GameStage.GAME_PAUSE.getStage();
        try {
            Thread.currentThread().wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save() {
        try{
            System.out.println("Saving the game data...");
            // Open a file to write to.
            FileOutputStream saveFile=new FileOutputStream("BattleState_"+System.currentTimeMillis()+".sav");

            // Create an ObjectOutputStream to put objects into save file.
            ObjectOutputStream save = new ObjectOutputStream(saveFile);

            // Now we do the save.
            save.writeObject(this);

            // Close the file.
            save.close(); // This also closes saveFile.
        }
        catch(Exception exc){
            // If there was an error, print the info.
            exc.printStackTrace();
        }
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
        // create a scanner so we can read the command-line input
        int menuOption = BattleUtils.chooseSaveGameOption();
        if(menuOption == 1) {
            save();
        }
        exit();
    }


    @Override
    public String toString() {
        return "Game is being played between \n {" +
                "Players: " + playerMap +
                ", Stage: '" + gameStage + '\'' +
                '}';
    }
}
