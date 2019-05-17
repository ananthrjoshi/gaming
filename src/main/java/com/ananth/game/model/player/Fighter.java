package com.ananth.game.model.player;

import com.ananth.game.constants.PlayerConstants;
import com.ananth.game.model.skills.Skill;

import java.util.List;


public class Fighter implements Player {

    private String playerName;

    //property that checks if the player is alive or dead
    private Boolean isAlive = Boolean.TRUE;

    //metric property that holds the attack strength (initially it is assigned to 100)
    private int attackPower = PlayerConstants.INITIAL_ATTACK_POWER;

    //metric property that holds the defense strength (initially it is assigned to 100)
    private int defensePower = PlayerConstants.INITIAL_DEFENSE_POWER;

    //metric property that holds the health factor of the player (initially it is assigned to 100)
    private double health = PlayerConstants.MAX_HEALTH;

    //metric property that holds the experience factor of the player (initially it is assigned to 10)
    private int experience = PlayerConstants.MAX_EXPERIENCE;

    private List<Skill> skillList;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * This method checks if the player is alive or dead
     * if health is greater than 0 then alive
     * @return boolean
     */
    public Boolean isAlive() {
        return health > 0;
    }

    public void setAlive(Boolean alive) {
        isAlive = alive;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getDefensePower() {
        return defensePower;
    }

    public void setDefensePower(int defensePower) {
        this.defensePower = defensePower;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public void attack(Player opponent){

    }

    public void train() {

    }
}
