package xmu.crms.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.crms.entity.Seminar;
import xmu.crms.entity.SeminarGroup;
import xmu.crms.entity.SeminarGroupTopic;
import xmu.crms.entity.Topic;

import java.math.BigInteger;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicMapperTest {

    @Autowired
    private TopicMapper topicMapper;

    @Test
    public void  getTopicByTopicId()
     {
        Topic topic=topicMapper.getTopicByTopicId(new BigInteger("1"));
        System.out.println(topic);
     }

    @Test
    public void  updateTopicByTopicId()
    {
        Topic topic=new Topic();
        Seminar seminar=new Seminar();
        seminar.setId(new BigInteger("1"));
        topic.setId(new BigInteger("5"));
        topic.setDescription("XXXXX");
        topic.setName("xx");
        topic.setGroupNumberLimit(5);
        topic.setGroupStudentLimit(5);
        topic.setSeminar(seminar);
        Integer res=topicMapper.updateTopicByTopicId(topic);
        System.out.println(res);
    }

    @Test
    public void  deleteTopicByTopicId()
    {
        Topic topic=new Topic();
        topic.setId(new BigInteger("5"));
        Integer res=topicMapper.deleteTopicByTopicId(topic);
        System.out.println(res);
    }

    @Test
    public void listTopicBySeminarId()
    {
        List<Topic> topicList = topicMapper.listTopicBySeminarId(new BigInteger("1"));
        System.out.println(topicList);
    }

    @Test
    public void insertTopicBySeminarId()
    {
        Topic topic=new Topic();
        Seminar seminar=new Seminar();
        seminar.setId(new BigInteger("1"));
        topic.setDescription("XXXXX");
        topic.setName("xx");
        topic.setGroupNumberLimit(5);
        topic.setGroupStudentLimit(5);
        topic.setSeminar(seminar);
        topicMapper.insertTopicBySeminarId(topic);
    }

    @Test
    public void deleteTopicById()
    {
        SeminarGroupTopic  seminarGroupTopic = new SeminarGroupTopic();
        Topic topic = new Topic();
        topic.setId(new BigInteger("1"));
        SeminarGroup seminarGroup = new SeminarGroup();
        seminarGroup.setId(new BigInteger("1"));
        seminarGroupTopic.setTopic(topic);
        seminarGroupTopic.setSeminarGroup(seminarGroup);
        Integer res=topicMapper.deleteTopicById(seminarGroupTopic);
        System.out.println(res);
    }

    @Test
    public void deleteSeminarGroupTopicByTopicId()
    {
        SeminarGroupTopic  seminarGroupTopic = new SeminarGroupTopic();
        Integer res=topicMapper.deleteSeminarGroupTopicByTopicId(new BigInteger("1"));
        System.out.println(res);
    }

    @Test
    public void getSeminarGroupTopicById()
    {
        SeminarGroupTopic  seminarGroupTopic = new SeminarGroupTopic();
        Topic topic = new Topic();
        topic.setId(new BigInteger("2"));
        SeminarGroup seminarGroup = new SeminarGroup();
        seminarGroup.setId(new BigInteger("1"));
        seminarGroupTopic.setTopic(topic);
        seminarGroupTopic.setSeminarGroup(seminarGroup);
        SeminarGroupTopic  seminarGroupTopic1 = topicMapper.getSeminarGroupTopicById(seminarGroupTopic);
        System.out.println(seminarGroupTopic1.getPresentationGrade());

    }

    @Test
    public void deleteTopicBySeminarId()
    {
        Seminar seminar=new Seminar();
        seminar.setId(new BigInteger("5"));
        Integer res=topicMapper.deleteTopicBySeminarId(seminar);
        System.out.println(res);
    }
}
