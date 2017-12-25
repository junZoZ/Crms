package xmu.crms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.crms.entity.ClassInfo;
import xmu.crms.entity.Course;
import xmu.crms.entity.User;
import xmu.crms.exception.ClassesNotFoundException;
import xmu.crms.exception.CourseNotFoundException;
import xmu.crms.exception.InfoIllegalException;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.mapper.CourseMapper;
import xmu.crms.service.ClassService;
import xmu.crms.service.CourseService;
import xmu.crms.service.SeminarService;
import xmu.crms.service.UserService;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhoujian
 * @time  2017/12/24
 */

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ClassService classService;
    @Autowired
    private SeminarService seminarService;
    @Autowired
    private UserService userService;
    @Override
    public List<Course> listCourseByUserId(BigInteger userId) throws IllegalArgumentException, CourseNotFoundException {
        List<Course> courses=courseMapper.listCourseByUserId(userId);
        if(courses.isEmpty()){
            throw new CourseNotFoundException("course cannot be founded with userId :"+String.valueOf(userId));
        }
        return courses;
    }

    /**
     *
     * @param userId 用户Id
     * @param course 课程信息
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public BigInteger insertCourseByUserId(BigInteger userId, Course course) throws IllegalArgumentException {
        courseMapper.insertCourseByUserId(userId,course);
        return course.getId();
    }

    @Override
    public Course getCourseByCourseId(BigInteger courseId) throws IllegalArgumentException, CourseNotFoundException {
        Course course=courseMapper.getCourseByCourseId(courseId);
        if(course==null){
            throw new CourseNotFoundException("course cannot be founded with id :"+String.valueOf(courseId));
        }
        return course;
    }

    @Override
    public void updateCourseByCourseId(BigInteger courseId, Course course) {
        courseMapper.updateCourseByCourseId(courseId,course);
    }

    @Override
    public void deleteCourseByCourseId(BigInteger courseId) throws IllegalArgumentException {
        try {
            seminarService.deleteSeminarByCourseId(courseId);
            classService.deleteClassByCourseId(courseId);
        }catch(CourseNotFoundException e){
            //函数上没丢，这里无法再丢出去
        }
        courseMapper.deleteCourseByCourseId(courseId);

    }

    @Override
    public List<Course> listCourseByCourseName(String courseName)  {
        return courseMapper.listCourseByCourseName(courseName);
    }

    @Override
    public List<ClassInfo> listClassByCourseName(String courseName) throws  CourseNotFoundException {
        List<Course> courses=new LinkedList<Course>();
        List<ClassInfo> classes=new LinkedList<ClassInfo>();
        courses=courseMapper.listCourseByCourseName(courseName);
        if(courses.isEmpty()){
            throw new CourseNotFoundException("无法找到名为"+courseName+"的课程");
        }
        for(Course each:courses)
        {
            classes.addAll(classService.listClassByCourseId(each.getId()));
        }
        return classes;
    }

    @Override
    public List<ClassInfo> listClassByTeacherName(String teacherName) throws UserNotFoundException, ClassesNotFoundException {
        List<User> users=userService.listUserByUserName(teacherName);
        List<Course> courses=new LinkedList<Course>();
        List<ClassInfo> classInfo=new LinkedList<ClassInfo>();
        if(users.isEmpty()){
            throw new UserNotFoundException("not found");
        }
        for(User each:users){
            try{
                courses.addAll(listCourseByUserId(each.getId()));
            }catch(CourseNotFoundException e)
            {
                throw new ClassesNotFoundException("not found");
            }
        }
        for(Course each:courses){
            try {
                classInfo.addAll(classService.listClassByCourseId(each.getId()));
            }catch(CourseNotFoundException e){
                throw new ClassesNotFoundException("not found");
            }
        }
        if(classInfo.isEmpty()){
            throw new ClassesNotFoundException("not found");
        }
        return classInfo;
    }

    @Override
    public List<ClassInfo> listClassByName(String courseName, String teacherName) throws
            UserNotFoundException, CourseNotFoundException{
        //user是否存在
        List<User> users=userService.listUserByUserName(teacherName);
        if(users.isEmpty()){
            throw new UserNotFoundException("user not found");
        }
        List<ClassInfo> classes=new LinkedList<ClassInfo>();
        List<ClassInfo> classesByCourseName=listClassByCourseName(courseName);
        List<ClassInfo> classesByteacherName;
        try {
             classesByteacherName = listClassByTeacherName(teacherName);
        }catch(ClassesNotFoundException e){
            throw new CourseNotFoundException("course not found");
        }
        if(classesByCourseName.isEmpty()||classesByteacherName.isEmpty()) {
            throw new CourseNotFoundException("course not found");
        }
        //id相等则符合两个条件
        for(ClassInfo each:classesByCourseName){
            for(ClassInfo every:classesByteacherName){
                if(each.getId().equals(every.getId())) {
                    classes.add(each);
                }
            }
        }
        return classes;
    }

}
