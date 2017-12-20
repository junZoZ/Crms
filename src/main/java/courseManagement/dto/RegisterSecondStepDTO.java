package courseManagement.dto;

public class RegisterSecondStepDTO {
    String name;
    String password;
    String school;
    String gender;
    String number;
    String email;
    String type;

    public RegisterSecondStepDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RegisterSecondStepDTO{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", school='" + school + '\'' +
                ", gender='" + gender + '\'' +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
