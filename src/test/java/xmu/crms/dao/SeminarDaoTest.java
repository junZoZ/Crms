package xmu.crms.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.crms.entity.Seminar;

import java.math.BigInteger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeminarDaoTest {

    @Autowired
    private SeminarDao seminarDao;

    @Test
    public void testListSeminarByCourseId()
    {
        seminarDao.listSeminarByCourseId(new BigInteger("2"));
    }

    @Test
    public void testDeleteSeminarByCourseId()
    {
        seminarDao.deleteSeminarByCourseId(new BigInteger("2"));
    }

    @Test
    public void testGetSeminarBySeminarId()
    {
        try
        {
        seminarDao.getSeminarBySeminarId(new BigInteger("5"));}
        catch (Exception e)
        {

        }
    }

    @Test
    public void testUpdateSeminarBySeminarId()
    {
        try
        {
            Seminar s=new Seminar();
            s.setId(new BigInteger("2"));
            seminarDao.updateSeminarBySeminarId(s);}
        catch (Exception e)
        {

        }
    }

    @Test
    public void testDeleteSeminarBySeminarId()
    {
        try
        {
            seminarDao.deleteSeminarBySeminarId(new BigInteger("2"));}
        catch (Exception e)
        {

        }
    }

    @Test
    public void testInsertSeminarByCourseId()
    {
        try
        {
            Seminar s=new Seminar();
            s.setId(new BigInteger("2"));
            seminarDao.insertSeminarByCourseId(s);}
        catch (Exception e)
        {

        }
    }
}
