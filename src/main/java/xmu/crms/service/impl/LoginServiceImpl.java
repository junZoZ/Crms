package xmu.crms.service.impl;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xmu.crms.entity.User;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.mapper.LoginMapper;

import xmu.crms.service.LoginService;
/**
 * 
 * @author Zhao zhengyu
 * @version 2017-12-24
 */
@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginMapper loginMapper;
	@Override
	public User signInWeChat(BigInteger userId, String code, String state, String successUrl)
			throws UserNotFoundException {
		
		return null;
	}

	@Override
	public void signUpWeChat(User user) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public User signInPhone(User user) throws UserNotFoundException {
		// 若user为空，则用户名或密码不正确
		return loginMapper.signInPhone(user);
	}

	@Override
	public User signUpPhone(User user) {
		// TODO Auto-generated method stub
		loginMapper.signUpPhone(user);
		return loginMapper.signInPhone(user);
	}

	@Override
	public void deleteTeacherAccount(BigInteger userId) throws IllegalArgumentException, UserNotFoundException {
		loginMapper.deleteTeacherAccount(userId);
		
	}

	@Override
	public void deleteStudentAccount(BigInteger userId) throws IllegalArgumentException, UserNotFoundException {
		// TODO Auto-generated method stub
		loginMapper.deleteStudentAccount(userId);
	}

	

}
