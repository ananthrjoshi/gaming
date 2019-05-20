package com.ananth.game.service;

import com.ananth.game.model.player.Character;
import com.ananth.game.model.player.Fighter;

import java.util.Scanner;

public class CharacterUtils {

    public static int showCharacterOptions() {
        // Display menu
        System.out.println("==============================");
        System.out.println("|   CHARACTER SELECTION       |");
        System.out.println("==============================");
        System.out.println("| Options:                    |");
        System.out.println("| 1. A                        |");
        System.out.println("| 2. B                        |");
        System.out.println("| 3. C                        |");
        System.out.println("| 4. Create your own character|");
        System.out.println("==============================");

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
     * This method is used to create a character
     * @param option is used to choose from the list of character
     */
    public static Character createCharacter(int option) {
        Character character = null;
        try {
            boolean isCharacterCreated = false;
            do {
                switch (option) {
                    case 1:

                        isCharacterCreated = true;
                        break;
                    case 2:

                        isCharacterCreated = true;
                        break;
                    case 3:

                        break;
                    case 4:
                        character = createCharacter();
                        isCharacterCreated = true;
                        break;
                    default:
                        System.out.println("Sorry, invalid option. Please choose a valid option");
                        option = showCharacterOptions();
                        break;
                }
            } while (!isCharacterCreated);

        } catch (Exception exception) {

        }

        return character;
    }

    private static Character createCharacter() {
        System.out.println("=====================================");
        System.out.println("|   CREATE A FIGHTER (CHARACTER)    |");
        System.out.println("=====================================");

        Fighter fighter = new Fighter();
        System.out.println("NAME YOUR FIGHTER: ");
        fighter.setPlayerName(characterName());

        System.out.println("CHOOSE THE WEAPON FROM THE FOLLOWING LIST:");
        //method that shows menu options
        int option = BattleUtils.showWeaponOptions();

        BattleUtils.initializeFighterWithWeapon((Fighter)fighter,option);

        return fighter;
    }

    private static String characterName() {
        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}
