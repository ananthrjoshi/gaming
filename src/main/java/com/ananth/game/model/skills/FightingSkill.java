package com.ananth.game.model.skills;

import com.ananth.game.model.weapon.Weapon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FightingSkill implements Skill {

    private Map<String,List<Weapon>> weaponMap;


    public Map<String, List<Weapon>> getWeaponMap() {
        if(weaponMap == null) {
            weaponMap = new HashMap<>();
        }
        return weaponMap;
    }

    public void setWeaponMap(Map<String, List<Weapon>> weaponMap) {
        this.weaponMap = weaponMap;
    }

    @Override
    public String toString() {
        return "FightingSkill{" +
                "weaponMap: " + weaponMap +
                '}';
    }
}
