package courseManagement.vo;

import courseManagement.dto.IdAndNameDTO;

import java.util.ArrayList;

public class GroupVO {

  private Integer id;
  private String name;
  private IdAndNameDTO leader;
  private ArrayList<IdAndNameDTO> members;
  private ArrayList<IdAndNameDTO> topics;

    public GroupVO() {
    }

    public GroupVO(Integer id, String name, IdAndNameDTO leader, ArrayList<IdAndNameDTO> members, ArrayList<IdAndNameDTO> topics) {
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

    public IdAndNameDTO getLeader() {
        return leader;
    }

    public void setLeader(IdAndNameDTO leader) {
        this.leader = leader;
    }

    public ArrayList<IdAndNameDTO> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<IdAndNameDTO> members) {
        this.members = members;
    }

    public ArrayList<IdAndNameDTO> getTopics() {
        return topics;
    }

    public void setTopics(ArrayList<IdAndNameDTO> topics) {
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
