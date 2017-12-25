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


    public void deleteSeminarGroupMemberBySeminarGroupId(BigInteger seminarGroupId) {
        Integer s = seminarGroupMapper.deleteSeminarGroupMemberBySeminarGroupId(seminarGroupId);
    }


    public BigInteger insertSeminarGroupMemberById(SeminarGroupMember seminarGroupMember) {
        Integer result = seminarGroupMapper.insertSeminarGroupMemberById(seminarGroupMember);
        if(result == 0) {
            return new BigInteger("-1");
        }
        else { return seminarGroupMember.getId(); }
    }

    public List<User> listSeminarGroupMemberByGroupId(BigInteger groupId) throws GroupNotFoundException{
        List<User> userList = seminarGroupMapper.listSeminarGroupMemberByGroupId(groupId);
        return  userList;
    }

    public List<SeminarGroup> listSeminarGroupIdByStudentId(BigInteger userId){
        List<SeminarGroup> seminarGroupList = seminarGroupMapper.listSeminarGroupIdByStudentId(userId);
        return  seminarGroupList;
    }

    public BigInteger getSeminarGroupLeaderByGroupId(BigInteger groupId){
        BigInteger leaderId = seminarGroupMapper.getSeminarGroupLeaderByGroupId(groupId);
        return leaderId;
    }

    public List<SeminarGroup> listSeminarGroupBySeminarId(BigInteger seminarId)
    {
        List<SeminarGroup> seminarGroupList = seminarGroupMapper.listSeminarGroupBySeminarId(seminarId);
        return  seminarGroupList;
    }

    public void deleteSeminarGroupBySeminarId(BigInteger seminarId){
        Integer result = seminarGroupMapper.deleteSeminarGroupBySeminarId(seminarId);
    }

    public BigInteger insertSeminarGroupBySeminarId(SeminarGroup seminarGroup){
        Integer result = seminarGroupMapper.insertSeminarGroupBySeminarId(seminarGroup);
        if(result == 0){
            return new BigInteger("-1");
        }
        else {return seminarGroup.getId();}
    }

    public BigInteger insertSeminarGroupMemberByGroupId(SeminarGroupMember seminarGroupMember){
        Integer result = seminarGroupMapper.insertSeminarGroupMemberByGroupId(seminarGroupMember);
        if(result == 0){
            return new BigInteger("-1");
        }
        else {return seminarGroupMember.getId();}
    }

    public void deleteSeminarGroupByGroupId(BigInteger seminarGroupId){
        seminarGroupMapper.deleteSeminarGroupMemberBySeminarGroupId(seminarGroupId);
    }

    public SeminarGroup getSeminarGroupByGroupId(BigInteger groupId)throws GroupNotFoundException{
        SeminarGroup seminarGroup = seminarGroupMapper.getSeminarGroupByGroupId(groupId);
        if(seminarGroup == null)
        {throw new GroupNotFoundException();}
        else {return seminarGroup;}
    }

    public SeminarGroup getSeminarGroupById(SeminarGroupMember seminarGroupMember)throws GroupNotFoundException{
        SeminarGroup seminarGroup = seminarGroupMapper.getSeminarGroupById(seminarGroupMember);
        if(seminarGroup == null)
        {throw  new GroupNotFoundException();}
        else {return  seminarGroup;}
    }

    public List<SeminarGroup> listGroupByTopicId(BigInteger topicId){
        List<SeminarGroup> seminarGroupList = seminarGroupMapper.listGroupByTopicId(topicId);
        return  seminarGroupList;
    }


    public BigInteger insertTopicByGroupId(SeminarGroupTopic seminarGroupTopic){
        Integer result = seminarGroupMapper.insertTopicByGroupId(seminarGroupTopic);
        if(result == 0){
            return new BigInteger("-1");
        }
        else {return seminarGroupTopic.getId();}
    }

    public void assignLeaderById(SeminarGroup seminarGroup)throws GroupNotFoundException{
        Integer result = seminarGroupMapper.assignLeaderById(seminarGroup);
        if(result == 0)
        {throw  new GroupNotFoundException();}
    }

    public void resignLeaderById(BigInteger seminarGroupId)throws GroupNotFoundException{
        Integer result = seminarGroupMapper.resignLeaderById(seminarGroupId);
        if(result == 0)
        {throw  new GroupNotFoundException();}
    }

    public void deleteSeminarGroupMemberById(SeminarGroupMember seminarGroupMember) {
               seminarGroupMapper.deleteSeminarGroupMemberById(seminarGroupMember);
    }

}
