package xmu.crms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import xmu.crms.entity.Seminar;
import xmu.crms.entity.SeminarGroupTopic;
import xmu.crms.entity.Topic;

import java.math.BigInteger;
import java.util.List;

@Mapper
@Component
public interface TopicMapper {

    Topic getTopicByTopicId(BigInteger id);

    Integer updateTopicByTopicId(Topic topic);

    Integer deleteTopicByTopicId(Topic topic);

    List<Topic> listTopicBySeminarId(BigInteger seminarId);

    void insertTopicBySeminarId(Topic topic);

    Integer deleteTopicById(SeminarGroupTopic seminarGroupTopic);

    Integer deleteSeminarGroupTopicByTopicId(BigInteger topicId);

    SeminarGroupTopic getSeminarGroupTopicById(SeminarGroupTopic seminarGroupTopic);

    Integer deleteTopicBySeminarId(Seminar seminar);
}

