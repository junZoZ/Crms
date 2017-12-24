package xmu.crms.mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.crms.entity.Event;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimerMapperTest {

    @Autowired
    TimerMapper timerMapper;

    @Test
    public void insertEvent()
    {
        Event event=new Event();
        event.setId(new BigInteger("10"));
        event.setBeanName("TopicService");
        event.setMethodName("listTopicBySeminarId");
        event.setParameter("123");
        event.setTime(new Date());
        Integer res=timerMapper.insertEvent(event);
    }

    @Test
    public void getEventByEventId()
    {
        Event event=timerMapper.getEventByEventId(new BigInteger("5"));
    }

    @Test
    public void deleteEvent()
    {
        timerMapper.deleteEvent(new BigInteger("5"));
    }

    @Test
    public void  updateEvent()
    {
        Event event=new Event();
        event.setId(new BigInteger("10"));
        event.setBeanName("TopicService");
        event.setMethodName("listTopicBySeminarId");
        event.setParameter("123");
        event.setTime(new Date());
        Integer res=timerMapper.insertEvent(event);
    }

    @Test
    public void listExecutableEvents()
    {
        List<Event> list=timerMapper.listExecutableEvents();
    }
}
