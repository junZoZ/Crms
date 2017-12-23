package xmu.crms.view;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xmu.crms.dto.IdAndNameDTO;
import xmu.crms.dto.SeminarDTO;
import xmu.crms.vo.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SeminarController {

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

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/seminar/{seminarId}",method = RequestMethod.GET)
    @ResponseBody
    public SeminarAndTopicsVO SeminarInfo(@PathVariable("seminarId") Integer seminarId) {
        return null;
    }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/seminar/{seminarId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void DeleteSeminar(@PathVariable("seminarId") Integer seminarId) {

    }


    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/seminar/{seminarId}",method = RequestMethod.PUT)
    @ResponseBody
    public void ModifySeminar(@PathVariable("seminarId") Integer seminarId, @RequestBody SeminarDTO modifySeminar) {

    }

    //创建话题POST
    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value="/seminar/{seminarId}/topic",method = RequestMethod.POST)
    @ResponseBody
    public SeminarAndTopicsVO index1(@PathVariable ("seminarId") Integer sid,@RequestBody TopicVo a){
        TopicCheckVO1 a1=new TopicCheckVO1(78,"A",a.getName(),a.getDescription(),a.getGroupLimit(),a.getLimit(),0);

        return null;
    }
}
