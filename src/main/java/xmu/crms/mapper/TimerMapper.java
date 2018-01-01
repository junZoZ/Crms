package xmu.crms.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import xmu.crms.entity.Event;

import java.math.BigInteger;
import java.util.List;

@Mapper
@Component

/**
 * @author zzj
 * */
public interface TimerMapper {

    /**
     * ss
     * @param event
     * @return
     */
    Integer insertEvent(Event event);

    /**
     * sdf
     * @param eventId
     */
    void deleteEvent(BigInteger eventId);

    /**
     * fgdf
     * @param event
     */
    void  updateEvent(Event event);

    /**
     * tghfgh
     * @return
     */
    List<Event> listExecutableEvents();

    /**
     * jgfjf
     * @param eventId
     * @return
     */
    Event getEventByEventId(BigInteger eventId);
}
