package xmu.crms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.crms.dao.TopicDao;
import xmu.crms.entity.Seminar;
import xmu.crms.entity.SeminarGroup;
import xmu.crms.entity.SeminarGroupTopic;
import xmu.crms.entity.Topic;
import xmu.crms.exception.TopicNotFoundException;
import xmu.crms.service.TopicService;

import java.math.BigInteger;
import java.util.List;

/**
 * @author zhouzhongjun
 **/
@Service
public class TopicImpl implements TopicService{

   @Autowired
    private TopicDao topicDao;


    @Override
    public Topic getTopicByTopicId(BigInteger topicId) throws TopicNotFoundException, IllegalArgumentException {
         if(topicId.intValue()<=0)
         {
             throw new IllegalArgumentException();
         }
         return topicDao.getTopicByTopicId(topicId);
    }

    @Override
    public void updateTopicByTopicId(BigInteger topicId, Topic topic) throws TopicNotFoundException, IllegalArgumentException {
        if(topicId.intValue()<=0)
        {
            throw new IllegalArgumentException();
        }
        topic.setId(topicId);
        topicDao.updateTopicByTopicId(topic);
    }

    @Override
    public void deleteTopicByTopicId(BigInteger topicId) throws IllegalArgumentException, TopicNotFoundException {
        if(topicId.intValue()<=0)
        {
            throw new IllegalArgumentException();
        }
        Topic topic=new Topic();
        topic.setId(topicId);
        topicDao.deleteTopicByTopicId(topic);
    }

    @Override
    public List<Topic> listTopicBySeminarId(BigInteger seminarId) throws IllegalArgumentException {
        if(seminarId.intValue()<=0)
        {
            throw new IllegalArgumentException();
        }
        return topicDao.listTopicBySeminarId(seminarId);
    }

    @Override
    public BigInteger insertTopicBySeminarId(BigInteger seminarId, Topic topic) throws IllegalArgumentException {
        if(seminarId.intValue()<=0)
        {
            throw new IllegalArgumentException();
        }
        Seminar seminar=new Seminar();
        seminar.setId(seminarId);
        topic.setSeminar(seminar);
        return topicDao.insertTopicBySeminarId(topic);
    }

    @Override
    public void deleteSeminarGroupTopicById(BigInteger groupId, BigInteger topicId) throws IllegalArgumentException {
        if(groupId.intValue()<=0||topicId.intValue()<=0)
        {
            throw new IllegalArgumentException();
        }
        SeminarGroupTopic seminarGroupTopic=new SeminarGroupTopic();
        SeminarGroup seminarGroup=new SeminarGroup();
        seminarGroup.setId(groupId);
        Topic topic=new Topic();
        topic.setId(topicId);
        seminarGroupTopic.setTopic(topic);
        seminarGroupTopic.setSeminarGroup(seminarGroup);
        topicDao.deleteTopicById(seminarGroupTopic);
    }


    @Override
    public void deleteSeminarGroupTopicByTopicId(BigInteger topicId) throws IllegalArgumentException {
        if(topicId.intValue()<=0)
        {
            throw new IllegalArgumentException();
        }
        topicDao.deleteSeminarGroupTopicByTopicId(topicId);
    }

    @Override
    public SeminarGroupTopic getSeminarGroupTopicById(BigInteger topicId, BigInteger groupId) throws IllegalArgumentException {
        if(groupId.intValue()<=0||topicId.intValue()<=0)
        {
            throw new IllegalArgumentException();
        }
        SeminarGroupTopic seminarGroupTopic=new SeminarGroupTopic();
        SeminarGroup seminarGroup=new SeminarGroup();
        seminarGroup.setId(groupId);
        Topic topic=new Topic();
        topic.setId(topicId);
        seminarGroupTopic.setTopic(topic);
        seminarGroupTopic.setSeminarGroup(seminarGroup);
        return topicDao.getSeminarGroupTopicById(seminarGroupTopic);
    }

    @Override
    public List<SeminarGroupTopic> listSeminarGroupTopicByGroupId(BigInteger groupId) throws IllegalArgumentException {
        if(groupId.intValue()<=0)
        {
            throw new IllegalArgumentException();
        }
        return topicDao.listSeminarGroupTopicByGroupId(groupId);
    }

    @Override
    public void deleteTopicBySeminarId(BigInteger seminarId) throws IllegalArgumentException {
        if(seminarId.intValue()<=0)
        {
            throw new IllegalArgumentException();
        }
        Seminar seminar=new Seminar();
        seminar.setId(seminarId);
        topicDao.deleteTopicBySeminarId(seminar);
    }
}
