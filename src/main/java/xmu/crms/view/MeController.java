package xmu.crms.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xmu.crms.entity.User;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.service.impl.UserServiceImpl;
import xmu.crms.vo.SchoolVO;
import xmu.crms.vo.UserVO;

import java.math.BigInteger;

@RestController
public class MeController {
    @Autowired
    private UserServiceImpl userSeviceImpl;
    /**
     * 获得当前用户
     * @return User deleteNumber
     */
    @RequestMapping(value="/me", method=RequestMethod.GET)
    public UserVO getUser() throws UserNotFoundException {
        //jwt
        BigInteger id=new BigInteger("5");
        User u=userSeviceImpl.getUserByUserId(id);
        UserVO u1=new UserVO();
        u1.setId(u.getId().intValue());
        u1.setName(u.getName());
        if(u.getType()==1)
            u1.setType("teacher");
        else
            u1.setType("student");
        u1.setNumber(u.getNumber());
        u1.setPhone(u.getPhone());
        u1.setEmail(u.getEmail());
        if(u.getGender()==1)
            u1.setGender("female");
        else
            u1.setGender("male");
        u1.setTitle(u.getTitle().toString());
        u1.setAvatar(u.getAvatar());
        return new UserVO();
    }
    SchoolVO school;
    String jwt ;
    /**
     * 修改当前用户
     * @return
     * @throws UserNotFoundException
     */
    @RequestMapping(value="/me", method=RequestMethod.PUT)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void updateUser(@RequestBody User user) throws UserNotFoundException {
        userServiceImpl.updateUserByUserId(user.getId(), user);
    }
    /**
     * 手机号登录，返回用户基本信息
     * @param phone
     * @param password
     * @return
     * @throws UserNotFoundException 用户不存在或密码不正确
     */
    @RequestMapping(value="/signin", method=RequestMethod.POST)
    public User signinByPhone(@RequestBody User user) throws UserNotFoundException{

        System.out.println(user);
        return user;
    }

    /**
     * 手机号密码注册
     * @param user
     * @return
     * @throws UserNotFoundException
     */
    @RequestMapping(value="/registerByPhone", method=RequestMethod.POST)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void registerByPhone(@RequestBody User user) throws UserNotFoundException{
        loginServiceImpl. signUpPhone(user) ;
    }
    /**
     * 微信登录，返回用户基本信息
     * @param code
     * @param state
     * @param successUrl
     * @param response
     * @return User deleteUser
     */
    @RequestMapping(value="/signin", method=RequestMethod.GET)
    public User signin(String code, String state, String successUrl, HttpServletResponse response){
    }
}
