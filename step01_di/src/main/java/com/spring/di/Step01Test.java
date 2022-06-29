package com.spring.di;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step01.model.domain.Car;
import step01.model.domain.People;


public class Step01Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("step01.xml");
		
		// step01
		// Car
		Car c1 = context.getBean("c1", Car.class);
		System.out.println(c1);
		
		//People
		People p1 = context.getBean("p1", People.class);
		System.out.println(p1);
		
		/*
		 * People p1 = new People();
		 * p1.setName("spring");
		 * p1.setAge(29);
		 * p1.setMyCar(c1);
		 */
		
		// 객체 생성이 가장 먼저 이뤄지고 그 이후에 의존성 주입
		
		//step02
		// People
		People p2 = context.getBean("p2", People.class);
		System.out.println(p2);
		
		System.out.println(p1 == p2); // false
		System.out.println(p1.getMyCar() == p2.getMyCar()); // true : 기본값은 singleton으로 관리됨
		// 서로 다른 객체가 되려면? -> xml 파일에 scope="prototype" 추가
		
		// request -> 요청마다 새로운 객체로 생성
		// session -> 세션마다 새로운 객체로 생성
	}

}
