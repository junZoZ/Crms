package xmu.crms.view;


import org.springframework.beans.factory.annotation.Autowired;
import xmu.crms.dto.ClassDTO;

import xmu.crms.dto.IdAndNameDTO;
import xmu.crms.dto.TopicDTO;
import xmu.crms.entity.*;
import xmu.crms.exception.ClassesNotFoundException;
import xmu.crms.exception.CourseNotFoundException;
import xmu.crms.exception.FixGroupNotFoundException;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.service.ClassService;
import xmu.crms.service.CourseService;
import xmu.crms.service.FixGroupService;
import xmu.crms.service.UserService;

import xmu.crms.vo.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.math.BigInteger;
import java.util.ArrayList;

import java.util.List;

@RestController
/**
 * @author cb
 * */
public class ClassController {

    @Autowired
    ClassService classService;


    @Autowired
    FixGroupService fixGroupService;

    @Autowired
    CourseService courseService;

    @Autowired
    UserService userService;

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/class",method = RequestMethod.GET)
    public List<ClassVO> classCheck(@RequestParam(value = "courseName",required = false) String courseName, @RequestParam(value = "teacherName",required = false) String teacherName)
    {
//userID JWT
//
        BigInteger userId=new BigInteger("5");

        List<ClassVO> listClassVO = new ArrayList<ClassVO>(16);
        List<ClassInfo> listClass =new ArrayList<ClassInfo>(16);
        if(courseName==null||teacherName==null) {
            try {
                listClass = classService.listClassByName(courseName,teacherName);
            } catch (UserNotFoundException e) {

            } catch (CourseNotFoundException e) {
            }

        }
        else
        {
            try {
                listClass = classService.listClassByUserId(userId);
            } catch (ClassesNotFoundException e) {
            }
        }
        for (ClassInfo item : listClass) {
            ClassVO classvo = new ClassVO();
            classvo.setId(item.getId().intValue());
            classvo.setName(item.getName());
            classvo.setTime(item.getClassTime());
            classvo.setSite(item.getSite());
            try {
                Integer studentNum = userService.listUserByClassId(item.getId(), "", "").size();
                classvo.setNumStudent(studentNum);
            } catch (ClassesNotFoundException e) {
                classvo.setNumStudent(0);
            } catch (UserNotFoundException e) {
                classvo.setNumStudent(0);
            }

            try {
                Course course = courseService.getCourseByCourseId(item.getCourse().getId());
                classvo.setCourseName(course.getName());
                try {
                    User teacher = userService.getUserByUserId(course.getTeacher().getId());
                    classvo.setCourseTeacher(teacher.getName());
                } catch (UserNotFoundException e) {
                }
            } catch (CourseNotFoundException e) {
            }
            listClassVO.add(classvo);
        }
                 return listClassVO;

    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/class/{classId}",method = RequestMethod.GET)
    @ResponseBody
    public ClassVO classInfo(@PathVariable("classId") Integer cid) throws ClassesNotFoundException {
        ClassVO classvo=new ClassVO();
        ClassInfo classInfo=classService.getClassByClassId(new BigInteger(cid.toString()));
        classvo.setId(classInfo.getId().intValue());
        classvo.setName(classInfo.getName());
        try {
            Integer studentNum = userService.listUserByClassId(classInfo.getId(), "", "").size();
            classvo.setNumStudent(studentNum);
        }  catch (UserNotFoundException e) {
            classvo.setNumStudent(0);
        }
        classvo.setTime(classInfo.getClassTime());
        classvo.setSite(classInfo.getSite());
        ProportionsVO pro=new ProportionsVO();
        pro.setPresentation(classInfo.getPresentationPercentage());
        pro.setReport(classInfo.getReportPercentage());
        pro.setA(classInfo.getFivePointPercentage());
        pro.setB(classInfo.getFourPointPercentage());
        pro.setC(classInfo.getThreePointPercentage());
        classvo.setProportion(pro);
        classvo.setCalling(-1);
        return classvo;
    }



    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/class/{classId}",method = RequestMethod.PUT)
    @ResponseBody
    public void ModifyClass(@PathVariable("classId") Integer classId,@RequestBody ClassVO modifyClass) throws ClassesNotFoundException {
          ClassInfo classInfo=new ClassInfo();
          classInfo.setClassTime(modifyClass.getTime());
          classInfo.setFivePointPercentage(modifyClass.getProportion().getA());
          classInfo.setFourPointPercentage(modifyClass.getProportion().getB());
          classInfo.setThreePointPercentage(modifyClass.getProportion().getC());
          classInfo.setPresentationPercentage(modifyClass.getProportion().getPresentation());
          classInfo.setReportPercentage(modifyClass.getProportion().getReport());
          classInfo.setSite(classInfo.getSite());
          classInfo.setName(classInfo.getName());
          classService.updateClassByClassId(new BigInteger(classId.toString()),classInfo);
    }


    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/class/{classId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void ModifyClass(@PathVariable("classId") Integer classId) throws ClassesNotFoundException
    {
        classService.deleteClassByClassId(new BigInteger(classId.toString()));
    }


    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "class/{classId}/student", method = RequestMethod.GET)
    @ResponseBody
    public List<UserVO> index3(@PathVariable("classId") Integer classid,@RequestParam("nameWith") String name,
                               @RequestParam("noWith") String no) throws ClassesNotFoundException {

        List<UserVO> listUserVO=new ArrayList<UserVO>(16);
        try {
           List<User> listUser=userService.listUserByClassId(new BigInteger(classid.toString()),name,no);
            for(User item:listUser)
            {
                UserVO uservo=new UserVO();
                uservo.setId(item.getId().intValue());
                uservo.setName(item.getName());
                uservo.setNumber(item.getNumber());
                listUserVO.add(uservo);
            }

        } catch (UserNotFoundException e) { }

        return listUserVO;
    }

    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value="/class/{classId}/student",method = RequestMethod.POST)
    Integer classChoose(@PathVariable("classId") Integer classId)
    {
//JWT
//
              BigInteger userId=new BigInteger("5");
        return classService.insertCourseSelectionById(userId,new BigInteger(classId.toString());
    }


    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/class/{classID}/student/{studentID}",method = RequestMethod.DELETE)
    public  void classDelete(@PathVariable("classID") Integer classId,@PathVariable("studentID") Integer studentId) throws UserNotFoundException, ClassesNotFoundException {
//JWT
//
        BigInteger userId=new BigInteger("5");
             classService.deleteCourseSelectionById(userId,new BigInteger(classId.toString()));
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/class/{classId}/classgroup", method = RequestMethod.GET)
    @ResponseBody
    public List<UserVO> getFixGroupById(@PathVariable("classId") Integer classId) {
//JWT
//
        BigInteger userId=new BigInteger("5");
        List<UserVO> listUser=new ArrayList<UserVO>(16);
        try {
            FixGroup fixGroup=fixGroupService.getFixedGroupById(userId,new BigInteger(classId.toString()));
                 UserVO uservo=new UserVO();
                 uservo.setId(fixGroup.getLeader().getId().intValue());
                 uservo.setName(fixGroup.getLeader().getName());
                 uservo.setNumber(fixGroup.getLeader().getNumber());
                 listUser.add(uservo);
                 BigInteger groupId=fixGroup.getId();
            try {
                List<User> listUsers=fixGroupService.listFixGroupMemberByGroupId(groupId);
                for(User item:listUsers)
                {
                    UserVO uservos=new UserVO();
                    uservos.setId(fixGroup.getLeader().getId().intValue());
                    uservos.setName(fixGroup.getLeader().getName());
                    uservos.setNumber(fixGroup.getLeader().getNumber());
                    listUser.add(uservos);
                }

            } catch (FixGroupNotFoundException e) { }
        } catch (ClassesNotFoundException e) { }
        catch (UserNotFoundException e) { }
        return listUser;
    }


    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/class/{classId}/classgroup/add", method = RequestMethod.PUT)
    @ResponseBody
    public void index4(@PathVariable("classId") Integer classId, @RequestBody Integer memberId) {
        System.out.println(memberId);

    }



}
