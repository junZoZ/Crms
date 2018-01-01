package xmu.crms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.crms.entity.*;
import xmu.crms.exception.*;
import xmu.crms.mapper.FixGroupMapper;
import xmu.crms.service.FixGroupService;
import xmu.crms.vo.FixedGroupLeaderVO;
import xmu.crms.vo.UserVO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuXin
 * @date 2017/12/22 16:50
 */
@Service
public class FixGroupServiceImpl implements FixGroupService {
    @Autowired
    private FixGroupMapper fixGroupMapper;
    @Override
    public BigInteger insertFixGroupByClassId(BigInteger classId, BigInteger userId) throws IllegalArgumentException, UserNotFoundException {
        if(classId.intValue()<=0 || userId.intValue()<=0){
            throw new IllegalArgumentException();
        }
        FixGroup group = new FixGroup();
        ClassInfo classInfo = new ClassInfo();
        classInfo.setId(classId);
        User user = new User();
        user.setId(userId);
        group.setClassInfo(classInfo);
        group.setLeader(user);

        if(fixGroupMapper.insertFixGroupByClassId(group)) {
            return new BigInteger(String.valueOf(0));
        }
        else {
            throw new UserNotFoundException("");
        }
    }

    @Override
    public void deleteFixGroupMemberByFixGroupId(BigInteger fixGroupId) throws IllegalArgumentException, FixGroupNotFoundException {
        if(fixGroupId.intValue()<=0){
            throw new IllegalArgumentException();
        }
        if(!fixGroupMapper.deleteFixGroupMemberByFixGroupId(fixGroupId)) {
            throw new FixGroupNotFoundException();
        }
    }

    @Override
    public void deleteFixGroupUserById(BigInteger fixGroupId, BigInteger userId) throws IllegalArgumentException, FixGroupNotFoundException, UserNotFoundException {
        if(fixGroupId.intValue()<0 || userId.intValue()<=0){
            throw new IllegalArgumentException();
        }
        Boolean res=fixGroupMapper.deleteFixGroupUserById(fixGroupId,userId);
        if(!res) {
            throw new FixGroupNotFoundException();
        }
    }

    @Override
    public List<User> listFixGroupMemberByGroupId(BigInteger groupId) throws IllegalArgumentException, FixGroupNotFoundException {
        if(groupId.intValue()<=0){
            throw new IllegalArgumentException();
        }
        List<User> users=new ArrayList<>();
        List<FixGroupMember> fixGroupMembers=fixGroupMapper.listFixGroupMemberByGroupId(groupId);
        if(fixGroupMembers.isEmpty()) {
            throw new FixGroupNotFoundException();
        }
        else{
            for (FixGroupMember fixGroupMember : fixGroupMembers) {
                BigInteger id = fixGroupMember.getStudent().getId();
                List<User> user = fixGroupMapper.listUsersById(id);
                users.add(user.get(0));
            }
            return users;
        }
    }

    @Override
    public List<FixGroup> listFixGroupByClassId(BigInteger classId) throws IllegalArgumentException {
        if(classId.intValue()<=0){
            throw new IllegalArgumentException();
        }
        List<FixGroup> fixGroups=fixGroupMapper.listFixGroupByClassId(classId);
        return fixGroups;
    }

    @Override
    public void deleteFixGroupByClassId(BigInteger classId) throws ClassesNotFoundException {
        //查找所有group信息
        List<FixGroup> fixGroups=fixGroupMapper.listFixGroupByClassId(classId);
        if(fixGroups.isEmpty()) {
            throw new ClassesNotFoundException("");
        }
        //循环删除
        for (FixGroup fixGroup : fixGroups) {
            fixGroupMapper.deleteFixGroupMemberByFixGroupId(fixGroup.getId());
            fixGroupMapper.deleteFixGroupTopicByGroupId(fixGroup.getId());
        }
        fixGroupMapper.deleteFixGroupByClassId(classId);

    }

    @Override
    public void deleteFixGroupByGroupId(BigInteger groupId) throws IllegalArgumentException, FixGroupNotFoundException {
        if(groupId.intValue()<=0){
            throw new IllegalArgumentException();
        }
        //删除成员信息
        Boolean res1=fixGroupMapper.deleteFixGroupMemberByFixGroupId(groupId);
        if(!res1) {
            throw new FixGroupNotFoundException();
        }
        //删除FixGroup中的信息
        Boolean res2=fixGroupMapper.deleteFixGroupById(groupId);
        if(!res2){
            throw new FixGroupNotFoundException();
        }
        //删除固定分组topic的信息
        Boolean res3=fixGroupMapper.deleteFixGroupTopicByGroupId(groupId);
        if(!res3){
            throw new FixGroupNotFoundException();
        }
    }

    @Override
    public void updateFixGroupByGroupId(BigInteger groupId, FixGroup fixGroupBO) throws IllegalArgumentException, FixGroupNotFoundException {
        if(groupId.intValue()<=0){
            throw new IllegalArgumentException();
        }
        Boolean res=fixGroupMapper.updateFixGroupByGroupId(groupId,fixGroupBO);
        if(!res){
            throw new FixGroupNotFoundException();
        }
    }

    @Override
    public List<FixGroupMember> listFixGroupByGroupId(BigInteger groupId) throws IllegalArgumentException, FixGroupNotFoundException {
        if(groupId.intValue()<=0){
            throw new IllegalArgumentException();
        }
        List<FixGroupMember> fixGroupMembers=fixGroupMapper.listFixGroupMemberByGroupId(groupId);
        if(fixGroupMembers.isEmpty()){
            throw new FixGroupNotFoundException();
        }
        return fixGroupMembers;
    }

    @Override
    public BigInteger insertStudentIntoGroup(BigInteger userId, BigInteger groupId) throws IllegalArgumentException, FixGroupNotFoundException, UserNotFoundException, InvalidOperationException {
        FixGroupMember fixGroupMember=new FixGroupMember();
        User user=new User();
        user.setId(userId);
        FixGroup fixGroup=new FixGroup();
        fixGroup.setId(groupId);
        fixGroupMember.setStudent(user);
        fixGroupMember.setFixGroup(fixGroup);
        Boolean res=fixGroupMapper.insertFixGroupMemberById(fixGroupMember);
        System.out.println(res);
        if(res){
            return fixGroupMember.getId();
        }else{
            return new BigInteger(String.valueOf(0));
        }
    }

    @Override
    public FixGroup getFixedGroupById(BigInteger userId, BigInteger classId) throws IllegalArgumentException, ClassesNotFoundException, UserNotFoundException {
        if(userId.intValue()<=0 || classId.intValue()<=0){
            throw new IllegalArgumentException();
        }
        List<FixGroupMember> list=fixGroupMapper.listFixGroupMemberByUserId(userId);
        if(list.isEmpty()){
            throw new UserNotFoundException("");
        }
        List<FixGroup> list1 = fixGroupMapper.listFixGroupById(list.get(0).getFixGroup().getId());

        for(FixGroup temp:list1){
            if(temp.getClassInfo().getId().intValue()==classId.intValue()){
                FixGroup fixGroup = new FixGroup();
                List<ClassInfo> classInfo = fixGroupMapper.listClassById(temp.getClassInfo().getId());
                fixGroup.setClassInfo(classInfo.get(0));
                List<User> leader = fixGroupMapper.listUsersById(temp.getLeader().getId());
                fixGroup.setLeader(leader.get(0));
                fixGroup.setId(temp.getId());
                return fixGroup;
            }
        }
        return null;
    }

    /*@Override
    public void updateSeminarGroupById(BigInteger groupId, SeminarGroup group) throws IllegalArgumentException, FixGroupNotFoundException {
        if(groupId.intValue()<=0){
            throw new IllegalArgumentException();
        }
        Boolean res=fixGroupMapper.updateSeminarGroupById(groupId,group);
        if(!res){
            throw new FixGroupNotFoundException();
        }
    }*/

    @Override
    public BigInteger fixedGroupToSeminarGroup(BigInteger semianrId, BigInteger fixedGroupId) throws IllegalArgumentException, FixGroupNotFoundException, SeminarNotFoundException {
        if(semianrId.intValue()<0 || fixedGroupId.intValue()<0){
            throw new IllegalArgumentException();
        }
        if(fixGroupMapper.listSeminarBySeminarId(semianrId).isEmpty()){
            throw new SeminarNotFoundException("");
        }
        //查找fixGroup信息
        List<FixGroup> fixGroups=fixGroupMapper.listFixGroupById(fixedGroupId);
        if(fixGroups.isEmpty()){
            throw new FixGroupNotFoundException();
        }
        //新建一条seminar_group记录
        SeminarGroup seminarGroup=new SeminarGroup();
        Seminar seminar=new Seminar();
        seminar.setId(semianrId);
        ClassInfo classInfo=new ClassInfo();
        classInfo.setId(fixGroups.get(0).getClassInfo().getId());
        User user=new User();
        user.setId(fixGroups.get(0).getLeader().getId());
        seminarGroup.setSeminar(seminar);
        seminarGroup.setClassInfo(classInfo);
        seminarGroup.setLeader(user);
        fixGroupMapper.insertSeminarGroup(seminarGroup);
        //查找fixGroup队员信息
        List<FixGroupMember> fixGroupMembers=fixGroupMapper.listFixGroupMemberByGroupId(fixedGroupId);
        if(fixGroupMembers.isEmpty()){
            throw new FixGroupNotFoundException();
        }
        for (FixGroupMember fixGroupMember : fixGroupMembers) {
            SeminarGroupMember seminarGroupMember = new SeminarGroupMember();
            seminarGroupMember.setSeminarGroup(seminarGroup);
            seminarGroupMember.setStudent(fixGroupMember.getStudent());
            fixGroupMapper.insertSeminarGroupMember(seminarGroupMember);
        }
        //向SeminarGroupTopic表中转移topic信息
        List<FixGroupTopic> fixGroupTopics=fixGroupMapper.selectFixGroupTopicByGroupId(fixedGroupId);
        if(!fixGroupTopics.isEmpty()){
            for (FixGroupTopic fixGroupTopic : fixGroupTopics) {
                SeminarGroupTopic seminarGroupTopic = new SeminarGroupTopic();
                Topic topic = new Topic();
                topic.setId(fixGroupTopic.getTopic().getId());
                seminarGroupTopic.setTopic(topic);
                seminarGroupTopic.setSeminarGroup(seminarGroup);
            }
        }
        fixGroupMapper.deleteFixGroupTopicByGroupId(fixedGroupId);
        System.out.println(seminarGroup.getId()+"ghfghfghg");
        return seminarGroup.getId();
    }

    @Override
    public BigInteger insertNewFixGroupStudent(BigInteger classId, BigInteger userId) {
        FixedGroupLeaderVO fixedGroupLeaderVO=new FixedGroupLeaderVO();
        fixedGroupLeaderVO.setClassId(classId);
        UserVO leader=new UserVO();
        leader.setId(userId.intValue());
        fixedGroupLeaderVO.setLeader(leader);
       boolean bigInteger = fixGroupMapper.insertNewFixGroupStudent(fixedGroupLeaderVO);
       return  fixedGroupLeaderVO.getId();
    }
}
