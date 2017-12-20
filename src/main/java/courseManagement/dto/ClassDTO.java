package courseManagement.dto;




/**
 *
 * @author zyx
 * @Time  2017-12-3  16:40
 * 某门课程的详细信息
 */
public class ClassDTO {

	private Integer id;
	private String name;
	private Integer numberStudent;
	private String time;
	private String site;
	private Integer calling;
	private String roster;
	private ProportionsDTO classProportion;

	public ClassDTO() {
	}

	public ClassDTO(Integer id, String name, Integer numberStudent, String time, String site, Integer calling, String roster, ProportionsDTO classProportion) {
		this.id = id;
		this.name = name;
		this.numberStudent = numberStudent;
		this.time = time;
		this.site = site;
		this.calling = calling;
		this.roster = roster;
		this.classProportion = classProportion;
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

	public Integer getNumberStudent() {
		return numberStudent;
	}

	public void setNumberStudent(Integer numberStudent) {
		this.numberStudent = numberStudent;
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

	public ProportionsDTO getClassProportion() {
		return classProportion;
	}

	public void setClassProportion(ProportionsDTO classProportion) {
		this.classProportion = classProportion;
	}

	@Override
	public String toString() {
		return "ClassDTO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", numberStudent=" + numberStudent +
				", time='" + time + '\'' +
				", site='" + site + '\'' +
				", calling=" + calling +
				", roster='" + roster + '\'' +
				", classProportion=" + classProportion +
				'}';
	}
}
