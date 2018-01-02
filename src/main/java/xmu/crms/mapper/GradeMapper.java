package xmu.crms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xmu.crms.entity.*;
import xmu.crms.exception.GroupNotFoundException;
import xmu.crms.service.GradeService;
import xmu.crms.service.SeminarGroupService;
import java.lang.*;
import java.math.BigInteger;
import java.util.List;



/**
 * @author  lyh
 *  Created by status200 on 2017/12/19.
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

    /**
     * gfdgfg
     * @param userId
     * @return
     */
    User getUserByUserId(@Param("userId")BigInteger userId);

    /**
     * dfdd
     * @param schoolId
     * @return
     */
    School getSchoolBySchoolId(@Param("schoolId")BigInteger schoolId);

    /**
     * klfdg
     * @param seminarId
     * @return
     */
    Seminar getSeminarBySeminarId(@Param("seminarId")BigInteger seminarId);

    /**
     * irdo
     * @param courseId
     * @return
     */
    Course getCourseByCourseId(@Param("courseId")BigInteger courseId);

    /**
     * ifod
     * @param classId
     * @return
     */
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
     * jdifhoi
     * @param topicId
     * @param seminarGroupId
     * @return
     */
     BigInteger getSeminarGroupTopicId(@Param("topicId")BigInteger topicId,@Param("seminarGroupId")BigInteger seminarGroupId);

    /**
     * ftiojhfj
     * @param userId
     * @param seminarGroupTopicId
     * @param grade
     */
     void insertGroupGradeByUserId(@Param("userId")BigInteger userId, @Param("groupId")BigInteger seminarGroupTopicId, @Param("grade")BigInteger grade);

    /**
     * iofghjfio
     * @param seminarGroupId
     * @param grade
     */
    void updateGroupByGroupId(@Param("seminarGroupId") BigInteger seminarGroupId, @Param("grade") BigInteger grade);

    /**
     * jthofjoigh
     * @param seminarId
     * @return
     */
    List<BigInteger> getSeminarGroupIdBySeminarId(@Param("seminarId")BigInteger seminarId);

    /**
     * jgfihj
     * @param seminarGroupId
     * @return
     */
    List<BigInteger> getSeminarGroupTopicIdBySeminarGroupId(@Param("seminarGroupId")BigInteger seminarGroupId);

    /**
     * jgiohfh
     * @param seminarGroupTopicId
     * @return
     */
    List<Integer> getGradeBySeminarGroupTopicId(@Param("seminarGroupTopicId")BigInteger seminarGroupTopicId);

    /**
     * jgiohjhfiog
     * @param seminarGroupTopicId
     * @param grade
     */
    void updatePresentationGradeBySeminarGroupTopicId(@Param("seminarGroupTopicId")BigInteger seminarGroupTopicId,@Param("grade")int grade);

    /**
     * joifghjfoijh
     * @param seminarGroupId
     * @param grade
     */
    void updatePresentationGradeBySeminarGroupId(@Param("seminarGroupId")BigInteger seminarGroupId,@Param("grade")int grade);

    /**
     * jitfouitf
     * @param seminarGroupId
     * @return
     */
    Integer getPresentationGradeBySeminarGroupId(@Param("seminarGroupId")BigInteger seminarGroupId);

    /**
     * jiofgji
     * @param seminarGroupId
     * @return
     */
    Integer getReportGradeBySeminarGroupId(@Param("seminarGroupId")BigInteger seminarGroupId);

    /**
     * fithopfih
     * @param seminarId
     * @return
     */
    BigInteger getCourseIdBySeminarId(@Param("seminarId")BigInteger seminarId);

    /**
     * iofgjhoig
     * @param courseId
     * @return
     */
    Integer getFivePercentageByCourseId(@Param("courseId")BigInteger courseId);

    /**
     * jfioghfh
     * @param courseId
     * @return
     */
    Integer getFourPercentageByCourseId(@Param("courseId")BigInteger courseId);

    /**
     * jtflhjtofihj
     * @param courseId
     * @return
     */
    Integer getThreePercentageByCourseId(@Param("courseId")BigInteger courseId);

    /**
     * jgoifjioh
     * @param seminarGroupId
     * @param grade
     */
    void updateFinalGradeBySeminarGroupId(@Param("seminarGroupId")BigInteger seminarGroupId,@Param("grade")int grade);
}
