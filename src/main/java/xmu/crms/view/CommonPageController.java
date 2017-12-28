package xmu.crms.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/common")
public class CommonPageController {

    @RequestMapping(value="/AccountLoginPage")
    public String studentBindPage() { return "common/AccountLoginPage"; }

    @RequestMapping(value="/RegisterPage")
    public String studentChooseCoursePage() { return"common/RegisterPage"; }

    @RequestMapping(value="/WechatLoginPage")
    public String studentCourseHome() { return"common/WechatLoginPage"; }
}
