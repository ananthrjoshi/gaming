package com.ananth.game.model.player;

import com.ananth.game.model.skills.Skill;

import java.util.List;


public class Fighter implements Player {

    private String playerName;
    private Boolean isAlive = true;
    private int attackPower;
    private int defensePower;
    private double health = 100;

    private int experience;
    private List<Skill> skillList;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

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
