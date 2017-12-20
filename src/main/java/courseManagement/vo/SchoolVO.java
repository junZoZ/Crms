package courseManagement.vo;

public class SchoolVO {
    Integer id;
    String name;
    String province;
    String city;

    public SchoolVO() {
    }

    public SchoolVO(Integer id, String name, String province, String city) {
        this.id = id;
        this.name = name;
        this.province = province;
        this.city = city;
    }

    public SchoolVO(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "SchoolVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
