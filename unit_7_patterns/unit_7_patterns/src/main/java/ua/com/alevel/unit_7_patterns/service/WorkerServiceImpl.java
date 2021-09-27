package ua.com.alevel.unit_7_patterns.service;

import org.springframework.stereotype.Service;
import ua.com.alevel.unit_7_patterns.dao.WorkerDao;
import ua.com.alevel.unit_7_patterns.entity.Worker;
import ua.com.alevel.unit_7_patterns.exception.DepartmentNotFoundException;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    private final WorkerDao workerDao;

    public WorkerServiceImpl(WorkerDao workerDao) {
        this.workerDao = workerDao;
    }

    @Override
    public void create(Worker worker) {
        workerDao.create(worker);
    }

    @Override
    public void update(Worker worker) {
        workerDao.update(worker);
    }

    @Override
    public void delete(String id) {
        if (isExist(id)) {
            workerDao.delete(id);
        } else {
            throw new DepartmentNotFoundException("Requested worker does not exist");
        }
        //    workerDao.delete(id);
    }

    @Override
    public Worker findById(String id) {
        return workerDao.findById(id);
    }

    @Override
    public List<Worker> findAll() {
        return workerDao.findAll();
    }

    private boolean isExist(String id) {
        if (workerDao.findById(id).equals(null)) {
            return false;
        } else {
            return true;
        }
    }
}
