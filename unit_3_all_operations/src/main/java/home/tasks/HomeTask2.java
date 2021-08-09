package home.tasks;

import java.util.*;

public class HomeTask2 {

    public void run() {
        Map<Character, Integer> letters = new HashMap<>();
        Scanner in = new Scanner(System.in);
        System.out.print("Please, type your input: ");
        String userInput = in.nextLine();
        String onlyLetters = extractOnlyLetters(userInput);
        char[] onlyLettersArray = new char[onlyLetters.length()];
        for (int i = 0; i < onlyLetters.length(); i++) {
            onlyLettersArray[i] = onlyLetters.charAt(i);
        }
        System.out.println("");
        for (char singleLetter : onlyLettersArray) {
            if (letters.containsKey(singleLetter)) {
                Integer count = letters.get(singleLetter);
                letters.put(singleLetter, ++count);
            } else {
                letters.put(singleLetter, 1);
            }
        }

        final class FrequencyComparator implements Comparator<Character> {
            Map<Character, Integer> refMap;
            public FrequencyComparator(Map<Character, Integer> base) {
                this.refMap = base;
            }

            @Override
            public int compare(Character k1, Character k2) {
                Integer val1 = refMap.get(k1);
                Integer val2 = refMap.get(k2);

                int num = val1.compareTo(val2);
                return num == 0 ? k1.compareTo(k2) : num;
            }
        }

        FrequencyComparator comp = new FrequencyComparator(letters);
        TreeMap<Character, Integer> sortedMap;
        sortedMap = new TreeMap<Character, Integer>(comp);
        sortedMap.putAll(letters);

        for (Map.Entry<Character, Integer> entry : sortedMap.descendingMap().entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    private String extractOnlyLetters(String input) {
        return input.replaceAll("[^a-zA-Z]", "");
    }
}
