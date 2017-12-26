package xmu.crms.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/teacher")
public class TeacherPageController {
    @RequestMapping(value="/TeacherBindPage")
    public String teacherBindPage() { ;return"TeacherBindPage"; }

    @RequestMapping(value="/TeacherClassInfo")
    public String teacherClassInfo() { ;return"TeacherClassInfo"; }

    @RequestMapping(value="/TeacherCourseHomePage")
    public String teacherCourseHomePage() { ;return"TeacherCourseHomePage"; }

    @RequestMapping(value="/TeacherCourseInformationPage")
    public String teacherCourseInformationPage() { ;return"TeacherCourseInformationPage"; }

    @RequestMapping(value="/TeacherCreateClass")
    public String teacherCreateClass() { ;return"TeacherCreateClass"; }

    @RequestMapping(value="/TeacherCreateCoursePage")
    public String teacherCreateCoursePage() { ;return"TeacherCreateCoursePage"; }

    @RequestMapping(value="/TeacherCreateSchool")
    public String teacherCreateSchool() { ;return"TeacherCreateSchool"; }

    @RequestMapping(value="/TeacherCreateSeminar")
    public String teacherCreateSeminar() { ;return"TeacherCreateSeminar"; }

    @RequestMapping(value="/TeacherCreateTopic")
    public String teacherCreateTopic() { ;return"TeacherCreateTopic"; }

    @RequestMapping(value="/TeacherHomePage")
    public String teacherHomePage() { ;return"TeacherHomePage"; }

    @RequestMapping(value="/TeacherScoreHome")
    public String teacherScoreHome() { ;return"TeacherScoreHome"; }

    @RequestMapping(value="/TeacherScoreReprotPage")
    public String teacherScoreReportPage() { ;return"TeacherScoreReportPage"; }

    @RequestMapping(value="/TeacherSeminarInfo")
    public String teacherSeminarInfo() { ;return"TeacherSeminarInfo"; }

    @RequestMapping(value="/TeacherTopicCheck(fixed)")
    public String teacherTopicCheckfixed() { return"TeacherTopicCheck(fixed)"; }

    @RequestMapping(value="/TeacherTopicCheck")
    public String teacherTopicCheck() { ;return"TeacherTopicCheck"; }

    @RequestMapping(value="/TeacherUpdateClass")
    public String teacherUpdateClass() { ;return"TeacherUpdateClass"; }

    @RequestMapping(value="/TeacherUpdateSeminar")
    public String teacherUpdateSeminarPage() { ;return"TeacherUpdateSeminar"; }

    @RequestMapping(value="/TeacherUpdateTopic")
    public String teacherUpdateTopic() { ;return"TeacherUpdateTopic"; }
}
