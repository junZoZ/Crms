package xmu.crms.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xmu.crms.entity.Seminar;
import xmu.crms.exception.CourseNotFoundException;
import xmu.crms.exception.SeminarNotFoundException;
import xmu.crms.mapper.SeminarMapper;

import java.math.BigInteger;
import java.util.List;

/**
 * @author  zyx
 */
@Component
public class SeminarDao {
    @Autowired
    private SeminarMapper seminarMapper;


    public List<Seminar> listSeminarByCourseId(BigInteger courseId){
        return seminarMapper.listSeminarByCourseId(courseId);
    }

    public void deleteSeminarByCourseId(BigInteger courseId){
         seminarMapper.deleteSeminarByCourseId(courseId);
    }

    public Seminar getSeminarBySeminarId(BigInteger seminarId)throws SeminarNotFoundException{
        Seminar seminar = seminarMapper.getSeminarBySeminarId(seminarId);
        if(seminar == null){
            throw new SeminarNotFoundException();
        }
        return  seminar;
    }


    public void updateSeminarBySeminarId( Seminar seminar)throws SeminarNotFoundException{
        Integer result = seminarMapper.updateSeminarBySeminarId(seminar);
        if(result == 0) {
            throw new SeminarNotFoundException();
        }
    }

    public void deleteSeminarBySeminarId(BigInteger seminarId)throws SeminarNotFoundException{
        Integer result = seminarMapper.deleteSeminarBySeminarId(seminarId);
        if(result == 0) {
            throw new SeminarNotFoundException();
        }
    }

    public BigInteger insertSeminarByCourseId(Seminar seminar){
        Integer result = seminarMapper.insertSeminarByCourseId(seminar);
        if(result == 0) {
            return new BigInteger("-1");
        }
        return  seminar.getId();
    }
}
