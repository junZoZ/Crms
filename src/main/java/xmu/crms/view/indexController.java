package xmu.crms.view;

import xmu.crms.dto.*;
import xmu.crms.vo.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
public class indexController {

    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value="/signin",method = RequestMethod.POST)
    @ResponseBody
    public UserVO index(@RequestBody UserDTO u)
    {
        UserVO user;
        if(u.getPhone().equals("123"))
        {
            user=new UserVO(3486,"李四","student","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjaWQiOiJPQTAwMDEiLCJpYXQiOjE0ODI2NTcyODQyMjF9.TeJpy936w610Vrrm+c3+RXouCA9k1AX0Bk8qURkYkdo=");
        }
        else
        {
           user=new UserVO(3486,"张三","teacher","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjaWQiOiJPQTAwMDEiLCJpYXQiOjE0ODI2NTcyODQyMjF9.TeJpy936w610Vrrm+c3+RXouCA9k1AX0Bk8qURkYkdo=");
        }
        System.out.print(user);
        return user;
    }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/me",method = RequestMethod.PUT)
    @ResponseBody
    public void registerFirst(@RequestBody  UserVO user)
    {

    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/me",method = RequestMethod.GET)
    @ResponseBody
    public UserVO homepage()
    {
        SchoolVO school=new SchoolVO(123,"厦门大学");
        UserVO user=new UserVO(3486,"XXX","XXXX","xxxxxx","xxxxxx","xxxxxx","male","xxxx","xxxxxx",school);
        return user;
    }


    @RequestMapping(value="/me/modify/Student",method=GET)
    public String studentInformationModify(Model model2) {
        SchoolVO school=new SchoolVO(123,"厦门大学");
        UserVO studentInformationVO=new UserVO(3486,"XXX","XXXX","xxxxxx","xxxxxx","xxxxxx","male","xxxxxx","/images/link.jpg",school);
        model2.addAttribute(studentInformationVO);
        return"StudentInformationModify";
    }

    @RequestMapping(value="/me/modify/Student",method=POST)
    public String studentInformationModify(@RequestPart("profilePicture") MultipartFile profilePicture, Model model1) throws IOException {
        SchoolVO school=new SchoolVO(123,"厦门大学");
        UserVO studentInformationVO=new UserVO(3486,"XXX","XXXX","xxxxxx","xxxxxx","xxxxxx","male","xxxxxx","/images/link.jpg",school);
        model1.addAttribute(studentInformationVO);
        if	(null != studentInformationVO) {
            profilePicture.transferTo(new File("C:\\Users\\"+studentInformationVO.getId()+".jpg"));
            return "StudentInformationModify";
        }else {
            return "StudentInformationModify";
        }
    }

    @RequestMapping(value="/me/modify/Teacher",method=GET)
    public String teacherInformationModify(Model model3) {
        SchoolVO school=new SchoolVO(123,"厦门大学");
        UserVO teacherInformationVO=new UserVO(3486,"XXX","XXXX","xxxxxx","xxxxxx","xxxxxx","male","xxxxxx","/images/link.jpg",school);
        model3.addAttribute(teacherInformationVO);
        return"TeacherInformationModify";
    }

    @RequestMapping(value="/me/modify/Teacher",method=POST)
    public String teacherInformationModify(@RequestPart("profilePicture") MultipartFile profilePicture, Model model4) throws IOException {
        SchoolVO school=new SchoolVO(123,"厦门大学");
        UserVO teacherInformationVO=new UserVO(3486,"XXX","XXXX","xxxxxx","xxxxxx","xxxxxx","male","xxxxxx","/images/link.jpg",school);
        model4.addAttribute(teacherInformationVO);
        if	(null != teacherInformationVO) {
            profilePicture.transferTo(new File("C:\\Users\\"+teacherInformationVO.getId()+".jpg"));
            return "TeacherInformationModify";
        }else {
            return "TeacherInformationModify";
        }
    }

}
