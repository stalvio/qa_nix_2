package ua.com.alevel.unit_7_patterns.dao;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;
import ua.com.alevel.unit_7_patterns.entity.Department;
import ua.com.alevel.unit_7_patterns.entity.Worker;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("CsvWorkerDao")
public class CsvWorkerDao extends AbstractWorkerDao implements WorkerDao, FileIO {

    private final List<String[]> csvData = new ArrayList<>();

    @Override
    public void create(Worker worker) {
        loadEntities();
        createWorker(worker);
        storeEntities();
        updateDepartments(worker);
    }

    @Override
    public void update(Worker worker) {
        loadEntities();
        updateWorker(worker);
        storeEntities();
        updateDepartments(worker);
    }

    @Override
    public void delete(String id) {
        loadEntities();
        deleteWorker(id);
        storeEntities();
        removeWorkerFromDepartment(id);
    }

    @Override
    public Worker findById(String id) {
        loadEntities();
        return findWorkerById(id);
    }

    @Override
    public boolean existByEmail(String email) {
        loadEntities();
        return existWorkerByEmail(email);
    }

    @Override
    public List<Worker> findAll() {
        loadEntities();
        return findAllWorkers();
    }

    @Override
    public void loadEntities() {
        try (CSVReader reader = new CSVReader(new FileReader("workers.csv"))) {
            super.workers.clear();
            List<String[]> res = reader.readAll();
            for (String[] re : res) {
                try {
                    Worker worker = Worker.newWorker()
                            .setId(re[0])
                            .setFirstName(re[1])
                            .setLastName(re[2])
                            .setEmail(re[3])
                            .setBirthDay(new Date(Long.parseLong(re[4])))
                            .setDepartment(re[5])
                            .build();
                    super.workers.add(worker);
                } catch (Exception e) {
                    System.out.println("e = " + e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void storeEntities() {
        this.csvData.clear();
        writeHeader();
        for (Worker u : super.workers) {
            String[] currentWorker = new String[6];
            currentWorker[0] = u.getId();
            currentWorker[1] = u.getFirstName();
            currentWorker[2] = u.getLastName();
            currentWorker[3] = u.getEmail();
            currentWorker[4] = String.valueOf(u.getBirthDay().getTime());
            if (!(u.getDepartment() == null)) {
                currentWorker[5] = u.getDepartment();
            } else {
                currentWorker[5] = "No Department";
            }
            csvData.add(currentWorker);
        }
        try (CSVWriter writer = new CSVWriter(new FileWriter("workers.csv"))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateDepartments(Worker worker) {
        CsvDepartmentDao csvDepartmentDao = new CsvDepartmentDao();
        csvDepartmentDao.loadEntities();
        for (Department department : csvDepartmentDao.departments) {
            if (department.getId().equals(worker.getDepartment())) {
                department.getWorkersId().add(worker.getId());
                if (department.getWorkersId().contains("NoWorkers")) {
                    department.getWorkersId().remove(0);
                }
            } else {
                for (String id : department.getWorkersId()) {
                    if (id.equals(worker.getId())) {
                        department.getWorkersId().remove(worker.getId());
                        break;
                    }
                }
            }
        }
        csvDepartmentDao.storeEntities();
    }

    private void removeWorkerFromDepartment(String workerId) {
        CsvDepartmentDao csvDepartmentDao = new CsvDepartmentDao();
        csvDepartmentDao.loadEntities();
        for (Department department : csvDepartmentDao.departments) {
            if (!department.getWorkersId().isEmpty()) {
                for (String id : department.getWorkersId()) {
                    if (id.equals(workerId)) {
                        department.getWorkersId().remove(id);
                        break;
                    }
                }
                if (department.getWorkersId().isEmpty()) department.getWorkersId().add("NoWorkers");
            }
        }
        csvDepartmentDao.storeEntities();
    }

    private void writeHeader() {
        String[] header = {"id", "firstName", "lastName", "email", "birthDay", "department"};
        csvData.add(header);
    }
}
