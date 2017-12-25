package xmu.crms.vo;

import xmu.crms.dto.ProportionsDTO;

import java.math.BigInteger;

/**
 *
 * @author zyx
 * @Time  2017-12-3  16:40
 * 某门课程的详细信息
 */
public class ClassVO {

    private BigInteger id;
    private String name;
    private Integer numClass;
    private String time;
    private String site;
    private Integer calling;
    private String roster;
    private ProportionsVO proportion;
    private String courseName;
    private String courseTeacher;


    public ClassVO() {
    }

    public ClassVO(BigInteger id, String name, Integer numClass, String time, String site) {
        this.id = id;
        this.name = name;
        this.numClass = numClass;
        this.time = time;
        this.site = site;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassVO(Integer numClass) {
        this.numClass = numClass;
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

    public Integer getNumClass() {
        return numClass;
    }

    public void setNumClass(Integer numClass) {
        this.numClass = numClass;
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

    public ProportionsVO getProportion() {
        return proportion;
    }

    public void setProportion(ProportionsVO proportion) {
        this.proportion = proportion;
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
}
