package ua.com.alevel.dao;

import ua.com.alevel.db.EmployerDB;
import ua.com.alevel.entity.Employer;

public class EmployerDao {

    private EmployerDB db = new EmployerDB();

    public void create(Employer employer) {
        db.create(employer);
    }

    public void update(Employer employer) {
        db.update(employer);
    }

    public void delete(String id) {
        db.delete(id);
    }

    public Employer findById(String id) {
        return db.findEmployerById(id);
    }

    public Employer[] findAll() {
        return db.findAll();
    }
}
