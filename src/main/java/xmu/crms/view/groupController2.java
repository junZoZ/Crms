package xmu.crms.view;

import xmu.crms.vo.People;
import xmu.crms.vo.groupscoreVo;
import xmu.crms.vo.seminarVo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class groupController2 {
    class Inner
    {
        List<groupscoreVo> list = new ArrayList<groupscoreVo>(16);
        public Inner()//测试例子
        {
            ArrayList<People>  member=new ArrayList<People>();
            member.add(new People(2,"张三"));
            list.add(new groupscoreVo(1,"A","1-A-2",new People(1,"余周周"),member,5,"已提交",5,5,"../../abc.pdf"));
            ArrayList<People>  member1=new ArrayList<People>();
            member1.add(new People(4,"李四"));
            list.add(new groupscoreVo(2,"A","1-A-1",new People(3,"林杨"),member1,5,"已提交",5,5,"../../abc.pdf"));
            ArrayList<People>  member2=new ArrayList<People>();
            member2.add(new People(6,"王五"));
            member2.add(new People(7,"赵六"));
            list.add(new groupscoreVo(3,"A","1-A-3",new People(5,"陈滨"),member2,5,"已提交",5,5,"../../abc.pdf"));
        }
    }
    class Selist
    {
        List<seminarVo> list=new ArrayList<seminarVo> (16);
        public Selist()
        {
            ArrayList<Integer>  l=new ArrayList<Integer>();
            l.add(1);
            l.add(2);
            l.add(3);
            seminarVo a=new seminarVo(5,l);
            list.add(a);
        }
    }
        Inner form=new Inner();
        Selist se=new Selist();
    //ScoreHome的GET
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/seminar/{seminarId}/group",method = RequestMethod.GET)
    @ResponseBody
    public List<Integer> index4(@PathVariable ("seminarId") Integer sid){
        for(seminarVo item:se.list)
            if(item.getId()==sid)
                return item.getGroupid();
        return null;
    }

    //ScoreHome get
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/group/{groupId}",method = RequestMethod.GET)
    @ResponseBody
    public groupscoreVo index5(@PathVariable ("groupId") Integer sid){
        for(groupscoreVo item:form.list)
            if(item.getId()==sid)
                return item;
        return null;
    }
    //scorereport put
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/group/{groupId}/grade",method = RequestMethod.PUT)
    @ResponseBody
    public void index6(@PathVariable ("groupId") Integer sid, @RequestBody Integer a) {
        for(groupscoreVo item:form.list)
            if(item.getId()==sid)
            {item.setReportScore(a); }
    }
}
