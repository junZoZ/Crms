package xmu.crms.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/student")
public class StudentPageController {

    @RequestMapping(value="/StudentBindPage")
    public String studentBindPage() { return "student/StudentBindPage"; }

    @RequestMapping(value="/StudentChooseCoursePage")
    public String studentChooseCoursePage() { return"student/StudentChooseCoursePage"; }

    @RequestMapping(value="/StudentCourseHome")
    public String studentCourseHome() { return"student/StudentCourseHome"; }

    @RequestMapping(value="/StudentCourseInformation")
    public String studentCourseInformation() { return"student/StudentCourseInformation"; }

    @RequestMapping(value="/StudentHomePage")
    public String studentHomePage() { return"student/StudentHomePage"; }

    @RequestMapping(value="/StudentModifyGroupPage")
    public String studentModifyGroupPage() { return"student/StudentModifyGroupPage"; }

    @RequestMapping(value="/StudentSeminarPage(fixed)")
    public String studentSeminarPageFixed() { return"student/StudentSeminarPage(fixed)"; }

    @RequestMapping(value="/StudentSeminarPage")
    public String studentSeminarPage() { return"student/StudentSeminarPage"; }


    @RequestMapping(value="/StudentViewGradePage")
    public String studentViewGradePage() { return"student/StudentViewGradePage"; }

    @RequestMapping(value="/StudentViewGroupPage")
    public String studentViewGroupPage() { return"student/StudentViewGroupPage"; }

    @RequestMapping(value="/StudentViewTopicPage(fixed)")
    public String studentViewTopicPageFixed() { return"student/StudentViewTopicPage(fixed)"; }

    @RequestMapping(value="/StudentViewTopicPage(random)")
    public String studentViewTopicPageRandom() { return"student/StudentViewTopicPage(random)"; }


}
