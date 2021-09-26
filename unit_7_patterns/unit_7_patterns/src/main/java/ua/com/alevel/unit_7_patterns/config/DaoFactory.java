package ua.com.alevel.unit_7_patterns.config;

import ua.com.alevel.unit_7_patterns.dao.CsvWorkerDao;
import ua.com.alevel.unit_7_patterns.dao.DaoType;
import ua.com.alevel.unit_7_patterns.dao.WorkerDao;
import ua.com.alevel.unit_7_patterns.util.ResourceUtil;

import java.util.Map;

public class DaoFactory {

    private static DaoFactory instance;
    private DaoType daoType;
    private WorkerDao workerDao;

    public DaoFactory() {
    }

    public static DaoFactory getInstance() {
        if(instance == null){
            instance = new DaoFactory();
        }
        return instance;
    }

    public WorkerDao getWorkerDao(){
        Map<String, String> map = ResourceUtil.getResource("application.properties");
        daoType = DaoType.init(map.get("dao.type"));

        switch (daoType) {
            case CSV : {
                if (workerDao == null) {
                    workerDao = new CsvWorkerDao();
                }
            } break;
            case JSON : {
            } break;
        }
        return workerDao;
    }
}
