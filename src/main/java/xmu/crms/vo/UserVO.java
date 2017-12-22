package xmu.crms.vo;

public class UserVO {
    Integer id;
    String name;
    String type;
    String number;
    String phone;
    String email;
    String gender;
    String title;
    String avatar;
    SchoolVO school;
    String jwt ;

    public UserVO() {
    }

    public UserVO(Integer id, String name, String type, String jwt) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.jwt = jwt;
    }

    public UserVO(Integer id, String name, String type, String number, String phone, String email, String gender, String title, String avatar, SchoolVO school) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.number = number;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.title = title;
        this.avatar = avatar;
        this.school = school;
    }

    public int getId() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public SchoolVO getSchool() {
        return school;
    }

    public void setSchool(SchoolVO school) {
        this.school = school;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", title='" + title + '\'' +
                ", avatar='" + avatar + '\'' +
                ", school=" + school +
                ", jwt='" + jwt + '\'' +
                '}';
    }
}
