package ua.com.alevel.unit_7_patterns.dto;

import ua.com.alevel.unit_7_patterns.entity.Worker;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class WorkerResponseDto {

    private String id;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private int age;
    private String departmentId;
    private String email;

    public WorkerResponseDto(Worker worker) {
        this.id = worker.getId();
        this.firstName = worker.getFirstName();
        this.lastName = worker.getLastName();
        this.birthDay = worker.getBirthDay();
        this.departmentId = worker.getDepartment();
        this.email = worker.getEmail();
        this.age = generateAge(worker);
    }

    private int generateAge(final Worker worker) {
        Calendar birthDay = Calendar.getInstance();
        birthDay.setTimeInMillis(worker.getBirthDay().getTime());
        LocalDate today = LocalDate.now();
        LocalDate userBirthDay = LocalDate.of(
                birthDay.get(Calendar.YEAR + 1),
                birthDay.get(Calendar.MONTH + 1),
                birthDay.get(Calendar.DAY_OF_MONTH + 1));
        Period period = Period.between(userBirthDay, today);
        return period.getYears();
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public int getAge() {
        return age;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getEmail() {
        return email;
    }
}
