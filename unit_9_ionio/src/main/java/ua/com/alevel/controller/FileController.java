package ua.com.alevel.controller;

import ua.com.alevel.model.FileModel;
import ua.com.alevel.model.FileType;
import ua.com.alevel.service.FIleServiceImpl;
import ua.com.alevel.service.FileService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileController {

    FileService fileService = new FIleServiceImpl();

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please, enter the text that contains the duplicates and palindrome(e.g. 'level', 'nun', 'noon ' etc)");
        String userInput;
        try {
            userInput = reader.readLine();
            FileModel fileModel = new FileModel();
            fileModel.setFileName("input");
            fileModel.setContent(userInput);
            fileModel.setFileType(FileType.INPUT);
            fileService.create(fileModel);
            System.out.println("Your input was saved in INPUT.txt file. Please, select from the following options:");
            navigation();
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void navigation() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 1, to get the statistic on numbers of duplicates, palindrome, and sentences");
        System.out.println("Enter 2, to check your input from INPUT.txt file");
        System.out.println("Enter 3, to update your input with duplicates and palindrome");
        System.out.println("Enter 4, to delete INPUT.txt and OUTPUT.txt");
        System.out.println("Enter 0, to quit");
        String fileOption;
        try {
            while ((fileOption = reader.readLine()) != null) {
                crudFile(fileOption);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void crudFile(String fileOption) {
        FileModel fileModel = new FileModel();
        switch (fileOption) {
            case "1":
             //   fileModel.setFileType(FileType.OUTPUT);
                fileModel.setFileName("output");
                fileService.create(fileModel);

                navigation();
                break;
            case "2":
             //   fileModel.setFileType(FileType.INPUT);
                fileModel.setFileName("input");
                System.out.println(fileService.read(fileModel.getFileName()));
                navigation();
                break;
            case "4":
                //fileModel.setFileType(FileType.INPUT);
                fileModel.setFileName("output");
                fileService.delete("output");
                navigation();
                break;
            case "0":
                System.exit(1);
                break;
            default:
                System.out.println("You've entered an invalid value, lets try again \n");
                navigation();

        }

    }
}

