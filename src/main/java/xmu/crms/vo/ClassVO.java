package xmu.crms.vo;


import java.math.BigInteger;

/**
 *
 * @author zyx
 * @Time  2017-12-3  16:40
 * 某门课程的详细信息
 */
public class ClassVO {

    private Integer id;
    private String name;
    private String roster;
    private Integer numStudent;
    private String time;
    private String site;
    private Integer calling;
    private Integer courseId;


    private ProportionsVO proportions;
    private String courseName;
    private String courseTeacher;


    public ClassVO() {
    }

    public ClassVO(Integer id, String name, Integer numStudent, String time, String site) {
        this.id = id;
        this.name = name;
        this.numStudent = numStudent;
        this.time = time;
        this.site = site;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassVO(Integer numClass) {
        this.numStudent = numClass;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Integer getNumStudent() {
        return numStudent;
    }

    public void setNumStudent(Integer numStudent) {
        this.numStudent = numStudent;
    }

    public Integer getCalling() {
        return calling;
    }

    public void setCalling(Integer calling) {
        this.calling = calling;
    }

    public ProportionsVO getProportions() {
        return proportions;
    }

    public void setProportions(ProportionsVO proportion) {
        this.proportions = proportion;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public String getRoster() {
        return roster;
    }

    public void setRoster(String roster) {
        this.roster = roster;
    }

    @Override
    public String toString() {
        return "ClassVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roster='" + roster + '\'' +
                ", numStudent=" + numStudent +
                ", time='" + time + '\'' +
                ", site='" + site + '\'' +
                ", calling=" + calling +
                ", proportions=" + proportions +
                ", courseName='" + courseName + '\'' +
                ", courseTeacher='" + courseTeacher + '\'' +
                '}';
    }
}
