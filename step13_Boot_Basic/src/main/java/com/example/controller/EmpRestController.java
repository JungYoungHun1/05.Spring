package com.example.controller;


import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Dept;
import com.example.model.Emp;
import com.example.service.DeptServiceImpl;
import com.example.service.EmpServiceImpl;

@RestController
public class EmpRestController {
	
	@Autowired
	private EmpServiceImpl empService;
	
	

	
	@GetMapping("/emps")
	public List<Emp> getEmps(){
		return empService.getEmpAll();
	}
	
	@GetMapping(value = "/emp/{empno}")
	public Emp getEmpByEmpno(@PathVariable Long empno) {
		System.out.println(empno);
		if(empService.getEmpByEmpno(empno) != null) {
			return empService.getEmpByEmpno(empno);
		}else {
			return null;
		}
	}
	

	
	@PostMapping(value="/emp", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertEmp(@RequestBody Emp param) {
		Emp emp = new Emp();
		
		if(getEmpByEmpno(param.getEmpno()) == null) { 
		emp.setEmpno(param.getEmpno());
		emp.setEname(param.getEname());
		emp.setDept(param.getDept());
		empService.save(emp);
		}
	}
	
	@PutMapping(value = "/emp/{empno}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateEmp(@PathVariable Long empno, @RequestBody Emp param) {
	
		Emp emp = getEmpByEmpno(empno);
		if(emp != null) {
			emp.setEmpno(empno);
			emp.setEname(param.getEname());
			emp.setDept(param.getDept());
//			emp.setDeptno(param.getDeptno());
			empService.save(emp);
		}
	}
	
	
	@DeleteMapping(value = "/emp/{empno}")
	public void deleteEmpByEmpno(@PathVariable Long empno) {
		System.out.println(empno);
		empService.deleteEmpByEmpno(empno);
	}
}
