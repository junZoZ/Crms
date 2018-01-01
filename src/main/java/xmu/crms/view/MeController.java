package xmu.crms.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xmu.crms.entity.School;
import xmu.crms.entity.User;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.security.auth.JwtService;
import xmu.crms.service.LoginService;
import xmu.crms.service.impl.UserServiceImpl;
import xmu.crms.vo.LoginSuccessVO;
import xmu.crms.vo.SchoolVO;
import xmu.crms.vo.UserVO;

import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
public class MeController {
    @Autowired
    private UserServiceImpl userSeviceImpl;

    @Autowired
    private LoginService loginService;

    @Autowired
    private JwtService jwtService;
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
        {u1.setType("teacher");}
        else
        { u1.setType("student");}
        u1.setNumber(u.getNumber());
        u1.setPhone(u.getPhone());
        u1.setEmail(u.getEmail());
        if(u.getGender()==1)
        {u1.setGender("女");}
        else
        {u1.setGender("男");}
        if(u.getTitle()==null)
        {
            u1.setTitle(" ");
        }
        else if(u.getTitle()!=null&&u.getTitle().toString()=="0")
        {
            u1.setTitle("本科生");
        }
        else
        {
            u1.setTitle("教职工");
        }
        if(u.getAvatar()==null)
        {
            u.setAvatar("");
        }
        u1.setAvatar(u.getAvatar());

        SchoolVO schoolVO=new SchoolVO();
        if(u.getSchool()!=null)
        {
            schoolVO.setId(u.getSchool().getId().intValue());
            schoolVO.setName(u.getSchool().getName());
            schoolVO.setCity(u.getSchool().getCity());
            schoolVO.setProvince(u.getSchool().getProvince());
            u1.setSchool(schoolVO);
        }

        return u1;
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

    }

    /**
     * 手机号密码注册
     * @param user
     * @return
     * @throws UserNotFoundException
     */
    @RequestMapping(value="/register", method=RequestMethod.POST)
    @ResponseBody
    public LoginSuccessVO registerByPhone(@RequestBody User user) throws UserNotFoundException{

        System.out.println(user);
        try {
            user.setPassword(md5Hex(user.getPassword())); //加密
        } catch (NoSuchAlgorithmException e) { }
        User u= loginService.signUpPhone(user);
        String jwt = jwtService.generateJwt(u);
        LoginSuccessVO l=new LoginSuccessVO(u.getId(), u.getType() == 0 ? "student" : "teacher", u.getName(), jwt);
        System.out.println(l);
        return l;
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
        return null;
    }

    private String md5Hex(String input) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] res = md5.digest(input.getBytes());
        return toHex(res);
    }

    private String toHex(byte[] bytes) {

        final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }
}
