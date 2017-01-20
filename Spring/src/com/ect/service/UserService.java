package com.ect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ect.dao.LoginLogDao;
import com.ect.dao.UserDao;
import com.ect.domain.LoginLog;
import com.ect.domain.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LoginLogDao logDao;
	
	public boolean hasMatchedUser(String userName,String password){
		int matchCount =  userDao.getMatchCount(userName, password);
		return matchCount > 0;
	}
	
	public User findUserByUserName(String userName){
		return userDao.findUserByUserName(userName);
	}
	
	public void loginSuccess(User user){
		user.setCredits(5 + user.getCredits());
		LoginLog loginLog =  new LoginLog();
		loginLog.setUserId(user.getUserId());
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(user.getLastVisit());
		userDao.updateLoginInfo(user);
		logDao.insertLoginLog(loginLog);
	}
}
