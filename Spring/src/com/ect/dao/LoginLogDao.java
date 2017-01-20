package com.ect.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ect.domain.LoginLog;

@Repository
public class LoginLogDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void insertLoginLog(LoginLog loginLog){
		String sqlStr = "insert into t_login_log(user_id,ip,login_datetine) values(?,?,?)";
		Object[] args = {loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDate()};
		jdbcTemplate.update(sqlStr, args);
	}
}
