package com.ananth.game.model.player;

import com.ananth.game.constants.PlayerConstants;
import com.ananth.game.constants.SkillSet;
import com.ananth.game.constants.WeaponSet;
import com.ananth.game.model.skills.FightingSkill;
import com.ananth.game.model.skills.Skill;
import com.ananth.game.model.weapon.Shield;
import com.ananth.game.model.weapon.Weapon;
import com.ananth.game.service.BattleUtils;

import java.util.ArrayList;
import java.util.List;

public class CaptainAmerica extends Fighter{

    public CaptainAmerica(String name) {
        super(name);

    }

    @Override
    public void initialize() {
        //create a new weapon
        Weapon shield = new Shield();

        //add this weapon to the list of weapons
        List<Weapon> weaponList = new ArrayList<>();
        weaponList.add(shield);

        //add new fighting skill
        FightingSkill fightingSkill = new FightingSkill();
        fightingSkill.getWeaponMap().put(WeaponSet.SHIELD.getWeaponName(),weaponList);

        List<Skill> skillList = this.getSkillSetMap().get(SkillSet.FIGHTING.getSkillName());

        if(skillList == null) {
            skillList = new ArrayList<>();
        }
        skillList.add(fightingSkill);
        this.getSkillSetMap().put(SkillSet.FIGHTING.getSkillName(),skillList);
    }

    @Override
    public void attack(Character opponent) {
        if(this.isAlive() && opponent.isAlive()) {
            //both are alive
            BattleUtils.logConsole("============================================");
            BattleUtils.logConsole(this.getPlayerName() + " attacks " + opponent.getPlayerName());
            this.gainFightExperience(PlayerConstants.FIGHT_ACT_ATTACK);

            if(opponent.defend(this.getAttackPower())) {
                //opponent
                opponent.gainFightExperience(PlayerConstants.FIGHT_ACT_DEFEND);
            } else {
                //opponent lost
                BattleUtils.logConsole("============================================");
                BattleUtils.logConsole(opponent.getPlayerName() + " is dead");
                opponent.setHealth(0);
            }
        }
    }
}
