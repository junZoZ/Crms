package xmu.crms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.crms.dao.SeminarGroupDao;
import xmu.crms.entity.*;
import xmu.crms.exception.*;
import xmu.crms.service.*;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author zyx
 * */
@Service
public  class SeminarGroupServiceImpl implements SeminarGroupService {

    @Autowired
    private SeminarGroupDao seminarGroupDao;

    @Autowired
    private  UserService userSerive;

    @Autowired
    private SeminarService seminarService;

    @Autowired
    private ClassService classService;

    @Autowired
    private TopicService topicService;

    @Override
    public  void deleteSeminarGroupMemberBySeminarGroupId(BigInteger seminarGroupId)
    {
        seminarGroupDao.deleteSeminarGroupMemberBySeminarGroupId(seminarGroupId);
    }


    @Override
    public BigInteger insertSeminarGroupMemberById(BigInteger userId, BigInteger groupId) throws IllegalArgumentException,
            GroupNotFoundException, UserNotFoundException, InvalidOperationException {
        if(userId.intValue() <= 0 || groupId.intValue() <= 0)
        { throw new IllegalArgumentException(); }
        //获取小组信息(找到小组)
         SeminarGroup seminarGroup = seminarGroupDao.getSeminarGroupByGroupId(groupId);
        //获取学生信息（存在该学生）
         User student =  userSerive.getUserByUserId(userId);
         //判断该学生是否在小组里面了
         List<User> memberList= seminarGroupDao.listSeminarGroupMemberByGroupId(groupId);
         for(User item:memberList) {
             if (item.getId().equals(userId)) {
                 throw  new InvalidOperationException();
             }
         }
         //最后进行插入 若创建成功返回该条记录的id，失败则返回-1
        SeminarGroupMember seminarGroupMember = new SeminarGroupMember();
        seminarGroupMember.setStudent(student);
        seminarGroupMember.setSeminarGroup(seminarGroup);
        BigInteger result = seminarGroupDao.insertSeminarGroupMemberByGroupId(seminarGroupMember);
        return  result;

    }

    @Override
    public List<User> listSeminarGroupMemberByGroupId(BigInteger groupId) throws IllegalArgumentException, GroupNotFoundException {
        if(groupId.intValue() <= 0)
        { throw new IllegalArgumentException(); }
        //判断小组是否存在
        SeminarGroup seminarGroup = seminarGroupDao.getSeminarGroupByGroupId(groupId);
        return seminarGroupDao.listSeminarGroupMemberByGroupId(groupId);
    }

    @Override
    public List<SeminarGroup> listSeminarGroupIdByStudentId(BigInteger userId) throws IllegalArgumentException {
        if(userId.intValue() <= 0)
        { throw new IllegalArgumentException(); }
        return seminarGroupDao.listSeminarGroupIdByStudentId(userId);
    }


    @Override
    public BigInteger getSeminarGroupLeaderByGroupId(BigInteger groupId) throws IllegalArgumentException, GroupNotFoundException {
        if(groupId.intValue() <= 0)
        { throw new IllegalArgumentException(); }
        //判断小组是否存在
         seminarGroupDao.getSeminarGroupByGroupId(groupId);
         return seminarGroupDao.getSeminarGroupLeaderByGroupId(groupId);
    }


    @Override
    public List<SeminarGroup> listSeminarGroupBySeminarId(BigInteger seminarId) throws IllegalArgumentException, SeminarNotFoundException {
        if(seminarId.intValue() <= 0)
        { throw new IllegalArgumentException(); }
         //判断讨论课是否存在
        seminarService.getSeminarBySeminarId(seminarId);
        return  seminarGroupDao.listSeminarGroupBySeminarId(seminarId);
    }

    @Override
    public void deleteSeminarGroupBySeminarId(BigInteger seminarId) throws IllegalArgumentException,SeminarNotFoundException  {
        if(seminarId.intValue() <= 0)
        { throw new IllegalArgumentException(); }
        //获取seminar所有小组
        List<SeminarGroup> seminarGroupList = listSeminarGroupBySeminarId(seminarId);
        //删除所有小组成员的信息（调用deleteSeminarGroupMemberBySeminarGroupId(BigInteger seminarGroupId)
        for (SeminarGroup item :seminarGroupList){
            deleteSeminarGroupMemberBySeminarGroupId(item.getId());
        }
        //删除讨论课小组信息
        seminarGroupDao.deleteSeminarGroupBySeminarId(seminarId);
    }

    @Override
    public BigInteger insertSeminarGroupBySeminarId(BigInteger seminarId, BigInteger classId, SeminarGroup seminarGroup) throws IllegalArgumentException {
        if(seminarId.intValue() <= 0 || classId.intValue() <= 0)
        { throw new IllegalArgumentException(); }
        Seminar seminar = new Seminar();
        seminar.setId(seminarId);
        ClassInfo classInfo = new ClassInfo();
        classInfo.setId(classId);
        seminarGroup.setSeminar(seminar);
        seminarGroup.setClassInfo(classInfo);
        return  seminarGroupDao.insertSeminarGroupBySeminarId(seminarGroup);
    }

    @Override
    public BigInteger insertSeminarGroupMemberByGroupId(BigInteger groupId, SeminarGroupMember seminarGroupMember) {
        SeminarGroup seminarGroup = new SeminarGroup();
        seminarGroup.setId(groupId);
        seminarGroupMember.setSeminarGroup(seminarGroup);
        return seminarGroupDao.insertSeminarGroupMemberByGroupId(seminarGroupMember);
    }


    @Override
    public void deleteSeminarGroupByGroupId(BigInteger seminarGroupId) throws IllegalArgumentException {
        if(seminarGroupId.intValue() <= 0 )
        { throw new IllegalArgumentException(); }
        deleteSeminarGroupMemberBySeminarGroupId(seminarGroupId);
        seminarGroupDao.deleteSeminarGroupByGroupId(seminarGroupId);
    }


    @Override
    public SeminarGroup getSeminarGroupByGroupId(BigInteger groupId) throws IllegalArgumentException, GroupNotFoundException {
        if(groupId.intValue() <= 0 )
        { throw new IllegalArgumentException(); }
        SeminarGroup seminarGroup = seminarGroupDao.getSeminarGroupByGroupId(groupId);
        return  seminarGroup;
    }

    @Override
    public BigInteger getSeminarGroupLeaderById(BigInteger userId, BigInteger seminarId) throws IllegalArgumentException,GroupNotFoundException {
        if(userId.intValue() <= 0 ||seminarId.intValue() <= 0)
        { throw new IllegalArgumentException(); }
        //寻找小组（出错会抛出异常）
        SeminarGroup seminarGroup = getSeminarGroupById(seminarId,userId);
        return seminarGroup.getId();
    }


    @Override
    public void automaticallyGrouping(BigInteger seminarId, BigInteger classId) throws
            IllegalArgumentException,ClassesNotFoundException,SeminarNotFoundException,
            GroupNotFoundException,UserNotFoundException,InvalidOperationException{
        if(classId.intValue() <= 0 ||seminarId.intValue() <= 0)
        { throw new IllegalArgumentException(); }
         //通过topic获取每个topic的组数
         Integer groupNumber = 0;
         List<Topic> topicList = topicService.listTopicBySeminarId(seminarId);
         for(Topic item:topicList) {
             groupNumber += item.getGroupNumberLimit();
         }
         //根据seminarID创建seminarGroup
        List<User> attendenceUserList = userSerive.listAbsenceStudent(seminarId,classId);
         if(attendenceUserList.size()<groupNumber){groupNumber = attendenceUserList.size();}
        for(int i = 0;i<groupNumber;i++){
         insertSeminarGroupBySeminarId(seminarId,classId,new SeminarGroup());}
         List<SeminarGroup> seminarGroupList = listSeminarGroupBySeminarId(seminarId);
         //给所有的组添加成员

         Collections.shuffle(attendenceUserList);
         int count = 0;
         groupNumber = seminarGroupList.size();
         for(User item:attendenceUserList){
             SeminarGroup seminarGroup = seminarGroupList.get(count%groupNumber);
             SeminarGroupMember seminarGroupMember = new SeminarGroupMember();
             seminarGroupMember.setSeminarGroup(seminarGroup);
             seminarGroupMember.setStudent(item);
             insertSeminarGroupMemberByGroupId(seminarGroup.getId(),seminarGroupMember);
             count++;
         }
    }


    @Override
    public SeminarGroup getSeminarGroupById(BigInteger seminarId, BigInteger userId) throws IllegalArgumentException, GroupNotFoundException {
        if(userId.intValue() <= 0 ||seminarId.intValue() <= 0)
        { throw new IllegalArgumentException(); }
        Seminar seminar = new Seminar();
        seminar.setId(seminarId);
        User user = new User();
        user.setId(userId);
        SeminarGroup seminarGroup = new SeminarGroup();
        seminarGroup.setSeminar(seminar);
        SeminarGroupMember seminarGroupMember = new SeminarGroupMember();
        seminarGroupMember.setStudent(user);
        seminarGroupMember.setSeminarGroup(seminarGroup);
        return seminarGroupDao.getSeminarGroupById(seminarGroupMember);
    }

    @Override
    public List<SeminarGroup> listGroupByTopicId(BigInteger topicId) throws IllegalArgumentException{
        if(topicId.intValue() <= 0 )
        { throw new IllegalArgumentException(); }
        return seminarGroupDao.listGroupByTopicId(topicId);
    }

    @Override
    public BigInteger insertTopicByGroupId(BigInteger groupId, BigInteger topicId) throws IllegalArgumentException, GroupNotFoundException {
        if(groupId.intValue() <= 0 ||topicId.intValue() <= 0)
        { throw new IllegalArgumentException(); }
        //如果不存在，会抛出异常
         SeminarGroup seminarGroup = getSeminarGroupByGroupId(groupId);
         SeminarGroupTopic seminarGroupTopic = new SeminarGroupTopic();
         Topic topic = new Topic();
         topic.setId(topicId);
         seminarGroupTopic.setSeminarGroup(seminarGroup);
         seminarGroupTopic.setTopic(topic);
         return  seminarGroupDao.insertTopicByGroupId(seminarGroupTopic);
    }

    @Override
    public void assignLeaderById(BigInteger groupId, BigInteger userId) throws IllegalArgumentException,
            UserNotFoundException, GroupNotFoundException, InvalidOperationException {
        if(userId.intValue() <= 0 ||groupId.intValue() <= 0)
        { throw new IllegalArgumentException(); }
        User student = userSerive.getUserByUserId(userId);
        SeminarGroup seminarGroup = getSeminarGroupByGroupId(groupId);
        if(seminarGroup.getLeader() != null){
            throw new InvalidOperationException();
        }
        seminarGroup.setLeader(student);
        seminarGroupDao.assignLeaderById(seminarGroup);
    }

    @Override
    public void resignLeaderById(BigInteger groupId, BigInteger userId) throws
            IllegalArgumentException,GroupNotFoundException,UserNotFoundException,InvalidOperationException{
        if(userId.intValue() <= 0 ||groupId.intValue() <= 0)
        { throw new IllegalArgumentException(); }
        User student = userSerive.getUserByUserId(userId);
        SeminarGroup seminarGroup = getSeminarGroupByGroupId(groupId);
        //组长不存在或者这个人不是组长
        if(seminarGroup.getLeader() == null || !userId.equals(seminarGroup.getLeader().getId())){
            throw new InvalidOperationException();
        }
        seminarGroupDao.resignLeaderById(groupId);
    }

    @Override
    public void deleteSeminarGroupMemberById(BigInteger seminarGroupId, BigInteger userId) {

        SeminarGroupMember seminarGroupMember=new SeminarGroupMember();
        User user=new User();
        user.setId(userId);
        SeminarGroup seminarGroup=new SeminarGroup();
        seminarGroup.setId(seminarGroupId);
        seminarGroupMember.setStudent(user);
        seminarGroupMember.setSeminarGroup(seminarGroup);
        seminarGroupDao.deleteSeminarGroupMemberById(seminarGroupMember);
    }

}
