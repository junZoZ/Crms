package xmu.crms.vo;

import java.math.BigInteger;
import java.util.Date;

public class CourseVO {
    private BigInteger id;
    private String name;
    private Integer numClass;
    private Date startTime;
    private Date endTime;
    private String description;
    private String teacherName;
    private String teacherEmail;
    private ProportionsVO proportions;

    public CourseVO() {
    }

    public CourseVO(BigInteger id, String name, Integer numClass, Date startTime, Date endTime) {
        this.id = id;
        this.name = name;
        this.numClass = numClass;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public CourseVO(String name, Date startTime, Date endTime, String description, ProportionsVO proportions) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.proportions = proportions;
    }

    public CourseVO(BigInteger id, String name, String description, String teacherName, String teacherEmail) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.teacherName = teacherName;
        this.teacherEmail = teacherEmail;
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

    public Integer getNumClass() {
        return numClass;
    }

    public void setNumClass(Integer numClass) {
        this.numClass = numClass;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public ProportionsVO getProportions() {
        return proportions;
    }

    public void setProportions(ProportionsVO courseProportion) {
        this.proportions = courseProportion;
    }




}
