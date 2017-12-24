package xmu.crms.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xmu.crms.entity.Seminar;
import xmu.crms.entity.SeminarGroupTopic;
import xmu.crms.entity.Topic;
import xmu.crms.exception.TopicNotFoundException;
import xmu.crms.mapper.TopicMapper;

import java.math.BigInteger;
import java.util.List;

@Component
/**
 * @author zyx
 * */
public class TopicDao {

    @Autowired
    TopicMapper topicMapper;

    public Topic getTopicByTopicId(BigInteger id) throws  TopicNotFoundException
    {
        Topic topic=topicMapper.getTopicByTopicId(id);

        if(topic == null)
        {throw new TopicNotFoundException();}
        return topic;
    }

    public void updateTopicByTopicId(Topic topic)throws  TopicNotFoundException
    {
        Integer res=topicMapper.updateTopicByTopicId(topic);
        if(res==null)
        {throw new TopicNotFoundException();}
    }

    public void deleteTopicByTopicId(Topic topic)throws  TopicNotFoundException
    {
        Integer res=topicMapper.deleteTopicByTopicId(topic);
        if(res==null)
        {throw new TopicNotFoundException();}
    }

    public List<Topic> listTopicBySeminarId(BigInteger seminarId)
    {
        List<Topic> list=topicMapper.listTopicBySeminarId(seminarId);
        return list;
    }

    public void insertTopicBySeminarId(Topic topic)
    {
       topicMapper.insertTopicBySeminarId(topic);
    }

    public void deleteTopicById(SeminarGroupTopic seminarGroupTopic)
    {
        Integer res=topicMapper.deleteTopicById(seminarGroupTopic);
    }

    public void deleteSeminarGroupTopicByTopicId(BigInteger topicId)
    {
        Integer res=topicMapper.deleteSeminarGroupTopicByTopicId(topicId);
    }

    public SeminarGroupTopic getSeminarGroupTopicById(SeminarGroupTopic seminarGroupTopic)
    {
        SeminarGroupTopic seminarGroupTopic1=topicMapper.getSeminarGroupTopicById(seminarGroupTopic);
        return seminarGroupTopic1;
    }

    public  List<SeminarGroupTopic> listSeminarGroupTopicByGroupId(BigInteger groupId)
    {
        return topicMapper.listSeminarGroupTopicByGroupId(groupId);
    }

    public void deleteTopicBySeminarId(Seminar seminar)
     {
         Integer res=topicMapper.deleteTopicBySeminarId(seminar);
     }

}

