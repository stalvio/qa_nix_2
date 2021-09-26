package ua.com.alevel.unit_7_patterns.dao;

import ua.com.alevel.unit_7_patterns.entity.Department;
import ua.com.alevel.unit_7_patterns.exception.DepartmentNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AbstractDepartmentDao {

    protected List<Department> departments = new ArrayList<Department>();

    protected void createDepartment(Department department) {
        department.setId(generateId());
        departments.add(department);
    }

    protected void updateDepartment(Department department) {
        if (existById(department.getId())) {
            Department current = findDepartmentById(department.getId());
            current.setName(department.getName());
        }
    }

    protected void deleteDepartment(String id) {
        departments.removeIf(department -> department.getId().equals(id));
    }

    protected Department findDepartmentById(String id) {
        if (existById(id)) {
            return departments.stream().filter(department -> department.getId().equals(id)).findFirst().get();
        } else {
            throw new DepartmentNotFoundException("Requested department does not exist");
        }
    }

    protected List<Department> findAllDepartments() {
        return departments;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (existById(id)) {
            return generateId();
        }
        return id;
    }

    private boolean existById(String id) {
        return departments.stream().anyMatch(department -> department.getId().equals(id));
    }
}
