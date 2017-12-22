package xmu.crms.vo;

public class TopicVo {
    String name;
    String description;
    Integer groupLimit;
    Integer limit;

    public TopicVo(String name, String description, Integer groupLimit, Integer limit) {
        this.name = name;
        this.description = description;
        this.groupLimit = groupLimit;
        this.limit = limit;
    }

    public TopicVo() {
    }
    public String getDescription() {
        return description;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getGroupLimit() {
        return groupLimit;
    }

    public void setGroupLimit(Integer groupLimit) {
        this.groupLimit = groupLimit;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
