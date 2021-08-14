package ua.com.alevel.controller;

import ua.com.alevel.entity.Employer;
import ua.com.alevel.service.EmployerService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmployerController {

    private EmployerService employerService = new EmployerService();

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want create employer, please enter 1");
        System.out.println("if you want update employer, please enter 2");
        System.out.println("if you want delete employer, please enter 3");
        System.out.println("if you want findById employer, please enter 4");
        System.out.println("if you want findAll employer, please enter 5");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1":
                create(reader);
                break;
            case "2":
                update(reader);
                break;
            case "3":
                delete(reader);
                break;
            case "4":
                findById(reader);
                break;
            case "5":
                findAll(reader);
                break;
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {
        System.out.println("EmployerController.create");
        try {
            System.out.println("Please, enter your employer name");
            String name = reader.readLine();
            System.out.println("Please, enter your employer age");
            String ageString = reader.readLine();
            System.out.println("Please, enter your employer occupation");
            String occupationString = reader.readLine();
            int age = Integer.parseInt(ageString.trim());
            Employer employer = new Employer();
            employer.setAge(age);
            employer.setName(name);
            employer.setOccupation(occupationString);
            employerService.create(employer);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void update(BufferedReader reader) {
        System.out.println("EmployerController.update");
        try {
            System.out.println("Please, enter employer id");
            String id = reader.readLine();
            System.out.println("Please, enter your a new name");
            String name = reader.readLine();
            System.out.println("Please, enter your a new age");
            String ageString = reader.readLine();
            System.out.println("Please, enter your employer new occupation");
            String occupationString = reader.readLine();
            int age = Integer.parseInt(ageString.trim());
            Employer employer = new Employer();
            employer.setId(id);
            employer.setAge(age);
            employer.setName(name);
            employer.setOccupation(occupationString);
            employerService.update(employer);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void delete(BufferedReader reader) {
        System.out.println("Employer.delete");
        try {
            System.out.println("Please, enter your employer id");
            String id = reader.readLine();
            employerService.delete(id);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findById(BufferedReader reader) {
        System.out.println("EmployerController.findById");
        try {
            System.out.println("Please, enter your employer id");
            String id = reader.readLine();
            Employer employer = employerService.findById(id);
            System.out.println("Employer = " + employer.getName() + " is " +
                    employer.getOccupation() + " in the age of " + employer.getAge());
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAll(BufferedReader reader) {
        System.out.println("UserController.findAll");
        Employer[] employers = employerService.findAll();
        System.out.println("You have the following list of employers:");
        int i = 1;
        for (Employer employer : employers) {
            System.out.println("Employer#" + i + ": " + employer.getName() + " is a "
                    + employer.getOccupation().toLowerCase() + " in the age of "
                    + employer.getAge() + " and has employer id - " + employer.getId());
            i++;
        }
    }
}
