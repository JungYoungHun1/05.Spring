package com.spring.project;

import java.text.DateFormat;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.spring.dto.DeptDTO;
import com.spring.service.DeptServiceImpl;

/**
 * Handles requests for the application home page.
 */
//@Controller
@CrossOrigin(origins = "*")
@org.springframework.web.bind.annotation.RestController
public class DeptRestController {	
	
	@Autowired
	private DeptServiceImpl service;
	
	@GetMapping(value="/api/dept")
	public List<DeptDTO> getAllDepts(){
		System.out.println(service.allListDept());
		return service.allListDept();
	};
	
	@GetMapping(value="/api/dept/{deptno}")
	public DeptDTO selectDept(@PathVariable("deptno") int deptno){
		System.out.println(service.selectDept(deptno));
		return service.selectDept(deptno);
	};
	
	@DeleteMapping(value="/api/dept/{deptno}")
	public void deleteDept(@PathVariable("deptno") int deptno) {
		System.out.println(deptno);
		service.deleteDept(deptno);
	}
	
	@PostMapping(value = "/api/dept", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertDept(@RequestBody DeptDTO param) {
		DeptDTO dto = new DeptDTO();
		dto.setDeptno(param.getDeptno());
		dto.setDname(param.getDname());
		dto.setLoc(param.getLoc());
		service.insertDept(dto);
	}
	
	@PutMapping(value="/api/dept/{deptno}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateDept(@PathVariable("deptno") int deptno, @RequestBody DeptDTO param) {
		DeptDTO dto = new DeptDTO();
		dto.setDeptno(deptno);
		dto.setDname(param.getDname());
		dto.setLoc(param.getLoc());
		
		service.updateDept(dto);
	}
	
	
	
	
	
}
