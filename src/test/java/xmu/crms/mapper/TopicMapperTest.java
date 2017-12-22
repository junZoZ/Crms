package xmu.crms.mapper;

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
        topicMapper.updateTopicByTopicId(topic);
    }

    @Test
    public void  deleteTopicByTopicId()
    {
        Topic topic=new Topic();
        topic.setId(new BigInteger("5"));
        topicMapper.deleteTopicByTopicId(topic);
    }

}
