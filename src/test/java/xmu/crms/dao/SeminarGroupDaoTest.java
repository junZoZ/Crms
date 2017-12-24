package xmu.crms.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.crms.entity.Seminar;
import xmu.crms.entity.SeminarGroup;
import xmu.crms.entity.SeminarGroupMember;
import xmu.crms.entity.SeminarGroupTopic;

import java.math.BigInteger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeminarGroupDaoTest {

    @Autowired
    private SeminarGroupDao seminarGroupDao;

    @Test
    public void testDeleteSeminarGroupMemberBySeminarGroupId()
    {
        seminarGroupDao.deleteSeminarGroupMemberBySeminarGroupId(new BigInteger("2"));
    }

    @Test
    public void testInsertSeminarGroupMemberById()
    {
        seminarGroupDao.insertSeminarGroupMemberById(new SeminarGroupMember());
    }

    @Test
    public void testListSeminarGroupMemberByGroupId()
    {
        try {
            seminarGroupDao.listSeminarGroupMemberByGroupId(new BigInteger("2"));
        }catch (Exception e)
        {

        }
    }

    @Test
    public void testListSeminarGroupIdByStudentId()
    {
            seminarGroupDao.listSeminarGroupIdByStudentId(new BigInteger("2"));
    }

    @Test
    public void testGetSeminarGroupLeaderByGroupId()
    {
        seminarGroupDao.getSeminarGroupLeaderByGroupId(new BigInteger("2"));
    }

    @Test
    public void testListSeminarGroupBySeminarId()
    {
        seminarGroupDao.listSeminarGroupBySeminarId(new BigInteger("2"));
    }

    @Test
    public void testDeleteSeminarGroupBySeminarId()
    {
        seminarGroupDao.deleteSeminarGroupBySeminarId(new BigInteger("2"));
    }

    @Test
    public void testInsertSeminarGroupBySeminarId()
    {
        seminarGroupDao.insertSeminarGroupBySeminarId(new SeminarGroup());
    }

    @Test
    public void testInsertSeminarGroupMemberByGroupId()
    {
        seminarGroupDao.insertSeminarGroupMemberByGroupId(new SeminarGroupMember());
    }

    @Test
    public void testDeleteSeminarGroupByGroupId()
    {
        seminarGroupDao.deleteSeminarGroupByGroupId(new BigInteger("2"));
    }

    @Test
    public void testGetSeminarGroupByGroupId()
    {
        try {
            seminarGroupDao.getSeminarGroupByGroupId(new BigInteger("2"));
        }catch (Exception e)
        {

        }
    }

    @Test
    public void testGetSeminarGroupById()
    {
        try {
            seminarGroupDao.getSeminarGroupById(new SeminarGroupMember());
        }catch (Exception e)
        {

        }
    }

    @Test
    public void testListGroupByTopicId()
    {
        seminarGroupDao.listGroupByTopicId(new BigInteger("2"));
    }

    @Test
    public void testInsertTopicByGroupId()
    {
        seminarGroupDao.insertTopicByGroupId(new SeminarGroupTopic());
    }

    @Test
    public void testAssignLeaderById()
    {
        try {
            seminarGroupDao.assignLeaderById(new SeminarGroup());
        }catch (Exception e)
        {

        }
    }

    @Test
    public void testResignLeaderById()
    {
        try {
            seminarGroupDao.resignLeaderById(new BigInteger("2"));
        }catch (Exception e)
        {

        }
    }
}
