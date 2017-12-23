package xmu.crms.dto;

/**
 *
 * @author zyx
 * @Time  2017-12-2   16:40
 * 某个班级的大略信息
 */
public class IdAndNameDTO {

	private Integer id;
	private String name;


	public IdAndNameDTO(Integer id, String name) {
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "IdAndNameDTO{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
