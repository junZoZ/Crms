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
	 * fjgfdglkdfg
	 * @param userId
	 * @return
	 */
	User getUserByUserIdBigInteger(@Param("userId") BigInteger userId);

	/**
	 *  返回签到序列
	 * @param classId
	 * @param seminarId
	 * @param userId
	 * @return
	 */
	BigInteger getIdByInfo(@Param("classId") BigInteger classId, @Param("seminarId") BigInteger seminarId, @Param("userId")
            BigInteger userId);

	/**
	 * 插入学生签到信息
	 * @param classId
	 * @param seminarId
	 * @param userId
	 */
	void insertAttendanceById(@Param("classId") BigInteger classId, @Param("seminarId") BigInteger seminarId, @Param("userId")
            BigInteger userId);

	/**
	 * 获取经度
	 * @param seminarId
	 * @param classId
	 * @return seminarId
	 */
	double getLongitude(@Param("seminarId") BigInteger seminarId, @Param("classId") BigInteger classId);

	/**
	 * 获取纬度
	 * @param seminarId
	 * @param classId
	 * @return
	 */
	double getLatitude(@Param("seminarId") BigInteger seminarId, @Param("classId") BigInteger classId);

	/**
	 * cvmblkc
	 * @param seminarId
	 * @param classId
	 * @return
	 */
	List<User> listAbsenceStudent(@Param("seminarId") BigInteger seminarId, @Param("classId") BigInteger classId);

	/**
	 * khfgpoh
	 * @param seminarId
	 * @param classId
	 * @return
	 */
	List<Attendance> listAttendanceById(@Param("seminarId") BigInteger seminarId, @Param("classId") BigInteger classId);

	/**
	 * jfiohjfgioh
	 * @param userName
	 * @return
	 */
	List<Course>listCourseByTeacherName(@Param("userName") String userName);

	/**
	 * jfghfgioh
	 * @param seminarId
	 * @param classId
	 * @return
	 */
	List<User>listLateStudent(@Param("seminarId") BigInteger seminarId, @Param("classId") BigInteger classId);

	/**
	 * jfighfoi
	 * @param seminarId
	 * @param classId
	 * @return
	 */
	List<User> listPresentStudent(@Param("seminarId") BigInteger seminarId, @Param("classId") BigInteger classId);

	/**
	 * kohgfkog
	 * @param classId
	 * @param numBeginWith
	 * @param nameBeginWith
	 * @return
	 */
	List<User>listUserByClassId(@Param("classId") BigInteger classId, @Param("numBeginWith") String numBeginWith, @Param("nameBeginWith") String nameBeginWith);

	/**
	 * kogkhko
	 * @param userName
	 * @return
	 */
	List<User>listUserByUserName(@Param("userName") String userName);

	/**
	 * fgohifoh
	 * @param userName
	 * @return
	 */
	List<BigInteger> listUserIdByUserName(@Param("userName") String userName);

	/**
	 * kogphkpog
	 * @param userId
	 * @param user
	 */
	void updateUserByUserId(@Param("userId") BigInteger userId, @Param("user") User user);
}
