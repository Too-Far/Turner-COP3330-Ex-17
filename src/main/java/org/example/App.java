/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 Ryan Turner
 */
package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App
{
    public static void compileMessage(float bac, boolean canDrive)
    {
        System.out.println("Your BAC is " + bac);
        if (canDrive) {
            System.out.println("It is legal for you to drive.");
        } else {
            System.out.println("It is not legal for you to drive.");
        }
    }

    public static void calcBAC(int ouncesDrank, int weight, int maleFemale, int timeSinceLastDrink)
    {
        double r;
        float bac;
        boolean canDrive;
        if (maleFemale == 1)
        {
            r = 0.73;
        } else if(maleFemale == 2)
        {
            r = 0.66;
        } else {
            return;
        }
        bac = (float) ((ouncesDrank * 5.14 / weight * r) - .015 * timeSinceLastDrink);
        canDrive = bac < 0.08;
        compileMessage(bac, canDrive);
    }

    public static void getUserInput()
    {
        int maleFemale = 0;
        int ouncesDrank = 0;
        int weight = 0;
        int timeSinceLastDrink = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter a 1 if you are male, 2 if you are female: ");
        try {
            maleFemale = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("You must input a number...");
        }

        System.out.println("How many ounces of alcohol did you have? ");
        try {
            ouncesDrank = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("You must input a number...");
        }

        System.out.println("What is your weight in pounds? ");
        try {
            weight = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("You must input a number...");
        }

        System.out.println("How many hours has it been since your last drink? ");
        try {
            timeSinceLastDrink = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("You must input a number...");
        }
        calcBAC(ouncesDrank, weight, maleFemale, timeSinceLastDrink);
    }

    public static void main( String[] args )
    {
        getUserInput();
    }
}
