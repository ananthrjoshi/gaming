package com.ananth.game.ui;

import java.util.Scanner;

public class GameGUI {

    public GameGUI() {
        System.out.println( "----------------------------------------\n" +
                "----------WELCOME TO THE GAME-----------\n" +
                "----------------------------------------\n");
    }

    public int showMenuOptions() {
        // Display menu
        System.out.println("============================");
        System.out.println("|   GAME MENU SELECTION    |");
        System.out.println("============================");
        System.out.println("| Options:                 |");
        System.out.println("|        1. Start Game     |");
        System.out.println("|        2. Exit           |");
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

}
