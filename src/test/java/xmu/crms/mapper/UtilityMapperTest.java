package xmu.crms.mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.crms.entity.*;

import java.math.BigInteger;

@RunWith(SpringRunner.class)
@SpringBootTest
/**
 * @author chenbin
 **/
public class UtilityMapperTest {
    @Autowired
    private UtilityMapper utilityMapper;

    @Test
    public void selectUser()
    {
        User u=utilityMapper.selectUser(new BigInteger("1"));
        System.out.println(u);
    }

    @Test
    public void selectSchool()
    {
        School s=utilityMapper.selectSchool(new BigInteger("1"));
        System.out.println(s);
    }

    @Test
    public void selectClass()
    {
        ClassInfo c=utilityMapper.selectClass(new BigInteger("1"));
        System.out.println(c);
    }

    @Test
    public void selectCourse()
    {
        Course c=utilityMapper.selectCourse(new BigInteger("1"));
        System.out.println(c);
    }

    @Test
    public void selectFixGroup()
    {
        FixGroup f=utilityMapper.selectFixGroup(new BigInteger("1"));
        System.out.println(f);
    }

    @Test
    public void selectSeminar()
    {
        Seminar s=utilityMapper.selectSeminar(new BigInteger("1"));
        System.out.println(s);
    }

    @Test
    public void selectSeminarGroup()
    {
        SeminarGroup s=utilityMapper.selectSeminarGroup(new BigInteger("1"));
        System.out.println(s);
    }

    @Test
    public void selectSeminarGroupTopic()
    {
        SeminarGroupTopic s=utilityMapper.selectSeminarGroupTopic(new BigInteger("7"));
        System.out.println(s);
    }

    @Test
    public void selectTopic()
    {
        Topic t=utilityMapper.selectTopic(new BigInteger("1"));
        System.out.println(t);
    }
}
