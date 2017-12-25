package xmu.crms.vo;

import xmu.crms.dto.ProportionsDTO;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author zyx
 * @Time  2017-12-3  16:40
 * 某门课程的详细信息
 */
public class SeminarAanTopics {

	  private Integer id;
      private String name;
	  private String description;
	  private String groupingMethod;
      private Date startTime;
      private Date endTime;
	  private ProportionsDTO seminarProportion;
      private ArrayList<IdAndNameDTO> topics;

	public SeminarAanTopics() {
	}


	public SeminarAanTopics(Integer id, String name, String description, String groupingMethod, Date startTime, Date endTime, ProportionsDTO seminarProportion, ArrayList<IdAndNameDTO> topics) {
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

	public ProportionsDTO getSeminarProportion() {
		return seminarProportion;
	}

	public void setSeminarProportion(ProportionsDTO seminarProportion) {
		this.seminarProportion = seminarProportion;
	}

	public ArrayList<IdAndNameDTO> getTopics() {
		return topics;
	}

	public void setTopics(ArrayList<IdAndNameDTO> topics) {
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
