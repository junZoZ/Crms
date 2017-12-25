package xmu.crms.view;


import xmu.crms.dto.ClassDTO;
import xmu.crms.vo.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
/**
 * @author cb
 * */
public class ClassController {

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "class/{classId}/student", method = RequestMethod.GET)
    @ResponseBody
    public fixedgroupVo index3(@PathVariable("classId") Integer sid,@RequestParam("nameWith") String name,
                               @RequestParam("noWith") String no) {


        return new fixedgroupVo();

    }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/class/{classId}/classgroup/add", method = RequestMethod.PUT)
    @ResponseBody
    public void index4(@PathVariable("classId") Integer classId, @RequestBody Integer memberId) {
        System.out.println(memberId);

    }
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/class",method = RequestMethod.GET)
    public List<ClassVO> classCheck(@RequestParam("courseName") String courseName, @RequestParam("teacherName") String teacherName)
    {
        return null;
    }

    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value="/class/{classID}/student",method = RequestMethod.POST)
    public   String classChoose(@PathVariable("classID") Integer classId)
    {
        return  "111";
    }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/class/{classID}/student/{studentID}",method = RequestMethod.DELETE)
    public   void classDelete(@PathVariable("classID") Integer classId,@PathVariable("studentID") Integer studentId)
    {

    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/class/{classId}",method = RequestMethod.GET)
    @ResponseBody
    public ClassVO classInfo(@PathVariable("classId") Integer cid) {
        return null;
    }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/class/{classId}",method = RequestMethod.PUT)
    @ResponseBody
    public void ModifyClass(@PathVariable("classId") Integer classId,@RequestBody ClassDTO modifyClass) {


    }



}
