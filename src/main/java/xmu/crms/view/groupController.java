package xmu.crms.view;

import xmu.crms.dto.TopicDTO;
import xmu.crms.vo.fixedgroupVo;
import xmu.crms.vo.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xmu.crms.vo.groupscoreVo;

import java.util.ArrayList;

@RestController
public class GroupController {
    class testgroup
    {
        fixedgroupVo  example=new fixedgroupVo();

        public testgroup()
        {
            Student s1=new Student(2757,"张三","23320152202333");
            Student s2=new Student(2756,"李四","23320152202443");
            Student s3=new Student(2777,"王五","23320152202433");
            ArrayList<Student> list=new ArrayList<Student>();
            list.add(s2);
            list.add(s3);
            example.setLeader(s1);
            example.setMember(list);
        }

        public  Student Del(Integer id) {


            ArrayList<Student> list = new ArrayList(example.getMember());
            Student s = new Student();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equals(id)) {
                    s = list.get(i);
                    list.remove(i);
                    example.setMember(list);
                    break;

                }
            }
            return s;
        }

        public  void add(Student s) {

            ArrayList<Student> list = new ArrayList(example.getMember());
            list.add(s);
            example.setMember(list);
        }


    }

    class testGroupAll {
        fixedgroupVo example = new fixedgroupVo();

        public testGroupAll(){
            Student s1 = new Student(2760, "张四", "23320152202353");
            Student s2 = new Student(2765, "张五", "23320152202493");
            Student s3 = new Student(2799, "王八", "23320152202473");
            Student s4 = new Student(2796, "王六", "233201522024t3");
            Student s5 = new Student(2794, "王九", "233201522024t3");
            ArrayList<Student> list = new ArrayList<Student>();
            list.add(s1);
            list.add(s2);
            list.add(s3);
            list.add(s4);
            list.add(s5);

            example.setMember(list);
        }


        public  Student Del(Integer id) {


            ArrayList<Student> list = new ArrayList(example.getMember());
            Student s = new Student();
            for(int i=0;i<list.size();i++)
            {
                if(list.get(i).getId().equals(id)) {

                    s =list.get(i);
                    list.remove(i);
                    break;
                }
            }

            example.setMember(list);
            return s;

        }

        public  void add(Student s) {

            ArrayList<Student> list = new ArrayList(example.getMember());
            list.add(s);
            example.setMember(list);
        }

        public fixedgroupVo choose(String stringId,String name) {



            ArrayList<Student> list = new ArrayList();
            for(int i=0;i<example.getMember().size();i++)
            {

                if( (name.isEmpty()||example.getMember().get(i).getName().contains(name) )&&
                        ( stringId.isEmpty()||example.getMember().get(i).getNumber().toString().contains(stringId))) {

                    list.add(example.getMember().get(i));
                }
            }
            fixedgroupVo temp = new fixedgroupVo(example.getLeader(),example.getMember());

            temp.setMember(list);

            return  temp;

        }

    }

    testgroup ex = new testgroup();
    testGroupAll exall = new testGroupAll();

    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value="/group/{groupID}/topic",method = RequestMethod.POST)
    public String topicChoose(@PathVariable("groupID") Integer groupId,  @RequestBody TopicDTO tid)
    {
        return "1111";
    }
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/class/{classId}/classgroup", method = RequestMethod.GET)
    @ResponseBody
    public fixedgroupVo index1(@PathVariable("classId") Integer sid) {

        return ex.example;
    }
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/group/{groupId}/remove", method = RequestMethod.PUT)
    @ResponseBody
    public void index2(@PathVariable("groupId") Integer groupId, @RequestBody Integer memberId) {
        System.out.println(memberId);
        Student s= ex.Del(memberId);
        exall.add(s);

    }

    //ScoreHome get
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/group/{groupId}",method = RequestMethod.GET)
    @ResponseBody
    public groupscoreVo index5(@PathVariable ("groupId") Integer sid){

        return null;
    }
    //scorereport put
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/group/{groupId}/grade",method = RequestMethod.PUT)
    @ResponseBody
    public void index6(@PathVariable ("groupId") Integer sid, @RequestBody Integer a) {

    }

}
