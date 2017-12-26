package xmu.crms.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.crms.entity.Seminar;
import xmu.crms.entity.Topic;

import java.math.BigInteger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicImplTest {

    @Autowired
    private TopicService topicImpl;

    @Test
    public void testGetTopicByTopicId()
    {
        try
        {
            topicImpl.getTopicByTopicId(new BigInteger("2"));
        }catch (Exception e)
        {

        }
    }

    @Test
    public void testUpdateTopicByTopicId()
    {
        try
        {
            topicImpl.updateTopicByTopicId(new BigInteger("2"),new Topic());
        }catch (Exception e)
        {

        }
    }

    @Test
    public void testDeleteTopicByTopicId()
    {
        try
        {
            topicImpl.deleteTopicByTopicId(new BigInteger("2"));
        }catch (Exception e)
        {

        }
    }

    @Test
    public void testListTopicBySeminarId()
    {
            topicImpl.listTopicBySeminarId(new BigInteger("2"));
    }

    @Test
    public void testInsertTopicBySeminarId()
    {
        Topic topic=new Topic();
        topic.setId(new BigInteger("4"));
        topic.setName("话题1");
        topic.setSerial("A");
        topic.setDescription("xxx");
        topic.setGroupNumberLimit(new Integer(5));
        topic.setGroupStudentLimit(new Integer(5));
        topic.setSerial("A");
        Seminar s=new Seminar();
        s.setId(new BigInteger("3"));
        topic.setSeminar(s);
        topicImpl.insertTopicBySeminarId(new BigInteger("3"),topic);
    }

    @Test
    public void testDeleteSeminarGroupTopicByTopicId()
    {
        topicImpl.deleteSeminarGroupTopicByTopicId(new BigInteger("2"));
    }

    @Test
    public void testDeleteSeminarGroupTopicById()
    {
        topicImpl.deleteSeminarGroupTopicById(new BigInteger("2"),new BigInteger("2"));
    }

    @Test
    public void testGetSeminarGroupTopicById()
    {
        topicImpl.getSeminarGroupTopicById(new BigInteger("2"),new BigInteger("2"));
    }

    @Test
    public void testListSeminarGroupTopicByGroupId()
    {
        topicImpl.listSeminarGroupTopicByGroupId(new BigInteger("2"));
    }

    @Test
    public void testDeleteTopicBySeminarId()
    {
        topicImpl.deleteTopicBySeminarId(new BigInteger("2"));
    }
}
