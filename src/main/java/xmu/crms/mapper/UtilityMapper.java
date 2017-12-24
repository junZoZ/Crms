package xmu.crms.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import xmu.crms.entity.*;

import java.math.BigInteger;

@Mapper
@Component
/**
 * @author chenbin
 * */
public interface UtilityMapper {
    /**
     * selectUser.
     *
     * @author cb
     * @param id
     * @return User deleteNumber
     */
        User selectUser(BigInteger id);
    /**
     * selectSchool.
     *
     * @author cb
     * @param id
     * @return School deleteNumber
     */
        School selectSchool(BigInteger id);

    /**
     * selectClass.
     *
     * @author cb
     * @param id
     * @return ClassInfo deleteNumber
     */
    ClassInfo selectClass(BigInteger id);

    /**
     * selectCourse.
     *
     * @author cb
     * @param id
     * @return Course deleteNumber
     */
    Course selectCourse(BigInteger id);

    /**
     * selectFixGroup.
     *
     * @author cb
     * @param id
     * @return FixGroup deleteNumber
     */
    FixGroup selectFixGroup(BigInteger id);

    /**
     * selectSeminar.
     *
     * @author cb
     * @param id
     * @return Seminar deleteNumber
     */
    Seminar selectSeminar(BigInteger id);

    /**
     * selectSeminarGroup.
     *
     * @author cb
     * @param id
     * @return SeminarGroup deleteNumber
     */
    SeminarGroup selectSeminarGroup(BigInteger id);

    /**
     * selectSeminarGroupTopic.
     *
     * @author cb
     * @param id
     * @return SeminarGroupTopic deleteNumber
     */
    SeminarGroupTopic selectSeminarGroupTopic(BigInteger id);

    /**
     * selectTopic.
     *
     * @author cb
     * @param id
     * @return Topic deleteNumber
     */
    Topic selectTopic(BigInteger id);
}
