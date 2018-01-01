package xmu.crms.view;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import xmu.crms.entity.*;
import xmu.crms.exception.*;
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
    public List<ClassVO> classCheck(@RequestParam(value = "courseName",required = false) String courseName, @RequestParam(value = "teacherName",required = false) String teacherName,@RequestAttribute("userId") String userId)
    {
//userID JWT

        System.out.println(courseName);
        List<ClassVO> listClassVO = new ArrayList<ClassVO>(16);
        List<ClassInfo> listClass =new ArrayList<ClassInfo>(16);
        List<ClassInfo> myClassInfoList = new ArrayList<ClassInfo>(16);
        if(courseName!=null||teacherName!=null) {
            try {
                listClass = courseService.listClassByName(courseName,teacherName);
                myClassInfoList = classService.listClassByUserId(new BigInteger(userId));
                //取差集
                for(ClassInfo item1: myClassInfoList){
                    for(ClassInfo item:listClass) {
                        if (item1.getId().equals(item.getId())) {
                            listClass.remove(item);
                            break;
                        }
                    }
                }
            } catch (UserNotFoundException e) {

            } catch (CourseNotFoundException e) {
            } catch (ClassesNotFoundException e) {
            }

        }
        else
        {
            try {
                listClass = classService.listClassByUserId(new BigInteger(userId));
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
//          roster没处理，也就是说，没有上传分组名单的变化
        ClassVO classvo=new ClassVO();
        ClassInfo classInfo = classService.getClassByClassId(new BigInteger(cid.toString()));
        System.out.println(classInfo);
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
        classvo.setProportions(pro);
        classvo.setCalling(-1);
        return classvo;
    }

    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/class/{classId}",method = RequestMethod.PUT)
    @ResponseBody
    public void ModifyClass(@PathVariable("classId") Integer classId,@RequestBody ClassVO modifyClass) throws ClassesNotFoundException {
          ClassInfo classInfo= classService.getClassByClassId(new BigInteger(classId.toString()));
          classInfo.setClassTime(modifyClass.getTime());
          classInfo.setFivePointPercentage(modifyClass.getProportions().getA());
          classInfo.setFourPointPercentage(modifyClass.getProportions().getB());
          classInfo.setThreePointPercentage(modifyClass.getProportions().getC());
          classInfo.setPresentationPercentage(modifyClass.getProportions().getPresentation());
          classInfo.setReportPercentage(modifyClass.getProportions().getReport());
          classInfo.setSite(modifyClass.getSite());
          classInfo.setName(modifyClass.getName());
//          roster没处理，也就是说，没有上传分组名单的变化
          classService.updateClassByClassId(new BigInteger(classId.toString()),classInfo);
    }


    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/class/{classId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void ModifyClass(@PathVariable("classId") Integer classId) throws ClassesNotFoundException
    {
        System.out.println(classId);
        classService.deleteClassByClassId(new BigInteger(classId.toString()));
    }


    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "class/{classId}/student", method = RequestMethod.GET)
    @ResponseBody
    public List<UserVO> index3(@PathVariable("classId") Integer classId,@RequestParam("nameWith") String name,
                               @RequestParam("noWith") String no,@RequestAttribute("userId") String userId) throws ClassesNotFoundException, UserNotFoundException, FixGroupNotFoundException {
        //jwt
        List<UserVO> listUserVO=new ArrayList<UserVO>(16);
        FixGroup fixGroup=fixGroupService.getFixedGroupById(new BigInteger(userId),new BigInteger(classId.toString()));
        BigInteger groupId=fixGroup.getId();
        List<User> listUsers=fixGroupService.listFixGroupMemberByGroupId(groupId);
        try {
           List<User> listUser=userService.listUserByClassId(new BigInteger(classId.toString()),no,name);
            for(User item:listUser)
            {
                UserVO uservo=new UserVO();
                uservo.setId(item.getId().intValue());
                uservo.setName(item.getName());
                uservo.setNumber(item.getNumber());
                Boolean temp=true;
                for(User item1:listUsers)
                {
                    if(item1.getId().intValue()==uservo.getId())
                    {temp=false;}
                }
                if(temp==true)
                {listUserVO.add(uservo);}
            }

        } catch (UserNotFoundException e) { }
        return listUserVO;
    }

    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value="/class/{classId}/student",method = RequestMethod.POST)
    Integer classChoose(@PathVariable("classId") Integer classId,@RequestAttribute("userId") String userId)
    {
//JWT
//
        try {
            return classService.insertCourseSelectionById(new BigInteger(userId),new BigInteger(classId.toString())).intValue();
        } catch (UserNotFoundException e) { } catch (ClassesNotFoundException e) { }
        return null;
    }


    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/class/{classID}/student/{studentID}",method = RequestMethod.DELETE)
    public  void classDelete(@PathVariable("classID") Integer classId,@PathVariable("studentID") Integer studentId,@RequestAttribute("userId") String userId) throws UserNotFoundException, ClassesNotFoundException {
//JWT
//
             classService.deleteCourseSelectionById(new BigInteger(userId),new BigInteger(classId.toString()));
    }

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/class/{classId}/classgroup", method = RequestMethod.GET)
    @ResponseBody
    public FixedGroupVO getFixGroupById(@PathVariable("classId") Integer classId,@RequestAttribute("userId") String userId) throws UserNotFoundException, ClassesNotFoundException, FixGroupNotFoundException {
//JWT
//

        FixedGroupVO fixedGroupVO=new FixedGroupVO();
            FixGroup fixGroup=fixGroupService.getFixedGroupById(new BigInteger(userId),new BigInteger(classId.toString()));
                 UserVO uservo=new UserVO();
                 uservo.setId(fixGroup.getLeader().getId().intValue());
                 uservo.setName(fixGroup.getLeader().getName());
                 uservo.setNumber(fixGroup.getLeader().getNumber());
                 fixedGroupVO.setLeader(uservo);
                 BigInteger groupId=fixGroup.getId();
                 List<User> listUsers=fixGroupService.listFixGroupMemberByGroupId(groupId);
                 ArrayList<UserVO>  listUserVO=new ArrayList<UserVO>();
                for(User item:listUsers)
                {
                    if(item.getId().intValue()!=uservo.getId()) {
                        UserVO uservos = new UserVO();
                        uservos.setId(item.getId().intValue());
                        uservos.setName(item.getName());
                        uservos.setNumber(item.getNumber());
                        listUserVO.add(uservos);
                        //System.out.println(item.getId());
                    }
                }
                fixedGroupVO.setUser(listUserVO);
        return fixedGroupVO;
    }


    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/class/{classId}/classgroup/add", method = RequestMethod.PUT)
    @ResponseBody
    public void insertFixGroupMember(@PathVariable("classId") Integer classId, @RequestBody Integer memberId,@RequestAttribute("userId") String userId) {
//JWT
//
        try {
            FixGroup fixGroup=fixGroupService.getFixedGroupById(new BigInteger(userId),new BigInteger(classId.toString()));
            try {
                fixGroupService.insertStudentIntoGroup(new BigInteger(memberId.toString()),fixGroup.getId());
        } catch (FixGroupNotFoundException e)
        { }
        catch (InvalidOperationException e) { }
        } catch (ClassesNotFoundException e) { }
        catch (UserNotFoundException e) { }
    }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/class/{classId}/classgroup/remove", method = RequestMethod.PUT)
    @ResponseBody
    public void deleteFixGroupMember(@PathVariable("classId") Integer classId, @RequestBody Integer memberId,@RequestAttribute("userId") String userId) {
//JWT
//
        try {
            FixGroup fixGroup=fixGroupService.getFixedGroupById(new BigInteger(userId),new BigInteger(classId.toString()));
            try {
                fixGroupService.deleteFixGroupUserById(fixGroup.getId(),new BigInteger(memberId.toString()));
            } catch (FixGroupNotFoundException e)
            { System.out.println("123");}
        } catch (ClassesNotFoundException e) { System.out.println("123");}
        catch (UserNotFoundException e) { System.out.println("123");}
    }


}
