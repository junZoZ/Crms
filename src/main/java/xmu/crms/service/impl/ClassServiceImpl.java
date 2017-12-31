package xmu.crms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.crms.entity.*;
import xmu.crms.exception.*;
import xmu.crms.mapper.ClassMapper;
import xmu.crms.service.ClassService;
import xmu.crms.service.FixGroupService;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author status200
 * @date 2017/12/19
 */
@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private FixGroupService fixGroupService;

    /**
     * 打分比例的总和。
     * 包括345分占比和课程分数报告占比
     */
    private final int percentageTotal = 100;

    @Override
    public void deleteClassSelectionByClassId(BigInteger classId) {
        classMapper.deleteCourseSelectionByClassId(classId);
    }


    public List<ClassInfo> listClassByName(String courseName, String teacherName) throws UserNotFoundException, CourseNotFoundException {

        List<Course> courses;
        List<ClassInfo> classInfoListByCourseName = new ArrayList<>();

        List<User> teachers;
        List<ClassInfo> classInfoListByTeacherName = new ArrayList<>();

        // 仅课程名非空
        if (courseName != null && teacherName == null) {
            courses = classMapper.listCourseByCourseName(courseName);

            if(courses == null) {
                throw new CourseNotFoundException(String.format("Course with name \"%s\" not found.",courseName));
            }

            courses.forEach(e -> classInfoListByCourseName.addAll(classMapper.listClassByCourseId(e.getId())));

            return classInfoListByCourseName;
        }
        // 仅教师名非空
        if (teacherName != null && courseName == null) {
            teachers = classMapper.listUserByUsername(teacherName);

            if(teachers == null) {
                throw new UserNotFoundException(String.format("User with name \"%s\" not found.",teacherName));
            }
            teachers.forEach(e -> classInfoListByTeacherName.addAll(classMapper.listClassByUserId(e.getId())));

            return classInfoListByTeacherName;
        }


        // 两个条件均非空
        if (courseName != null) {

            List<ClassInfo> intersectClasses = new ArrayList<>();

            classInfoListByCourseName.forEach(e->{

                for(ClassInfo e1:classInfoListByTeacherName) {
                    if(e.getId().equals(e1.getId())) {
                        intersectClasses.add(e);
                    }
                }
            });

            return intersectClasses;
        }

        return null;
    }

    @Override
    public List<ClassInfo> listClassByCourseId(BigInteger courseId) throws CourseNotFoundException {

        // 先查询Course是否存在
        if (classMapper.countCourseByCourseId(courseId) <= 0) {
            throw new CourseNotFoundException(String.format("Course with id %d not found.",courseId ));
        }

        return classMapper.listClassByCourseId(courseId);
    }

    @Override
    public ClassInfo getClassByClassId(BigInteger classId) throws ClassesNotFoundException {
        if(classMapper.countClassByClassId(classId) <= 0) {
            throw new ClassesNotFoundException(String.format("Class with id %d not found!", classId));
        }
        return classMapper.getClassByClassId(classId);
    }

    @Override
    public void updateClassByClassId(BigInteger classId, ClassInfo newClass) throws ClassesNotFoundException {
        if(!classMapper.updateClassByClassId(classId, newClass)) {
           throw new ClassesNotFoundException(String.format("Class with id %d not found",classId));
        }
    }

    @Override
    public void deleteClassByClassId(BigInteger classId) throws ClassesNotFoundException {

        fixGroupService.deleteFixGroupByClassId(classId);
        deleteClassSelectionByClassId(classId);
        if(!classMapper.deleteClassById(classId)) {
            throw new ClassesNotFoundException(String.format("Class with id %d not found!",classId));
        }
    }

    @Override
    public BigInteger insertCourseSelectionById(BigInteger userId, BigInteger classId) throws ClassesNotFoundException, UserNotFoundException {

        if(classMapper.countClassByClassId(classId) <= 0) {
            throw new ClassesNotFoundException(String.format("Class with id %d not found!", classId));
        }

        if(classMapper.countUserByUserId(userId) <=0) {
            throw new UserNotFoundException(String.format("User with id %d not found!", userId));
        }
        CourseSelection courseSelection = new CourseSelection();
        User student = new User();
        student.setId(userId);
        courseSelection.setStudent(student);

        ClassInfo classInfo = new ClassInfo();
        classInfo.setId(classId);
        courseSelection.setClassInfo(classInfo);

        classMapper.insertCourseSelectionById(courseSelection);

        return courseSelection.getId();
    }

    @Override
    public void deleteCourseSelectionById(BigInteger userId, BigInteger classId) throws ClassesNotFoundException, UserNotFoundException {

        if(classMapper.countClassByClassId(classId) <= 0) {
            throw new ClassesNotFoundException(String.format("Class with id %d not found!", classId));
        }

        if(classMapper.countUserByUserId(userId) <= 0) {
            throw new UserNotFoundException(String.format("User with id %d not found!", userId));
        }

        classMapper.deleteCourseSelectionByStudentIdAndClassId(userId, classId);
    }

    @Override
    public Location getCallStatusById(BigInteger classId, BigInteger seminarId) throws SeminarNotFoundException {

        if(classMapper.countSeminarById(seminarId) <= 0) {
            throw new SeminarNotFoundException(String.format("Seminar with name %d not found!",seminarId));
        }

        return classMapper.getLocationBySeminarIdAndClassId(seminarId, classId);
    }

    @Override
    public BigInteger insertClassById(BigInteger courseId, ClassInfo classInfo) throws CourseNotFoundException {

        if (classMapper.countCourseByCourseId(courseId) <= 0) {
            throw new CourseNotFoundException(String.format("Course with id %d not found.", courseId));
        }

        Course course = new Course();
        course.setId(courseId);
        classInfo.setCourse(course);
        classMapper.insertClassById(classInfo);
        return classInfo.getId();
    }


    @Override
    public void deleteClassByCourseId(BigInteger courseId) throws CourseNotFoundException {

        if (classMapper.countCourseByCourseId(courseId) <= 0) {
            throw new CourseNotFoundException(String.format("Course with id %d not found.",courseId ));
        }
        // 获取该课程下的所有班级
        List<ClassInfo> classInfoList = classMapper.listClassByCourseId(courseId);

        for(ClassInfo item:classInfoList){
            try {
                deleteClassByClassId(item.getId());
            } catch (ClassesNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public BigInteger callInRollById(Location location) throws SeminarNotFoundException, ClassesNotFoundException {

        if(classMapper.countSeminarById(location.getSeminar().getId()) <= 0){
            throw new SeminarNotFoundException(String.format("Seminar with id %d not found!",location.getSeminar().getId()));
        }

        if(classMapper.countClassByClassId(location.getClassInfo().getId()) <=0) {
            throw new ClassesNotFoundException(String.format("Class with id %d not found!", location.getClassInfo().getId()));
        }

        location.setStatus(0);
        classMapper.insertLocation(location);
        return location.getId();
    }

  /*  @Override
    public void endCallRollById(Location location) throws SeminarNotFoundException, ClassesNotFoundException {

        if(classMapper.countSeminarById(location.getSeminar().getId()) <= 0){
            throw new SeminarNotFoundException(String.format("Seminar with id %d not found!",location.getSeminar().getId()));
        }

        if(classMapper.countClassByClassId(location.getClassInfo().getId()) <=0) {
            throw new ClassesNotFoundException(String.format("Class with id %d not found!", location.getClassInfo().getId()));
        }

        classMapper.updateLocationBySeminarIdAndClassId(location);
    }
*/

    @Override
    public List<ClassInfo> listClassByUserId(BigInteger userId) throws IllegalArgumentException, ClassesNotFoundException {

        if(userId.compareTo(new BigInteger("0")) <= 0) {
            throw new IllegalArgumentException(String.format("illegal userId format %d!", userId));
        }

        List<ClassInfo> classes = classMapper.listClassByUserId(userId);
        if(classes.size() <= 0) {
            throw new ClassesNotFoundException(String.format("no classes for userId %d!", userId));
        }

        return classes;
    }
}
