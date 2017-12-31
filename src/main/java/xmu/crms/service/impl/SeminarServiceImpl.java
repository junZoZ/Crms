package xmu.crms.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.crms.dao.SeminarDao;
import xmu.crms.entity.Course;
import xmu.crms.entity.Seminar;
import xmu.crms.entity.SeminarGroup;
import xmu.crms.exception.CourseNotFoundException;
import xmu.crms.exception.InfoIllegalException;
import xmu.crms.exception.SeminarNotFoundException;
import xmu.crms.service.CourseService;
import xmu.crms.service.SeminarGroupService;
import xmu.crms.service.SeminarService;
import xmu.crms.service.TopicService;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yixin
 */
@Service
public class SeminarServiceImpl implements SeminarService {

    @Autowired
    private SeminarDao seminarDao;

    @Autowired
    private CourseService courseService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private SeminarGroupService seminarGroupService;

    @Override
    public List<Seminar> listSeminarByCourseId(BigInteger courseId) throws IllegalArgumentException, CourseNotFoundException {
        if (courseId.intValue() <= 0) {
            throw new IllegalArgumentException();
        }
        courseService.getCourseByCourseId(courseId);
        List<Seminar> seminarList = seminarDao.listSeminarByCourseId(courseId);
        return seminarList;
    }


    @Override
    public void deleteSeminarByCourseId(BigInteger courseId) throws IllegalArgumentException, CourseNotFoundException {
        if (courseId.intValue() <= 0) {
            throw new IllegalArgumentException();
        }
        List<Seminar> seminarList = listSeminarByCourseId(courseId);


        for (Seminar item : seminarList) {
            try {
                deleteSeminarBySeminarId(item.getId());
            } catch (SeminarNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Seminar getSeminarBySeminarId(BigInteger seminarId) throws IllegalArgumentException, SeminarNotFoundException {
        if (seminarId.intValue() <= 0) {
            throw new IllegalArgumentException();
        }
        return seminarDao.getSeminarBySeminarId(seminarId);
    }

    @Override
    public void updateSeminarBySeminarId(BigInteger seminarId, Seminar seminar) throws IllegalArgumentException, SeminarNotFoundException {
        if (seminarId.intValue() <= 0) {
            throw new IllegalArgumentException();
        }
        seminar.setId(seminarId);
        seminarDao.updateSeminarBySeminarId(seminar);
    }

    @Override
    public void deleteSeminarBySeminarId(BigInteger seminarId) throws IllegalArgumentException, SeminarNotFoundException {
        if (seminarId.intValue() <= 0) {
            throw new IllegalArgumentException();
        }

        //删除seminarGroup(级联已实现)
        seminarGroupService.deleteSeminarGroupBySeminarId(seminarId);
        //删除seminarTopic（Topic的级联删除已经实现）
        topicService.deleteTopicBySeminarId(seminarId);
        seminarDao.deleteSeminarBySeminarId(seminarId);
    }

    @Override
    public BigInteger insertSeminarByCourseId(BigInteger courseId, Seminar seminar) throws IllegalArgumentException, CourseNotFoundException {
        if (courseId.intValue() <= 0) {
            throw new IllegalArgumentException();
        }
        Course course = null;
        course = courseService.getCourseByCourseId(courseId);

        course.setId(courseId);
        seminar.setCourse(course);
        return seminarDao.insertSeminarByCourseId(seminar);
    }
}
