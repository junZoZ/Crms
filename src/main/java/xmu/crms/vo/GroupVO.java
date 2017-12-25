package xmu.crms.vo;

import java.util.ArrayList;

public class GroupVO {

  private Integer id;
  private String name;
  private IdAndNameVO leader;
  private ArrayList<IdAndNameVO> members;
  private ArrayList<IdAndNameVO> topics;

    public GroupVO() {
    }

    public GroupVO(Integer id, String name, IdAndNameVO leader, ArrayList<IdAndNameVO> members, ArrayList<IdAndNameVO> topics) {
        this.id = id;
        this.name = name;
        this.leader = leader;
        this.members = members;
        this.topics = topics;
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

    public IdAndNameVO getLeader() {
        return leader;
    }

    public void setLeader(IdAndNameVO leader) {
        this.leader = leader;
    }

    public ArrayList<IdAndNameVO> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<IdAndNameVO> members) {
        this.members = members;
    }

    public ArrayList<IdAndNameVO> getTopics() {
        return topics;
    }

    public void setTopics(ArrayList<IdAndNameVO> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "GroupVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", leader=" + leader +
                ", members=" + members +
                ", topics=" + topics +
                '}';
    }
}
