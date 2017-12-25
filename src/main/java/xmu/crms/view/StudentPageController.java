package xmu.crms.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xmu.crms.vo.SchoolVO;
import xmu.crms.vo.UserVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value="/teacher")
public class StudentPageController {
    @RequestMapping(value="/TeacherBindPage")
    public String TeacherBindPage() { ;return"TeacherBindPage"; }

    @RequestMapping(value="/TeacherClassInfo")
    public String TeacherClassInfo() { ;return"TeacherClassInfo"; }

    @RequestMapping(value="/TeacherCourseHomePage")
    public String TeacherCourseHomePage() { ;return"TeacherCourseHomePage"; }

    @RequestMapping(value="/TeacherCourseInformationPage")
    public String TeacherCourseInformationPage() { ;return"TeacherCourseInformationPage"; }

    @RequestMapping(value="/TeacherCreateClass")
    public String TeacherCreateClass() { ;return"TeacherCreateClass"; }

    @RequestMapping(value="/TeacherCreateCoursePage")
    public String TeacherCreateCoursePage() { ;return"TeacherCreateCoursePage"; }



}
