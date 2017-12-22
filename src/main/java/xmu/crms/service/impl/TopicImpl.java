package xmu.crms.service.impl;

import xmu.crms.entity.SeminarGroupTopic;
import xmu.crms.entity.Topic;
import xmu.crms.exception.TopicNotFoundException;
import xmu.crms.service.TopicService;

import java.math.BigInteger;
import java.util.List;

public class TopicImpl implements TopicService{


    @Override
    public Topic getTopicByTopicId(BigInteger topicId) throws TopicNotFoundException, IllegalArgumentException {
        return null;
    }

    @Override
    public Boolean updateTopicByTopicId(BigInteger topicId, Topic topic) throws TopicNotFoundException, IllegalArgumentException {
        return null;
    }

    @Override
    public Boolean deleteTopicByTopicId(BigInteger topicId) throws IllegalArgumentException {
        return null;
    }

    @Override
    public List<Topic> listTopicBySeminarId(BigInteger seminarId) throws IllegalArgumentException {
        return null;
    }

    @Override
    public BigInteger insertTopicBySeminarId(BigInteger seminarId, Topic topic) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Boolean deleteTopicById(BigInteger groupId, BigInteger topicId) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Boolean deleteSeminarGroupTopicByTopicId(BigInteger topicId) throws IllegalArgumentException {
        return null;
    }

    @Override
    public SeminarGroupTopic getSeminarGroupTopicById(BigInteger topicId, BigInteger groupId) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Boolean deleteTopicBySeminarId(BigInteger seminarId) throws IllegalArgumentException {
        return null;
    }
}
