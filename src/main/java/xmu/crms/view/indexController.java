package xmu.crms.view;

import org.springframework.beans.factory.annotation.Autowired;
import xmu.crms.entity.User;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.service.UserService;
import xmu.crms.vo.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author  zzj
 */
@Controller
public class IndexController {

@Autowired
    UserService userService;

    @RequestMapping(value="/me/modify/Student/{StudentId}",method=GET)
    public String studentInformationModify(Model model2,@PathVariable ("StudentId") Integer studentId) throws UserNotFoundException {
        Integer r1=new Integer(2);
        User u=userService.getUserByUserId(new BigInteger(studentId.toString()));
        UserVO u1=new UserVO();
        u1.setId(u.getId().intValue());
        u1.setName(u.getName());
        if(u.getType()==1) {
            u1.setType("teacher");
            if (u.getTitle() != null) {
                if (u.getTitle() == 1) {
                    u1.setTitle("教授");
                } else {
                    u1.setTitle("非教授");
                }
            }
        }
        else
        { u1.setType("student");}
        u1.setNumber(u.getNumber());
        u1.setPhone(u.getPhone());
        u1.setEmail(u.getEmail());
        if(u.getGender()==1)
        {u1.setGender("女");}
        else
        {u1.setGender("男");}

        if(u.getEducation()==null)
        {
            u1.setEducation("");
        }
        else if(u.getEducation()!=null&&u.getEducation()==0)
        {
            u1.setEducation("本科生");
        }
        else if(u.getEducation()!=null&&u.getEducation()==1)
        {
            u1.setEducation("研究生");
        }
        else if(u.getEducation()!=null&&u.getEducation().equals(r1))
        {
            u1.setEducation("博士");
        }
        if(u.getAvatar()==null)
        {
            u.setAvatar("");
        }
        u1.setAvatar(u.getAvatar());

        SchoolVO schoolVO=new SchoolVO();
        if(u.getSchool()!=null)
        {
            schoolVO.setId(u.getSchool().getId().intValue());
            schoolVO.setName(u.getSchool().getName());
            schoolVO.setCity(u.getSchool().getCity());
            schoolVO.setProvince(u.getSchool().getProvince());
            u1.setSchool(schoolVO);
        }
        model2.addAttribute(u1);
        return"StudentInformationModify";
    }

    @RequestMapping(value="/me/modify/Student",method=GET)
    public String studentInformationModify()  {

        return"/student/StudentHomePage";
    }

    @RequestMapping(value="/me/modify/Teacher",method=GET)
    public String teacherInformationModify()  {

        return"/teacher/TeacherHomePage";
    }

    @RequestMapping(value="/me/modify/Student",method=POST)
    public String studentInformationModify(@RequestPart("profilePicture") MultipartFile profilePicture, UserVO user) throws IOException, UserNotFoundException {

        String r1="研究生";
        String r2="博士";
        User user1= new User();
        user1.setPhone(user.getPhone());
        user1.setNumber(user.getNumber());
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        if(user.getEducation()!=null) {
            if (user.getEducation().equals(r1)) {
                user1.setEducation(1);
            }
            else if (user.getEducation().equals(r2)) {
                user1.setEducation(2);
            }
            else {
                user1.setEducation(0);
            }
        }
        userService.updateUserByUserId(new BigInteger(user.getId().toString()),user1);
        return "/student/StudentHomePage";
           // profilePicture.transferTo(new File("C:\\Users\\"+studentInformationVO.getId()+".jpg"));

    }

    @RequestMapping(value="/me/modify/Teacher/{TeacherId}",method=GET)
    public String teacherInformationModify(Model model3,@PathVariable ("TeacherId") Integer teacherId) throws UserNotFoundException {
        Integer r1=new Integer(2);
        User u=userService.getUserByUserId(new BigInteger(teacherId.toString()));
        UserVO u1=new UserVO();
        u1.setId(u.getId().intValue());
        u1.setName(u.getName());
        if(u.getType()==1)
        {u1.setType("teacher");
        if(u.getTitle()!=null) {
            if (u.getTitle() == 1) {
                u1.setTitle("教授");
            } else {
                u1.setTitle("非教授");
            }
        }
        }
        else
        { u1.setType("student");}
        u1.setNumber(u.getNumber());
        u1.setPhone(u.getPhone());
        u1.setEmail(u.getEmail());
        if(u.getGender()==1)
        {u1.setGender("女");}
        else
        {u1.setGender("男");}

        if(u.getEducation()==null)
        {
            u1.setEducation(" ");
        }
        else if(u.getEducation()!=null&&u.getEducation()==0)
        {
            u1.setEducation("本科生");
        }
        else if(u.getEducation()!=null&&u.getEducation()==1)
        {
            u1.setEducation("研究生");
        }
        else if(u.getEducation()!=null&&u.getEducation().equals(r1))
        {
            u1.setEducation("博士");
        }
        if(u.getAvatar()==null)
        {
            u.setAvatar("");
        }
        u1.setAvatar(u.getAvatar());

        SchoolVO schoolVO=new SchoolVO();
        if(u.getSchool()!=null)
        {
            schoolVO.setId(u.getSchool().getId().intValue());
            schoolVO.setName(u.getSchool().getName());
            schoolVO.setCity(u.getSchool().getCity());
            schoolVO.setProvince(u.getSchool().getProvince());
            u1.setSchool(schoolVO);
        }
        model3.addAttribute(u1);
        return"TeacherInformationModify";
    }

    @RequestMapping(value="/me/modify/Teacher",method=POST)
    public String teacherInformationModify(@RequestPart("profilePicture") MultipartFile profilePicture,UserVO user) throws IOException, UserNotFoundException {
        String r1="研究生";
        String r2="博士";
        User user1= new User();
        user1.setNumber(user.getNumber());
        user1.setPhone(user.getPhone());
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        if(user.getEducation()!=null) {
            if (user.getEducation() .equals(r1)) {
                user1.setEducation(1);
            }
            else if (user.getEducation() .equals(r2)) {
                user1.setEducation(2);
            }
            else {
                user1.setEducation(0);
            }
        }
        userService.updateUserByUserId(new BigInteger(user.getId().toString()),user1);
        return "/teacher/TeacherHomePage";
           // profilePicture.transferTo(new File("C:\\Users\\"+teacherInformationVO.getId()+".jpg"));

    }

}
