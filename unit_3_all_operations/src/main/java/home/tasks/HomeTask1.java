package home.tasks;

import java.util.Scanner;

public class HomeTask1 {

    public void run() {

        Scanner in = new Scanner(System.in);
        int sum = 0;
        System.out.print("Please, type your input: ");
        String userInput = in.nextLine();

        String stringOfDigits = extractOnlyDigits(userInput);

        int num = getIntFromString(stringOfDigits);

        for (int i = 0; i < stringOfDigits.length(); i++) {
            sum += num % 10;
            num = num / 10;
        }

        System.out.println("The sum of extracted digits is: " + sum + "\n");

    }

    private String extractOnlyDigits (String originString) {
        return originString.replaceAll("[^0-9]","");
    }

    private int getIntFromString (String str) {
        return Integer.parseInt(str);
    }
}
