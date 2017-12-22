package xmu.crms.view;

import xmu.crms.vo.ClassVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentChooseCourseController {
    List<ClassVO> list1=new ArrayList<ClassVO>(16);

    ClassVO class1=new ClassVO(11,"一班",60,"周三一二节，周三三四节","海韵202","OOAD","邱明");
    ClassVO class2=new ClassVO(12,"一班",60,"周二一二节，周三五六节","海韵203","J2EE","邱明");
    ClassVO class3=new ClassVO(13,"二班",60,"周二一二节，周三五六节","海韵204","操作系统","吴清强");
    ClassVO class4=new ClassVO(14,"三班",60,"周二一二节，周三五六节","海韵205",".NET","杨律青");

    List<ClassVO> classes = new ArrayList<ClassVO>(16);
    ClassVO class11 = new ClassVO(23,"周三1-2节",60,"周三1-2、周五1-2",
            "公寓405","软件工程导论","王美红");
    ClassVO class21 = new ClassVO( 42,"一班",60,"周三34节 周五12节",
            "海韵202","数据仓库","王鸿吉");

    public StudentChooseCourseController() {
        System.out.print(1231313);
        list1.add(class1);
        list1.add(class2);
        list1.add(class3);
        list1.add(class4);
        list1.add(class11);
        list1.add(class21);
    }

   /* class EX
    {
        public EX()
        {
            list1.add(class1);
            list1.add(class2);
            list1.add(class3);
            list1.add(class4);
            list1.add(class11);
            list1.add(class21);
        }
    }

    EX s=new EX();*/

     @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/class",method = RequestMethod.GET)
    public List<ClassVO> classCheck(@RequestParam("courseName") String courseName, @RequestParam("teacherName") String teacherName)
    {
        if(courseName.isEmpty()&&teacherName.isEmpty())
            return classes;

        List<ClassVO> list2=new ArrayList<ClassVO>(16);
        for(int i=0;i<list1.size();i++)
        {
            if((courseName.equals("*")||list1.get(i).getCourseName().equals(courseName))
                    &&(teacherName.equals("*")||list1.get(i).getCourseTeacher().equals(teacherName)))
                list2.add(list1.get(i));
        }
        return list2;
    }
    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value="/class/{classID}/student",method = RequestMethod.POST)
    public   String classChoose(@PathVariable("classID") Integer classId)
    {
        for(ClassVO item:list1)
            if(item.getId()==classId)
            {list1.remove(item);classes.add(item); break;}
        return  "111";
    }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/class/{classID}/student/{studentID}",method = RequestMethod.DELETE)
    public   void classDelete(@PathVariable("classID") Integer classId,@PathVariable("studentID") Integer studentId)
    {
        for(ClassVO item:classes)
            if(item.getId()==classId)
            {classes.remove(item);list1.add(item); break;}

    }
}
