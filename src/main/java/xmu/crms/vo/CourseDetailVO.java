package xmu.crms.vo;

import xmu.crms.dto.ProportionsDTO;

import java.math.BigInteger;
import java.util.Date;

/**
 * 
 * @author zyx
 * @Time  2017-12-3  16:40
 * 某门课程的详细信息
 */
public class CourseDetailVO {

	  private BigInteger id;
      private String name;
      private Date startTime;
      private Date endTime;
      private String description;
      private ProportionsVO courseProportion;

	public CourseDetailVO() {
	}

	public CourseDetailVO(BigInteger id, String name, Date startTime, Date endTime, String description,
						  ProportionsVO courseProportion) {
		this.id = id;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.courseProportion = courseProportion;
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

	public ProportionsVO getCourseProportion() {
		return courseProportion;
	}

	public void setCourseProportion(ProportionsVO courseProportion) {
		this.courseProportion = courseProportion;
	}

	@Override
	public String toString() {
		return "CourseDetailVO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", description='" + description + '\'' +
				", courseProportion=" + courseProportion +
				'}';
	}
}
