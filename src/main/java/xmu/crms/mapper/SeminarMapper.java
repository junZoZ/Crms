package xmu.crms.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import xmu.crms.entity.Seminar;
import xmu.crms.exception.CourseNotFoundException;
import xmu.crms.exception.SeminarNotFoundException;
import xmu.crms.service.SeminarGroupService;
import xmu.crms.service.SeminarService;
import xmu.crms.service.TopicService;

import java.math.BigInteger;
import java.util.List;

@Mapper
@Component
/**
 * @author zzj
 * */

public interface SeminarMapper {

    /**
     * 按courseId获取Seminar.
     * @author zhouzhongjun
     * @param courseId 课程Id
     * @return List 讨论课列表
     */
    List<Seminar> listSeminarByCourseId(BigInteger courseId);

    /**
     * 按courseId删除Seminar.
     * <p>将seminar的信息删除<br>
     * @author zhouzhongjun
     * @param courseId 课程Id
     * @return deleteNumber
     */
    Integer deleteSeminarByCourseId(BigInteger courseId);

    /**
     * 用户通过讨论课id获得讨论课的信息.
     * <p>用户通过讨论课id获得讨论课的信息（包括讨论课名称、讨论课描述、分组方式、开始时间、结束时间）<br>
     * @author zhouzhongjun
     * @param seminarId 讨论课的id
     * @return 相应的讨论课信息
     */
    Seminar getSeminarBySeminarId(BigInteger seminarId);

    /**
     * 按讨论课id修改讨论课.
     * <p>用户（老师）通过seminarId修改讨论课的相关信息<br>
     * @author zhouzhongjun
     * @param seminar 讨论课信息
     * @return updateNumber
     */
    Integer updateSeminarBySeminarId( Seminar seminar);

    /**
     * 按讨论课id删除讨论课.
     * <p>用户（老师）通过seminarId删除讨论课<br>(包括删除讨论课包含的topic信息和小组信息).
     * @author zhouzhongjun
     * @param seminarId 讨论课的id
     * @return deleteNumber
     */
    Integer deleteSeminarBySeminarId(BigInteger seminarId);

    /**
     * 新增讨论课.
     * <p>用户（老师）在指定的课程下创建讨论课<br>
     * @author zhouzhongjun
     * @param seminar 讨论课信息
     * @return seminarId 若创建成功返回创建的讨论课id，失败则返回-1
     */
    Integer insertSeminarByCourseId(Seminar seminar);
}
