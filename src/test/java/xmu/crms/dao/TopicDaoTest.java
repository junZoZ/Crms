package xmu.crms.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.crms.entity.Seminar;
import xmu.crms.entity.SeminarGroupTopic;
import xmu.crms.entity.Topic;

import java.math.BigInteger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicDaoTest {

    @Autowired
    private TopicDao topicDao;

    @Test
    public void testGetTopicByTopicId()
    {
        try
        {
            topicDao.getTopicByTopicId(new BigInteger("2"));
        }catch (Exception e)
        {

        }
    }

    @Test
    public void testUpdateTopicByTopicId()
    {
        try
        {
            topicDao.updateTopicByTopicId(new Topic());
        }catch (Exception e)
        {

        }
    }

    @Test
    public void testDeleteTopicByTopicId()
    {
        try
        {
            topicDao.deleteTopicByTopicId(new Topic());
        }catch (Exception e)
        {

        }
    }

    @Test
    public void testListTopicBySeminarId()
    {
            topicDao.listTopicBySeminarId(new BigInteger("2"));
    }

    @Test
    public void testInsertTopicBySeminarId()
    {
        Topic topic=new Topic();
        topic.setId(new BigInteger("99"));
        topic.setName("话题1");
        topic.setDescription("xxx");
        topic.setGroupNumberLimit(new Integer(5));
        topic.setGroupStudentLimit(new Integer(5));
        Seminar s=new Seminar();
        s.setId(new BigInteger("3"));
        topic.setSeminar(s);
        topicDao.insertTopicBySeminarId(topic);
    }

    @Test
    public void testDeleteTopicById()
    {
        topicDao.deleteTopicById(new SeminarGroupTopic());
    }

    @Test
    public void testDeleteSeminarGroupTopicByTopicId()
    {
        topicDao.deleteSeminarGroupTopicByTopicId(new BigInteger("2"));
    }

    @Test
    public void testGetSeminarGroupTopicById()
    {
        topicDao.getSeminarGroupTopicById(new SeminarGroupTopic());
    }

    @Test
    public void testListSeminarGroupTopicByGroupId()
    {
        topicDao.listSeminarGroupTopicByGroupId(new BigInteger("2"));
    }

    @Test
    public void testDeleteTopicBySeminarId()
    {
        topicDao.deleteTopicBySeminarId(new Seminar());
    }
}
