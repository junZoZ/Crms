package xmu.crms.vo;

import xmu.crms.entity.Seminar;
import xmu.crms.entity.SeminarGroup;

import java.util.ArrayList;
/**
 * @author  cb
 */
public class TopicVO {

    Integer id;
    String serial;
    String name;
    String description;
    Integer groupLimit;
    Integer groupMemberLimit;
    Integer groupLeft;
    ArrayList<SeminarGroup> groups;

    public TopicVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getGroupLimit() {
        return groupLimit;
    }

    public void setGroupLimit(Integer groupLimit) {
        this.groupLimit = groupLimit;
    }

    public Integer getGroupMemberLimit() {
        return groupMemberLimit;
    }

    public void setGroupMemberLimit(Integer groupMemberLimit) {
        this.groupMemberLimit = groupMemberLimit;
    }

    public Integer getGroupLeft() {
        return groupLeft;
    }

    public void setGroupLeft(Integer groupLeft) {
        this.groupLeft = groupLeft;
    }

    public ArrayList<SeminarGroup> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<SeminarGroup> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "TopicVO{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", groupLimit=" + groupLimit +
                ", groupMemberLimit=" + groupMemberLimit +
                ", groupLeft=" + groupLeft +
                ", groups=" + groups +
                '}';
    }
}
