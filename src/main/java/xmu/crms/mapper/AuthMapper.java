package xmu.crms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xmu.crms.entity.School;
import xmu.crms.entity.User;

import java.math.BigInteger;

/**
 *
 * @author status200
 * @date 2017/12/24
 */
@Mapper
@Component
public interface AuthMapper {

    /**
     * 根据微信的openId获得
     *
     * @param openId
     * @return
     */
    User getUserByOpenId(@Param("openId") String openId);

    /**
     * 根据学校id查询学校
     *
     * @param schoolId
     * @return
     */
    School getSchoolBySchoolId(@Param("schoolId") BigInteger schoolId);
}
