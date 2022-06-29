package com.spring.common;

public class LoginNoticeAspect {
	
	// 로그인 성공시 실행되는 공통 로직
	public void noticeLoginUser(Object name) {
		if(name != null) {
			System.out.println(name + " 님 환영합니다!");
		}
	}
	// 로그인 실패시 실행되는 공통 로직
	public void noticeLoginException(Exception e) {
		System.out.println("발생된 문제 : " + e.getMessage());
	}
}
