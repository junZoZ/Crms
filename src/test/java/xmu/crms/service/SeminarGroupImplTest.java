package xmu.crms.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.crms.dao.SeminarDao;
import xmu.crms.entity.Seminar;
import xmu.crms.entity.SeminarGroup;
import xmu.crms.entity.SeminarGroupMember;
import xmu.crms.entity.SeminarGroupTopic;
import xmu.crms.service.impl.SeminarGroupImpl;

import java.math.BigInteger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeminarGroupImplTest {

    @Autowired
    private SeminarGroupImpl seminarGroupImpl;

    @Test
    public void testDeleteSeminarGroupMemberBySeminarGroupId()
    {
        seminarGroupImpl.deleteSeminarGroupMemberBySeminarGroupId(new BigInteger("2"));
    }

    @Test
    public void testInsertSeminarGroupMemberById()
    {
        try {
            seminarGroupImpl.insertSeminarGroupMemberById(new BigInteger("2"), new BigInteger("2"));
        }catch (Exception e)
        {

        }
    }

    @Test
    public void testListSeminarGroupMemberByGroupId()
    {
        try {
            seminarGroupImpl.listSeminarGroupMemberByGroupId(new BigInteger("2"));
        }catch (Exception e)
        {

        }
    }

    @Test
    public void testListSeminarGroupIdByStudentId()
    {
        try {
            seminarGroupImpl.listSeminarGroupMemberByGroupId(new BigInteger("2"));
        }catch (Exception e)
        {

        }
    }

    @Test
    public void testGetSeminarGroupLeaderByGroupId()
    {
        try {
            seminarGroupImpl.getSeminarGroupLeaderByGroupId(new BigInteger("2"));
        }catch (Exception e)
        {

        }
    }

    @Test
    public void testListSeminarGroupBySeminarId()
    {
        try {
            seminarGroupImpl.listSeminarGroupBySeminarId(new BigInteger("2"));
        }catch (Exception e)
        {

        }
    }

    @Test
    public void testDeleteSeminarGroupBySeminarId()
    {
        try {
            seminarGroupImpl.deleteSeminarGroupBySeminarId(new BigInteger("2"));
        }catch (Exception e)
        {

        }
    }

    @Test
    public void testInsertSeminarGroupBySeminarId()
    {
        seminarGroupImpl.insertSeminarGroupBySeminarId(new BigInteger("2"),new BigInteger("2"),new SeminarGroup());
    }

    @Test
    public void testInsertSeminarGroupMemberByGroupId()
    {
       seminarGroupImpl.insertSeminarGroupMemberByGroupId(new BigInteger("2"),new SeminarGroupMember());
    }

    @Test
    public void testDeleteSeminarGroupByGroupId()
    {
        seminarGroupImpl.deleteSeminarGroupByGroupId(new BigInteger("2"));
    }

    @Test
    public void testGetSeminarGroupByGroupId()
    {
        try {
            seminarGroupImpl.getSeminarGroupByGroupId(new BigInteger("2"));
        }catch (Exception e)
        {

        }
    }

    @Test
    public void testGetSeminarGroupById()
    {
        try {
            seminarGroupImpl.getSeminarGroupById(new BigInteger("2"),new BigInteger("2"));
        }catch (Exception e)
        {

        }
    }

    @Test
    public void testAutomaticallyGrouping()
    {
        try {
            seminarGroupImpl.automaticallyGrouping(new BigInteger("2"), new BigInteger("2"));
        }catch (Exception e)
        {

        }
    }

    @Test
    public void testListGroupByTopicId()
    {
        seminarGroupImpl.listGroupByTopicId(new BigInteger("2"));
    }

    @Test
    public void testInsertTopicByGroupId()
    {
        try {
            seminarGroupImpl.insertTopicByGroupId(new BigInteger("2"), new BigInteger("2"));
        }catch (Exception e)
        {

        }
    }

    @Test
    public void testAssignLeaderById()
    {
        try {
            seminarGroupImpl.assignLeaderById(new BigInteger("2"),new BigInteger("2"));
        }catch (Exception e)
        {

        }
    }

    @Test
    public void testResignLeaderById()
    {
        try {
            seminarGroupImpl.resignLeaderById(new BigInteger("2"),new BigInteger("2"));
        }catch (Exception e)
        {

        }
    }
}
