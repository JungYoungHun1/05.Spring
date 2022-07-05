package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.model.Dept;
import com.example.repository.DeptRepository;

@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	private DeptRepository deptRepository;
	
	
	@Override
	public List<Dept> getDeptAll() {
		return deptRepository.findAll();
	}


	@Override
	public Dept getDeptByDeptno(Long deptno) {
		return deptRepository.findDeptByDeptno(deptno);
	}
	
	
}
