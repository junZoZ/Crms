package xmu.crms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import xmu.crms.entity.SeminarGroupTopic;
import xmu.crms.entity.Topic;

import java.math.BigInteger;
import java.util.List;

@Mapper
@Component
public interface TopicMapper {

    Topic getTopicByTopicId(BigInteger id);

    void updateTopicByTopicId(Topic topic);

    void deleteTopicByTopicId(Topic topic);

    List<Topic> listTopicBySeminarId(BigInteger seminarId);

    void insertTopicBySeminarId(Topic topic);

    void deleteTopicById(SeminarGroupTopic seminarGroupTopic);

    void deleteSeminarGroupTopicByTopicId(BigInteger topicId);

    SeminarGroupTopic getSeminarGroupTopicById(SeminarGroupTopic seminarGroupTopic);


}

