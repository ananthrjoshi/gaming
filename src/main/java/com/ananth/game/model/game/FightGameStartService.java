package com.ananth.game.model.game;

import com.ananth.game.constants.PlayerType;
import com.ananth.game.constants.SkillSet;
import com.ananth.game.constants.WeaponSet;
import com.ananth.game.model.player.Fighter;
import com.ananth.game.model.player.Player;
import com.ananth.game.model.skills.FightingSkill;
import com.ananth.game.model.skills.Skill;
import com.ananth.game.model.weapon.FireBall;
import com.ananth.game.model.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FightGameStartService {

    private FightGame fightGame;

    public FightGameStartService(FightGame fightGame) {
        this.fightGame = fightGame;
    }

    public FightGame getFightGame() {
        return fightGame;
    }

    public void setFightGame(FightGame fightGame) {
        this.fightGame = fightGame;
    }

    public void setup() {
        Player user = createCharacter();
        Player opponent = createOpponent();

        System.out.println("USER: " + user.toString());
        System.out.println("OPPONENT: " + opponent.toString());

        fightGame.getPlayerMap().put(PlayerType.USER.getPlayerType(),user);
        fightGame.getPlayerMap().put(PlayerType.OPPONENT.getPlayerType(),opponent);


    }

    private Player createOpponent() {
        return new OpponentService().createOpponent();
    }

    private Player createCharacter() {
        System.out.println("=====================================");
        System.out.println("|   CREATE A FIGHTER (CHARACTER)    |");
        System.out.println("=====================================");

        Player player = new Fighter();
        System.out.println("NAME YOUR FIGHTER: ");
        player.setPlayerName(characterName());

        System.out.println("CHOOSE THE WEAPON FROM THE FOLLOWING LIST:");
        initializeFighterWithWeapon((Fighter)player);


        return player;
    }


    private String characterName() {
        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    private int showWeaponOptions() {
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

    private void initializeFighterWithWeapon(Fighter fighter) {
        try {
            boolean isWeaponAdded = false;
            //method that shows menu options
            int option = this.showWeaponOptions();
            do {
                switch (option) {
                    case 1:
                        FightUtils.addFireBallWeapon(fighter);
                        isWeaponAdded = true;
                        break;
                    case 2:
                        isWeaponAdded = true;
                        break;
                    default:
                        System.out.println("Sorry, invalid option. Please choose a valid option");
                        option = this.showWeaponOptions();
                        break;
                }
            } while (!isWeaponAdded);

        } catch (Exception exception) {

        }
    }


}
