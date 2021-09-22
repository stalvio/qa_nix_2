package ua.com.alevel.service;

import ua.com.alevel.model.FileModel;
import ua.com.alevel.model.FileType;

import java.io.*;
import java.text.BreakIterator;
import java.util.*;
import java.util.stream.Collectors;

public class FIleServiceImpl implements FileService {

    private static final String BASE_PATH = "unit_9_ionio";

    public void create(FileModel fileModel) {
        File file = null;
        switch (fileModel.getFileType()) {
            case INPUT: {
                file = new File(BASE_PATH + "/" + fileModel.getFileName() + ".txt");
            }
            break;
            case OUTPUT: {
                String inputContent = read(FileType.INPUT.getFileName());
                String outputContent = getStatistic(inputContent);
                fileModel.setContent(outputContent);
                file = new File(BASE_PATH + "/" + fileModel.getFileName() + ".txt");
            }
            break;
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(fileModel.getContent());
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    public void delete(String fileName) {
        if (!isExist(fileName)) {
            System.out.println(fileName + ".txt wasn't created yet.");
            System.out.println();
        } else {
            File file = new File(BASE_PATH + "/" + fileName + ".txt");

           // file.deleteOnExit(); <- using this method the files are deleted only after exiting the program.
            file.delete();
            System.out.println(fileName + ".txt was deleted.");
            System.out.println();
        }
    }

    public String read(String fileName) {
        if (!isExist(fileName)) {
            System.out.println(fileName + ".txt wasn't created yet.");
        } else {
            File file = new File(BASE_PATH + "/" + fileName + ".txt");
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String fileContent; //= reader.readLine();
                fileContent =  reader.lines().collect(Collectors.joining());
                reader.close();
                return fileContent;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            return null;
    }

    private boolean isExist(String fileName) {
        File file = new File(BASE_PATH + "/");
        return Arrays.asList(file.list()).stream().anyMatch(fName -> (fName.equals(fileName + ".txt")));
    }

    private String getStatistic(String inputContent) {
        String strWithNoSpecSymbols = inputContent.trim().replaceAll("[^a-zA-Z]", " ");
        String[] words = strWithNoSpecSymbols.split("\\s+");

        String results = "Duplicates are: " + getNumberOfDuplicates(words).toString() + "\n" +
                "Palindromes are: " + getPalindromes(words).toString() + "\n" +
                "Number of Sentences: " + getSentencesNumber(inputContent);
        return results;
    }

    private Map<String, Integer> getNumberOfDuplicates(String[] words) {
        Map<String, Integer> wordMap = new HashMap<String, Integer>();

        HashSet<String> wordsSet = new HashSet<String>(Arrays.asList(words));

        for (String str : wordsSet) {
            str = str.toLowerCase();
            int wordCount = 0;
            for (int i = 0; i < words.length; i++) {
                if (str.equals(words[i].toLowerCase())) wordCount++;
            }
            wordMap.put(str, wordCount);
        }

        return wordMap.entrySet()
                .stream()
                .filter(map -> map.getValue().intValue() > 1)
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
    }

    private Map<String, Integer> getPalindromes(String[] words) {
        Map<String, Integer> wordMap = new HashMap<String, Integer>();

        for (String str : words) {
            str = str.toLowerCase();
            int wordCount = 0;
            for (int i = 0; i < words.length; i++) {
                if (str.equals(words[i].toLowerCase())) wordCount++;
            }
            if (isPalindrome(str)) {
                wordMap.put(str, wordCount);
            }
        }
        return wordMap;
    }

    private static boolean isPalindrome(String str) {
        if (str.length() == 1) {
            return false;
        } else if (str.length() == 2 || str.length() == 3) {
            return str.charAt(0) == str.charAt(str.length() - 1);
        } else if (str.length() % 2 == 0) {
            String str1 = str.substring(0, str.length() / 2);
            StringBuilder stringBuilder1 = new StringBuilder(str1);
            str1 = stringBuilder1.reverse().toString();
            String str2 = str.substring(str.length() / 2);
            return str1.equals(str2);
        } else if (str.length() % 2 == 1) {
            String str1 = str.substring(0, str.length() / 2);
            StringBuilder stringBuilder1 = new StringBuilder(str1);
            str1 = stringBuilder1.reverse().toString();
            String str2 = str.substring(str.length() / 2 + 1);
            return str1.equals(str2);
        }
        return false;
    }

    private int getSentencesNumber(String targetSentence) {

        Locale currentLocale = new Locale("en", "US");

        BreakIterator iterator
                = BreakIterator.getSentenceInstance(currentLocale);

        StringBuffer markers = new StringBuffer();

        markers.setLength(targetSentence.length() + 1);
        for (int k = 0; k < markers.length(); k++) {
            markers.setCharAt(k, ' ');
        }
        int count = 0;
        iterator.setText(targetSentence);
        int boundary = iterator.first();
        while (boundary != BreakIterator.DONE) {
            markers.setCharAt(boundary, '^');
            ++count;
            boundary = iterator.next();
        }

        return count - 1;
    }
}
