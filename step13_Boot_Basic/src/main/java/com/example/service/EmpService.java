package com.example.service;

import java.util.List;

import com.example.dto.EmpDTO;
import com.example.model.Dept;
import com.example.model.Emp;

public interface EmpService {
	public List<Emp> getEmpAll();
	public EmpDTO getEmpByEmpno(Long empno);
	
	public void deleteEmpByEmpno(Long empno);
	public void save(EmpDTO empdto);
}
