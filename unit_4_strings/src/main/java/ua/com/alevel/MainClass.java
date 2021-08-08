package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {
    private static String reversionType = new String();
    private static String userStr = new String("");
    private static String userSubStr = new String("");
    private static Integer firstIndex, lastIndex;

    public static void main(String[] args) {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (!reversionType.equals("quit")) {
            while (userStr.equals("")) {
                try {
                    System.out.println("Please, enter the string you would like to reverse or enter Q to leave:");
                    userStr = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                System.out.println("Please, select the type of reversion you would like to apply:\n" +
                        "- Type 1 to reverse a full string\n" +
                        "- Type 2 to reverse each word of the string separately\n" +
                        "- Type 3 to reverse only a specific substring\n" +
                        "- Type 4 to reverse a chosen range\n" +
                        "- Type 5 to submit a new string\n" +
                        "- Type Q to quit");
                reversionType = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (reversionType) {
                case "1": {
                    System.out.println(StringReverser.reverse(userStr, true) + "\n");
                }
                break;
                case "2": {
                    System.out.println(StringReverser.reverse(userStr, false) + "\n");
                }
                break;
                case "3": {
                    while (userSubStr.equals("")) {
                        try {
                            System.out.println("Please, type a substring you would like to reverse:");
                            userSubStr = bufferedReader.readLine();
                            if (userStr.contains(userSubStr)) {
                                System.out.println(StringReverser.reverse(userStr, userSubStr) + "\n");
                            } else {
                                System.out.println("Original string does not contain the substring you've entered. " +
                                        " Try again");
                                userSubStr = "";
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
                case "4": {
                    try {
                        System.out.println("Please, type the first index of the range:");
                        String firstInd = bufferedReader.readLine();

                        System.out.println("Type the last index:");
                        String lastInd = bufferedReader.readLine();

                        if (areIndexesValid(firstInd, lastInd)) {
                            firstIndex = Integer.parseInt(firstInd);
                            lastIndex = Integer.parseInt(lastInd);
                            System.out.println(StringReverser.reverse(userStr, firstIndex, lastIndex) + "\n");
                        } else {
                            break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
                case "5": {
                    userStr = "";
                }
                break;
                case "Q": {
                    reversionType = "quit";
                    System.out.println("Thank you for your time, goodbye!");
                }
                break;
                default: {
                    System.out.println("You've entered an invalid value, lets try again \n");
                }
            }
        }

    }

    private static boolean areIndexesValid(String firstIndex, String lastIndex) {
        if (!firstIndex.matches("^[0-9]*$") || !lastIndex.matches("^[0-9]*$")) {
            System.out.println("You've entered an invalid format of indexes. Indexes should only contain numbers. Please, Try again.");
            return false;
        } else if (Integer.parseInt(firstIndex) >= Integer.parseInt(lastIndex)) {
            System.out.println("The first index should be smaller that the last index. Please, try again");
            return false;
        } else if (Integer.parseInt(firstIndex) < 0 || Integer.parseInt(firstIndex) > userStr.length() - 1
                || Integer.parseInt(lastIndex) < 0 || Integer.parseInt(lastIndex) > userStr.length() - 1) {
            System.out.println("Some index(-es) is out of your string range. Please, try again");
            return false;
        } else {
            return true;
        }
    }
}
