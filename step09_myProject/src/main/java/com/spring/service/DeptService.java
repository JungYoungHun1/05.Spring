package com.spring.service;

import java.util.List;
import java.util.Map;

import com.spring.dto.DeptDTO;

public interface DeptService {
	public List<DeptDTO> allListDept();
	
	public void deleteDept(int deptno);
	
	public void insertDept(DeptDTO dto);
	
	public void updateDept(DeptDTO dto);
	
	public DeptDTO selectDept(int deptno);


}
