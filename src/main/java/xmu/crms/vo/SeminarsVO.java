package xmu.crms.vo;

import xmu.crms.dto.IdAndNameDTO;

import java.util.ArrayList;
import java.util.Date;


public  class SeminarsVO {

	Integer id;
	String name;
	String description;
	String groupingMethod;
	Date startTime;
	Date endTime;
	Integer grade;

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

	@Override
	public String toString() {
		return "SeminarsVO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", startTime='" + startTime + '\'' +
				", endTime='" + endTime + '\'' +
				", grade='" + grade + '\'' +
				'}';
	}
}
