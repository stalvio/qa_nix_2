package ua.com.alevel.controller;

import ua.com.alevel.entity.*;
import ua.com.alevel.service.PlanetReporter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlanetController {

    public static void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = "";
        try {
            while (true) {
                System.out.println("Please, select the planet which 'Acceleration Of Gravity' you would like to get:");
                runPlanetOptionNavigation();
                userInput = reader.readLine();
                runCalculation(userInput);
                System.out.println("Would you like to check another planet? \n" +
                        "Enter any symbol if YES \n" +
                        "Enter N if NO");
                userInput = reader.readLine();
                if(userInput.equals("N")) {
                    System.out.println("Thank you for your time!");
                    System.exit(0);
                }
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private static void runPlanetOptionNavigation() {
        System.out.println("Enter 1 for Mercury");
        System.out.println("Enter 2 for Venus");
        System.out.println("Enter 3 for Earth");
        System.out.println("Enter 4 for Mars");
        System.out.println("Enter 5 for Jupiter");
        System.out.println("Enter 6 for Saturn");
        System.out.println("Enter 7 for Uranus");
        System.out.println("Enter 8 for Neptune");
        System.out.println("Enter 9 for Pluto");
    }

    private static void runCalculation(String input) {
        switch (input) {
            case "1": {
                System.out.print("Mercury's 'Acceleration Of Gravity' is: ");
                PlanetReporter.print(new Mercury());
            }
            break;
            case "2": {
                System.out.print("Venus's 'Acceleration Of Gravity' is: ");
                PlanetReporter.print(new Venus());
            }
            break;
            case "3":
                System.out.print("Earth's 'Acceleration Of Gravity' is: ");
                PlanetReporter.print(new Earth());
                break;
            case "4":
                System.out.print("Mars's 'Acceleration Of Gravity' is: ");
                PlanetReporter.print(new Mars());
                break;
            case "5":
                System.out.print("Jupiter's 'Acceleration Of Gravity' is: ");
                PlanetReporter.print(new Jupiter());
                break;
            case "6":
                System.out.print("Saturn's 'Acceleration Of Gravity' is: ");
                PlanetReporter.print(new Saturn());
                break;
            case "7":
                System.out.print("Uranus's 'Acceleration Of Gravity' is: ");
                PlanetReporter.print(new Uranus());
                break;
            case "8":
                System.out.print("Neptune's 'Acceleration Of Gravity' is: ");
                PlanetReporter.print(new Neptune());
                break;
            case "9":
                System.out.print("Pluto's 'Acceleration Of Gravity' is: ");
                PlanetReporter.print(new Pluto());
                break;
            default: {
                System.out.println("You've entered an invalid value. Please, make your choice from the listed options. \n");
            }
        }
    }
}
