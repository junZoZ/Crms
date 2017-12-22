package xmu.crms.dto;

public class TopicDTO {

    Integer id;

    public TopicDTO() {
    }

    public TopicDTO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TopicDTO{" +
                "id=" + id +
                '}';
    }
}
