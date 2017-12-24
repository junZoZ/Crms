package xmu.crms.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import xmu.crms.entity.Attendance;
import xmu.crms.entity.Course;
import xmu.crms.entity.User;
import xmu.crms.exception.ClassesNotFoundException;
import xmu.crms.exception.CourseNotFoundException;
import xmu.crms.exception.SeminarNotFoundException;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.service.UserService;

import java.math.BigInteger;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public BigInteger insertAttendanceById(BigInteger classId, BigInteger seminarId, BigInteger userId, double longitude, double latitude) throws IllegalArgumentException, ClassesNotFoundException, SeminarNotFoundException, UserNotFoundException {
        return null;
    }

    @Override
    public List<Attendance> listAttendanceById(BigInteger classId, BigInteger seminarId) throws IllegalArgumentException, ClassesNotFoundException, SeminarNotFoundException {
        return null;
    }

    @Override
    public User getUserByUserId(BigInteger userId) throws IllegalArgumentException, UserNotFoundException {
        return null;
    }

    @Override
    public List<BigInteger> listUserIdByUserName(String userName) throws IllegalArgumentException, UserNotFoundException {
        return null;
    }

    @Override
    public void updateUserByUserId(BigInteger userId, User user) throws UserNotFoundException {

    }

    @Override
    public List<User> listUserByClassId(BigInteger classId, String numBeginWith, String nameBeginWith) throws IllegalArgumentException, ClassesNotFoundException, UserNotFoundException {
        return null;
    }

    @Override
    public List<User> listUserByUserName(String userName) throws UserNotFoundException {
        return null;
    }

    @Override
    public List<User> listPresentStudent(BigInteger seminarId, BigInteger classId) throws IllegalArgumentException, ClassesNotFoundException, SeminarNotFoundException {
        return null;
    }

    @Override
    public List<User> listLateStudent(BigInteger seminarId, BigInteger classId) throws IllegalArgumentException, ClassesNotFoundException, SeminarNotFoundException {
        return null;
    }

    @Override
    public List<User> listAbsenceStudent(BigInteger seminarId, BigInteger classId) throws IllegalArgumentException, ClassesNotFoundException, SeminarNotFoundException {
        return null;
    }

    @Override
    public List<Course> listCourseByTeacherName(String teacherName) throws UserNotFoundException, IllegalArgumentException, CourseNotFoundException {
        return null;
    }
}
