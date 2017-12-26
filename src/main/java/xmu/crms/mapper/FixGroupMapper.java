package xmu.crms.mapper;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xmu.crms.entity.ClassInfo;
import xmu.crms.entity.FixGroup;
import xmu.crms.entity.FixGroupMember;
import xmu.crms.entity.FixGroupTopic;
import xmu.crms.entity.SeminarGroup;
import xmu.crms.entity.SeminarGroupMember;
import xmu.crms.entity.SeminarGroupTopic;
import xmu.crms.entity.User;

@Mapper
@Component
/**
 *
 * @author Administrator
 *
 */

public interface FixGroupMapper {
    /**
     * 根据组Id获取固定小组对象
     * @param groupId
     * @return
     */
    FixGroup getFixGroupByGroupId(@Param("groupId") BigInteger groupId);
    /**
     * 按班级Id添加固定分组.
     * @param group 固定分组entity
     * @return BigInteger 若创建成功返回该条记录的id，失败则返回-1
     */
    Boolean insertFixGroupByClassId(FixGroup group);

    /**
     * 用于查找fix_group表中班级是否存在
     * @param classId 班级ID
     * @return 返回查找的列表
     */
    List<FixGroup> listFixGroupByClassId(@Param("classId") BigInteger classId);

    /**
     * 在fix_group_member中按照fixGroupId删除队伍
     * @param fixGroupId fixGroupId
     * @return 是否删除成功
     */
    Boolean deleteFixGroupMemberByFixGroupId(@Param("fixGroupId") BigInteger fixGroupId);

    /**
     * 在fix_group_member中按照fixGroupId和userId删除记录
     * @param fixGroupId fixGroupId
     * @param userId userId
     * @return 是否删除成功
     */
    Boolean deleteFixGroupUserById(@Param("fixGroupId") BigInteger fixGroupId, @Param("userId") BigInteger userId);

    /**
     * 用于查找fix_group_member表中队伍是否存在
     * @param fixGroupId 班级ID
     * @return 返回查找的列表
     */
    List<FixGroupMember> listFixGroupMemberByGroupId(@Param("fixGroupId") BigInteger fixGroupId);

    /**
     * 用于查找fix_group_member表中user是否存在
     * @param userId 班级ID
     * @return 返回查找的列表
     */
    List<FixGroupMember> listFixGroupMemberByUserId(@Param("userId") BigInteger userId);

    /**
     * 向fix_group_member表中添加记录
     * @param fixGroupMember fixGroupMember对象
     * @return 是否插入成功
     */
    Boolean insertFixGroupMemberById(@Param("fixGroupMember") FixGroupMember fixGroupMember);

    /**
     * 按classId删除班级
     * @param classId
     * @return
     */
    Boolean deleteFixGroupByClassId(@Param("classId") BigInteger classId);

    /**
     * 按组Id删除fix_group表中的记录
     * @param groupId 组Id
     * @return 是否删除成功
     */
    Boolean deleteFixGroupById(@Param("groupId") BigInteger groupId);

    /**
     * 更新FixGroup表中班级和队长的记录
     * @param groupId 队伍id
     * @param fixGroupBO 队伍对象
     * @return 是否成功
     */
    Boolean updateFixGroupByGroupId(@Param("groupId") BigInteger groupId, @Param("fixGroupBO") FixGroup fixGroupBO);

    /**
     * 用于查找FixGroupMember中记录是否已经存在
     * @param groupId groupId
     * @param userId groupId
     * @return 查找列表
     */
    List<FixGroupMember> listFixGroupMemberByGroupIdUserId(@Param("groupId") BigInteger groupId,@Param("userId") BigInteger userId);

    /**
     * 更新seminar_group记录
     * @param groupId 队伍id
     * @param group 队伍信息
     * @return
     */
    Boolean updateSeminarGroupById(@Param("groupId") BigInteger groupId, @Param("group") SeminarGroup group);

    /**
     * 用于查找seminar是否存在
     * @param seminarId 讨论课ID
     * @return 查询结果
     */
    List<Integer> listSeminarBySeminarId(@Param("seminarId") BigInteger seminarId);

    /**
     * 按groupId查找fix_group表中记录
     * @param groupId 队伍id
     * @return 查询结果
     */
    List<FixGroup> listFixGroupById(@Param("groupId") BigInteger groupId);

    /**
     * 向seminarGroup表中插入记录
     * @param seminarGroup 讨论课队伍信息
     * @return 是否插入成功
     */
    Boolean insertSeminarGroup(@Param("seminarGroup") SeminarGroup seminarGroup);

    /**
     * 向seminarGroupMember表中插入记录
     * @param seminarGroupMember 记录信息
     * @return 是否成功
     */
    Boolean insertSeminarGroupMember(@Param("seminarGroupMember") SeminarGroupMember seminarGroupMember);

    /**
     * 按fixGroupId在FixGroupTopic表中查询记录
     * @param groupId fixGroupId
     * @return 查询结果
     */
    List<FixGroupTopic> selectFixGroupTopicByGroupId(@Param("groupId") BigInteger groupId);

    /**
     * 向SeminarGroupTopic表中插入记录，此处用来从FixGroupTopic转移过来
     * @param seminarGroupTopic seminarGroupTopic信息
     * @return 是否成功
     */
    Boolean insertSeminarGroupTopic(@Param("seminarGroupTopic") SeminarGroupTopic seminarGroupTopic);

    /**
     * 按照groupId删除fixgrouptopic里面的记录
     * @param groupId 组id
     * @return 是否成功
     */
    Boolean deleteFixGroupTopicByGroupId(@Param("groupId") BigInteger groupId);

    /**
     * 按照Id查user信息
     * @param userId userId
     * @return 查询结果
     */
    List<User> listUsersById(BigInteger userId);

    /**
     * 按照Id查class信息
     * @param classId classId
     * @return 查询结果
     */
    List<ClassInfo> listClassById(BigInteger classId);

}
