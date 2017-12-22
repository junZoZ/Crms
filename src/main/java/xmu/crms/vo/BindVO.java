package xmu.crms.vo;

public class BindVO {
    String name;
    SchoolVO school;
    String gender;
    String number;
    String email;

    public BindVO() {
    }

    public BindVO(String name, SchoolVO school, String gender, String number, String email) {
        this.name = name;
        this.school = school;
        this.gender = gender;
        this.number = number;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "BindVO{" +
                "name='" + name + '\'' +
                ", school=" + school +
                ", gender='" + gender + '\'' +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
