package xmu.crms.view;


import xmu.crms.dto.IdAndNameDTO;
import xmu.crms.dto.TopicDTO;
import xmu.crms.vo.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ClassController {

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

    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value="/group/{groupID}/topic",method = RequestMethod.POST)
    public String topicChoose(@PathVariable("groupID") Integer groupId,  @RequestBody TopicDTO tid)
    {
        return "1111";
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/course/{courseID}/grade",method = RequestMethod.GET)
    public   ArrayList courseGrade(@PathVariable("courseID") Integer courseId)
    {

        ArrayList<CourseGradeVO> courseGradeList = new ArrayList<CourseGradeVO>();

        CourseGradeVO grade1 = new CourseGradeVO("需求分析","3A2","张三",
                3,4,4);
        CourseGradeVO grade2 = new CourseGradeVO("界面原型设计","3A3","张三",
                4,4,4);
        CourseGradeVO grade3 = new CourseGradeVO("需求分析","3A2","张三",
                3,4,4);
        CourseGradeVO grade4 = new CourseGradeVO("界面原型设计","3A3","张三",
                4,4,4);

        courseGradeList.add(grade1);
        courseGradeList.add(grade2);
        courseGradeList.add(grade3);
        courseGradeList.add(grade4);


        return courseGradeList;
    }
}
