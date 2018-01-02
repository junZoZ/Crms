package xmu.crms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.crms.entity.SeminarGroup;
import xmu.crms.exception.GroupNotFoundException;
import xmu.crms.mapper.GradeMapper;
import xmu.crms.service.GradeService;

import javax.validation.constraints.Null;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/**
 * @author zzj
 * */

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeMapper gradeMapper;
    @Override
    /**
     * 按seminarGroupTopicId删除学生打分表.
     *
     * @param seminarGroupTopicId  小组话题表的Id
     * @throws IllegalArgumentException topicId格式错误时抛出
     */
    public void deleteStudentScoreGroupByTopicId(BigInteger seminarGroupTopicId) throws IllegalArgumentException {
        if(!(seminarGroupTopicId instanceof BigInteger)){
            throw new IllegalArgumentException();
        }
        else{
            gradeMapper.deleteStudentScoreGroupByTopicId(seminarGroupTopicId);
        }
    }
    /**
     * 获取学生某一堂讨论课的小组信息.
     * <p>获取某学生一堂讨论课的小组信息（包括成绩）<br>
     *
     * @param seminarGroupId 讨论课小组id
     * @return seminarGroup 讨论课小组信息（包括成绩）
     * @throws xmu.crms.exception.GroupNotFoundException 无此小组
     * @throws IllegalArgumentException                  userId或seminarGrouopId格式错误
     */
    @Override
    public SeminarGroup getSeminarGroupBySeminarGroupId(BigInteger seminarGroupId) throws GroupNotFoundException, IllegalArgumentException {
        if(!(seminarGroupId instanceof BigInteger)){
            throw new IllegalArgumentException();
        }
        else {
            return gradeMapper.getSeminarGroupBySeminarGroupId(seminarGroupId);
        }
    }
    /**
     * 获取某学生所有讨论课的所有成绩
     * @param userId 用户id
     * @return list 学生历史讨论课小组列表（包含成绩）
     * @throws IllegalArgumentException userId格式错误
     */
    @Override
    public List<SeminarGroup> listSeminarGradeByUserId(BigInteger userId) throws IllegalArgumentException {
        if(!(userId instanceof BigInteger)) {
            throw new IllegalArgumentException();
        }
        else{
            return gradeMapper.listSeminarGradeByUserId(userId);
        }
    }
    /**
     * 按课程id获取学生该课程所有讨论课
     * @param userId 用户id
     * @param courseId 课程id
     * @return List 该课程下所有讨论课列表
     */
    @Override
    public List<SeminarGroup> listSeminarGradeByCourseId(BigInteger userId, BigInteger courseId) throws IllegalArgumentException {
        if(!(userId instanceof BigInteger)) {
            throw new IllegalArgumentException();
        }
        else if(!(courseId instanceof BigInteger)){
            throw new IllegalArgumentException();
        }
        else{
            return gradeMapper.listSeminarGradeByCourseId(userId,courseId);
        }
    }
    /**
     * 提交对其他小组的打分.
     *
     * @param userId    用户id
     * @param groupId   小组Id
     * @param grade     分数
     * @param topicId   话题id
     * @throws IllegalArgumentException topicId或userId或seminarId或groupId或grade格式错
     */
    @Override
    public void insertGroupGradeByUserId(BigInteger topicId, BigInteger userId, BigInteger groupId, BigInteger grade) throws IllegalArgumentException {
        if(!(topicId instanceof BigInteger)||!(userId instanceof BigInteger)||!(groupId instanceof BigInteger)||!(topicId instanceof BigInteger)){
            throw new IllegalArgumentException();
        }
        else {
            BigInteger seminarGroupTopicId = gradeMapper.getSeminarGroupTopicId(topicId, groupId);
            gradeMapper.insertGroupGradeByUserId(userId, seminarGroupTopicId, grade);
        }
    }

    @Override
    public void updateGroupByGroupId(BigInteger seminarGroupId, BigInteger grade) throws GroupNotFoundException, IllegalArgumentException {
        if(!(seminarGroupId instanceof BigInteger)){
            throw new IllegalArgumentException();
        }
        else if(!(grade instanceof  BigInteger)){
            throw new IllegalArgumentException();
        }
        else{
            gradeMapper.updateGroupByGroupId(seminarGroupId,grade);
        }
    }
    /**
     * 定时器方法.
     * 讨论课结束后计算展示得分.
     * @param seminarId      讨论课Id
     * @throws IllegalArgumentException seminarId或seminarGroupId格式错误
     */
    @Override
    public void countPresentationGrade(BigInteger seminarId) throws IllegalArgumentException {
        if(!(seminarId instanceof BigInteger)){
            throw new IllegalArgumentException();
        }
        List<BigInteger> seminarGroupId=gradeMapper.getSeminarGroupIdBySeminarId(seminarId);
        for(BigInteger z:seminarGroupId) {
            List<BigInteger> seminarGroupTopicId = gradeMapper.getSeminarGroupTopicIdBySeminarGroupId(z);
            int size = seminarGroupTopicId.size();
            int countGroup = 0;
            int[] countTopic = new int[size];
            int count = 0;
            for (BigInteger x : seminarGroupTopicId) {
                List<Integer> grade = gradeMapper.getGradeBySeminarGroupTopicId(x);
                for (Integer y : grade) {
                    countTopic[count] += y;
                }
                if(grade.size()!=0){
                    gradeMapper.updatePresentationGradeBySeminarGroupTopicId(x,countTopic[count] / grade.size());
                }
                count++;
            }
            for (int x : countTopic) {
                countGroup += x;
            }
            countGroup = countGroup / size;
            gradeMapper.updatePresentationGradeBySeminarGroupId(z, countGroup);
        }
    }
    /**
     * 定时器方法.
     * 讨论课结束后计算本次讨论课得分.
     * @param seminarId      讨论课ID
     * @throws IllegalArgumentException seminarId或seminarGroupId格式错误
     */
    @Override
    public void countGroupGradeBySeminarId(BigInteger seminarId) throws IllegalArgumentException {
        //获得百分比
        BigInteger courseId = gradeMapper.getCourseIdBySeminarId(seminarId);
        System.out.println(courseId);
        int fivePointPercentage = gradeMapper.getFivePercentageByCourseId(courseId);
        int fourPointPercentage = gradeMapper.getFourPercentageByCourseId(courseId);
        int threePointPercentage = gradeMapper.getThreePercentageByCourseId(courseId);
        //获取所有group的分数
        List<BigInteger> seminarGroupId = gradeMapper.getSeminarGroupIdBySeminarId(seminarId);
        int[] groupGrade = new int[seminarGroupId.size()];
        BigInteger[] seminarGroupIdArray = new BigInteger[seminarGroupId.size()];
        int count = 0;
        for(BigInteger x:seminarGroupId){
            if(gradeMapper.getReportGradeBySeminarGroupId(x)==null){
                return;
            }
        }
        for (BigInteger x : seminarGroupId) {
            seminarGroupIdArray[count] = x;
            count++;
        }
        count = 0;
        if (seminarGroupId.size() <= 0) {
            return ;
        }
        else {
            for (BigInteger x : seminarGroupId) {
                int presentageGrade = gradeMapper.getPresentationGradeBySeminarGroupId(x);
                int reportGrade = gradeMapper.getReportGradeBySeminarGroupId(x);
                groupGrade[count] = presentageGrade + reportGrade;
                count++;
            }
            //冒泡排序分数和seminarGroupId
            for (int i = 0; i < seminarGroupId.size(); i++) {
                for (int j = i + 1; j < seminarGroupId.size(); j++) {
                    if (groupGrade[i] < groupGrade[j]) {
                        int temp = groupGrade[i];
                        groupGrade[i] = groupGrade[j];
                        groupGrade[j] = temp;
                        BigInteger temp2 = seminarGroupIdArray[i];
                        seminarGroupIdArray[i] = seminarGroupIdArray[j];
                        seminarGroupIdArray[j] = temp2;
                    }
                }
            }
            int fiveGroup = (int) Math.floor(fivePointPercentage * 1.0 / 100 * seminarGroupId.size());
            int fourGroup = (int) Math.floor(fourPointPercentage * 1.0 / 100 * seminarGroupId.size());
            int threeGroup = seminarGroupId.size() - fiveGroup - fourGroup;
            fourGroup = fourGroup + fiveGroup;
            for (int i = 0; i < seminarGroupId.size(); i++) {
                if (i < fiveGroup) {
                    groupGrade[i] = 5;
                } else if (i >= fiveGroup && i < fourGroup) {
                    groupGrade[i] = 4;
                } else {
                    groupGrade[i] = 3;
                }
            }
            //更新成绩
            for (int i = 0; i < seminarGroupId.size(); i++) {
                gradeMapper.updateFinalGradeBySeminarGroupId(seminarGroupIdArray[i], groupGrade[i]);
            }
        }
    }
}
