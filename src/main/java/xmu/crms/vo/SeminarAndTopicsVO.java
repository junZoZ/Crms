package xmu.crms.vo;

import xmu.crms.dto.ProportionsDTO;

import java.util.ArrayList;

/**
 * 
 * @author zyx
 * @Time  2017-12-3  16:40
 * 某门课程的详细信息
 */
public class SeminarAndTopicsVO {

	  private Integer id;
      private String name;
	  private String description;
	  private String groupingMethod;
      private String startTime;
      private String endTime;
	  private ProportionsDTO seminarProportion;
      private ArrayList<TopicCheckVO1> topics;

	public SeminarAndTopicsVO() {
	}

	public SeminarAndTopicsVO(Integer id, String name, String description, String groupingMethod, String startTime,
							  String endTime, ProportionsDTO seminarProportion, ArrayList<TopicCheckVO1> topics) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.groupingMethod = groupingMethod;
		this.startTime = startTime;
		this.endTime = endTime;
		this.seminarProportion = seminarProportion;
		this.topics = topics;
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

	public String getGroupingMethod() {
		return groupingMethod;
	}

	public void setGroupingMethod(String groupingMethod) {
		this.groupingMethod = groupingMethod;
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

	public ProportionsDTO getSeminarProportion() {
		return seminarProportion;
	}

	public void setSeminarProportion(ProportionsDTO seminarProportion) {
		this.seminarProportion = seminarProportion;
	}

	public ArrayList<TopicCheckVO1> getTopics() {
		return topics;
	}

	public void setTopics(ArrayList<TopicCheckVO1> topics) {
		this.topics = topics;
	}

	@Override
	public String toString() {
		return "SeminarAanTopics{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", groupingMethod='" + groupingMethod + '\'' +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", seminarProportion=" + seminarProportion +
				", topics=" + topics +
				'}';
	}
}
