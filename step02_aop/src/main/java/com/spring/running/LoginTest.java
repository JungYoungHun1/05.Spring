package com.spring.running;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.User;

public class LoginTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("login.xml");
		
		User user = context.getBean("user", User.class);
		
		try {
			user.login("test");
		} catch (Exception e) {

		}
		try {
			user.login("admin");
		} catch (Exception e) {

		}
		try {
			user.login("");
		} catch (Exception e) {

		}
	}

}
