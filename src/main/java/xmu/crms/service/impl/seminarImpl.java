package xmu.crms.service.impl;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import xmu.crms.entity.Seminar;
import xmu.crms.exception.CourseNotFoundException;
import xmu.crms.exception.SeminarNotFoundException;
import xmu.crms.service.SeminarService;

import java.math.BigInteger;
import java.util.List;

@Service
public class seminarImpl implements SeminarService{

    @Override
    public List<Seminar> listSeminarByCourseId(BigInteger courseId) throws IllegalArgumentException, CourseNotFoundException {
        return null;
    }

    @Override
    public Boolean deleteSeminarByCourseId(BigInteger courseId) throws IllegalArgumentException, CourseNotFoundException {
        return null;
    }

    @Override
    public Seminar getSeminarBySeminarId(BigInteger seminarId) throws IllegalArgumentException, SeminarNotFoundException {
        return null;
    }

    @Override
    public Boolean updateSeminarBySeminarId(BigInteger seminarId, Seminar seminar) throws IllegalArgumentException, SeminarNotFoundException {
        return null;
    }

    @Override
    public Boolean deleteSeminarBySeminarId(BigInteger seminarId) throws IllegalArgumentException, SeminarNotFoundException {
        return null;
    }

    @Override
    public BigInteger insertSeminarByCourseId(BigInteger courseId, Seminar seminar) throws IllegalArgumentException, CourseNotFoundException {
        return null;
    }
}
