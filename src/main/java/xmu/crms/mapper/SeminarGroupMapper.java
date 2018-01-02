package xmu.crms.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import xmu.crms.entity.SeminarGroup;
import xmu.crms.entity.SeminarGroupMember;
import xmu.crms.entity.SeminarGroupTopic;
import xmu.crms.entity.User;
import xmu.crms.exception.GroupNotFoundException;
import xmu.crms.exception.InvalidOperationException;
import xmu.crms.exception.SeminarNotFoundException;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.service.SeminarGroupService;


import java.math.BigInteger;
import java.util.List;

/**
 * @author zhouzhongjun
 * */
@Mapper
@Component
public interface SeminarGroupMapper {

    /**
     * 按seminarGroupId删除SeminarGroupMember信息.
     *
     * @author zhouzhongjun
     * @param seminarGroupId 小组id
     * @return Integer deleteNumber
     */
    Integer  deleteSeminarGroupMemberBySeminarGroupId(BigInteger seminarGroupId);

    /**
     * 将学生加入讨论课小组.
     * <p>将用户加入指定的讨论课小组<br>
     * @author zhouzhongjun
     * @param seminarGroupMember 学生的id,要加入讨论课小组的id
     * @return insertNumber
     */
    Integer insertSeminarGroupMemberById(SeminarGroupMember seminarGroupMember);

    /**
     * 查询讨论课小组成员.
     * <p>按照讨论课小组id查询该小组的成员<br>
     * @author zhouzhongjun
     * @param groupId 要查询的讨论课小组id
     * @return List 讨论课小组成员信息
     */
    List<User> listSeminarGroupMemberByGroupId(BigInteger groupId);

    /**
     * 获取某学生所有的讨论课小组.
     * <p>根据学生id获取学生所在的所有讨论课小组的信息<br>
     * @author zhouzhongjun
     * @param userId 学生id
     * @return list 讨论课小组列表
     */
    List<SeminarGroup> listSeminarGroupIdByStudentId(BigInteger userId);

    /**
     * 查询讨论课小组队长id.
     * <p>按照讨论课小组id查询该小组的队长id<br>
     * @author zhouzhongjun
     * @param groupId 要查询的讨论课小组id
     * @return leaderId 讨论课小组队长id
     */
    BigInteger getSeminarGroupLeaderByGroupId(BigInteger groupId);

    /**
     * 按seminarId获取SeminarGroup.
     * <p>按seminarId获取SeminarGroup<br>
     * @author zhouzhongjun
     * @param seminarId 课程Id
     * @return 讨论课小组列表
     */
    List<SeminarGroup> listSeminarGroupBySeminarId(BigInteger seminarId);

    /**
     * 按seminarId删除讨论课小组信息.
     * <p>根据seminarId获得SeminarGroup，然后根据SeminarGroupId删除SeminarGroupMember信息，最后再删除SeminarGroup信息<br>
     * @author zhouzhongjun
     * @param seminarId 讨论课Id
     * @return  deleteNumber
     */
    Integer deleteSeminarGroupBySeminarId(BigInteger seminarId);

    /**
     * 创建讨论课小组.
     * <p>在指定讨论课下创建讨论课小组<br>
     * @author zhouzhongjun
     * @param seminarGroup 小组信息(讨论课的id)
     * @return insertNumber
     */
    Integer insertSeminarGroupBySeminarId(SeminarGroup seminarGroup);

    /**
     * 创建小组成员信息.
     * <p>在指定小组成员表下创建一个新的小组信息<br>
     * @author zhouzhongjun
     * @param seminarGroupMember 小组成员信息(小组的id)
     * @return insertNumber
     */
    Integer insertSeminarGroupMemberByGroupId(SeminarGroupMember seminarGroupMember);

    /**
     * 删除讨论课小组.
     * <p>按照id删除讨论课小组<br>
     * @author zhouzhongjun
     * @param seminarGroupId 讨论课小组的id
     *@return deleteNum
     */
    Integer deleteSeminarGroupByGroupId(BigInteger seminarGroupId);

    /**
     * 查询讨论课小组.
     * <p>按照id查询某一讨论课小组的信息（包括成员）<br>
     * @author zhouzhongjun
     * @param groupId 小组的id
     * @return seminarGroup 讨论课小组对象，若未找到相关小组返回空(null)
     */
    SeminarGroup getSeminarGroupByGroupId(BigInteger groupId);

    /**
     * 根据讨论课Id及用户id，获得该用户所在的讨论课的小组的信息.
     * <p>根据讨论课Id及用户id，获得该用户所在的讨论课的小组的信息<br>
     * @author zhouzhongjun
     * @param seminarGroupMember （userId ,seminarId ）
     * @return SeminarGroup Group的相关信息
     */
    SeminarGroup getSeminarGroupById(SeminarGroupMember seminarGroupMember);

    /**
     * 根据话题Id获得选择该话题的所有小组的信息.
     * <p>根据话题Id获得选择该话题的所有小组的信息<br>
     * @author zhouzhongjun
     * @param  topicId 话题的id
     * @return List 所有选择该话题的所有group的信息
     */
    List<SeminarGroup> listGroupByTopicId(BigInteger topicId);

    /**
     * 小组按id选择话题.
     * <p>小组通过小组id和话题id选择讨论课的话题<br>
     * @author heqi
     * @param seminarGroupTopic(groupId,topicId)
     * @return insertNumber
     */
    Integer insertTopicByGroupId(SeminarGroupTopic seminarGroupTopic);

    /**
     * 成为组长.
     * <p>同学按小组id和自身id成为组长<br>
     * @param seminarGroup(groupId,userId)
     * @return deleteNumber
     */
    Integer assignLeaderById(SeminarGroup seminarGroup);

    /**
     * 组长辞职.
     * <p>同学按小组id和自身id,辞掉组长职位<br>
     * @param seminarGroupId
     * @return deleteNumber
     */
    Integer resignLeaderById(BigInteger seminarGroupId);


    /**
     * jgodjfgj
     * @param seminarGroupMember
     * @return SeminarGroupMember
     */
    Integer deleteSeminarGroupMemberById(SeminarGroupMember seminarGroupMember);
}

