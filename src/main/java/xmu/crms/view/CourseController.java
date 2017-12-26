package xmu.crms.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @Autowired
    private  GradeService  gradeService;

    @Autowired
    private  UserService userService;

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
                courseVOList.add(new CourseVO(item.getId(),item.getName(),classNumber,item.getStartDate(),item.getEndDate()));
            }
            return courseVOList;
        } catch (CourseNotFoundException e) {}
       return  null;
    }

    @JsonIgnoreProperties
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
        course.setPresentationPercentage(newCourseVO.getProportions().getPresentation());
        course.setReportPercentage(newCourseVO.getProportions().getReport());
        course.setFivePointPercentage(newCourseVO.getProportions().getA());
        course.setFourPointPercentage(newCourseVO.getProportions().getB());
        course.setThreePointPercentage(newCourseVO.getProportions().getC());
        BigInteger courseId  = courseService.insertCourseByUserId(userId,course);
        return courseId.intValue();
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/course/{courseId}",method = RequestMethod.GET)
    @ResponseBody
    public CourseVO CourseDescription(@PathVariable("courseId") Integer courseId)
            throws IllegalArgumentException,CourseNotFoundException {
//      courseNotFound报500错误
        Course course = courseService.getCourseByCourseId(new BigInteger(courseId.toString()));
        CourseVO courseVO = new CourseVO(course.getId(),course.getName(),
                course.getDescription(),course.getTeacher().getName(),course.getTeacher().getEmail());
        return courseVO;
    }


    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/course/{courseId}",method = RequestMethod.PUT)
    public void NewCourse1(@PathVariable("courseId") Integer courseId,@RequestBody CourseVO courseDetail)
    {
        Course course = null;
        try {
            course = courseService.getCourseByCourseId(new BigInteger(courseId.toString()));
        } catch (CourseNotFoundException e) {}

        course.setName(courseDetail.getName());
        course.setDescription(courseDetail.getDescription());
        course.setStartDate(courseDetail.getStartTime());
        course.setEndDate(courseDetail.getEndTime());
        course.setPresentationPercentage(courseDetail.getProportions().getPresentation());
        course.setReportPercentage(courseDetail.getProportions().getReport());
        course.setFivePointPercentage(courseDetail.getProportions().getA());
        course.setFourPointPercentage(courseDetail.getProportions().getB());
        course.setThreePointPercentage(courseDetail.getProportions().getC());
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
//    500错误
    public ArrayList<IdAndNameVO> Classes(@PathVariable("courseId") Integer courseId) throws CourseNotFoundException{
        List<ClassInfo> classInfo = classService.listClassByCourseId(new BigInteger(courseId.toString()));
        ArrayList<IdAndNameVO> idAndNameVOArrayList = new ArrayList<>();
        for(ClassInfo item :classInfo){
            idAndNameVOArrayList.add(new IdAndNameVO(item.getId(),item.getName()));
        }
        return idAndNameVOArrayList;
    }

    @JsonIgnoreProperties
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
        classInfo.setReportPercentage(newClass.getProportions().getReport());
        classInfo.setPresentationPercentage(newClass.getProportions().getPresentation());
        classInfo.setThreePointPercentage(newClass.getProportions().getC());
        classInfo.setFourPointPercentage(newClass.getProportions().getB());
        classInfo.setFivePointPercentage(newClass.getProportions().getA());
        BigInteger id=classService.insertClassById(new BigInteger(courseId.toString()),classInfo);
        return id.intValue();
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/course/{courseId}/seminar",method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<SeminarVO> ListSeminars(@PathVariable("courseId") Integer courseId,@RequestParam(value="embedGrade",required = false) boolean embedGrades) throws CourseNotFoundException{
//        和小程序有交集
//        需要用到jwt
//        有一个属性用不到
        BigInteger userId=new BigInteger("233");
        List<Seminar> seminar = seminarService.listSeminarByCourseId(new BigInteger(courseId.toString()));
        ArrayList<SeminarVO> seminarVO=new ArrayList<SeminarVO>(16);
        for(Seminar item:seminar)
        {
            SeminarVO s=new SeminarVO();
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
    public Integer NewSeminar(@PathVariable("courseId") Integer courseId, @RequestBody SeminarVO newSeminar) throws CourseNotFoundException {
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

//小程序的url: get /course/{courseID}/seminar/current

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/course/{courseID}/grade",method = RequestMethod.GET)
    public   ArrayList<CourseGradeVO> courseGrade(@PathVariable("courseID") Integer courseId) throws IllegalArgumentException{
//        需要用到jwt
        BigInteger userId = new BigInteger("3");

        List<SeminarGroup> courseGradeList = gradeService.listSeminarGradeByCourseId(userId,new BigInteger(courseId.toString()));
        ArrayList<CourseGradeVO> courseGradeVOArrayList = new ArrayList<CourseGradeVO>();
        for(SeminarGroup item:courseGradeList){
           CourseGradeVO courseGradeVO = new CourseGradeVO();
           courseGradeVO.setSeminarName(item.getSeminar().getName());
           courseGradeVO.setGroupName(item.getLeader().getName()+"的小组");
           courseGradeVO.setLeaderName(item.getLeader().getName());
           courseGradeVO.setPresentationGrade(item.getPresentationGrade());
           courseGradeVO.setReportGrade(item.getReportGrade());
           courseGradeVO.setGrade(item.getFinalGrade());
           courseGradeVOArrayList.add(courseGradeVO);
        }

        return courseGradeVOArrayList;
    }




}
