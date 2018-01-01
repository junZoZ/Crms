package xmu.crms.security.auth.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xmu.crms.entity.User;
import xmu.crms.service.LoginService;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * 获取用户登录信息
 * spring security 中有 UserDetailsService 的定义，但考虑到登录的方式等问题，未采用其定义
 *
 * @author LuLongfei
 * @date 2017-12-21
 */
@Service
@Qualifier("customUserDetailsService")
public class UserDetailsServiceImpl implements xmu.crms.security.auth.UserDetailsService {
    @Autowired
    private LoginService loginService;



    private static final String LOGIN_WITH_PHONE = "phone";



    /**
     * 获取用户信息
     * s以 phone 开头，使用账号密码登录； 以 wechat 开头，小程序登录
     *
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */

    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {

        String[] m = s.split(" ");
        System.out.println("    "+ m[1] );
        User user = null;
        System.out.println(s);
        if (LOGIN_WITH_PHONE.equals(m[0])) {
            System.out.println(getUserByPhone(m[1]));
            return getUserByPhone(m[1]);
        }


        return null;
    }

    /**
     *
     * @param phone
     * @return
     * @throws UsernameNotFoundException
     */
    private User getUserByPhone(String phone)
            throws UsernameNotFoundException {


        User users=new User();
        users.setPhone(phone);
        User user =loginService.getUserByPhone(phone);

        if (user == null) {
            throw new UsernameNotFoundException("");
        }
        return user;
    }



}
