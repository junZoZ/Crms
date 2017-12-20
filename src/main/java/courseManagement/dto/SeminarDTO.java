package courseManagement.dto;

import java.util.Date;

/**
 * 
 * @author zyx
 * @Time  2017-12-3  16:40
 * 某门课程的详细信息
 */
public class SeminarDTO {

      private String name;
	  private String groupingMethod;
      private String startTime;

      private String endTime;
      private String description;
      private ProportionsDTO seminarProportion;

	public SeminarDTO() {
	}

	public SeminarDTO(String name, String groupingMethod, String startTime, String endTime, String description, ProportionsDTO seminarProportion) {
		this.name = name;
		this.groupingMethod = groupingMethod;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.seminarProportion = seminarProportion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProportionsDTO getSeminarProportion() {
		return seminarProportion;
	}

	public void setSeminarProportion(ProportionsDTO seminarProportion) {
		this.seminarProportion = seminarProportion;
	}

	@Override
	public String toString() {
		return "SeminarDTO{" +
				"name='" + name + '\'' +
				", groupingMethod='" + groupingMethod + '\'' +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", description='" + description + '\'' +
				", seminarProportion=" + seminarProportion +
				'}';
	}
}
