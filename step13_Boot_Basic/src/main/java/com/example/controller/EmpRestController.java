package com.example.controller;


import java.util.ArrayList;
import java.util.List;


import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Dept;
import com.example.model.Emp;
import com.example.repository.EmpRepository;
import com.example.service.DeptServiceImpl;
import com.example.service.EmpServiceImpl;
import com.example.dto.EmpDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;


@RestController
@CrossOrigin(origins = "*")
public class EmpRestController {
	
	@Autowired
	private EmpServiceImpl empService;
	
	@Autowired
	EmpRepository empRepository;
	
	@GetMapping("/emps")
	public PageResultDTO<EmpDTO, Emp> getEmps(PageRequestDTO pageDTO){
//		System.out.println("====PageRequestDTO====");
//		System.out.println(pageDTO);
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
		                        .page(pageDTO.getPage())
		                        .size(10)
		                        .build();

		PageResultDTO<EmpDTO, Emp> pageResultDTO = empService.getList(pageRequestDTO);

//		System.out.println(pageResultDTO.isPrev()); //?? false
//		System.out.println(pageResultDTO.isNext()); //?? next
//		System.out.println(pageResultDTO.getTotalPage()); //?? 20

		System.out.println("====PageRequestDTO 객체값 출력(1번 페이지에 있는 내용만)====");
		// ??
		List<EmpDTO> resultEmps = new ArrayList<EmpDTO>(); 
		pageResultDTO.getDtoList().forEach(EmpDTO -> resultEmps.add(EmpDTO));
		
		return pageResultDTO;
		
	}
	
	@GetMapping(value = "/emp/{empno}")
	public EmpDTO getEmpByEmpno(@PathVariable Long empno) {
//		System.out.println(empno);
		EmpDTO empDTO=empService.getEmpByEmpno(empno);
		return empDTO;

	}
	
	
	@PostMapping(value="/emp", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertEmp(@RequestBody EmpDTO param) {
//		EmpDTO emp = new Emp();
//	
//		
//		if(getEmpByEmpno(param.getEmpno()) == null) { 
//		emp.setEmpno(param.getEmpno());
//		emp.setEname(param.getEname());
//		emp.setDept(param.getDept());
		
		
//		emp.setDeptno(param.getDeptno());
//		if(getEmpByEmpno(param.getEmpno()) == null) {
//			empService.save(param);
//			}
			EmpDTO dto = getEmpByEmpno(param.getEmpno());
			if(dto == null) {
				empService.save(param);
			}
		}
	
	
	@PutMapping(value = "/emp/{empno}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateEmp(@PathVariable Long empno, @RequestBody EmpDTO param) {
	
		
//		if(emp != null) {
//			param.setEmpno(empno);
//			empService.save(param);
//		}
		EmpDTO dto = getEmpByEmpno(empno);
		if(dto != null) {
			
		dto.setEmpno(empno);
		dto.setEname(param.getEname());
		dto.setDept(param.getDept());
		empService.save(dto);
		}
			
	}
	
	
	@DeleteMapping(value = "/emp/{empno}")
	public void deleteEmpByEmpno(@PathVariable Long empno) {
		empService.deleteEmpByEmpno(empno);
	}
}
