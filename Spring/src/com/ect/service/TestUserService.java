package com.ect.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})
public class TestUserService {

	@Autowired
	private UserService userService;
	
	@Test
	public void hasMatchUser() {
		boolean b1 = userService.hasMatchedUser("admin", "123");
		boolean b2 = userService.hasMatchedUser("admin", "13");
//		
		assertTrue(b1);
		assertTrue(!b2);
	}

}
