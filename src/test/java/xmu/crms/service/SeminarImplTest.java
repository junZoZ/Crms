package xmu.crms.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.crms.dao.SeminarDao;
import xmu.crms.entity.Seminar;
import xmu.crms.service.impl.SeminarImpl;

import java.math.BigInteger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeminarImplTest {

    @Autowired
    private SeminarImpl seminarImpl;

    @Test
    public void testListSeminarByCourseId()
    {
        try {
            seminarImpl.listSeminarByCourseId(new BigInteger("2"));
        }catch(Exception e)
        {

        }

    }

    @Test
    public void testDeleteSeminarByCourseId()
    {
        try {
            seminarImpl.deleteSeminarByCourseId(new BigInteger("2"));
        }catch (Exception e)
        {

        }
    }

    @Test
    public void testGetSeminarBySeminarId()
    {
        try
        {
        seminarImpl.getSeminarBySeminarId(new BigInteger("5"));}
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
            seminarImpl.updateSeminarBySeminarId(new BigInteger("2"),s);}
        catch (Exception e)
        {

        }
    }

    @Test
    public void testDeleteSeminarBySeminarId()
    {
        try
        {
            seminarImpl.deleteSeminarBySeminarId(new BigInteger("2"));}
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
            seminarImpl.insertSeminarByCourseId(new BigInteger("2"),s);}
        catch (Exception e)
        {

        }
    }
}
