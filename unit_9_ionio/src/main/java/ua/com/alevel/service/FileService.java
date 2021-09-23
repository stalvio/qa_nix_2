package ua.com.alevel.service;

import ua.com.alevel.model.FileModel;

public interface FileService {

    void create(FileModel fileModel);

    void delete(String file);

    String read(String fileName);
}
