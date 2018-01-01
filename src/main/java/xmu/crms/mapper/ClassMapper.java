package xmu.crms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xmu.crms.entity.*;
import xmu.crms.exception.CourseNotFoundException;

import java.math.BigInteger;
import java.util.List;

/**
 * @author status200
 * @date 2017/12/19
 */
@Mapper
@Component
public interface ClassMapper {

    /**
     * 根据课堂id删除CourseSelection中的选课记录。
     *
     * @param classId 课堂id
     */
    void deleteCourseSelectionByClassId(BigInteger classId);

    /**
     * 按班级id获取班级详情.
     * <p>
     * 根据班级id获取班级<br>
     *
     * @param classId 班级id
     * @return 班级信息
     */
    ClassInfo getClassByClassId(BigInteger classId);

    /**
     * 按班级id和班级修改班级信息.
     * <p>
     * 根据班级id修改班级信息<br>
     *
     * @param classId 班级ID
     */
    Boolean updateClassByClassId(@Param("classId") BigInteger classId, @Param("newClass") ClassInfo newClass);

    /**
     * 根据课程ID获得班级列表.
     *
     * @param courseId
     * @return
     * @throws CourseNotFoundException
     */
    List<ClassInfo> listClassByCourseId(BigInteger courseId);


    /**
     * 根据学生id和班级id插入一条选课记录
     *
     * @param courseSelection 选课实体
     * @return 插入的记录数量
     */
    Integer insertCourseSelectionById(@Param("courseSelection") CourseSelection courseSelection);


    /**
     * 学生按班级id和用户id取消选择班级.
     * <p>
     * 根据班级id和用户id删除选课记录及与该班级相关的信息<br>
     *
     * @param userId  用户id
     * @param classId 班级id
     * @return 删除的记录的数量
     * @author yexiaona
     */
    Integer deleteCourseSelectionByStudentIdAndClassId(@Param("userId") BigInteger userId, @Param("classId") BigInteger classId);


    /**
     * 按classId删除ScoreRule.
     * ScoreRule在class_info表中.
     * 实际上调用的是update.
     *
     * @param classId 班级Id
     * @return 删除的数量
     */
    Boolean deleteScoreRuleById(@Param("classId") BigInteger classId);


    /**
     * 查询评分规则.
     * <p>
     * 按id查询指定的评分规则<br>
     *
     * @param classId 班级id
     * @return 查询出来的班级
     */
    ClassInfo getScoreRuleByClassId(@Param("classId") BigInteger classId);


    /**
     * 新增评分规则.
     * <p>
     * 新增评分规则<br>
     *
     * @param classId     班级id
     * @param proportions 评分规则
     * @return 修改的行数
     */
    Boolean updateScoreRuleById(@Param("classId") BigInteger classId, @Param("proportions") ClassInfo proportions);


    /**
     * 新建班级.
     * <p>
     * 根据课程id新建班级<br>
     *
     * @return classId 班级Id
     * @author ixing
     */
    Boolean insertClassById(@Param("classInfo") ClassInfo classInfo);

    /**
     * 根据班级id删除该班级
     *
     * @param classId
     * @return
     */
    Boolean deleteClassById(@Param("classId") BigInteger classId);

    /**
     * 判断某个course是否存在
     *
     * @param courseId
     * @return 存在返回1，否则返回0
     */
    Integer countCourseByCourseId(@Param("courseId") BigInteger courseId);

    /**
     * 判断某个class是否存在
     *
     * @param classId
     * @return 存在返回1，否则返回0
     */
    Integer countClassByClassId(@Param("classId") BigInteger classId);

    /**
     * 根据课程名称取得所有课程
     *
     * @param courseName
     * @return
     */
    List<Course> listCourseByCourseName(@Param("courseName") String courseName);

    /**
     * 根据课程id查询课程
     *
     * @param courseId
     * @return
     */
    Course getCourseById(@Param("courseId") BigInteger courseId);

    /**
     * 根据教师id查询教师
     *
     * @param teacherId
     * @return
     */
    User getTeacherByTeacherId(@Param("teacherId") BigInteger teacherId);

    /**
     * 根据学校id查询学校
     *
     * @param schoolId
     * @return
     */
    School getSchoolBySchoolId(@Param("schoolId") BigInteger schoolId);

    /**
     * 根据用户名称查询用户
     *
     * @param username
     * @return
     */
    List<User> listUserByUsername(@Param("username") String username);

    /**
     * 根据用户id查询class
     *
     * @param userId
     * @return
     */
    List<ClassInfo> listClassByUserId(@Param("userId") BigInteger userId);

    /**
     * 判断某个用户是否存在
     *
     * @param userId
     * @return
     */
    Integer countUserByUserId(@Param("userId") BigInteger userId);


    /**
     * 往location插入一条新记录
     *
     * @param location
     * @return
     */
    Boolean insertLocation(@Param("location") Location location);

    /**
     * 更新location的信息。只更新不为空的属性。
     *
     * @param location
     * @return
     */
    Boolean updateLocationById(@Param("location") Location location);

    /**
     * 根据seminarId计数
     *
     * @param seminarId
     * @return
     */
    Integer countSeminarById(@Param("seminarId") BigInteger seminarId);

    /**
     * 按照SeminarId和ClassId修改Location
     *
     * @param location
     * @return
     */
    Boolean updateLocationBySeminarIdAndClassId(@Param("location") Location location);

    /**
     * 按照SeminarId和ClassId查询Location
     *
     * @param seminarId
     * @param classId
     * @return
     */
    Location getLocationBySeminarIdAndClassId(@Param("seminarId") BigInteger seminarId, @Param("classId") BigInteger classId);

    /**
     * 根据id查询seminar
     *
     * @param seminarId
     * @return
     */
    Seminar getSeminarById(@Param("seminarId") BigInteger seminarId);


    /**
     * 根据teacherId查询Class
     *
     * @param teacherId
     * @return
     */
    List<ClassInfo>  listClassByTeacherId(@Param("teacherId") BigInteger teacherId);

}
