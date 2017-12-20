package courseManagement.dto;

import java.util.Date;

/**
 * 
 * @author zyx
 * @Time  2017-12-3  16:40
 * 某门课程的详细信息
 */
public class CourseDTO {

      private String name;
      private Date startTime;
      private Date endTime;
      private String description;
      private ProportionsDTO courseProportion;

	public CourseDTO() {
	}

	public CourseDTO(String name, Date startTime, Date endTime, String description, ProportionsDTO courseProportion) {
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.courseProportion = courseProportion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public ProportionsDTO getCourseProportion() {
		return courseProportion;
	}

	public void setCourseProportion(ProportionsDTO courseProportion) {
		this.courseProportion = courseProportion;
	}

	@Override
	public String toString() {
		return "CourseDTO{" +
				"name='" + name + '\'' +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", description='" + description + '\'' +
				", courseProportion=" + courseProportion +
				'}';
	}
}
