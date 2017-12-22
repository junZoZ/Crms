package xmu.crms.dto;
/**
 * 
 * @author zyx
 * @Time  2017-12-2   16:49
 * 分数百分比
 */
public class ProportionsDTO {
	 private Integer c;
	 private Integer b;
	 private Integer a;
	 private Integer report;
	 private Integer presentation;

	public ProportionsDTO() {
	}

	public ProportionsDTO(Integer c, Integer b, Integer a, Integer report, Integer presentation) {
		this.c = c;
		this.b = b;
		this.a = a;
		this.report = report;
		this.presentation = presentation;
	}



	public Integer getC() {
		return c;
	}

	public void setC(Integer c) {
		this.c = c;
	}

	public Integer getB() {
		return b;
	}

	public void setB(Integer b) {
		this.b = b;
	}

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}

	public Integer getReport() {
		return report;
	}

	public void setReport(Integer report) {
		this.report = report;
	}

	public Integer getPresentation() {
		return presentation;
	}

	public void setPresentation(Integer presentation) {
		this.presentation = presentation;
	}

	@Override
	public String toString() {
		return "ProportionsDTO{" +
				"c=" + c +
				", b=" + b +
				", a=" + a +
				", report=" + report +
				", presentation=" + presentation +
				'}';
	}
}
