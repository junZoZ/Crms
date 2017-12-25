package xmu.crms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xmu.crms.entity.Attendance;
import xmu.crms.entity.Course;
import xmu.crms.entity.User;
import xmu.crms.exception.ClassesNotFoundException;
import xmu.crms.exception.CourseNotFoundException;
import xmu.crms.exception.SeminarNotFoundException;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.mapper.UserMapper;
import xmu.crms.service.UserService;

import java.math.BigInteger;
import java.util.List;

/**
 * service要加上一个@Service的注解，以便可以到处注入这个service
 *
 * @author yangkepiao
 * @date 2017/12/19
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public BigInteger insertAttendanceById(BigInteger classId, BigInteger seminarId, BigInteger userId, double longitude,
                                           double latitude)
            throws IllegalArgumentException, ClassesNotFoundException, SeminarNotFoundException, UserNotFoundException {
        // TODO Auto-generated method stub
        double longi = userMapper.getLongitude(seminarId, classId);
        double lati = userMapper.getLatitude(seminarId, classId);
        //经纬度相近
        if ( Math.abs(longi - longitude)<1 && Math.abs(lati - latitude)<1) {
            userMapper.insertAttendanceById(classId, seminarId, userId);
            return userMapper.getIdByInfo(classId, seminarId, userId);
        } else {
            return null;
        }
    }

    @Override
    public List<Attendance> listAttendanceById(BigInteger classId, BigInteger seminarId)
            throws IllegalArgumentException, ClassesNotFoundException, SeminarNotFoundException {
        // TODO Auto-generated method stub
        return userMapper.listAttendanceById(seminarId, classId);

    }

    @Override
    public User getUserByUserId(BigInteger userId) throws IllegalArgumentException, UserNotFoundException {
        // TODO Auto-generated method stub
        return userMapper.getUserByUserIdBigInteger(userId);
    }

    @Override
    public List<BigInteger> listUserIdByUserName(String userName)
            throws IllegalArgumentException, UserNotFoundException {
        // TODO Auto-generated method stub
        return userMapper.listUserIdByUserName(userName);
    }

    @Override
    public void updateUserByUserId(BigInteger userId, User user) throws UserNotFoundException {
        // TODO Auto-generated method stub
        userMapper.updateUserByUserId(userId, user);
    }

    @Override
    public List<User> listUserByClassId(BigInteger classId, String numBeginWith, String nameBeginWith)
            throws IllegalArgumentException, ClassesNotFoundException, UserNotFoundException {
        // TODO Auto-generated method stub
        return userMapper.listUserByClassId(classId, numBeginWith + "%", nameBeginWith + "%");
    }

    @Override
    public List<User> listUserByUserName(String userName) throws UserNotFoundException {
        // TODO Auto-generated method stub
        return userMapper.listUserByUserName(userName);
    }

    @Override
    public List<User> listPresentStudent(BigInteger seminarId, BigInteger classId)
            throws IllegalArgumentException, ClassesNotFoundException, SeminarNotFoundException {
        // TODO Auto-generated method stub
        return userMapper.listPresentStudent(seminarId, classId);
    }

    @Override
    public List<User> listLateStudent(BigInteger seminarId, BigInteger classId)
            throws IllegalArgumentException, ClassesNotFoundException, SeminarNotFoundException {
        // TODO Auto-generated method stub
        return userMapper.listLateStudent(seminarId, classId);
    }

    @Override
    public List<User> listAbsenceStudent(BigInteger seminarId, BigInteger classId)
            throws IllegalArgumentException, ClassesNotFoundException, SeminarNotFoundException {
        // TODO Auto-generated method stub
        return userMapper.listAbsenceStudent(seminarId, classId);
    }

    @Override
    public List<Course> listCourseByTeacherName(String teacherName)
            throws UserNotFoundException, IllegalArgumentException, CourseNotFoundException {
        // TODO Auto-generated method stub
        return userMapper.listCourseByTeacherName(teacherName);
    }

}
