package com.ananth.game.application;

import java.awt.*;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GameApplication {


    public void loadGame() {

        System.out.println("----------------------------------------\n" +
                "----------WELCOME TO THE GAME-----------\n" +
                "----------------------------------------\n");

        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);

        //  prompt for the user's name
        //System.out.print("Enter your name: ");

        // get their input as a String
        //String username = scanner.next();

        // prompt for their age
        //System.out.print("Enter your age: ");

        // get the age as an int
        //int age = scanner.nextInt();

        //openDoc();
    }

    public void openDoc() {
        //text file, should be opening in default text editor
        //File file = new File("/Users/z0019r9/test.json");
        File file = new File("GameTutorial.html");

        //first check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }

        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) try {
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
