package xmu.crms.vo;

import xmu.crms.dto.IdAndNameDTO;
import xmu.crms.entity.Topic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;


public  class SeminarVO {

	Integer id;
	String name;
	String description;
	String groupingMethod;
	Date startTime;
	Date endTime;
	Integer grade;
	ArrayList<IdAndNameVO> topics;



	public SeminarVO() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getGroupingMethod() {
		return groupingMethod;
	}

	public void setGroupingMethod(String groupingMethod) {
		this.groupingMethod = groupingMethod;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public ArrayList<IdAndNameVO> getTopics() {
		return topics;
	}

	public void setTopics(ArrayList<IdAndNameVO> topics) {
		this.topics = topics;
	}



	@Override
	public String toString() {
		return "SeminarVO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", groupingMethod='" + groupingMethod + '\'' +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", grade=" + grade +
				", topics=" + topics +
				'}';
	}
}
