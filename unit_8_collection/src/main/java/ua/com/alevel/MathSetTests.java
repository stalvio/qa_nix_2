package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MathSetTests {

    MathSet mathSet;

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Let's test MathSet object creation.");
        String constructorType;
        try {
            constructorCreatorNavigation();
            constructorType = reader.readLine();
            createMathSetObject(constructorType);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void constructorCreatorNavigation() {
        System.out.println("Enter 1, to use a default constructor");
        System.out.println("Enter 2, to pass a capacity in constructor");
        System.out.println("Enter 3, to pass an array of Numbers in constructor");
        System.out.println("Enter 4, to pass an array of arrays of Numbers in constructor");
        System.out.println("Enter 5, to pass a MathSet object in constructor");
        System.out.println("Enter 6, to pass an array of MathSet objects in constructor");
        System.out.println("Enter 0, to exit");
    }

    private void createMathSetObject(String constructorType) {
        switch (constructorType) {
            case "1":
                mathSet = new MathSet();

                System.out.println("Your MathSet object has been created:");
                System.out.println(mathSet.toString());
                addNumbersNavigation();
                break;
            case "2":
                mathSet = new MathSet(5);

                System.out.println("Your MathSet object with capacity=5 has been created:");
                System.out.println(mathSet.toString());
                addNumbersNavigation();
                break;
            case "3":
                mathSet = new MathSet(new Number[]{3, 4, 5, 7, 22, 0});

                System.out.println("Your MathSet object with the array of Numbers - {3, 4, 5, 7, 22, 0}" +
                        " passed to constructor has been created:");
                System.out.println(mathSet.toString());
                addNumbersNavigation();
                break;
            case "4":
                mathSet = new MathSet(new Number[]{3, 4, 6, 8, 0}, new Number[]{3, 22, 7, 88});

                System.out.println("Your MathSet object with two array of Numbers {3, 4, 5, 7, 8, 0} and {3, 22, 7, 88}" +
                        " passed to constructor has been created:");
                System.out.println(mathSet.toString());
                addNumbersNavigation();
                break;
            case "5":
                MathSet test1 = new MathSet(new Number[]{3, 4, 22, 8, 0});
                mathSet = new MathSet(test1);

                System.out.println("Your MathSet object with the following MathSet object (mathSet=[3, 4, 22, 8, 0], size=5, current_capacity=5) " +
                        "passed in constructor has been created:");
                System.out.println(mathSet.toString());
                addNumbersNavigation();
                break;
            case "6":
                MathSet test2 = new MathSet(new Number[]{3, 4, 6, 8, 0});
                MathSet test3 = new MathSet(new Number[]{4, 22, 8, 0});
                mathSet = new MathSet(test2, test3);

                System.out.println("Your MathSet object with two following MathSet objects " +
                        "(mathSet=[3, 4, 6, 8, 0], size=5, current_capacity=5) and " +
                        " (mathSet=[4, 22, 8, 0], size=4, current_capacity=4) passed in constructor has been created:");
                System.out.println(mathSet.toString());
                addNumbersNavigation();
                break;
            case "0":
                System.exit(1);
            default: {
                System.out.println("You've entered an invalid value, lets try again \n");
                constructorCreatorNavigation();
            }
        }
    }

    private void addNumbersNavigation() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 1, to add a Number to your MathSet");
        System.out.println("Enter 2, to add an array of Numbers to your MathSet");
        System.out.println("Enter 3, to move to joining MathSets");
        System.out.println("Enter 4, to move to interception MathSets");
        System.out.println("Enter 5, to move to sorting MathSets");
        System.out.println("Enter 4, to return to constructor creating");
        System.out.println("Enter 0, to exit");
        String addingType;
        try {
            while ((addingType = reader.readLine()) != null) {
                addNumber(addingType);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void addNumber(String addingType) {
        switch (addingType) {
            case "1":
                System.out.println("Your MathSet before adding Number '99':");
                System.out.println(mathSet.toString() + "\n");

                mathSet.add(99);

                System.out.println("Your MathSet after adding Number '99':");
                System.out.println(mathSet.toString());

                addNumbersNavigation();
                break;
            case "2":
                System.out.println("Your MathSet before adding Number '22' and Number '88':");
                System.out.println(mathSet.toString() + "\n");

                mathSet.add(22);
                mathSet.add(88);

                System.out.println("Your MathSet after adding Number '22' and Number '88':");
                System.out.println(mathSet.toString());

                addNumbersNavigation();
                break;
            case "3":
                joinMathSetNavigation();
                break;
            case "4":
                intersectionNavigation();
                break;
            case "5":
                sortingNavigation();
                break;
            case "6":
                constructorCreatorNavigation();
                break;
            case "0":
                System.exit(1);
            default: {
                System.out.println("You've entered an invalid value, lets try again \n");
                addNumbersNavigation();
            }
        }
    }

    private void joinMathSetNavigation() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 1, to join another MathSet to yours");
        System.out.println("Enter 2, to join an array of MathSets to yours");
        System.out.println("Enter 3, to return to adding Numbers");
        System.out.println("Enter 4, to move to intersections");
        System.out.println("Enter 5, to move to sorting");
        System.out.println("Enter 6, to move to the very beginning");
        System.out.println("Enter 0, to exit");
        String joinType;
        try {
            while ((joinType = reader.readLine()) != null) {
                joinMathSet(joinType);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void joinMathSet(String joinType) {
        switch (joinType) {
            case "1":
                MathSet test1 = new MathSet(new Number[]{30, 40, 10});

                System.out.println("Your MathSet before adding a MathSet (mathSet=[30, 40, 10], size=3, current_capacity=3):");
                System.out.println(mathSet.toString() + "\n");

                mathSet.join(test1);

                System.out.println("Your MathSet after adding a MathSet (mathSet=[30, 40, 10], size=3, current_capacity=3):");
                System.out.println(mathSet.toString());
                joinMathSetNavigation();
                break;
            case "2":
                MathSet test2 = new MathSet(new Number[]{40, 22, 10, 0});
                MathSet test3 = new MathSet(new Number[]{30, 40, 10});

                System.out.println("Your MathSet before adding a MathSet#1 (mathSet=[40, 22, 10, 0], size=4, current_capacity=4)" +
                        " and a MathSet#2 (mathSet=[30, 40, 10], size=3, current_capacity=3): ");
                System.out.println(mathSet.toString() + "\n");

                mathSet.add(22);
                mathSet.add(88);

                System.out.println("Your MathSet after adding a MathSet#1 (mathSet=[40, 22, 10, 0], size=4, current_capacity=4)" +
                        "and a MathSet#2 (mathSet=[30, 40, 10], size=3, current_capacity=3):");
                System.out.println(mathSet.toString());
                joinMathSetNavigation();
                break;
            case "3":
                addNumbersNavigation();
                break;
            case "4":
                intersectionNavigation();
                break;
            case "5":
                sortingNavigation();
                break;
            case "6":
                constructorCreatorNavigation();
                break;
            case "0":
                System.exit(1);
            default: {
                System.out.println("You've entered an invalid value, lets try again \n");
                joinMathSetNavigation();
            }
        }
    }

    private void intersectionNavigation() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 1, to intersection your MathSet with another MathSet");
        System.out.println("Enter 2, to intersection your MathSet with an array of MathSets");
        System.out.println("Enter 3, to return to joining MathSets");
        System.out.println("Enter 4, to move to sorting");
        System.out.println("Enter 5, to move to the very beginning");
        System.out.println("Enter 0, to exit");
        String intersectionType;
        try {
            while ((intersectionType = reader.readLine()) != null) {
                intersectMathSet(intersectionType);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void intersectMathSet(String intersectionType) {
        switch (intersectionType) {
            case "1":
                MathSet test1 = new MathSet(new Number[]{22, 40, 10});

                System.out.println("Your MathSet before intersection with a MathSet (mathSet=[22, 40, 10], size=3, current_capacity=3):");
                System.out.println(mathSet.toString() + "\n");

                mathSet.intersection(test1);

                System.out.println("Your MathSet after intersection with a MathSet (mathSet=[22, 40, 10], size=3, current_capacity=3)");
                System.out.println(mathSet.toString());
                intersectionNavigation();
                break;
            case "2":
                MathSet test2 = new MathSet(new Number[]{40, 22, 10, 0});
                MathSet test3 = new MathSet(new Number[]{30, 40, 10});

                System.out.println("Your MathSet before intersection with a MathSet (mathSet=[22, 40, 10, 0], size=3, current_capacity=3) " +
                        "and MathSet#2 (mathSet=[30, 40, 10], size=3, current_capacity=3):");
                System.out.println(mathSet.toString() + "\n");

                mathSet.intersection(test2, test3);

                System.out.println("Your MathSet after intersection with a MathSet (mathSet=[22, 40, 10], size=3, current_capacity=3) " +
                        "and MathSet#2 (mathSet=[30, 40, 10], size=3, current_capacity=3):");
                System.out.println(mathSet.toString());
                intersectionNavigation();
                break;
            case "3":
                joinMathSetNavigation();
                break;
            case "4":
                sortingNavigation();
                break;
            case "5":
                constructorCreatorNavigation();
                break;
            case "0":
                System.exit(1);
            default: {
                System.out.println("You've entered an invalid value, lets try again \n");
                intersectionNavigation();
            }
        }
    }

    private void sortingNavigation() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 1, to sort your full MathSet in descending order");
        System.out.println("Enter 2, to sort a chosen range of your MathSet in descending order");
        System.out.println("Enter 3, to sort your MathSet in descending order starting from a chosen Number value");
        System.out.println("Enter 4, to sort your full MathSet in ascending order");
        System.out.println("Enter 5, to sort a chosen range of your MathSet in ascending order");
        System.out.println("Enter 6, to sort your MathSet in ascending order starting from a chosen Number value");
        System.out.println("Enter 7, to move to the very beginning");
        System.out.println("Enter 0, to exit");
        String sortingType;
        try {
            while ((sortingType = reader.readLine()) != null) {
                sortMathSet(sortingType);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void sortMathSet(String sortingType) {
        switch (sortingType) {
            case "1":
                mathSet = new MathSet(new Number[]{2, 33, 13, 22, 80, 32, 3, 110});
                System.out.println("Your MathSet before being sorted in descending order:");
                System.out.println(mathSet.toString() + "\n");

                mathSet.sortDesc();

                System.out.println("Your MathSet after being sorted in descending order:");
                System.out.println(mathSet.toString());
                sortingNavigation();
                break;
            case "2":
                mathSet = new MathSet(new Number[]{2, 33, 13, 22, 80, 32, 3, 110});
                System.out.println("Your MathSet before being sorted in descending order in a chosen range[1, 4]:");
                System.out.println(mathSet.toString() + "\n");

                mathSet.sortDesc(1, 4);

                System.out.println("Your MathSet after being sorted in descending order in a chosen range[1, 4]:");
                System.out.println(mathSet.toString());
                sortingNavigation();
                break;
            case "3":
                mathSet = new MathSet(new Number[]{2, 33, 13, 22, 80, 32, 3, 110});
                System.out.println("Your MathSet before being sorted in descending order starting from a chosen value '22':");
                System.out.println(mathSet.toString() + "\n");

                mathSet.sortDesc(22);

                System.out.println("Your MathSet after being sorted in descending order starting from a chosen value '22':");
                System.out.println(mathSet.toString());
                sortingNavigation();
                break;
            case "4":
                mathSet = new MathSet(new Number[]{2, 33, 13, 22, 80, 32, 3, 110});
                System.out.println("Your MathSet before being sorted in ascending order:");
                System.out.println(mathSet.toString() + "\n");

                mathSet.sortAsc();

                System.out.println("Your MathSet after being sorted in ascending order:");
                System.out.println(mathSet.toString());
                sortingNavigation();
                break;
            case "5":
                mathSet = new MathSet(new Number[]{2, 33, 13, 22, 80, 32, 3, 110});
                System.out.println("Your MathSet before being sorted in ascending order in a chosen range[1, 4]:");
                System.out.println(mathSet.toString() + "\n");

                mathSet.sortDesc(1, 4);

                System.out.println("Your MathSet after being sorted in ascending order in a chosen range[1, 4]:");
                System.out.println(mathSet.toString());
                sortingNavigation();
                break;
            case "6":
                mathSet = new MathSet(new Number[]{2, 33, 13, 22, 80, 32, 3, 110});
                System.out.println("Your MathSet before being sorted in ascending order starting from a chosen value '22':");
                System.out.println(mathSet.toString() + "\n");

                mathSet.sortDesc(22);

                System.out.println("Your MathSet after being sorted in ascending order starting from a chosen value '22':");
                System.out.println(mathSet.toString());
                sortingNavigation();
                break;
            case "7":
                constructorCreatorNavigation();
                break;
            case "0":
                System.exit(1);
            default: {
                System.out.println("You've entered an invalid value, lets try again \n");
                sortingNavigation();
            }
        }
    }
// TO DO: create the test methods for the rest of MathSet functions
}


