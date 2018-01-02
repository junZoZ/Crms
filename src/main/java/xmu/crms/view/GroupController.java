package xmu.crms.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xmu.crms.entity.*;
import xmu.crms.exception.FixGroupNotFoundException;
import xmu.crms.exception.GroupNotFoundException;
import xmu.crms.exception.SeminarNotFoundException;
import xmu.crms.mapper.GradeMapper;
import xmu.crms.service.*;
import xmu.crms.vo.CourseVO;
import xmu.crms.vo.GroupVO;
import xmu.crms.vo.IdAndNameVO;
import xmu.crms.vo.SeminarGroupGradeVO;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author  zyx
 */
@RestController
public class GroupController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private ClassService classService;

    @Autowired
    private SeminarService seminarService;

    @Autowired
    private SeminarGroupService seminarGroupService;

    @Autowired
    private FixGroupService fixGroupService;

    @Autowired
    private UserService userService;

    @Autowired
    private  TopicService topicService;

    @Autowired
    private  GradeService gradeService;

    @Autowired
    private GradeMapper gradeMapper;
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/group/{groupId}",method = RequestMethod.GET)
    @ResponseBody
    public GroupVO index5(@PathVariable ("groupId") Integer groupId,@RequestParam(value = "embedTopics",required = false) String embedTopics,
                               @RequestParam(value = "embedGrade",required = false) String embedGrade)
                     throws IllegalArgumentException,GroupNotFoundException {
        SeminarGroup seminarGroup = seminarGroupService.getSeminarGroupByGroupId(new BigInteger(groupId.toString()));
        GroupVO groupVO = new GroupVO();
        groupVO.setId(seminarGroup.getId().intValue());
        groupVO.setName(seminarGroup.getLeader().getName()+"的小组");
        groupVO.setLeader(new IdAndNameVO(seminarGroup.getLeader().getId(),seminarGroup.getLeader().getName()));
        List<User> seminarGroupMemberList = seminarGroupService.listSeminarGroupMemberByGroupId(seminarGroup.getId());
        ArrayList<IdAndNameVO> memberList = new ArrayList<>();
        for(User item:seminarGroupMemberList){
            memberList.add(new IdAndNameVO(item.getId(),item.getName()));
        }
        groupVO.setMembers(memberList);
        return groupVO;
    }

//    put /group/{groupId}/resign
//    put /group/{groupId}/assign
//    put /group/{groupId}/add
//    put /group/{groupId}/remove
//      post /Group/{groupID}/topic


//    @ResponseStatus(value= HttpStatus.CREATED)
//    @RequestMapping(value="/Group/{groupID}/topic/{topicID}",method = RequestMethod.POST)
//    public void NewCourse(@PathVariable ("groupID") Integer groupId,@PathVariable ("topicID") Integer topicId) throws GroupNotFoundException {
//
//        SeminarGroupTopic seminarGroupTopic = new SeminarGroupTopic();
//
//
//    }

    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value="/fixGroup/{groupID}/seminar/{seminarID}/topic/{topicID}",method = RequestMethod.POST)
    public Integer fixGrouptopicChoose(@PathVariable("groupID") Integer groupId,@PathVariable("seminarID") Integer seminarId,
                                    @PathVariable ("topicID") Integer topicId,@RequestAttribute("userId") String userId) throws FixGroupNotFoundException, SeminarNotFoundException {
       System.out.println("fgidogdof");
       BigInteger groupeID = new BigInteger("0");
        SeminarGroup seminarGroup = new SeminarGroup();
       //先确定这个组不存在seminarGroup中
        try {
            seminarGroup = seminarGroupService.getSeminarGroupById(new BigInteger(seminarId.toString()),new BigInteger(userId));
        } catch (GroupNotFoundException e) { System.out.println("fg854444444444");
            groupeID =  fixGroupService.fixedGroupToSeminarGroup(new BigInteger(seminarId.toString()),new BigInteger(groupId.toString()));}
        if(seminarGroup!=null && seminarGroup.getId() != null)  {groupeID = seminarGroup.getId();}
        System.out.println(groupeID);

        if(groupeID.intValue()!=0  ){

                SeminarGroupTopic seminarGroup1 = topicService.getSeminarGroupTopicById(new BigInteger(topicId.toString()),groupeID);

                if(seminarGroup1 == null){
                try {

                    seminarGroupService.insertTopicByGroupId(groupeID,new BigInteger(topicId.toString()));
                    return groupeID.intValue();
                } catch (GroupNotFoundException e1) {
                    System.out.println("fg877777777");
                }
            }}

       return  null;
    }

//    delete  /group/{groupId}/topic/{topicId}

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/group/{groupId}/grade",method = RequestMethod.GET)
    @ResponseBody
    public SeminarGroupGradeVO index7(@PathVariable ("groupId") Integer groupId) throws GroupNotFoundException {
       SeminarGroup seminarGroup = seminarGroupService.getSeminarGroupByGroupId(new BigInteger(groupId.toString()));
       SeminarGroupGradeVO seminarGroupGradeVO = new SeminarGroupGradeVO();
       seminarGroupGradeVO.setGroupName(seminarGroup.getLeader().getName()+"的小组");
       seminarGroupGradeVO.setLeaderName(seminarGroup.getLeader().getName());
       seminarGroupGradeVO.setPresentationGrade(seminarGroup.getPresentationGrade());
       seminarGroupGradeVO.setReportGrade(seminarGroup.getReportGrade());
       seminarGroupGradeVO.setFinalGrade(seminarGroup.getFinalGrade());
       seminarGroupGradeVO.setReport(seminarGroup.getReport());
       String ran ="未提交" ;
       String ran1 = "已提交";
       if("".equals(seminarGroup.getReport())){seminarGroupGradeVO.setSubmit(ran);}
       else{seminarGroupGradeVO.setSubmit(ran1);}
       //处理小组的topic
        String topicSerial = "";
        List<SeminarGroupTopic> seminarGroupTopicList = topicService.listSeminarGroupTopicByGroupId(seminarGroup.getId());
        for(SeminarGroupTopic item:seminarGroupTopicList){
            topicSerial += item.getTopic().getSerial();
            topicSerial += ",";
        }
        topicSerial = topicSerial.substring(0,topicSerial.length()-1);
        seminarGroupGradeVO.setTopicSerial(topicSerial);
        return seminarGroupGradeVO;

    }


    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/group/{groupId}/grade/report",method = RequestMethod.PUT)
    @ResponseBody
    public void index6(@PathVariable ("groupId") Integer groupId,@RequestBody Integer grade) throws IllegalArgumentException,GroupNotFoundException {
        System.out.println("jinlaile");
        System.out.println(grade);
        gradeService.updateGroupByGroupId(new BigInteger(groupId.toString()),new BigInteger(grade.toString()));
        SeminarGroup seminarGroup = seminarGroupService.getSeminarGroupByGroupId(new BigInteger(groupId.toString()));
        gradeService.countGroupGradeBySeminarId(seminarGroup.getSeminar().getId());
    }
//    put  /group/{groupId}/grade/presentation/
}
