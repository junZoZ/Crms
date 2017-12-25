package xmu.crms.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xmu.crms.entity.User;
import xmu.crms.entity.Attendance;
import xmu.crms.entity.Course;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
/**
 * School Mapper
 * 注意，每个mapper要给其加上一个@Mapper的注解。
 * 且每个mapper都是接口，实现是由mybatis做的,不需要我们实现。
 *
 *
 * @author liuxin
 * @date 2017/12/19
 */
@Mapper
@Component
public interface UserMapper {
/**
 * 根据id得到用户
*/
	User getUserByUserIdBigInteger(@Param("userId") BigInteger userId);
	/**
	 * 返回签到序列
	*/
	BigInteger getIdByInfo(@Param("classId") BigInteger classId, @Param("seminarId") BigInteger seminarId, @Param("userId")
            BigInteger userId);
/**
 * 插入学生签到信息
*/
	void insertAttendanceById(@Param("classId") BigInteger classId, @Param("seminarId") BigInteger seminarId, @Param("userId")
            BigInteger userId);
	/**
	* 获取经度
	*/
	double getLongitude(@Param("seminarId") BigInteger seminarId, @Param("classId") BigInteger classId);
	/**
	* 获取纬度
	*/
	double getLatitude(@Param("seminarId") BigInteger seminarId, @Param("classId") BigInteger classId);
	/**
* 获取讨论课所在班级缺勤学生名单
*/
	List<User> listAbsenceStudent(@Param("seminarId") BigInteger seminarId, @Param("classId") BigInteger classId);

	/**
	 * 
	* 获取学生签到信息.
	*/
	List<Attendance> listAttendanceById(@Param("seminarId") BigInteger seminarId, @Param("classId") BigInteger classId);
	/**
	* 根据教师名称列出课程名称.
	*/
	List<Course>listCourseByTeacherName(@Param("userName") String userName);
	/**
	* 获取讨论课所在班级迟到学生名单.
	*/
	List<User>listLateStudent(@Param("seminarId") BigInteger seminarId, @Param("classId") BigInteger classId);
	/**
	* 获取讨论课所在的班级出勤的学生名单
	*/
	List<User> listPresentStudent(@Param("seminarId") BigInteger seminarId, @Param("classId") BigInteger classId);
	/**
	*按班级ID、学号开头、姓名开头获取学生列表.
	*/
	List<User>listUserByClassId(@Param("classId") BigInteger classId, @Param("numBeginWith") String numBeginWith, @Param("nameBeginWith") String nameBeginWith);
	/**
	*根据用户名获取用户列表.
	*/
	List<User>listUserByUserName(@Param("userName") String userName);
	/**
	*根据用户名获取用户ID.
	*/
	List<BigInteger> listUserIdByUserName(@Param("userName") String userName);
	/**
	*根据用户ID修改用户信息.
	*/
	void updateUserByUserId(@Param("userId") BigInteger userId, @Param("user") User user);
}
