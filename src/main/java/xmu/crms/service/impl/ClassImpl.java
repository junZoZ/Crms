package xmu.crms.service.impl;

import org.springframework.stereotype.Service;
import xmu.crms.entity.ClassInfo;
import xmu.crms.entity.Location;
import xmu.crms.exception.*;
import xmu.crms.service.ClassService;

import java.math.BigInteger;
import java.util.List;

@Service
public class ClassImpl implements ClassService{
    @Override
    public void deleteClassSelectionByClassId(BigInteger classId) {

    }

    @Override
    public List<ClassInfo> listClassByName(String courseName, String teacherName) throws UserNotFoundException, CourseNotFoundException {
        return null;
    }

    @Override
    public List<ClassInfo> listClassByCourseId(BigInteger courseId) throws CourseNotFoundException {
        return null;
    }

    @Override
    public ClassInfo getClassByClassId(BigInteger classId) throws ClassesNotFoundException {
        return null;
    }

    @Override
    public void updateClassByClassId(BigInteger classId, ClassInfo newClass) throws ClassesNotFoundException {

    }

    @Override
    public void deleteClassByClassId(BigInteger classId) throws ClassesNotFoundException {

    }

    @Override
    public Integer insertCourseSelectionById(BigInteger userId, BigInteger classId) throws UserNotFoundException, ClassesNotFoundException {
        return null;
    }

    @Override
    public void deleteCourseSelectionById(BigInteger userId, BigInteger classId) throws UserNotFoundException, ClassesNotFoundException {

    }

    @Override
    public Location getCallStatusById(BigInteger classId, BigInteger seminarId) throws SeminarNotFoundException {
        return null;
    }

    @Override
    public BigInteger insertClassById(BigInteger courseId, ClassInfo classInfo) throws CourseNotFoundException {
        return null;
    }

    @Override
    public void deleteClassByCourseId(BigInteger courseId) throws CourseNotFoundException {

    }

    @Override
    public void deleteScoreRuleById(BigInteger classId) throws ClassesNotFoundException {

    }

    @Override
    public ClassInfo getScoreRule(BigInteger classId) throws ClassesNotFoundException {
        return null;
    }

    @Override
    public BigInteger insertScoreRule(BigInteger classId, ClassInfo proportions) throws InvalidOperationException, ClassesNotFoundException {
        return null;
    }

    @Override
    public void updateScoreRule(BigInteger classId, ClassInfo proportions) throws InvalidOperationException, ClassesNotFoundException {

    }

    @Override
    public BigInteger CallInRollById(Location location) throws SeminarNotFoundException, ClassesNotFoundException {
        return null;
    }

    @Override
    public List<ClassInfo> listClassByUserId(BigInteger userId) throws IllegalArgumentException, ClassesNotFoundException {
        return null;
    }
}
