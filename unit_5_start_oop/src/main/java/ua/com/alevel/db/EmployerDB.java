package ua.com.alevel.db;

import ua.com.alevel.entity.Employer;

import java.util.Arrays;
import java.util.UUID;

public class EmployerDB {

    private Employer[] employers = new Employer[0];
    private int totalNumEmp = 0;

    public void create(Employer newEmp) {
        Employer[] newEmployers = new Employer[totalNumEmp + 1];

        for (int i = 0; i < employers.length; i++) {
            newEmployers[i] = employers[i];
        }

        newEmp.setId(generateId());
        newEmployers[totalNumEmp] = newEmp;
        totalNumEmp++;

        employers = newEmployers;
        System.out.println("Congratulation! A new  " + employers[totalNumEmp - 1].getOccupation().toLowerCase() +
                " " + employers[totalNumEmp - 1].getName() + " was successfully hired!");
    }

    public void update(Employer updatedEmp) {
        if (isEmployerIdExist(updatedEmp.getId())) {
            Employer currentEmp = Arrays.stream(employers).filter(emp ->
                    emp.getId().equals(updatedEmp.getId())).findFirst().get();

            currentEmp.setAge(updatedEmp.getAge());
            currentEmp.setName(updatedEmp.getName());
            currentEmp.setOccupation(updatedEmp.getOccupation());
        } else {
            System.out.println("This employer is not exist. Lets, try again.");
        }
    }

    public void delete(String empId) {
        if (isEmployerIdExist(empId)) {
            String name = "";
            Employer[] latestEmployers = new Employer[employers.length - 1];

            int j = 0;
            for (int i = 0; i < employers.length; i++) {
                if (employers[i].getId().equals(empId)) {
                    name = employers[i].getName();
                    i++;
                }
                latestEmployers[j] = employers[i];
                j++;
            }
            employers = latestEmployers;
            System.out.println("Congratulation! " + name + " was successfully fired!");
        } else {
            System.out.println("The employer with this id is not exist. Lets, try again.");
        }
    }

    public Employer findEmployerById(String id) {
        Employer employer = Arrays.stream(employers).filter(emp -> emp.getId().equals(id)).findFirst().get();
        return employer;
    }

    public Employer[] findAll() {
        return employers;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (Arrays.stream(employers).anyMatch(employer -> employer.getId().equals(id))) {
            return generateId();
        }
        return id;
    }

    private boolean isEmployerIdExist(String empId) {
        for (Employer emp : employers) {
            if (emp.getId().equals(empId)) {
                return true;
            }
        }
        return false;
    }
}




