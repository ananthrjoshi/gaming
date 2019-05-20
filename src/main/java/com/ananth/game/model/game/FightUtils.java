package com.ananth.game.model.game;

import com.ananth.game.constants.SkillSet;
import com.ananth.game.constants.WeaponSet;
import com.ananth.game.model.player.Fighter;
import com.ananth.game.model.skills.FightingSkill;
import com.ananth.game.model.skills.Skill;
import com.ananth.game.model.weapon.FireBall;
import com.ananth.game.model.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

public class FightUtils {

    public static void addFireBallWeapon(Fighter fighter) {
        //create a new weapon
        Weapon fireBall = new FireBall();

        //add this weapon to the list of weapons
        List<Weapon> weaponList = new ArrayList<>();
        weaponList.add(fireBall);

        //add new fighting skill
        FightingSkill fightingSkill = new FightingSkill();
        fightingSkill.getWeaponMap().put(WeaponSet.FIREBALL.getWeaponName(),weaponList);

        List<Skill> skillList = fighter.getSkillSetMap().get(SkillSet.FIGHTING.getSkillName());

        if(skillList == null) {
            skillList = new ArrayList<>();
        }
        skillList.add(fightingSkill);
        fighter.getSkillSetMap().put(SkillSet.FIGHTING.getSkillName(),skillList);

    }
}
