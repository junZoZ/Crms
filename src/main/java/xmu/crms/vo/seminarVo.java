package xmu.crms.vo;

import java.util.ArrayList;

public class seminarVo {
    Integer id;
    ArrayList<Integer>  groupid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Integer> getGroupid() {
        return groupid;
    }

    public void setGroupid(ArrayList<Integer> groupid) {
        this.groupid = groupid;
    }

    public seminarVo(Integer id, ArrayList<Integer> groupid) {
        this.id = id;
        this.groupid = groupid;
    }
}
