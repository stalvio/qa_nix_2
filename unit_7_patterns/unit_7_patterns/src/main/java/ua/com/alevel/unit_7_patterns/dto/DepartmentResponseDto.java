package ua.com.alevel.unit_7_patterns.dto;

import ua.com.alevel.unit_7_patterns.entity.Department;

import java.util.ArrayList;

public class DepartmentResponseDto {

    private String id;
    private String name;
    private ArrayList<String> workers;

    public DepartmentResponseDto(Department department) {
        id = department.getId();
        name = department.getName();
        workers = department.getWorkersId();
    }




}
