package ua.com.alevel.unit_7_patterns.service;

import org.springframework.stereotype.Service;
import ua.com.alevel.unit_7_patterns.dao.DepartmentDao;
import ua.com.alevel.unit_7_patterns.entity.Department;
import ua.com.alevel.unit_7_patterns.exception.DepartmentNotFoundException;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentDao departmentDao;

    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public void create(Department department) {
        departmentDao.create(department);
    }

    @Override
    public void update(Department department) {
        departmentDao.update(department);
    }

    @Override
    public void delete(String id) {
        if(isEmpty(id)) {
            departmentDao.delete(id);
        } else {
            throw new DepartmentNotFoundException("Requested department does not exist");
        }
    }

    @Override
    public Department findById(String id) {
        return departmentDao.findById(id);
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    private boolean isEmpty(String id) {
        return (departmentDao.findById(id).getWorkersId().get(0).equals("No workers") || departmentDao.findById(id).getWorkersId().isEmpty());
    }
}
