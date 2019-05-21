package com.ananth.game.model.player;

import com.ananth.game.application.GameApplication;
import com.ananth.game.constants.PlayerConstants;
import com.ananth.game.model.skills.Skill;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class Fighter implements Character,Serializable {

    private String playerName;

    //property that checks if the player is alive or dead
    private Boolean isAlive = Boolean.TRUE;

    //metric property that holds the attack strength (initially it is assigned to 100)
    private int attackPower = PlayerConstants.INITIAL_ATTACK_POWER;

    //metric property that holds the defense strength (initially it is assigned to 100)
    private int defensePower = PlayerConstants.INITIAL_DEFENSE_POWER;

    //metric property that holds the health factor of the player (initially it is assigned to 100)
    private double health = PlayerConstants.MAX_HEALTH;

    //metric property that holds the experience factor of the player (initially it is assigned to 0)
    private int experience = 0;

    private static Map<String,Integer> fightExperience = new HashMap<>();

    //initialize the experience to a random value
    static {
        fightExperience.put(PlayerConstants.FIGHT_ACT_ATTACK,
                PlayerConstants.MAX_EXPERIENCE/ GameApplication.getRandom().nextInt(100)+1);
        fightExperience.put(PlayerConstants.FIGHT_ACT_DEFEND,
                PlayerConstants.MAX_EXPERIENCE/ GameApplication.getRandom().nextInt(50)+1);
    }

    private Map<String,List<Skill>> skillSetMap;

    public Map<String, Integer> getFightExperience() {
        return fightExperience;
    }

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

    public Fighter(String playerName) {
        this.playerName = playerName;
    }

    public Map<String, List<Skill>> getSkillSetMap() {
        if(skillSetMap == null) {
            skillSetMap = new HashMap<>();
        }
        return skillSetMap;
    }

    public void setSkillSetMap(Map<String, List<Skill>> skillSetMap) {
        this.skillSetMap = skillSetMap;
    }

    public void gainFightExperience(String fightAct) {
        int newExperience  = fightExperience.get(fightAct);
        this.experience = Math.min(experience + newExperience,PlayerConstants.MAX_EXPERIENCE);
    }

    public void reduceHealth(int attackPower,int opponentDefensePower) {

    }

    /**
     * This method is used to check if player can defend the attack or not
     * @param opponentAttackPower opponents attack power
     * @return true if player is able to defend, false otherwise
     */
    public Boolean defend(int opponentAttackPower) {
        setDefensePower(this.defensePower--);
        return defensePower > opponentAttackPower;
    }

    @Override
    public String toString() {
        return "Fighter{" +
                "playerName='" + playerName + '\'' +
                ", isAlive=" + isAlive +
                ", attackPower=" + attackPower +
                ", defensePower=" + defensePower +
                ", health=" + health +
                ", experience=" + experience +
                ", skillSetMap=" + skillSetMap +
                '}';
    }
}
