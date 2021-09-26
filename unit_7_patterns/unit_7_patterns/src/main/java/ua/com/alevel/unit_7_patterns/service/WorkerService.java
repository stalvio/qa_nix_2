package ua.com.alevel.unit_7_patterns.service;

import ua.com.alevel.unit_7_patterns.entity.Worker;

import java.util.List;

public interface WorkerService {

    void create(Worker worker);
    void update(Worker worker);
    void delete(String id);
    Worker findById(String id);
    List<Worker> findAll();
}
