package xmu.crms.view;

import org.springframework.beans.factory.annotation.Autowired;
import xmu.crms.entity.ClassInfo;
import xmu.crms.entity.Course;
import xmu.crms.entity.Seminar;
import xmu.crms.entity.SeminarGroup;
import xmu.crms.exception.CourseNotFoundException;
import xmu.crms.exception.GroupNotFoundException;
import xmu.crms.service.*;
import xmu.crms.vo.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private ClassService classService;

    @Autowired
    private SeminarService seminarService;

    @Autowired
    private  SeminarGroupService  seminarGroupService;

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/course",method = RequestMethod.GET)
    public   List<CourseVO> getCourseList()  {
//        需要用到jwt
//        返回这个错误不是很有道理
        BigInteger userId = new BigInteger("1");
        List<Course> courseList = null;
        try {
            courseList = courseService.listCourseByUserId(userId);
            List<CourseVO> courseVOList = new ArrayList<>();
            for (Course item:courseList){
                //获取每个course的班级数
                Integer classNumber = classService.listClassByCourseId(item.getId()).size();
                courseVOList.add(new CourseVO(item.getId(),item.getName(),classNumber,item.getStartDate(),item.getEndDate());
            }
            return courseVOList;
        } catch (CourseNotFoundException e) {}
       return  null;
    }

    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value="/course",method = RequestMethod.POST)
    public Integer NewCourse(@RequestBody CourseVO newCourseVO)
    {
//        需要用到jwt
        BigInteger userId = new BigInteger("1");
        Course course = new Course();
        course.setName(newCourseVO.getName());
        course.setDescription(newCourseVO.getDescription());
        course.setStartDate(newCourseVO.getStartTime());
        course.setEndDate(newCourseVO.getEndTime());
        course.setPresentationPercentage(newCourseVO.getProportion().getPresentation());
        course.setReportPercentage(newCourseVO.getProportion().getReport());
        course.setFivePointPercentage(newCourseVO.getProportion().getC());
        course.setFourPointPercentage(newCourseVO.getProportion().getB());
        course.setThreePointPercentage(newCourseVO.getProportion().getA());
        BigInteger courseId  = courseService.insertCourseByUserId(userId,course);
        return courseId.intValue();
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/course/{courseId}",method = RequestMethod.GET)
    @ResponseBody
    public CourseVO CourseDescription(@PathVariable("courseId") Integer courseId)
            throws CourseNotFoundException {

        Course course = courseService.getCourseByCourseId(new BigInteger(courseId.toString()));
        CourseVO courseVO = new CourseVO(course.getId(),course.getName(),
                course.getDescription(),course.getTeacher().getName(),course.getTeacher().getEmail());
        return courseVO;
    }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/course/{courseId}",method = RequestMethod.PUT)
    public void NewCourse1(@PathVariable("courseId") Integer courseId,@RequestBody CourseVO courseDetail) throws CourseNotFoundException
    {
        Course course = courseService.getCourseByCourseId(new BigInteger(courseId.toString()));
        course.setName(courseDetail.getName());
        course.setDescription(courseDetail.getDescription());
        course.setStartDate(courseDetail.getStartTime());
        course.setEndDate(courseDetail.getEndTime());
        course.setPresentationPercentage(courseDetail.getProportion().getPresentation());
        course.setReportPercentage(courseDetail.getProportion().getReport());
        course.setFivePointPercentage(courseDetail.getProportion().getC());
        course.setFourPointPercentage(courseDetail.getProportion().getB());
        course.setThreePointPercentage(courseDetail.getProportion().getA());
        courseService.updateCourseByCourseId(course.getId(),course);
    }


    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/course/{courseId}",method = RequestMethod.DELETE)
    public   void registerSecond(@PathVariable("courseId") Integer courseId)
    {
        courseService.deleteCourseByCourseId(new BigInteger(courseId.toString()));
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/course/{courseId}/class",method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<IdAndNameVO> Classes(@PathVariable("courseId") Integer courseId) throws CourseNotFoundException{
        List<ClassInfo> classInfo = classService.listClassByCourseId(new BigInteger(courseId.toString()));
        ArrayList<IdAndNameVO> idAndNameVOArrayList = new ArrayList<>();
        for(ClassInfo item :classInfo){
            idAndNameVOArrayList.add(new IdAndNameVO(item.getId(),item.getName()));
        }
        return idAndNameVOArrayList;
    }

    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value = "/course/{courseId}/class",method = RequestMethod.POST)
    @ResponseBody
    public Integer NewClass(@PathVariable("courseId") Integer courseId,@RequestBody ClassVO newClass) throws CourseNotFoundException {

        ClassInfo classInfo=new ClassInfo();
        Course course=courseService.getCourseByCourseId(new BigInteger(courseId.toString()));
        classInfo.setCourse(course);
        classInfo.setName(newClass.getName());
        classInfo.setDescription(newClass.getSite());
        classInfo.setClassTime(newClass.getTime());
        classInfo.setReportPercentage(newClass.getProportion().getReport());
        classInfo.setPresentationPercentage(newClass.getProportion().getPresentation());
        classInfo.setThreePointPercentage(newClass.getProportion().getC());
        classInfo.setFourPointPercentage(newClass.getProportion().getB());
        classInfo.setFivePointPercentage(newClass.getProportion().getA());
        BigInteger id=classService.insertClassById(new BigInteger(courseId.toString()),classInfo);
        return id.intValue();
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/course/{courseId}/seminars",method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<SeminarsVO> ListSeminars(@PathVariable("courseId") Integer courseId,@RequestParam(value="embedGrade",required = false) boolean embedGrades) throws CourseNotFoundException{

        BigInteger userId=new BigInteger("233");
        List<Seminar> seminar=seminarService.listSeminarByCourseId(new BigInteger(courseId.toString()));
        ArrayList<SeminarsVO> seminarVO=new ArrayList<SeminarsVO>(16);
        for(Seminar item:seminar)
        {
            SeminarsVO s=new SeminarsVO();
            s.setId(item.getId().intValue());
            s.setName(item.getName());
            s.setDescription(item.getDescription());
            if(item.getFixed())  {
                s.setGroupingMethod("fixed");
            }
            else
            {
                s.setGroupingMethod("random");
            }
            s.setStartTime(item.getStartTime());
            s.setEndTime(item.getEndTime());
            if(embedGrades)
            {
                try {
                    SeminarGroup seminarGroup=seminarGroupService.getSeminarGroupById(userId,item.getId());
                    s.setGrade(seminarGroup.getFinalGrade());
                } catch (GroupNotFoundException e) {
                }
            }
            seminarVO.add(s);
        }
        return seminarVO;
    }

    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value = "/course/{courseId}/seminar",method = RequestMethod.POST)
    @ResponseBody
    public Integer NewSeminar(@PathVariable("courseId") Integer courseId, @RequestBody SeminarsVO newSeminar) throws CourseNotFoundException {
        Seminar seminar=new Seminar();
        Course course=courseService.getCourseByCourseId(new BigInteger(courseId.toString()));
        seminar.setCourse(course);
        seminar.setName(newSeminar.getName());
        seminar.setDescription(newSeminar.getDescription());
        seminar.setStartTime(newSeminar.getStartTime());
        seminar.setEndTime(newSeminar.getEndTime());
        if(newSeminar.getGroupingMethod().equals("fixed"))
        {seminar.setFixed(true);}
        else
        {
            seminar.setFixed(false);
        }
        BigInteger id=seminarService.insertSeminarByCourseId(new BigInteger(courseId.toString()),seminar);
        return id.intValue();
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
    @RequestMapping(value = "/class/{classId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void DeleteClass(@PathVariable("classId") Integer classId) {

    }



}
