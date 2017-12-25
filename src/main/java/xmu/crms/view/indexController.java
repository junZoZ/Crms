package xmu.crms.view;

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
