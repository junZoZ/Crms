package xmu.crms.vo;
/**
 * @author  cb
 */
public class TeacherHomeVO {
    String name;
    String number;
    String phone;
    String school;
    String email;
    String title;

    public TeacherHomeVO(String name, String number, String phone, String school, String email, String title) {
        this.name = name;
        this.number = number;
        this.phone = phone;
        this.school = school;
        this.email = email;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
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

    @Override
    public String toString() {
        return "TeacherHomeVO{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", phone='" + phone + '\'' +
                ", school='" + school + '\'' +
                ", email='" + email + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
