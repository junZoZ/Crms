package xmu.crms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xmu.crms.entity.ClassInfo;
import xmu.crms.entity.Course;
import xmu.crms.exception.CourseNotFoundException;
import xmu.crms.exception.InfoIllegalException;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.service.ClassService;
import xmu.crms.service.CourseService;
import xmu.crms.service.SeminarService;
import xmu.crms.service.UserService;

import java.math.BigInteger;
import java.util.List;

/**
 * @author zhoujian
 * Created  on 2017/12/19.
 */
@Mapper
@Component
public interface CourseMapper {
    /**
     * 按userId获取与当前用户相关联的课程列表.
     * <p>老师与他相关联的课程列表<br>
     * @author ZhouZhongjun
     * @param userId 用户Id
     * @return null 课程列表
     * @exception InfoIllegalException userId格式错误时抛出
     * @exception CourseNotFoundException 未找到课程
     */
    List<Course> listCourseByUserId(@Param("userId") BigInteger userId);

    /**
     * 按userId创建课程.
     * @author ZhouZhongjun
     * @param userId 用户Id
     * @param course 课程信息
     * @return courseId 新建课程的id
     * @exception InfoIllegalException userId格式错误时抛出
     */
    void insertCourseByUserId(@Param("userId") BigInteger userId,@Param("course") Course course);

    /**
     * 按courseId获取课程 .
     * @author ZhouZhongjun
     * @param courseId 课程Id
     * @return course
     * @exception InfoIllegalException courseId格式错误时抛出
     * @exception CourseNotFoundException 未找到课程
     */
    Course getCourseByCourseId(@Param("courseId") BigInteger courseId);

    /**
     * 传入courseId和course信息修改course信息.
     * @author ZhouZhongjun
     * @param courseId 课程Id
     * @param course 课程信息
     * @return true修改成功  false修改失败
     */
    Boolean updateCourseByCourseId(@Param("courseId") BigInteger courseId,@Param("course") Course course);

    /**
     * 按courseId删除课程.
     * <p>先根据courseID删除Seminar 和 class,然后再将course的信息删除<br>
     * @author ZhouZhongjun
     * @param courseId 课程Id
     * @see SeminarService #deleteSemiarByCourseId(BigInteger courseId)
     * @see ClassService   #deleteClassByCourseId(BigInteger courseId)
     * @return true删除成功  false删除失败
     * @exception InfoIllegalException courseId格式错误时抛出
     * @exception CourseNotFoundException 未找到课程
     */
    Boolean deleteCourseByCourseId(@Param("courseId")BigInteger courseId);

    /**
     * 根据课程名称获取课程列表.
     * <p>根据课程名称获取课程列表<br>
     * @author YeXiaona
     * @param courseName 课程名称
     * @return list 课程列表
     * @see CourseService #getCourseByCourseId(BigInteger courseId)
     * @exception InfoIllegalException courseId格式错误时抛出
     * @exception CourseNotFoundException 未找到课程
     */
    List<Course> listCourseByCourseName(@Param("courseName") String courseName);

}
