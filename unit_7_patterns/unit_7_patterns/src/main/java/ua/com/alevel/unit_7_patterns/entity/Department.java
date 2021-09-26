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

//    public static Builder newDepartment() {
//        return new Department().new Builder();
//    }
//
//    public class Builder {
//
//        private Builder() {
//        }
//
//        public Builder setId(String id) {
//            Department.this.id = id;
//            return this;
//        }
//
//        public Builder setName(String name) {
//            Department.this.name = name;
//            return this;
//        }
//
//        public Builder setWorkers(String workers) {
//            String workersArr[] = workers.split(", ");
//            ArrayList<String> al = new ArrayList<String>();
//            al.addAll(Arrays.asList(workersArr));
//            Department.this.workersId = al;
//            return this;
//        }
//
//        public Department build() {
//            return Department.this;
//        }
//    }
}
