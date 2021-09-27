package ua.com.alevel.unit_7_patterns.entity;

import java.util.ArrayList;
import java.util.Arrays;

public class Department {

    private String id;
    private String name;
    private ArrayList<String> workersId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getWorkersId() {
        return workersId;
    }

    public void setWorkersId(String workersId) {
        ArrayList<String> workers = new ArrayList<String>(Arrays.asList(workersId.split(",")));
        this.workersId = workers;
    }
}
