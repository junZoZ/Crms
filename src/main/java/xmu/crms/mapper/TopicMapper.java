package xmu.crms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import xmu.crms.entity.Topic;

import java.math.BigInteger;

@Mapper
@Component
public interface TopicMapper {

    Topic getTopicByTopicId(BigInteger id);

    void updateTopicByTopicId(Topic topic);

    void deleteTopicByTopicId(Topic topic);

}

