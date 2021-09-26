package ua.com.alevel.unit_7_patterns.dao;

import ua.com.alevel.unit_7_patterns.entity.Worker;

import java.util.List;

public interface WorkerDao {

        void create(Worker worker);
        void update(Worker worker);
        void delete(String id);
        Worker findById(String id);
        boolean existByEmail(String email);
        List<Worker> findAll();
    }
