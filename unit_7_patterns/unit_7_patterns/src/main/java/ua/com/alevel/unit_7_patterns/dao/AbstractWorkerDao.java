package ua.com.alevel.unit_7_patterns.dao;

import ua.com.alevel.unit_7_patterns.entity.Worker;
import ua.com.alevel.unit_7_patterns.exception.WorkerNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class AbstractWorkerDao {

    protected List<Worker> workers = new ArrayList<>();

    protected void createWorker(Worker worker) {
        worker.setId(generateId());
        workers.add(worker);
    }

    protected void updateWorker(Worker worker) {
        if (existById(worker.getId())) {
            Worker current = findWorkerById(worker.getId());
            current.setId(worker.getId());
            current.setFirstName(worker.getFirstName());
            current.setLastName(worker.getLastName());
            current.setDepartment(worker.getDepartment());
        }
    }

    protected void deleteWorker(String id) {
        workers.removeIf(worker -> worker.getId().equals(id));
    }

    protected Worker findWorkerById(String id) {
        if (existById(id)) return workers.stream().filter(worker -> worker.getId().equals(id)).findFirst().get();
        return null;
    }

    protected List<Worker> findAllWorkers() {
        return workers;
    }

    protected boolean existWorkerByEmail(String email) {
        return workers.stream().anyMatch(user -> user.getEmail().equals(email));
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (existById(id)) {
            return generateId();
        }
        return id;
    }

    private boolean existById(String id) {
        if (!workers.stream().anyMatch(worker -> worker.getId().equals(id))) {
            throw new WorkerNotFoundException("Requested worker does not exist");
        } else {
        return workers.stream().anyMatch(worker -> worker.getId().equals(id));
    }
    }
}
