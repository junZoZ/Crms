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
    public void updateTopicByTopicId(BigInteger topicId, Topic topic) throws TopicNotFoundException, IllegalArgumentException {

    }

    @Override
    public void deleteTopicByTopicId(BigInteger topicId) throws IllegalArgumentException {

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
    public void deleteTopicById(BigInteger groupId, BigInteger topicId) throws IllegalArgumentException {

    }

    @Override
    public void deleteSeminarGroupTopicByTopicId(BigInteger topicId) throws IllegalArgumentException {

    }

    @Override
    public SeminarGroupTopic getSeminarGroupTopicById(BigInteger topicId, BigInteger groupId) throws IllegalArgumentException {
        return null;
    }

    @Override
    public void deleteTopicBySeminarId(BigInteger seminarId) throws IllegalArgumentException {

    }
}
