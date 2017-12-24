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
/**
 * @author cb
 * */
public interface TopicMapper {
    /**
     * .
     *
     * @author cb
     * @param id
     * @return Topic deleteNumber
     */
    Topic getTopicByTopicId(BigInteger id);
    /**
     * .
     *
     * @author cb
     * @param topic
     * @return Topic deleteNumber
     */
    Integer updateTopicByTopicId(Topic topic);
    /**
     * .
     *
     * @author cb
     * @param topic
     * @return Topic deleteNumber
     */
    Integer deleteTopicByTopicId(Topic topic);
    /**
     * .
     *
     * @author cb
     * @param seminarId
     * @return List<Topic> deleteNumber
     */
    List<Topic> listTopicBySeminarId(BigInteger seminarId);
    /**
     * .
     *
     * @author cb
     * @param topic
     * @return  deleteNumber
     */
    void insertTopicBySeminarId(Topic topic);
    /**
     * .
     *
     * @author cb
     * @param seminarGroupTopic
     * @return Integer deleteNumber
     */
    Integer deleteTopicById(SeminarGroupTopic seminarGroupTopic);
    /**
     * .
     *
     * @author cb
     * @param topicId
     * @return Integer deleteNumber
     */
    Integer deleteSeminarGroupTopicByTopicId(BigInteger topicId);
    /**
     * .
     *
     * @author cb
     * @param seminarGroupTopic
     * @return SeminarGroupTopic deleteNumber
     */
    SeminarGroupTopic getSeminarGroupTopicById(SeminarGroupTopic seminarGroupTopic);
    /**
     * .
     *
     * @author cb
     * @param  groupId
     * @return Integer deleteNumber
     */

    List<SeminarGroupTopic> listSeminarGroupTopicByGroupId(BigInteger groupId);

    /**
     * .
     *
     * @author cb
     * @param seminar
     * @return Integer deleteNumber
     */
    Integer deleteTopicBySeminarId(Seminar seminar);
}

