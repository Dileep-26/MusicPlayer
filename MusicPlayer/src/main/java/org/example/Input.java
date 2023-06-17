package org.example;

import java.util.Scanner;

public class Input {

    public static String song;


    public static void UserInput() {

    Scanner scan = new Scanner(System.in);
    System.out.print("Enter Song Name:");
    song =scan.nextLine();
    System.out.println(song);



    }
}
