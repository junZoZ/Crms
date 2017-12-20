package courseManagement.vo;

import courseManagement.dto.IdAndNameDTO;

import java.util.ArrayList;


/**
 * 
 * @author zyx
 * @Time  2017-12-2   09:57:01
 * 课程下的所有班级的简要信息
 */
public  class SeminarsVO {

	private ArrayList<IdAndNameDTO> classList;


	public SeminarsVO(ArrayList<IdAndNameDTO> classList) {
		this.classList = classList;
	}

	public ArrayList<IdAndNameDTO> getClassList() {
		return classList;
	}

	public void setClassList(ArrayList<IdAndNameDTO> classList) {
		this.classList = classList;
	}
    
	
}
