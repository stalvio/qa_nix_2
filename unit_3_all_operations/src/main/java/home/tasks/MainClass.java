package home.tasks;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String userInput = "";

        while (!userInput.equals("Q")) {
            System.out.println("Please, enter the number (1-3) of a home-task you would like to check or enter Q to quit: ");
            userInput = in.nextLine();

            switch (userInput) {
                case "1": {
                    new HomeTask1().run();
                }
                break;
                case "2": {
                    new HomeTask2().run();
                }
                break;
                case "3": {
                    new HomeTask3().run();
                }
                break;
                case "Q": {
                    System.out.println("Thank you for your time!");
                }
                break;
                default: {
                    System.out.println("You've entered an invalid value, lets try again");
                }
            }
        }
    }
}
