package xmu.crms.vo;

import java.util.ArrayList;

public class fixedgroupVo {
    Student leader;
    ArrayList<Student> member;

    public fixedgroupVo() {
    }

    public fixedgroupVo(Student leader, ArrayList<Student> member) {
        this.leader = leader;
        this.member = member;
    }

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public ArrayList<Student> getMember() {
        return member;
    }

    public void setMember(ArrayList<Student> member) {
        this.member = member;
    }
}
