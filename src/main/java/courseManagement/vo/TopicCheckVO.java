package courseManagement.vo;

public class TopicCheckVO {
    String name;
    String description;
    int groupLimit;
    int groupStuLim;
    String groupChoose;

    public TopicCheckVO() {
    }

    public TopicCheckVO(String name, String description, int groupLimit, int groupStuLim, String groupChoose) {
        this.name = name;
        this.description = description;
        this.groupLimit = groupLimit;
        this.groupStuLim = groupStuLim;
        this.groupChoose = groupChoose;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGroupLimit() {
        return groupLimit;
    }

    public void setGroupLimit(int groupLimit) {
        this.groupLimit = groupLimit;
    }

    public int getGroupStuLim() {
        return groupStuLim;
    }

    public void setGroupStuLim(int groupStuLim) {
        this.groupStuLim = groupStuLim;
    }

    public String getGroupChoose() {
        return groupChoose;
    }

    public void setGroupChoose(String groupChoose) {
        this.groupChoose = groupChoose;
    }
    @Override
    public String toString() {
        return "TopicCheckVO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", groupLimit=" + groupLimit +
                ", groupStuLim=" + groupStuLim +
                ", groupChoose='" + groupChoose + '\'' +
                '}';
    }
}
