package xmu.crms.vo;

public class CoursesListVO {
    int id;
    String name;
    int numClass;
    int numStudent;
    String startTime;
    String endTime;

    public CoursesListVO() {
    }

    public CoursesListVO(int id, String name, int numClass,int numStudent, String startTime, String endTime) {
        this.id = id;
        this.name = name;
        this.numClass = numClass;
        this.numStudent = numStudent;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumClass() {
        return numClass;
    }

    public void setNumClass(int numClass) {
        this.numClass = numClass;
    }

    public int getNumStudent() {
        return numStudent;
    }

    public void setNumStudent(int numStudet) {
        this.numStudent = numStudet;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "CoursesListVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numClass='" + numClass + '\'' +
                ", numStudet='" + numStudent + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
