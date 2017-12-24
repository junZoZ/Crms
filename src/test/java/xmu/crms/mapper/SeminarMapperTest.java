package xmu.crms.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.crms.entity.Course;
import xmu.crms.entity.Seminar;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeminarMapperTest {

    @Autowired
    private SeminarMapper seminarMapper;

    @Test
    public void  listSeminarByCourseId()
    {
        List<Seminar>  seminarList = seminarMapper.listSeminarByCourseId(new BigInteger("1"));
        for(Seminar item:seminarList) {
            System.out.println(item);
        }
    }

    @Test
    public void  deleteSeminarByCourseId()
    {
        Integer result =  seminarMapper.deleteSeminarByCourseId(new BigInteger("1"));
        System.out.println(result);
    }

    @Test
    public void  getSeminarBySeminarId()
    {
        Seminar seminar =  seminarMapper.getSeminarBySeminarId(new BigInteger("2"));
        System.out.println(seminar);
    }

    @Test
    public void  updateSeminarBySeminarId()
    {
        Seminar seminar = new Seminar();
        seminar.setId(new BigInteger("2"));
        seminar.setName("我已经不是原来的我了");
        Integer result =  seminarMapper.updateSeminarBySeminarId(seminar);
        System.out.println(result);
    }

    @Test
    public void  deleteSeminarBySeminarId()
    {
        Integer result =  seminarMapper.deleteSeminarBySeminarId(new BigInteger("1"));
        System.out.println(result);
    }

    @Test
    public void  insertSeminarByCourseId()
    {
        Seminar seminar = new Seminar();
        seminar.setName("名字不能为空");
        seminar.setStartTime(new Date(2017,4,4));
        seminar.setEndTime(new Date(2017,5,5));
        Course course = new Course();
        course.setId(new BigInteger("1"));

        seminar.setCourse(course);
        Integer result =  seminarMapper.insertSeminarByCourseId(seminar);
        System.out.println(result);
    }
}
