package xmu.crms.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/teacher")
public class TeacherPageController {
    @RequestMapping(value="/TeacherBindPage")
    public String teacherBindPage() { return "teacher/TeacherBindPage"; }

    @RequestMapping(value="/TeacherClassInfo")
    public String teacherClassInfo() { return "teacher/TeacherClassInfo"; }

    @RequestMapping(value="/TeacherCourseHomePage")
    public String teacherCourseHomePage() { return "teacher/TeacherCourseHomePage"; }

    @RequestMapping(value="/TeacherCourseInformation")
    public String teacherCourseInformationPage() { return "teacher/TeacherCourseInformation"; }

    @RequestMapping(value="/TeacherCreateClass")
    public String teacherCreateClass() { return "teacher/TeacherCreateClass"; }

    @RequestMapping(value="/TeacherCreateCoursePage")
    public String teacherCreateCoursePage() { return "teacher/TeacherCreateCoursePage"; }

    @RequestMapping(value="/TeacherCreateSchool")
    public String teacherCreateSchool() { return "teacher/TeacherCreateSchool"; }

    @RequestMapping(value="/TeacherCreateSeminar")
    public String teacherCreateSeminar() { return "teacher/TeacherCreateSeminar"; }

    @RequestMapping(value="/TeacherCreateTopic")
    public String teacherCreateTopic() { return "teacher/TeacherCreateTopic"; }

    @RequestMapping(value="/TeacherHomePage")
    public String teacherHomePage() { return "teacher/TeacherHomePage"; }

    @RequestMapping(value="/TeacherScoreHome")
    public String teacherScoreHome() { return "teacher/TeacherScoreHome"; }

    @RequestMapping(value="/TeacherScoreReprotPage")
    public String teacherScoreReportPage() { return "teacher/TeacherScoreReportPage"; }

    @RequestMapping(value="/TeacherSeminarInfo")
    public String teacherSeminarInfo() { return "teacher/TeacherSeminarInfo"; }

    @RequestMapping(value="/TeacherTopicCheck(after)")
    public String teacherTopicCheckfixed() { return "teacher/TeacherTopicCheck(after)"; }

    @RequestMapping(value="/TeacherTopicCheck")
    public String teacherTopicCheck() { return "teacher/TeacherTopicCheck"; }

    @RequestMapping(value="/TeacherUpdateClass")
    public String teacherUpdateClass() { return "teacher/TeacherUpdateClass"; }

    @RequestMapping(value="/TeacherUpdateSeminar")
    public String teacherUpdateSeminarPage() { return "teacher/TeacherUpdateSeminar"; }

    @RequestMapping(value="/TeacherUpdateTopic")
    public String teacherUpdateTopic() { return "teacher/TeacherUpdateTopic"; }

    @RequestMapping(value="/TeacherCheckRandomGroupTopic")
    public String teacherCheckRandomGroupTopic() { return "teacher/TeacherCheckRandomGroupTopic"; }
}
