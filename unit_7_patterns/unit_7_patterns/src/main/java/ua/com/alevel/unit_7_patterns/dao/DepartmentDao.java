package ua.com.alevel.unit_7_patterns.dao;

import ua.com.alevel.unit_7_patterns.entity.Department;

import java.util.List;

public interface DepartmentDao {

        void create(Department department);
        void update(Department department);
        void delete(String id);
        Department findById(String id);
        List<Department> findAll();
    }

