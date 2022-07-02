package com.spring.mapper;

import java.util.List;
import java.util.Map;

import com.spring.dto.DeptDTO;

public interface DeptMapper {
	public List<DeptDTO> allListDept();
	
	public void deleteDept(int deptno);
	
	public void insertDept(DeptDTO dto);
	
	

	public DeptDTO selectDept(int deptno);

	public void updateDept(DeptDTO dto);

}
