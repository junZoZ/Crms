package xmu.crms.vo;

import java.math.BigInteger;
import java.util.ArrayList;
/**
 * @author  cb
 */
public class FixedGroupLeaderVO {
    BigInteger id;
    BigInteger classId;
    UserVO leader;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getClassId() {
        return classId;
    }

    public void setClassId(BigInteger classId) {
        this.classId = classId;
    }

    public UserVO getLeader() {
        return leader;
    }

    public void setLeader(UserVO leader) {
        this.leader = leader;
    }

    @Override
    public String toString() {
        return "FixedGroupLeaderVO{" +
                "id=" + id +
                ", classId=" + classId +
                ", leader=" + leader +
                '}';
    }
}
