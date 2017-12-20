package courseManagement.view;
import courseManagement.dto.*;
import courseManagement.vo.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class CourseController {
    class Example{
        List<CoursesListVO> courses=new ArrayList(16);
        public Example()
        {
            CoursesListVO course1=new CoursesListVO(1001,"OOAD",3,60,"2017-9-1","2018-1-1");
            CoursesListVO course2=new CoursesListVO(1002,"J2EE",1,60,"2017-9-1","2018-1-1");
            CoursesListVO course3=new CoursesListVO(1003,"Python",2,60,"2017-9-1","2018-1-1");
            courses.add(course1);
            courses.add(course2);
            courses.add(course3);
        }
    }
    Example ex=new Example();

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/course",method = RequestMethod.GET)
    public   List<CoursesListVO> registerfirst()
    {
        return ex.courses;
    }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/course/{courseId}",method = RequestMethod.DELETE)
    public   void registerSecond(@PathVariable("courseId") Integer courseId)
    {
        for(CoursesListVO item:ex.courses)
            if(item.getId()==courseId)
            {ex.courses.remove(item); break;  }
    }

    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value="/course",method = RequestMethod.POST)
    public CoursesListVO NewCourse(@RequestBody CourseDTO newCourse)
    {
        CoursesListVO course=new CoursesListVO(1004,newCourse.getName(),0,60,"2017-12-6","2017-12-6");
        ex.courses.add(course);
        return course;
    }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/course/{courseId}",method = RequestMethod.PUT)
    public void NewCourse1(@PathVariable("courseId") Integer courseId,@RequestBody CourseDTO newCourse)
    {
        CoursesListVO course=new CoursesListVO(1004,newCourse.getName(),0,60,"2017-12-6","2017-12-6");


    }


}
