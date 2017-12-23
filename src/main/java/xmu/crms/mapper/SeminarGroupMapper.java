package xmu.crms.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import xmu.crms.entity.SeminarGroup;
import xmu.crms.entity.SeminarGroupMember;
import xmu.crms.entity.SeminarGroupTopic;
import xmu.crms.entity.User;


import java.math.BigInteger;
import java.util.List;

@Mapper
@Component
public interface SeminarGroupMapper {

    Integer  deleteSeminarGroupMemberBySeminarGroupId(BigInteger seminarGroupId);

    void insertSeminarGroupMemberById(SeminarGroupMember seminarGroupMember);

    List<User> listSeminarGroupMemberByGroupId(BigInteger groupId);

    List<SeminarGroup> listSeminarGroupIdByStudentId(BigInteger userId);

    BigInteger getSeminarGroupLeaderByGroupId(BigInteger groupId);

    List<SeminarGroup> listSeminarGroupBySeminarId(BigInteger seminarId);

    Integer deleteSeminarGroupBySeminarId(BigInteger seminarId);

    void insertSeminarGroupBySeminarId(SeminarGroup seminarGroup);

    void insertSeminarGroupMemberByGroupId(SeminarGroupMember seminarGroupMember);

    Integer deleteSeminarGroupByGroupId(BigInteger seminarGroupId);

    SeminarGroup getSeminarGroupByGroupId(BigInteger groupId);

    SeminarGroup getSeminarGroupById(SeminarGroupMember seminarGroupMember);

    List<SeminarGroup> listGroupByTopicId(BigInteger topicId);

    void insertTopicByGroupId(SeminarGroupTopic seminarGroupTopic);

    Integer assignLeaderById(SeminarGroup seminarGroup);

    Integer resignLeaderById(BigInteger seminarGroupId);



}

