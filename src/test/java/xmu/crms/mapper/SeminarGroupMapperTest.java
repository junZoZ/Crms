package xmu.crms.mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.crms.entity.*;

import java.math.BigInteger;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeminarGroupMapperTest {

    @Autowired
    private SeminarGroupMapper seminarGroupMapper;

    @Test
    public void  deleteSeminarGroupMemberBySeminarGroupId()
    {
        Integer s=seminarGroupMapper.deleteSeminarGroupMemberBySeminarGroupId(new BigInteger("4"));
        System.out.println(s);
    }

    @Test
    public void insertSeminarGroupMemberById()
    {
        SeminarGroupMember seminarGroupMember=new SeminarGroupMember();
        SeminarGroup seminarGroup=new SeminarGroup();
        seminarGroup.setId(new BigInteger("1"));
        User student=new User();
        student.setId(new BigInteger("2"));
        seminarGroupMember.setSeminarGroup(seminarGroup);
        seminarGroupMember.setStudent(student);
        seminarGroupMapper.insertSeminarGroupMemberById(seminarGroupMember);
        System.out.println(seminarGroupMember.getId());
    }

    @Test
    public void  listSeminarGroupMemberByGroupId()
    {
        List<User> user=seminarGroupMapper. listSeminarGroupMemberByGroupId(new BigInteger("3"));
        for(User i:user)
            System.out.println(i.getId());
    }

    @Test
    public void  listSeminarGroupIdByStudentId()
    {
        List<SeminarGroup> seminar_group=seminarGroupMapper.  listSeminarGroupIdByStudentId(new BigInteger("3"));
        for(SeminarGroup i:seminar_group)
            System.out.println(i.getId()+" "+i.getSeminar().getId());
    }

    @Test
    public void getSeminarGroupLeaderByGroupId()
    {
        BigInteger id=seminarGroupMapper.getSeminarGroupLeaderByGroupId(new BigInteger("3"));
        System.out.println(id);
    }

    @Test
    public void  listSeminarGroupBySeminarId()
    {
        List<SeminarGroup> seminar_group=seminarGroupMapper.listSeminarGroupBySeminarId(new BigInteger("1"));
        for(SeminarGroup i:seminar_group)
            System.out.println(i.getId());
    }

    @Test
    public void  deleteSeminarGroupBySeminarId()
    {
        Integer s=seminarGroupMapper.deleteSeminarGroupBySeminarId(new BigInteger("3"));
        System.out.println(s);
    }

    @Test
    public void insertSeminarGroupBySeminarId()
    {
        SeminarGroup seminarGroup=new SeminarGroup();
        Seminar seminar=new Seminar();
        seminar.setId(new BigInteger("2"));
        seminarGroup.setSeminar(seminar);
        seminarGroup.setReportGrade(new Integer("5"));
        seminarGroup.setPresentationGrade(new Integer("5"));
        seminarGroup.setFinalGrade(new Integer("5"));
        User student=new User();
        student.setId(new BigInteger("2"));
        ClassInfo classInfo=new ClassInfo();
        classInfo.setId(new BigInteger("2"));
        seminarGroup.setClassInfo(classInfo);
        seminarGroup.setLeader(student);
        seminarGroupMapper.insertSeminarGroupBySeminarId(seminarGroup);
        System.out.println(seminarGroup.getId());
    }

    @Test
    public void  insertSeminarGroupMemberByGroupId()
    {
        User student = new User();
        student.setId(new BigInteger("74"));
        student.setName("html");
        SeminarGroup seminarGroup = new SeminarGroup();
        seminarGroup.setId(new BigInteger("2"));
        SeminarGroupMember seminarGroupMember = new SeminarGroupMember();
        seminarGroupMember.setSeminarGroup(seminarGroup);
        seminarGroupMember.setStudent(student);
        seminarGroupMapper.insertSeminarGroupMemberByGroupId(seminarGroupMember);

    }

    @Test
    public void  deleteSeminarGroupByGroupId()
    {
        Integer s = seminarGroupMapper.deleteSeminarGroupByGroupId(new BigInteger("4"));
        System.out.println(s);
    }

    @Test
    public void  getSeminarGroupByGroupId()
    {
        SeminarGroup s = seminarGroupMapper.getSeminarGroupByGroupId(new BigInteger("4"));
    }

    @Test
    public void  getSeminarGroupById()
    {
        SeminarGroupMember  seminarGroupMember = new SeminarGroupMember();
        User student = new User();
        student.setId(new BigInteger("3"));
        Seminar seminar = new Seminar();
        seminar.setId(new BigInteger("1"));
        SeminarGroup seminarGroup = new SeminarGroup();
        seminarGroup.setSeminar(seminar);
        seminarGroupMember.setStudent(student);
        seminarGroupMember.setSeminarGroup(seminarGroup);

        SeminarGroup s = seminarGroupMapper.getSeminarGroupById(seminarGroupMember);
        System.out.println(s.getId());
    }

    @Test
    public void  insertTopicByGroupId()
    {
        SeminarGroupTopic  seminarGroupTopic = new SeminarGroupTopic();
        Topic topic = new Topic();
        topic.setId(new BigInteger("1"));
        SeminarGroup seminarGroup = new SeminarGroup();
        seminarGroup.setId(new BigInteger("1"));
        seminarGroupTopic.setTopic(topic);
        seminarGroupTopic.setSeminarGroup(seminarGroup);
        seminarGroupMapper.insertTopicByGroupId(seminarGroupTopic);
        System.out.println(seminarGroupTopic.getId());
    }

    @Test
    public void  listGroupByTopicId()
    {
        List<SeminarGroup> seminarGroupList = seminarGroupMapper.listGroupByTopicId(new BigInteger("2"));
        for(SeminarGroup item :seminarGroupList )
            System.out.println(item.getId());
    }

    @Test
    public void  assignLeaderById()
    {
        User leader = new User();
        leader.setId(new BigInteger("9"));
        SeminarGroup seminarGroup = new SeminarGroup();
        seminarGroup.setId(new BigInteger("2"));
        seminarGroup.setLeader(leader);
        Integer s = seminarGroupMapper.assignLeaderById(seminarGroup);
        System.out.println(s);
    }

    @Test
    public void  resignLeaderById()
    {
        Integer s = seminarGroupMapper.resignLeaderById(new BigInteger("2"));
        System.out.println(s);
    }


}
