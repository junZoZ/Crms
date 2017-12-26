package xmu.crms.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/student")
public class StudentPageController {

    @RequestMapping(value="/StudentBindPage")
    public String studentBindPage() { ;return"StudentBindPage"; }

    @RequestMapping(value="/StudentChooseCoursePage")
    public String studentChooseCoursePage() { ;return"StudentChooseCoursePage"; }

    @RequestMapping(value="/StudentCourseHome")
    public String studentCourseHome() { ;return"StudentCourseHome"; }

    @RequestMapping(value="/StudentCourseInformation")
    public String studentCourseInformation() { ;return"StudentCourseInformation"; }

    @RequestMapping(value="/StudentHomePage")
    public String studentHomePage() { ;return"StudentHomePage"; }

    @RequestMapping(value="/StudentModifyGroupPage")
    public String studentModifyGroupPage() { ;return"StudentModifyGroupPage"; }

    @RequestMapping(value="/StudentSeminarPage(fixed)")
    public String studentSeminarPageFixed() { ;return"StudentSeminarPage(fixed)"; }

    @RequestMapping(value="/StudentSeminarPage")
    public String studentSeminarPage() { ;return"StudentSeminarPage"; }


    @RequestMapping(value="/StudentViewGradePage")
    public String studentViewGradePage() { ;return"StudentViewGradePage"; }

    @RequestMapping(value="/StudentViewGroupPage")
    public String studentViewGroupPage() { ;return"StudentViewGroupPage"; }

    @RequestMapping(value="/StudentViewTopicPage(fixed)")
    public String studentViewTopicPageFixed() { ;return"StudentViewTopicPage(fixed)"; }

    @RequestMapping(value="/StudentViewTopicPage(random)")
    public String studentViewTopicPageRandom() { ;return"StudentViewTopicPage(random)"; }


}
