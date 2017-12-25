package xmu.crms.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xmu.crms.entity.SeminarGroup;
import xmu.crms.entity.Topic;
import xmu.crms.exception.TopicNotFoundException;
import xmu.crms.service.*;
import xmu.crms.vo.IdAndNameVO;
import xmu.crms.vo.TopicVO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private ClassService classService;

    @Autowired
    private SeminarService seminarService;

    @Autowired
    private SeminarGroupService seminarGroupService;


    @Autowired
    private UserService userService;

    @Autowired
    private  TopicService topicService;

    //话题GET
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/topic/{topicId}",method = RequestMethod.GET)
    @ResponseBody
    public TopicVO index2(@PathVariable("topicId") Integer topicId) throws TopicNotFoundException, IllegalArgumentException {
        Topic topic = topicService.getTopicByTopicId(new BigInteger(topicId.toString()));
        TopicVO topicVO = new TopicVO();
        topicVO.setId(topic.getId().intValue());
        topicVO.setSerial(topic.getSerial());
        topicVO.setName(topic.getName());
        topicVO.setDescription(topic.getDescription());
        topicVO.setGroupLimit(topic.getGroupNumberLimit());
        topicVO.setGroupMemberLimit(topic.getGroupNumberLimit());
        //获取选topic的小组
        Integer number = seminarGroupService.listGroupByTopicId(topic.getId()).size();
        topicVO.setGroupLeft(topic.getGroupNumberLimit()-number);
        return topicVO;
    }

    //修改话题PUT
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/topic/{topicId}",method = RequestMethod.PUT)
    @ResponseBody
    public void index3(@PathVariable ("topicId") Integer topicId,@RequestBody TopicVO topicVO) throws TopicNotFoundException, IllegalArgumentException {
        Topic topic = topicService.getTopicByTopicId(new BigInteger(topicId.toString()));
        topic.setSerial(topicVO.getSerial());
        topic.setName(topicVO.getDescription());
        topic.setGroupNumberLimit(topicVO.getGroupLimit());
        topic.setGroupStudentLimit(topicVO.getGroupMemberLimit());
        topicService.updateTopicByTopicId(topic.getId(), topic);
    }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/topic/{topicId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void index3(@PathVariable ("topicId") Integer topicId) throws TopicNotFoundException, IllegalArgumentException  {
        topicService.deleteTopicByTopicId(new BigInteger(topicId.toString()));
    }


    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/topic/{topicId}/group",method = RequestMethod.GET)
    @ResponseBody
    public List<IdAndNameVO> index4(@PathVariable("topicId") Integer topicId)throws TopicNotFoundException, IllegalArgumentException{
        List<SeminarGroup> seminarGroupList = seminarGroupService.listGroupByTopicId(new BigInteger(topicId.toString()));
        List<IdAndNameVO> idAndNameVOList = new ArrayList<>();
        for(SeminarGroup item:seminarGroupList){
            idAndNameVOList.add(new IdAndNameVO(item.getId(), item.getLeader().getName()+"的小组"));
        }
        return idAndNameVOList;
    }

}
