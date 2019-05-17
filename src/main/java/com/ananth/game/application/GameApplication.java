package com.ananth.game.application;

import com.ananth.game.exception.GameException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GameApplication {

    //private static final Logger logger = LoggerFactory.getLogger(GameApplication.class);

    public void loadGame() {



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
        File file = new File("GameTutorial.pdf");

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

    public void setupGame() throws GameException {

        try {
            System.out.println( "----------------------------------------\n" +
                                "----------WELCOME TO THE GAME-----------\n" +
                                "----------------------------------------\n");
        } catch (Exception exception) {
            throw new GameException(exception);
        }

    }
}
