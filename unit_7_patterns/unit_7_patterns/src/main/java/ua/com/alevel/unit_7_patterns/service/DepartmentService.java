package ua.com.alevel.unit_7_patterns.service;

import ua.com.alevel.unit_7_patterns.entity.Department;

import java.util.List;

public interface DepartmentService {

    void create(Department department);
    void update(Department department);
    void delete(String id);
    Department findById(String id);
    List<Department> findAll();
}
