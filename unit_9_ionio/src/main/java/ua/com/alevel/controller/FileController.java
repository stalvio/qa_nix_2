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
            fileModel.setFileName(FileType.INPUT.getFileName());
            fileModel.setContent(userInput);
            fileModel.setFileType(FileType.INPUT);
            fileService.create(fileModel);
            System.out.println();
            System.out.println("Your input was saved in input.txt file of this directory. Please, select from the following options:");
            navigation();
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void navigation() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 1, to store the statistic on numbers of duplicates, palindrome, and sentences in output.txt file");
        System.out.println("Enter 2, to check the statistic from output.txt file");
        System.out.println("Enter 3, to check your input from input.txt file");
        System.out.println("Enter 4, to delete input.txt file");
        System.out.println("Enter 5, to delete output.txt file");
        System.out.println("Enter 6, to update your input");
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
                fileModel.setFileType(FileType.OUTPUT);
                fileModel.setFileName(FileType.OUTPUT.getFileName());
                fileService.create(fileModel);
                System.out.println("The statistic on your input was successfully created and stored in output.txt file");
                System.out.println();
                navigation();
                break;
            case "2":
                fileModel.setFileType(FileType.OUTPUT);
                fileModel.setFileName(FileType.OUTPUT.getFileName());
                String outputData = fileService.read(fileModel.getFileName());
                printData(outputData);
                navigation();
                break;
            case "3":
                fileModel.setFileType(FileType.INPUT);
                fileModel.setFileName(FileType.INPUT.getFileName());
                String inputData = fileService.read(fileModel.getFileName());
                printData(inputData);
                navigation();
                break;
            case "4":
                fileService.delete(FileType.INPUT.getFileName());
                navigation();
                break;
            case "5":
                fileService.delete(FileType.OUTPUT.getFileName());
                navigation();
                break;
            case "6":
                fileService.delete(FileType.OUTPUT.getFileName());
                start();
                break;
            case "0":
                System.exit(1);
                break;
            default:
                System.out.println("You've entered an invalid value, lets try again \n");
                navigation();

        }
    }

    private void printData(String content) {
        if(content!= null) {
            System.out.println(content);
            System.out.println();
        }
    }
}

