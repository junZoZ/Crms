package xmu.crms.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xmu.crms.entity.*;
import xmu.crms.exception.GroupNotFoundException;
import xmu.crms.exception.SeminarNotFoundException;
import xmu.crms.service.*;
import xmu.crms.vo.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SeminarController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private ClassService classService;

    @Autowired
    private SeminarService seminarService;

    @Autowired
    private SeminarGroupService seminarGroupService;


    @Autowired
    private  UserService userService;

    @Autowired
    private  TopicService topicService;

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/seminar/{seminarId}",method = RequestMethod.GET)
    @ResponseBody
    public SeminarVO SeminarInfo(@PathVariable("seminarId") Integer seminarId) throws IllegalArgumentException,SeminarNotFoundException {

        List<Topic> topicList = topicService.listTopicBySeminarId(new BigInteger(seminarId.toString()));
        //处理topic
        ArrayList<IdAndNameVO> topicIdAndNameList = new ArrayList<>();
        for(Topic item:topicList){
            IdAndNameVO topic = new IdAndNameVO();
            topic.setId(item.getId());
            topic.setName(item.getName());
            topicIdAndNameList.add(topic);
        }
        Seminar seminar = seminarService.getSeminarBySeminarId(new BigInteger(seminarId.toString()));
        SeminarVO seminarVO = new SeminarVO();
        seminarVO.setId(seminar.getId().intValue());
        seminarVO.setName(seminar.getName());
        seminarVO.setDescription(seminar.getDescription());
        seminarVO.setStartTime(seminar.getStartTime());
        seminarVO.setEndTime(seminar.getEndTime());
        seminarVO.setTopics(topicIdAndNameList);
        return seminarVO;
    }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/seminar/{seminarId}",method = RequestMethod.PUT)
    @ResponseBody
    public void ModifySeminar(@PathVariable("seminarId") Integer seminarId, @RequestBody SeminarVO modifySeminar) throws IllegalArgumentException,SeminarNotFoundException {
        Seminar seminar = seminarService.getSeminarBySeminarId(new BigInteger(seminarId.toString()));
        seminar.setName(modifySeminar.getName());
        seminar.setDescription(modifySeminar.getDescription());
        seminar.setFixed("fixed".equals(modifySeminar.getGroupingMethod()));
        seminar.setStartTime(modifySeminar.getStartTime());
        seminar.setEndTime(modifySeminar.getEndTime());
        seminarService.updateSeminarBySeminarId(seminar.getId(),seminar);
    }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/seminar/{seminarId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void DeleteSeminar(@PathVariable("seminarId") Integer seminarId) throws
            IllegalArgumentException,SeminarNotFoundException{
        seminarService.deleteSeminarBySeminarId(new BigInteger(seminarId.toString()));
    }

//    get seminar/{seminarid}/my
//    get seminar/{seminarid}/detail

    //获得话题Topic
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/seminar/{seminarId}/topic",method = RequestMethod.GET)
    @ResponseBody
    public List<TopicVO> index1(@PathVariable ("seminarId") Integer seminarId) throws IllegalArgumentException{
        List<Topic> topicList = topicService.listTopicBySeminarId(new BigInteger(seminarId.toString()));
        List<TopicVO> topicVOList = new ArrayList<>();
        for(Topic item:topicList){
            TopicVO topicVO = new TopicVO();
            topicVO.setId(item.getId().intValue());
            topicVO.setName(item.getName());
            topicVO.setSerial(item.getSerial());
            topicVO.setDescription(item.getDescription());
            topicVO.setGroupLimit(item.getGroupNumberLimit());
            topicVO.setGroupMemberLimit(item.getGroupNumberLimit());
            //获取选topic的小组
            Integer number = seminarGroupService.listGroupByTopicId(item.getId()).size();
            topicVO.setGroupLeft(item.getGroupNumberLimit()-number);
            topicVOList.add(topicVO);
        }
        return topicVOList;
    }

    //创建话题POST
    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value="/seminar/{seminarId}/topic",method = RequestMethod.POST)
    @ResponseBody
    public Integer index1(@PathVariable ("seminarId") Integer seminarId,@RequestBody TopicVO topicVO)  {
        Topic topic = new Topic();
        Seminar seminar = null;
        try {
            seminar = seminarService.getSeminarBySeminarId(new BigInteger(seminarId.toString()));
        } catch (SeminarNotFoundException e) {}
        topic.setSeminar(seminar);
        topic.setName(topicVO.getName());
        topic.setDescription(topicVO.getDescription());
        topic.setGroupNumberLimit(topicVO.getGroupLimit());
        topic.setGroupStudentLimit(topicVO.getGroupMemberLimit());
        BigInteger topicId = topicService.insertTopicBySeminarId(seminar.getId(),topic);
        return topicId.intValue();
    }


    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/seminar/{seminarId}/group",method = RequestMethod.GET)
    @ResponseBody
    public List<GroupVO> index4(@PathVariable ("seminarId") Integer seminarId)throws
            IllegalArgumentException,SeminarNotFoundException{
        List<SeminarGroup> seminarGroupList = seminarGroupList = seminarGroupService.listSeminarGroupBySeminarId(new BigInteger(seminarId.toString()));
        List<GroupVO> seminarGroupVOList = new ArrayList<>();
        for (SeminarGroup item : seminarGroupList){
            GroupVO seminarGroupVO = new GroupVO();
            seminarGroupVO.setId(item.getId().intValue());
            seminarGroupVO.setName(item.getLeader().getName()+"的小组");
            List<SeminarGroupTopic> topicList = topicService.listSeminarGroupTopicByGroupId(item.getId());
            ArrayList<IdAndNameVO> topicIdAndNameVOList = new ArrayList<IdAndNameVO>();
            for(SeminarGroupTopic seminarGroupTopic:topicList){
                topicIdAndNameVOList.add(new IdAndNameVO(seminarGroupTopic.getId(),seminarGroupTopic.getTopic().getName()));
            }
            seminarGroupVO.setTopics(topicIdAndNameVOList);
            seminarGroupVOList.add(seminarGroupVO);
        }
        return seminarGroupVOList;
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/seminar/{seminarId}/group/my",method = RequestMethod.GET)
    @ResponseBody
    public GroupVO MySeminarGroup(@PathVariable("seminarId") Integer seminarId) throws GroupNotFoundException {
//        用到jwt
//         没有实现404尚未分组
        BigInteger userId = new BigInteger("27");
        SeminarGroup seminarGroup = seminarGroupService.getSeminarGroupById(new BigInteger(seminarId.toString()),userId);
        GroupVO groupVO = new GroupVO();
        groupVO.setId(seminarGroup.getId().intValue());
        groupVO.setName(seminarGroup.getLeader().getName()+"的小组");
        groupVO.setLeader(new IdAndNameVO(seminarGroup.getLeader().getId(),seminarGroup.getLeader().getName()));
        List<User> seminarGroupMemberList = seminarGroupService.listSeminarGroupMemberByGroupId(seminarGroup.getId());
        ArrayList<IdAndNameVO> memberList = new ArrayList<>();
        for(User item:seminarGroupMemberList){
            memberList.add(new IdAndNameVO(item.getId(),item.getName()));
        }
        List<SeminarGroupTopic> topicList = topicService.listSeminarGroupTopicByGroupId(seminarGroup.getId());
        ArrayList<IdAndNameVO> topics = new ArrayList<>();
        for(SeminarGroupTopic item:topicList){
            topics.add(new IdAndNameVO(item.getTopic().getId(),item.getTopic().getName()));
        }
        groupVO.setTopics(topics);
        groupVO.setMembers(memberList);
        return groupVO;
    }
//    get seminar/{seminarId}/class/{classId}/attendence
//    get seminar/{seminarId}/class/{classId}/attendence/present
//    get seminar/{seminarId}/class/{classId}/attendence/late
//    get seminar/{seminarId}/class/{classId}/attendence/absent
//    put seminar/{seminarId}/class/{classId}/attendence/{studentId}

    }































