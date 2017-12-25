package xmu.crms.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xmu.crms.dto.IdAndNameDTO;
import xmu.crms.entity.Seminar;
import xmu.crms.entity.Topic;
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
    private GradeService gradeService;

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
    public SeminarAndTopicsVO index1(@PathVariable ("seminarId") Integer sid,@RequestBody TopicVO topicVO){

        Topic topic = new Topic();
        topic.setSeminar();
        "serial": "A",
                "name": "领域模型与模块",
                "description": "Domain model与模块划分",
                "groupLimit": 5,
                "groupMemberLimit": 6
        return null;
    }
























    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/seminar/{seminarId}/group/my",method = RequestMethod.GET)
    @ResponseBody
    public GroupVO MySeminarGroup(@PathVariable("seminarId") Integer seminarId) {
        IdAndNameDTO topic1 = new IdAndNameDTO(12,"话题A");
        IdAndNameDTO topic2 = new IdAndNameDTO(34,"话题B");
        ArrayList<IdAndNameDTO> topics = new  ArrayList<IdAndNameDTO>();
        topics.add(topic1);
        topics.add(topic2);

        IdAndNameDTO leader = new IdAndNameDTO(12,"王组长");

        IdAndNameDTO member1 = new IdAndNameDTO(12,"张三");
        IdAndNameDTO member2 = new IdAndNameDTO(34,"李四");
        ArrayList<IdAndNameDTO> members = new  ArrayList<IdAndNameDTO>();
        members.add(member1);
        members.add(member2);

        GroupVO group = new GroupVO(12,"12组",leader,members,topics);

        return group;

    }

    //ScoreHome的GET
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/seminar/{seminarId}/group",method = RequestMethod.GET)
    @ResponseBody
    public List<Integer> index4(@PathVariable ("seminarId") Integer sid){
        return null;
    }









}
