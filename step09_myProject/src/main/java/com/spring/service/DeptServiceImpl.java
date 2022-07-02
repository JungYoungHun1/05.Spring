package com.spring.service;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.DeptDTO;
import com.spring.mapper.DeptMapper;

@Service
public class DeptServiceImpl implements DeptService{

	@Autowired
	private DeptMapper deptmapper;
	
	@Override
	public List<DeptDTO> allListDept() {
		return deptmapper.allListDept();
	}

	@Override
	public void deleteDept(int deptno) {
		deptmapper.deleteDept(deptno);
		
	}

	@Override
	public void insertDept(DeptDTO dto) {
		deptmapper.insertDept(dto);
		
	}

	

	@Override
	public DeptDTO selectDept(int deptno) {
		return deptmapper.selectDept(deptno);
	}

	@Override
	public void updateDept(DeptDTO dto) {
		deptmapper.updateDept(dto);
		
	}
	

}
