package xmu.crms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xmu.crms.entity.*;
import xmu.crms.exception.GroupNotFoundException;
import xmu.crms.service.GradeService;
import xmu.crms.service.SeminarGroupService;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by status200 on 2017/12/19.
 */
@Mapper
@Component
public interface GradeMapper {
    /**
     * 按seminarGroupTopicId删除学生打分表
     * @param seminarGroupTopicId  小组话题表的Id
     */
    void deleteStudentScoreGroupByTopicId(@Param("seminarGroupTopicId") BigInteger seminarGroupTopicId);
    /**
     * 获取学生某一堂讨论课的小组信息.
     * @param seminarGroupId 讨论课小组id
     * @return seminarGroup 讨论课小组信息（包括成绩)
     */
    SeminarGroup getSeminarGroupBySeminarGroupId(@Param("seminarGroupId") BigInteger seminarGroupId);

    User getUserByUserId(@Param("userId")BigInteger userId);

    School getSchoolBySchoolId(@Param("schoolId")BigInteger schoolId);

    Seminar getSeminarBySeminarId(@Param("seminarId")BigInteger seminarId);

    Course getCourseByCourseId(@Param("courseId")BigInteger courseId);

    ClassInfo getClassInfoByClassId(@Param("classId")BigInteger classId);
    /**
     * 获取某学生所有讨论课的所有成绩
     * <p>获取某学生所有讨论课的详细信息（包括成绩）<br>
     * @param userId 用户id
     * @return list 学生历史讨论课小组列表（包含成绩）
     * @throws IllegalArgumentException userId格式错
     */
    List<SeminarGroup> listSeminarGradeByUserId(BigInteger userId);
    /**
     * 按课程id获取学生该课程所有讨论课
     * @param userId 用户id
     * @param courseId 课程id
     * @return List 该课程下所有讨论课列表
     */
    List<SeminarGroup> listSeminarGradeByCourseId(@Param("userId")BigInteger userId, @Param("courseId")BigInteger courseId);
    /**
     * 提交对其他小组的打分
     */
     BigInteger getSeminarGroupTopicId(@Param("topicId")BigInteger topicId,@Param("seminarGroupId")BigInteger seminarGroupId);
     void insertGroupGradeByUserId(@Param("userId")BigInteger userId, @Param("groupId")BigInteger seminarGroupTopicId, @Param("grade")BigInteger grade);
    /**
     * 按ID设置小组报告分.
     */
    void updateGroupByGroupId(@Param("seminarGroupId") BigInteger seminarGroupId, @Param("grade") BigInteger grade);
    /**
     * 定时器方法.
     * 讨论课结束后计算展示得分.
     * @param seminarId
     * @throws IllegalArgumentException seminarId或seminarGroupId格式错误
     */
    List<BigInteger> getSeminarGroupIdBySeminarId(@Param("seminarId")BigInteger seminarId);
    List<BigInteger> getSeminarGroupTopicIdBySeminarGroupId(@Param("seminarGroupId")BigInteger seminarGroupId);
    List<Integer> getGradeBySeminarGroupTopicId(@Param("seminarGroupTopicId")BigInteger seminarGroupTopicId);
    void updatePresentationGradeBySeminarGroupTopicId(@Param("seminarGroupTopicId")BigInteger seminarGroupTopicId,@Param("grade")int grade);
    void updatePresentationGradeBySeminarGroupId(@Param("seminarGroupId")BigInteger seminarGroupId,@Param("grade")int grade);
    /**
     * 定时器方法.
     * 讨论课结束后计算本次讨论课得分.
     * <p>条件: 讨论课已结束，展示得分已算出<br>*GradeService<br>
     * @throws IllegalArgumentException seminarId或seminarGroupId格式错误
     */
    int getPresentationGradeBySeminarGroupId(@Param("seminarGroupId")BigInteger seminarGroupId);
    int getReportGradeBySeminarGroupId(@Param("seminarGroupId")BigInteger seminarGroupId);
    BigInteger getCourseIdBySeminarId(@Param("seminarId")BigInteger seminarId);
    int getFivePercentageByCourseId(@Param("courseId")BigInteger courseId);
    int getFourPercentageByCourseId(@Param("courseId")BigInteger courseId);
    int getThreePercentageByCourseId(@Param("courseId")BigInteger courseId);
    void updateFinalGradeBySeminarGroupId(@Param("seminarGroupId")BigInteger seminarGroupId,@Param("grade")int grade);
}
