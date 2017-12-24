package xmu.crms.service.impl;

import org.springframework.stereotype.Service;
import xmu.crms.entity.ClassInfo;
import xmu.crms.entity.Course;
import xmu.crms.exception.ClassesNotFoundException;
import xmu.crms.exception.CourseNotFoundException;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.service.CourseService;

import java.math.BigInteger;
import java.util.List;

@Service
public class CourseImpl implements CourseService{
    @Override
    public List<Course> listCourseByUserId(BigInteger userId) throws IllegalArgumentException, CourseNotFoundException {
        return null;
    }

    @Override
    public BigInteger insertCourseByUserId(BigInteger userId, Course course) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Course getCourseByCourseId(BigInteger courseId) throws IllegalArgumentException, CourseNotFoundException {
        return null;
    }

    @Override
    public void updateCourseByCourseId(BigInteger courseId, Course course) {

    }

    @Override
    public void deleteCourseByCourseId(BigInteger courseId) throws IllegalArgumentException {

    }

    @Override
    public List<Course> listCourseByCourseName(String courseName) {
        return null;
    }

    @Override
    public List<ClassInfo> listClassByCourseName(String courseName) throws CourseNotFoundException {
        return null;
    }

    @Override
    public List<ClassInfo> listClassByTeacherName(String teacherName) throws UserNotFoundException, ClassesNotFoundException {
        return null;
    }
}
