package xmu.crms.view;
import xmu.crms.dto.*;
import xmu.crms.vo.*;
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

    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value="/course",method = RequestMethod.POST)
    public CoursesListVO NewCourse(@RequestBody CourseDTO newCourse)
    {
        CoursesListVO course=new CoursesListVO(1004,newCourse.getName(),0,60,"2017-12-6","2017-12-6");
        ex.courses.add(course);
        return course;
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/course/{courseID}/grade",method = RequestMethod.GET)
    public   ArrayList courseGrade(@PathVariable("courseID") Integer courseId)
    {

        ArrayList<CourseGradeVO> courseGradeList = new ArrayList<CourseGradeVO>();

        CourseGradeVO grade1 = new CourseGradeVO("需求分析","3A2","张三",
                3,4,4);
        CourseGradeVO grade2 = new CourseGradeVO("界面原型设计","3A3","张三",
                4,4,4);
        CourseGradeVO grade3 = new CourseGradeVO("需求分析","3A2","张三",
                3,4,4);
        CourseGradeVO grade4 = new CourseGradeVO("界面原型设计","3A3","张三",
                4,4,4);

        courseGradeList.add(grade1);
        courseGradeList.add(grade2);
        courseGradeList.add(grade3);
        courseGradeList.add(grade4);


        return courseGradeList;
    }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/course/{courseId}",method = RequestMethod.PUT)
    public void NewCourse1(@PathVariable("courseId") Integer courseId,@RequestBody CourseDTO newCourse)
    {
        CoursesListVO course=new CoursesListVO(1004,newCourse.getName(),0,60,"2017-12-6","2017-12-6");
    }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/course/{courseId}",method = RequestMethod.DELETE)
    public   void registerSecond(@PathVariable("courseId") Integer courseId)
    {
        for(CoursesListVO item:ex.courses)
            if(item.getId()==courseId)
            {ex.courses.remove(item); break;  }
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/course/{courseId}",method = RequestMethod.GET)
    @ResponseBody
    public CourseDescriptionVO CourseDescription(@PathVariable("courseId") Integer courseId) {

        CourseDescriptionVO courseDescription = new CourseDescriptionVO(12,"OOAD",
                "面向对象过程与设计","邱明","mingqiu@xmu.edu.cn");
        System.out.print("11");
        return courseDescription;
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/course/{courseId}/class",method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<IdAndNameDTO> Classes(@PathVariable("courseId") Integer courseId) {
        return null;
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/course/{courseId}/seminars",method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<IdAndNameDTO> Seminars(@PathVariable("courseId") Integer courseId) {
        return null;
    }

    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value = "/course/{courseId}/class",method = RequestMethod.POST)
    @ResponseBody
    public ClassVO NewClass(@PathVariable("courseId") Integer courseId,@RequestBody ClassDTO newClass) {

        return null;
    }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/class/{classId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void DeleteClass(@PathVariable("classId") Integer classId) {

    }

    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value = "/course/{courseId}/seminar",method = RequestMethod.POST)
    @ResponseBody
    public SeminarAndTopicsVO NewSeminar(@PathVariable("courseId") Integer courseId, @RequestBody SeminarDTO newSeminar) {

        return null;
    }


}
