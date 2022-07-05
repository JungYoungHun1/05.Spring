package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Dept;
import com.example.service.DeptServiceImpl;

@RestController
public class DeptRestController {
	
	@Autowired
	private DeptServiceImpl deptService;
	
	@GetMapping("/depts")
	public List<Dept> getDepts(){
		return deptService.getDeptAll();
	}
	
	@GetMapping(value = "/dept/{deptno}")
	public Dept getDeptByDeptno(@PathVariable Long deptno) {
		System.out.println(deptno);
		return deptService.getDeptByDeptno(deptno);
	}
	
	
}
