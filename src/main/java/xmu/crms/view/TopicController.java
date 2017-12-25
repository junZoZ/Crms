package xmu.crms.view;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xmu.crms.vo.TopicVO;

@RestController
public class TopicController {

    //修改话题GET
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/topic/{topicId}",method = RequestMethod.GET)
    @ResponseBody
    public TopicCheckVO1 index2(@PathVariable("topicId") Integer sid){
        return null;
    }

    //修改话题PUT
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/topic/{topicId}",method = RequestMethod.PUT)
    @ResponseBody
    public void index3(@PathVariable ("topicId") Integer sid,@RequestBody TopicVO a){

    }
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/topic/{topicId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void index3(@PathVariable ("topicId") Integer sid){

    }

}
