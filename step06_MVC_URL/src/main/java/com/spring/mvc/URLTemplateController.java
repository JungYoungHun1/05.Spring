package com.spring.mvc;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class URLTemplateController {
	
	@GetMapping("urlTest.do/{id}")
	public String urlTest1(@PathVariable String id) {
		System.out.println("value - " + id);
		return "forward:../view.jsp";
	}
	
	@GetMapping("urlTest.do/{id}/home/{age}")
	public String urlTest2(Model model, @PathVariable String id, @PathVariable int age) {
		model.addAttribute("id", id);
		model.addAttribute("age", age);
		System.out.println("id - " + id);
		System.out.println("age - " + age);
		return "forward:/view.jsp";
	}
	
	//model API 활용하기
	//http://localhost:8080/mvc/urlTest.do/1/home/27 -> id/age -> view.jsp
	
}
