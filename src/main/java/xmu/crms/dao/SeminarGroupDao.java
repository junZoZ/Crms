package xmu.crms.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xmu.crms.entity.SeminarGroup;
import xmu.crms.entity.SeminarGroupMember;
import xmu.crms.entity.SeminarGroupTopic;
import xmu.crms.entity.User;
import xmu.crms.exception.GroupNotFoundException;
import xmu.crms.mapper.SeminarGroupMapper;

import java.math.BigInteger;
import java.util.List;
/**
* @author zyx
* */
@Component
public class SeminarGroupDao {
    @Autowired
    SeminarGroupMapper seminarGroupMapper;


    void deleteSeminarGroupMemberBySeminarGroupId(BigInteger seminarGroupId) {
        Integer s = seminarGroupMapper.deleteSeminarGroupMemberBySeminarGroupId(seminarGroupId);
    }


    void insertSeminarGroupMemberById(SeminarGroupMember seminarGroupMember) {
        seminarGroupMapper.insertSeminarGroupMemberById(seminarGroupMember);

    }

    List<User> listSeminarGroupMemberByGroupId(BigInteger groupId) throws GroupNotFoundException{
        List<User> userList = seminarGroupMapper.listSeminarGroupMemberByGroupId(groupId);
        if(userList == null)
        {throw new GroupNotFoundException();}
        else {return  userList;}
    }

    List<SeminarGroup> listSeminarGroupIdByStudentId(BigInteger userId){
        List<SeminarGroup> seminarGroupList = seminarGroupMapper.listSeminarGroupIdByStudentId(userId);
        return  seminarGroupList;
    }

    BigInteger getSeminarGroupLeaderByGroupId(BigInteger groupId){
        BigInteger leaderId = seminarGroupMapper.getSeminarGroupLeaderByGroupId(groupId);
        return leaderId;
    }

    List<SeminarGroup> listSeminarGroupBySeminarId(BigInteger seminarId)
    {
        List<SeminarGroup> seminarGroupList = seminarGroupMapper.listSeminarGroupBySeminarId(seminarId);
        return  seminarGroupList;
    }

    void deleteSeminarGroupBySeminarId(BigInteger seminarId){
        Integer result = seminarGroupMapper.deleteSeminarGroupBySeminarId(seminarId);
    }

    void insertSeminarGroupBySeminarId(SeminarGroup seminarGroup){
        seminarGroupMapper.insertSeminarGroupBySeminarId(seminarGroup);
    }

    void insertSeminarGroupMemberByGroupId(SeminarGroupMember seminarGroupMember){
        seminarGroupMapper.insertSeminarGroupMemberByGroupId(seminarGroupMember);
    }

    void deleteSeminarGroupByGroupId(BigInteger seminarGroupId){
        seminarGroupMapper.deleteSeminarGroupMemberBySeminarGroupId(seminarGroupId);
    }

    SeminarGroup getSeminarGroupByGroupId(BigInteger groupId)throws GroupNotFoundException{
        SeminarGroup seminarGroup = seminarGroupMapper.getSeminarGroupByGroupId(groupId);
        if(seminarGroup == null)
        {throw new GroupNotFoundException();}
        else {return seminarGroup;}
    }

    SeminarGroup getSeminarGroupById(SeminarGroupMember seminarGroupMember)throws GroupNotFoundException{
        SeminarGroup seminarGroup = seminarGroupMapper.getSeminarGroupById(seminarGroupMember);
        if(seminarGroup == null)
        {throw  new GroupNotFoundException();}
        else {return  seminarGroup;}
    }

    List<SeminarGroup> listGroupByTopicId(BigInteger topicId)throws GroupNotFoundException{
        List<SeminarGroup> seminarGroupList = seminarGroupMapper.listGroupByTopicId(topicId);
        if(seminarGroupList == null)
        {throw  new GroupNotFoundException();}
        else {return  seminarGroupList;}
    }


    void insertTopicByGroupId(SeminarGroupTopic seminarGroupTopic){
        seminarGroupMapper.insertTopicByGroupId(seminarGroupTopic);
    }

    void assignLeaderById(SeminarGroup seminarGroup)throws GroupNotFoundException{
        Integer result = seminarGroupMapper.assignLeaderById(seminarGroup);
        if(result == 0)
        {throw  new GroupNotFoundException();}
    }

    void resignLeaderById(BigInteger seminarGroupId)throws GroupNotFoundException{
        Integer result = seminarGroupMapper.resignLeaderById(seminarGroupId);
        if(result == 0)
        {throw  new GroupNotFoundException();}
    }

}
