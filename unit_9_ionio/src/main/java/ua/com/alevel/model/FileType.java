package ua.com.alevel.model;

public enum FileType {

    INPUT("input"), OUTPUT("output");

    private final String fileType;

    FileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileType;
    }
}
