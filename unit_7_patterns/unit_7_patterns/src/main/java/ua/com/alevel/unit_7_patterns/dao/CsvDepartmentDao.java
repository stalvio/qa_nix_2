package ua.com.alevel.unit_7_patterns.dao;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;
import ua.com.alevel.unit_7_patterns.entity.Department;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service("CsvDepartmentDao")
public class CsvDepartmentDao extends AbstractDepartmentDao implements FileIO, DepartmentDao {

    private final List<String[]> csvData = new ArrayList<>();

    @Override
    public void create(Department department) {
        loadEntities();
        createDepartment(department);
        storeEntities();
    }

    @Override
    public void update(Department department) {
        loadEntities();
        updateDepartment(department);
        storeEntities();
    }

    @Override
    public void delete(String id) {
        loadEntities();
        deleteDepartment(id);
        storeEntities();
    }

    @Override
    public Department findById(String id) {
        loadEntities();
        return findDepartmentById(id);
    }

    @Override
    public List<Department> findAll() {
        loadEntities();
        return findAllDepartments();
    }

    @Override
    public void loadEntities() {
        try(CSVReader reader = new CSVReader(new FileReader("departments.csv"))) {
            super.departments.clear();
            List<String[]> res = reader.readAll();
            for (String[] re : res) {
                try {
                    if (!re[0].equals("id")) {
                        Department department = new Department();
                        department.setId(re[0]);
                        department.setName(re[1]);
                        department.setWorkersId(re[2]);
                        super.departments.add(department);
                    }
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
        for (Department u : super.departments) {
            String[] currentDepartment = new String[3];
            currentDepartment[0] = u.getId();
            currentDepartment[1] = u.getName();
            if(!(u.getWorkersId() == null) && (!u.getWorkersId().equals("NoWorkers") || u.getWorkersId().equals(""))) {
                currentDepartment[2] = u.getWorkersId().toString().substring(1, u.getWorkersId().toString().length() - 1).replace(" ", "");
            } else {
                currentDepartment[2] = "NoWorkers";
            }
            csvData.add(currentDepartment);
        }
        try(CSVWriter writer = new CSVWriter(new FileWriter("departments.csv"))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeHeader() {
        String[] header = { "id", "DepartmentName", "Workers" };
        csvData.add(header);
    }

}
