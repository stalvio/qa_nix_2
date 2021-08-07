package home.tasks;

import java.util.Scanner;

public class HomeTask3 {

    public void run() {
        int lessonNumber = 0;
        int timeToTheLessonEndInMin;
        String userInput;

        Scanner in = new Scanner(System.in);

        while (lessonNumber == 0) {
            System.out.print("Please, enter the number of a lesson (1-10): ");
            userInput = in.nextLine();

            if ((userInput.matches("^\\d$") || userInput.equals("10")) && !userInput.equals("0")) {

                lessonNumber = getLessonNumber(userInput);
                timeToTheLessonEndInMin = getTimeToTheLessonEndInMinutes(lessonNumber);

                System.out.println(9 + timeToTheLessonEndInMin / 60 + " " + (timeToTheLessonEndInMin % 60) / 10 + (timeToTheLessonEndInMin % 60) % 10 + "\n");

            } else {
                System.out.println("You've entered an invalid value, let's try again!" + "\n");
            }
        }
    }

    private int getLessonNumber (String userInput) {
        return Integer.parseInt(userInput);
    }

    private int getTimeToTheLessonEndInMinutes (int lessonNumber){
        return (45 + (lessonNumber - 1) * 55 - ((lessonNumber - 1) % 2) * 5);
    }
}
