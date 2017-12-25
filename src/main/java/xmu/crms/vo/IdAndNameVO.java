package xmu.crms.vo;

import java.math.BigInteger;

/**
 *
 * @author zyx
 * @Time  2017-12-2   16:40
 * 某个班级的大略信息
 */
public class IdAndNameVO {

	private BigInteger id;
	private String name;


	public IdAndNameVO() {
	}

	public IdAndNameVO(BigInteger id, String name) {
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "IdAndNameDTO{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
