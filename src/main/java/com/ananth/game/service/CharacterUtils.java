package com.ananth.game.service;

import com.ananth.game.model.player.CaptainAmerica;
import com.ananth.game.model.player.Character;
import com.ananth.game.model.player.CustomFighter;

import java.util.Scanner;

public class CharacterUtils {

    public static int showCharacterOptions() {
        // Display menu
        System.out.println("==============================");
        System.out.println("|   CHARACTER SELECTION       |");
        System.out.println("==============================");
        System.out.println("| Options:                    |");
        System.out.println("| 1. CAPTAIN AMERICA          |");
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
                        character = createCaptainAmericaCharacter();
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

        System.out.println("NAME YOUR FIGHTER: ");
        CustomFighter customFighter = new CustomFighter(characterName());

        //initialize this character
        customFighter.initialize();

        return customFighter;
    }

    private static Character createCaptainAmericaCharacter() {
        CaptainAmerica captainAmerica = new CaptainAmerica("CAPTAIN AMERICA");

        //initialize this character
        captainAmerica.initialize();

        return captainAmerica;
    }

    private static String characterName() {
        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}
