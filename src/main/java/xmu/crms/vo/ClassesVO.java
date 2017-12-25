package xmu.crms.vo;

import java.util.ArrayList;


/**
 * 
 * @author zyx
 * @Time  2017-12-2   09:57:01
 * 课程下的所有班级的简要信息
 */
public  class ClassesVO {

	private ArrayList<IdAndNameDTO> classList;

	
	public ClassesVO(ArrayList<IdAndNameDTO> classList) {
		this.classList = classList;
	}

	public ArrayList<IdAndNameDTO> getClassList() {
		return classList;
	}

	public void setClassList(ArrayList<IdAndNameDTO> classList) {
		this.classList = classList;
	}
    
	
}
