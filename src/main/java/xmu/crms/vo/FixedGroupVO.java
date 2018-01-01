package xmu.crms.vo;

import java.util.ArrayList;

public class FixedGroupVO {
    Integer id;
    UserVO leader;
    ArrayList<UserVO> user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserVO getLeader() {
        return leader;
    }

    public void setLeader(UserVO leader) {
        this.leader = leader;
    }

    public ArrayList<UserVO> getUser() {
        return user;
    }

    public void setUser(ArrayList<UserVO> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "FixedGroupVO{" +
                "leader=" + leader +
                ", user=" + user +
                '}';
    }
}
