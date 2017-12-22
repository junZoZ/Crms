package xmu.crms.vo;

import xmu.crms.dto.ProportionsDTO;

/**
 *
 * @author zyx
 * @Time  2017-12-3  16:40
 * 某门课程的详细信息
 */
public class ClassVO {

    private Integer id;
    private String name;
    private Integer numberStudent;
    private String time;
    private String site;
    private Integer calling;
    private String roster;
    private ProportionsDTO classProportion;

    private String courseName;
    private String courseTeacher;


    public ClassVO() {
    }

    public ClassVO(Integer id, String name, Integer numberStudent, String site, String time, Integer calling, String roster, ProportionsDTO classProportion) {
        this.id = id;
        this.name = name;
        this.numberStudent = numberStudent;
        this.site = site;
        this.time = time;
        this.calling = calling;
        this.roster = roster;
        this.classProportion = classProportion;
    }

    public ClassVO(Integer id, String name, Integer numberStudent, String time, String site, String courseName, String courseTeacher) {
        this.id = id;
        this.name = name;
        this.numberStudent = numberStudent;
        this.time = time;
        this.site = site;
        this.courseName = courseName;
        this.courseTeacher = courseTeacher;
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



    public void setNumberStudent(Integer numberStudent) {
        this.numberStudent = numberStudent;
    }



    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getCalling() {
        return calling;
    }

    public void setCalling(Integer calling) {
        this.calling = calling;
    }

    public String getRoster() {
        return roster;
    }

    public void setRoster(String roster) {
        this.roster = roster;
    }

    public ProportionsDTO getClassProportion() {
        return classProportion;
    }

    public void setClassProportion(ProportionsDTO classProportion) {
        this.classProportion = classProportion;
    }

    public Integer getNumberStudent() {
        return numberStudent;
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

    @Override
    public String toString() {
        return "ClassVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberStudent=" + numberStudent +
                ", time='" + time + '\'' +
                ", site='" + site + '\'' +
                ", calling=" + calling +
                ", roster='" + roster + '\'' +
                ", classProportion=" + classProportion +
                ", courseName='" + courseName + '\'' +
                ", courseTeacher='" + courseTeacher + '\'' +
                '}';
    }
}
