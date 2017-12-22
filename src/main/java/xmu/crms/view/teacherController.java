package xmu.crms.view;

import xmu.crms.dto.*;
import xmu.crms.vo.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class teacherController {

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/course/{courseId}",method = RequestMethod.GET)
    @ResponseBody
    public CourseDescriptionVO CourseDescription(@PathVariable("courseId") Integer courseId) {

        CourseDescriptionVO courseDescription = new CourseDescriptionVO(12,"OOAD",
                "面向对象过程与设计","邱明","mingqiu@xmu.edu.cn");
        System.out.print("11");
        return courseDescription;
    }
    class Example
    {
        ArrayList<IdAndNameDTO>  classes=new ArrayList<IdAndNameDTO>();
        public Example()
        {
            IdAndNameDTO class1 = new IdAndNameDTO(12,"周三12节");
            IdAndNameDTO class2 = new IdAndNameDTO(34,"周三34节");
            IdAndNameDTO class3 = new IdAndNameDTO(56,"周三56节");
            classes.add(class1 );
            classes.add(class2 );
            classes.add(class3 );
        }
    }
    class Example1
    {
        ArrayList<IdAndNameDTO>  seminars=new ArrayList<IdAndNameDTO>();
        public Example1()
        {
            IdAndNameDTO seminar1 = new IdAndNameDTO(12,"讨论课12节");
            IdAndNameDTO seminar2 = new IdAndNameDTO(34,"讨论课34节");
            IdAndNameDTO seminar3 = new IdAndNameDTO(56,"讨论课56节");
            seminars.add(seminar1 );
            seminars.add(seminar2 );
            seminars.add(seminar3 );
        }
    }
    Example ex=new Example();
    Example1 ex1=new Example1();
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/course/{courseId}/class",method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<IdAndNameDTO> Classes(@PathVariable("courseId") Integer courseId) {
        return ex.classes;
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/course/{courseId}/seminars",method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<IdAndNameDTO> Seminars(@PathVariable("courseId") Integer courseId) {
        return ex1.seminars;
    }

    class Example2
    {
        ArrayList<ClassVO>  classes=new ArrayList<ClassVO>();
        public Example2()
        {
            ProportionsDTO classProportion = new ProportionsDTO(20,20,60,50,50);
            ClassVO classVO1 = new ClassVO(12,"周三 1-2 节",120,"海韵102",
                    "双周 周三 5-6节",-1,"/roster/周三12班.xlsx",classProportion);
            ClassVO classVO2 = new ClassVO(34,"周三 3-4节",120,"海韵102",
                    "双周 周三 5-6节",-1,"/roster/周三12班.xlsx",classProportion);
            ClassVO classVO3 = new ClassVO(56,"周三 5-6 节",120,"海韵102",
                    "双周 周三 5-6节",-1,"/roster/周三12班.xlsx",classProportion);
            classes.add(classVO1);
            classes.add(classVO2);
            classes.add(classVO3);
        }
    }
    Example2 ex2=new Example2();
    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value = "/course/{courseId}/class",method = RequestMethod.POST)
    @ResponseBody
    public ClassVO NewClass(@PathVariable("courseId") Integer courseId,@RequestBody ClassDTO newClass) {
        ClassVO classVO = new ClassVO(78,newClass.getName(),newClass.getNumberStudent(),newClass.getSite(),
                newClass.getTime(),newClass.getCalling(),newClass.getRoster(),newClass.getClassProportion());
        ex2.classes.add(classVO);
        ex.classes.add(new IdAndNameDTO(78,newClass.getName()));
        return classVO;
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/class/{classId}",method = RequestMethod.GET)
    @ResponseBody
    public ClassVO classInfo(@PathVariable("classId") Integer cid) {
        for(ClassVO item:ex2.classes) {
            if (cid == item.getId()) {
                return item;
            }
        }
    return null;
    }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/class/{classId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void DeleteClass(@PathVariable("classId") Integer classId) {
        for(ClassVO item:ex2.classes)
            if (classId== item.getId()) {
                {ex2.classes.remove(item);break;}
            }
        for(IdAndNameDTO item:ex.classes)
            if (classId== item.getId()) {
                {ex.classes.remove(item);break;}
            }

    }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/class/{classId}",method = RequestMethod.PUT)
    @ResponseBody
    public void ModifyClass(@PathVariable("classId") Integer classId,@RequestBody ClassDTO modifyClass) {
        for(ClassVO item:ex2.classes)
            if(classId==item.getId())
            {
                item.setName(modifyClass.getName());
                item.setNumberStudent(modifyClass.getNumberStudent());
                item.setTime(modifyClass.getTime());
                item.setSite(modifyClass.getSite());
                item.setCalling(modifyClass.getCalling());
                item.setRoster(modifyClass.getRoster());
                item.setClassProportion(modifyClass.getClassProportion());
            }
        for(IdAndNameDTO item:ex.classes)
            if(classId==item.getId())
            {
                item.setName(modifyClass.getName());
                return;
            }

    }


    class Example3
    {
        ArrayList<SeminarAndTopicsVO>  seminars=new ArrayList<SeminarAndTopicsVO>();
        public Example3()
        {
            TopicCheckVO1 topic1 = new TopicCheckVO1(12,"A","话题A","xxx",5,5,0);
            TopicCheckVO1 topic2 = new TopicCheckVO1(34,"B","话题B","xxx",5,5,0);
            TopicCheckVO1 topic3 = new TopicCheckVO1(56,"C","话题C","xxx",5,5,0);
            ArrayList<TopicCheckVO1> topics = new  ArrayList<TopicCheckVO1>();
            topics.add(topic1);
            topics.add(topic2);
            topics.add(topic3);

            //固定分组和随机分组要判断界面跳转问题，在这里不做判断
            ProportionsDTO seminarProportion = new ProportionsDTO(20,20,60,50,50);
            SeminarAndTopicsVO seminarAndTopicsVO1 = new SeminarAndTopicsVO(12,"概要设计1", "数据库设计","fixed","2017-10-10","2017-10-24", seminarProportion,topics);
            SeminarAndTopicsVO seminarAndTopicsVO2 = new SeminarAndTopicsVO(34,"概要设计2", "数据库设计","fixed","2017-10-10","2017-10-24", seminarProportion,topics);
            SeminarAndTopicsVO seminarAndTopicsVO3 = new SeminarAndTopicsVO(56,"概要设计3", "数据库设计","fixed","2017-10-10","2017-10-24", seminarProportion,topics);
            seminars.add(seminarAndTopicsVO1);
            seminars.add(seminarAndTopicsVO2);
            seminars.add(seminarAndTopicsVO3);
        }
    }
    Example3 ex3=new Example3();


    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value = "/course/{courseId}/seminar",method = RequestMethod.POST)
    @ResponseBody
    public SeminarAndTopicsVO NewSeminar(@PathVariable("courseId") Integer courseId, @RequestBody SeminarDTO newSeminar) {
        SeminarAndTopicsVO s=new SeminarAndTopicsVO(78,newSeminar.getName(),newSeminar.getDescription(),newSeminar.getGroupingMethod(),newSeminar.getStartTime(),newSeminar.getEndTime(),newSeminar.getSeminarProportion(),null);
        ex3.seminars.add(s);
        ex1.seminars.add(new IdAndNameDTO(78,newSeminar.getName()));
        return s;
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/seminar/{seminarId}",method = RequestMethod.GET)
    @ResponseBody
    public SeminarAndTopicsVO SeminarInfo(@PathVariable("seminarId") Integer seminarId) {
        for(SeminarAndTopicsVO item:ex3.seminars)
            if(seminarId==item.getId())
                return item;
        return null;
        }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/seminar/{seminarId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void DeleteSeminar(@PathVariable("seminarId") Integer seminarId) {
        for(SeminarAndTopicsVO item:ex3.seminars)
            if (seminarId== item.getId()) {
                {ex3.seminars.remove(item);break;}
            }
        for(IdAndNameDTO item:ex1.seminars)
            if (seminarId== item.getId()) {
                {ex1.seminars.remove(item);break;}
            }

    }


    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/seminar/{seminarId}",method = RequestMethod.PUT)
    @ResponseBody
    public void ModifySeminar(@PathVariable("seminarId") Integer seminarId, @RequestBody SeminarDTO modifySeminar) {
        for(SeminarAndTopicsVO item:ex3.seminars)
            if(seminarId==item.getId())
            {
                item.setName(modifySeminar.getName());
                item.setDescription(modifySeminar.getDescription());
                item.setGroupingMethod(modifySeminar.getGroupingMethod());
                item.setStartTime(modifySeminar.getStartTime());
                item.setEndTime(modifySeminar.getEndTime());
                item.setSeminarProportion(modifySeminar.getSeminarProportion());
            }
        for(IdAndNameDTO item:ex1.seminars)
            if(seminarId==item.getId())
            {
                item.setName(modifySeminar.getName());
                return ;
            }

    }

    //创建话题POST
    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value="/seminar/{seminarId}/topic",method = RequestMethod.POST)
    @ResponseBody
    public SeminarAndTopicsVO index1(@PathVariable ("seminarId") Integer sid,@RequestBody TopicVo a){
        TopicCheckVO1 a1=new TopicCheckVO1(78,"A",a.getName(),a.getDescription(),a.getGroupLimit(),a.getLimit(),0);
        for(SeminarAndTopicsVO item:ex3.seminars)
            if(sid==item.getId())
            {
                System.out.print("123");
                item.getTopics().add(a1);  return item;
            }
            SeminarAndTopicsVO s=new SeminarAndTopicsVO();
        return s;
    }
    //修改话题GET
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/topic/{topicId}",method = RequestMethod.GET)
    @ResponseBody
    public TopicCheckVO1 index2(@PathVariable ("topicId") Integer sid){
        for(SeminarAndTopicsVO item:ex3.seminars)
            if(item.getId().equals(12)) {
            for(TopicCheckVO1 item1:item.getTopics()){
                if (sid .equals( item1.getId()) ){
                    return item1;
                }}
            }
        return null;
    }
    //修改话题PUT
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/topic/{topicId}",method = RequestMethod.PUT)
    @ResponseBody
    public void index3(@PathVariable ("topicId") Integer sid,@RequestBody TopicVo a){
        for(SeminarAndTopicsVO item:ex3.seminars)
            if(item.getId()==12) {
                for(TopicCheckVO1 item1:item.getTopics())
                    if (sid == item1.getId()) {
                        item1.setName(a.getName());
                        item1.setDescription(a.getDescription());
                        item1.setGroupLimit(a.getGroupLimit());
                        item1.setGroupMemberLimit(a.getLimit());
                    }
            }
    }
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/topic/{topicId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void index3(@PathVariable ("topicId") Integer sid){
        for(SeminarAndTopicsVO item:ex3.seminars)
            if(item.getId()==12) {
                for(TopicCheckVO1 item1:item.getTopics())
                    if (sid == item1.getId()) {
                    item.getTopics().remove(item1); break;
                    }
            }
    }

}
