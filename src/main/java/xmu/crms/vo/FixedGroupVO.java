package xmu.crms.vo;

import java.util.ArrayList;

public class FixedGroupVO {
    UserVO leader;
    ArrayList<UserVO> user;

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
