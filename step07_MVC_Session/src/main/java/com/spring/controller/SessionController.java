package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import model.domain.Customer;


@Controller
//@RequestMapping("session")
@SessionAttributes({"job", "id" , "age", "customer"})
public class SessionController {
	@RequestMapping("/cookieTest.do")
	public String cookieTest(@CookieValue("id") String ids) {
		System.out.println("Cookie : " + ids);
		return "redirect:/cookieView.jsp";
	}
	
	@GetMapping("session/sessionTest1.do")
	public String sessionTest1(HttpSession session) {
//		System.out.println(session.getAttribute("id"));
		
		session.setAttribute("job", "programmer");
		return "redirect:/sessionView1.jsp";
	}
	
	@GetMapping("session/jobDelete.do")
	public String sessionTest2(@ModelAttribute("job") String job, SessionStatus status) {
//		session.removeAttribute("job");
		// 세션 무효화
		status.setComplete();
		System.out.println("job : " + job);
		return "redirect:/sessionView1.jsp";
	}
	
	@GetMapping("session/sessionDelete.do")
	public String sessionDelete(@ModelAttribute("id") String id, @ModelAttribute("age") int age, SessionStatus status) {
		status.setComplete();
		System.out.println("id : " + id);
		System.out.println("age : " + age);
		return "redirect:/sessionView1.jsp";
	}
	
	@GetMapping("session/sessionTest2.do")
	public String sessionTest2DTO(Model model, Customer customer) {
		model.addAttribute("customer", customer);
		System.out.println(customer);
		return "redirect:/sessionView2.jsp";
	}
	
	@GetMapping("session/customerDelete.do")
	public String customerDelete(SessionStatus status) {
		status.setComplete();
		return "redirect:/sessionView2.jsp";
	}
	
	@GetMapping("session/loginForm.do")
	public String loginForm() {
		return "loginForm";
	}
	
	@RequestMapping(value="session/login.do", method = {RequestMethod.POST})
	public String login(String password, HttpSession session) {
		// pw가 1234일때 admin ㅇㅈ
		// 만약 아니라면 index로 유배
		if("1234".equals(password)) {
			session.setAttribute("admin", "관리자");
		}else {
			return "loginForm";
		}
		return "redirect:/index.jsp";
	}
	
	@GetMapping("session/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		// 로그아웃 버튼 클릭시 해당 세션 해제 후 index로 전환
		return "redirect:/index.jsp";
	}
	
	
}
