package models;

public class Batch {
    private int batchID;
    private String batchName;
    private int teacherID;

    public Batch(int batchID, String batchName, int teacherID) {
        this.batchID = batchID;
        this.batchName = batchName;
        this.teacherID = teacherID;
    }

    public int getBatchID() {
        return batchID;
    }

    public void setBatchID(int batchID) {
        this.batchID = batchID;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }
}
