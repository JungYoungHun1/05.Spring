package com.spring.running;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.Car;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
		
		Car car = context.getBean("car", Car.class);
		
		car.buy();
//		car.buyMoney(1000);
		
//		car.buyString();
//		car.buyReturn(); 
//		try {
//			car.sellCar(900);
//		} catch (Exception e) {
//			
//		}
	}

}
