package com.ect.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.ect.domain.User;
import com.sun.org.apache.xerces.internal.util.EntityResolver2Wrapper;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int getMatchCount(String username,String password){
		String sqlStr = "select count(*) from t_user where user_name=? and password=?";
		return jdbcTemplate.queryForInt(sqlStr,new Object[]{username,password});
	}
	
	public User findUserByUserName(final String userName){
		String sqlStr = "select user_id,credits,last_ip,user_name from t_user where user_name=?";
		final User user = new User();
		jdbcTemplate.query(sqlStr,new Object[]{userName}, 
				new RowCallbackHandler(){

					@Override
					public void processRow(ResultSet rs) throws SQLException {
						// TODO Auto-generated method stub
						user.setCredits(rs.getInt("credits"));
						user.setUserName(userName);
						user.setLastIp(rs.getString("last_ip"));
						user.setUserId(rs.getInt("user_id"));
					}
			
					}
				);
		return user;
	}
	
	public void updateLoginInfo(User user){
		String sqlStr = "update t_user set last_ip = ?,last_time=?,credits=? where user_id =? ";
		jdbcTemplate.update(sqlStr, new Object[]{user.getLastIp(),user.getLastVisit(),user.getCredits(),user.getUserId()});
	}
	
}
