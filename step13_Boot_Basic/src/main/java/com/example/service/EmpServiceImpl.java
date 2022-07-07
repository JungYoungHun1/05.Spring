package com.example.service;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.model.Emp;
import com.example.repository.DeptRepository;
import com.example.repository.EmpRepository;
import com.example.dto.EmpDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;
@Service
public class EmpServiceImpl implements EmpService{
	@Autowired
	private EmpRepository empRepository;
	
	@Autowired
	private DeptRepository deptRepository;
	
	@Override
	public List<Emp> getEmpAll() {
		return empRepository.findAll();
	}

	@Override
	public Emp getEmpByEmpno(Long empno) {
		return empRepository.findEmpByEmpno(empno);
	}

	@Override
	public void deleteEmpByEmpno(Long empno) {
		empRepository.deleteEmpByEmpno(empno);
	}

	@Override
	public void save(Emp emp) {
		empRepository.save(emp);
	}
	public PageResultDTO<EmpDTO, Emp> getList(PageRequestDTO pageRequestDTO) {
		Pageable pageable = pageRequestDTO.getPageable(Sort.by("empno").descending());
		
		Page<Emp> result =  empRepository.findAll(pageable);
		
		// entity -> dto
		Function<Emp, EmpDTO> function = (EmpEntity -> EmpEntity.toDTO(EmpEntity));
		
		return new PageResultDTO<EmpDTO, Emp>(result, function);
	}

	

	

}
