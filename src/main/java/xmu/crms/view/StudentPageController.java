package xmu.crms.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


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

    @RequestMapping(value="/TeacherCreateSchool")
    public String TeacherCreateSchool() { ;return"TeacherCreateSchool"; }

    @RequestMapping(value="/TeacherCreateSeminar")
    public String TeacherCreateSeminar() { ;return"TeacherCreateSeminar"; }

    @RequestMapping(value="/TeacherCreateTopic")
    public String TeacherCreateTopic() { ;return"TeacherCreateTopic"; }

    @RequestMapping(value="/TeacherHomePage")
    public String TeacherHomePage() { ;return"TeacherHomePage"; }

    @RequestMapping(value="/TeacherScoreHome")
    public String TeacherScoreHome() { ;return"TeacherScoreHome"; }

    @RequestMapping(value="/TeacherScoreReprotPage")
    public String TeacherScoreReportPage() { ;return"TeacherScoreReportPage"; }

    @RequestMapping(value="/TeacherSeminarInfo")
    public String TeacherSeminarInfo() { ;return"TeacherSeminarInfo"; }

    @RequestMapping(value="/TeacherTopicCheck(fixed)")
    public String TeacherTopicCheckfixed() { return"TeacherTopicCheck(fixed)"; }

    @RequestMapping(value="/TeacherTopicCheck")
    public String TeacherTopicCheck() { ;return"TeacherTopicCheck"; }

    @RequestMapping(value="/TeacherUpdateClass")
    public String UpdateClass() { ;return"UpdateClass"; }

    @RequestMapping(value="/TeacherUpdateSeminar")
    public String UpdateSeminarPage() { ;return"TeacherUpdateSeminar"; }

    @RequestMapping(value="/TeacherUpdateTopic")
    public String TeacherUpdateTopic() { ;return"TeacherUpdateTopic"; }
}
