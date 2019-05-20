package com.ananth.game.service;

import com.ananth.game.constants.SkillSet;
import com.ananth.game.constants.WeaponSet;
import com.ananth.game.model.player.Fighter;
import com.ananth.game.model.skills.FightingSkill;
import com.ananth.game.model.skills.Skill;
import com.ananth.game.model.weapon.FireBall;
import com.ananth.game.model.weapon.Gun;
import com.ananth.game.model.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BattleUtils {

    /**
     * Methos shows the weapon menu options and returns the chosen option number
     * @return integer
     */
    public static int showWeaponOptions() {
        // Display menu
        System.out.println("============================");
        System.out.println("|   WEAPON MENU SELECTION    |");
        System.out.println("============================");
        System.out.println("| Options:                 |");
        System.out.println("|        1. FIREBALL       |");
        System.out.println("|        2. GUN            |");
        System.out.println("|        3. SWORD          |");
        System.out.println("============================");

        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);

        int menuOption = 0;
        try {
            menuOption = scanner.nextInt();
        } catch (Exception exception) {
            //log the error
        }

        return menuOption;
    }


    /**
     * Method to initialize the fighter with the chosen weapon
     * @param fighter to which weapon is added
     * @param option type of weapon to be added
     */
    public static void initializeFighterWithWeapon(Fighter fighter,int option) {
        try {
            boolean isWeaponAdded = false;
            do {
                switch (option) {
                    case 1:
                        BattleUtils.addFireBallWeapon(fighter);
                        isWeaponAdded = true;
                        break;
                    case 2:
                        BattleUtils.addGunWeapon(fighter);
                        isWeaponAdded = true;
                        break;
                    default:
                        System.out.println("Sorry, invalid option. Please choose a valid option");
                        option = showWeaponOptions();
                        break;
                }
            } while (!isWeaponAdded);

        } catch (Exception exception) {

        }
    }

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

    public static void addGunWeapon(Fighter fighter) {
        //create a new weapon
        Weapon gun = new Gun();

        //add this weapon to the list of weapons
        List<Weapon> weaponList = new ArrayList<>();
        weaponList.add(gun);

        //add new fighting skill
        FightingSkill fightingSkill = new FightingSkill();
        fightingSkill.getWeaponMap().put(WeaponSet.GUN.getWeaponName(),weaponList);

        List<Skill> skillList = fighter.getSkillSetMap().get(SkillSet.FIGHTING.getSkillName());

        if(skillList == null) {
            skillList = new ArrayList<>();
        }
        skillList.add(fightingSkill);
        fighter.getSkillSetMap().put(SkillSet.FIGHTING.getSkillName(),skillList);
    }
}
