package com.spring.jdbc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.Dept;
import com.spring.service.DeptServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
//@RequestMapping("/jdbc")
public class DeptController {
	
	@Autowired
	private DeptServiceImpl deptService;
	
	
	@GetMapping("/index")
	public String home(Locale locale, Model model, int deptno) {

		model.addAttribute("result", deptService.getDeptByDeptno(deptno));
		return "../../index";
	}	
}
	