package com.spring.di;



import org.springframework.context.ApplicationContext;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import step03.model.domain.Car;
import step03.model.domain.People;


public class Step03Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("step03.xml");
		

		//People
		People p1 = context.getBean("people", People.class);
		System.out.println(p1);
		
		//Car
		Car c1 = context.getBean("car", Car.class);
		System.out.println(c1);
		
		

	}

}
