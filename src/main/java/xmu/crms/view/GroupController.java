package xmu.crms.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xmu.crms.entity.SeminarGroup;
import xmu.crms.entity.User;
import xmu.crms.exception.FixGroupNotFoundException;
import xmu.crms.exception.GroupNotFoundException;
import xmu.crms.exception.SeminarNotFoundException;
import xmu.crms.service.*;
import xmu.crms.vo.GroupVO;
import xmu.crms.vo.IdAndNameVO;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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
//      post /fixGroup/{groupID}/topic
    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value="/fixGroup/{groupID}/seminar/{seminarID}/topic",method = RequestMethod.GET)
    public void FixGrouptopicChoose(@PathVariable("groupID") Integer groupId,@PathVariable("seminarID") Integer seminarId)
    {
        try {
            fixGroupService.fixedGroupToSeminarGroup(new BigInteger(seminarId.toString()),new BigInteger(groupId.toString()));
        } catch (FixGroupNotFoundException e) { } catch (SeminarNotFoundException e) { }
    }

//    delete  /group/{groupId}/topic/{topicId}

//    @ResponseStatus(value= HttpStatus.OK)
//    @RequestMapping(value="/group/{groupId}/grade",method = RequestMethod.GET)
//    @ResponseBody
//    public GroupVO index7(@PathVariable ("groupId") Integer groupId) throws GroupNotFoundException {
//       SeminarGroup seminarGroup = seminarGroupService.getSeminarGroupByGroupId(new BigInteger(groupId.toString()));
//       GroupVO groupVO = new GroupVO();
//       groupVO.setId(seminarGroup.getId());
//
//
//    }
//    private Integer id;
//    private String name;
//    private IdAndNameVO leader;
//    private ArrayList<IdAndNameVO> members;
//    private ArrayList<IdAndNameVO> topics;
//    private String report;


    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/group/{groupId}/grade/report",method = RequestMethod.PUT)
    @ResponseBody
    public void index6(@PathVariable ("groupId") Integer groupId, @RequestBody Integer grade) throws IllegalArgumentException,GroupNotFoundException {
        gradeService.updateGroupByGroupId(new BigInteger(groupId.toString()),new BigInteger(grade.toString()));
    }
//    put  /group/{groupId}/grade/presentation/
}
