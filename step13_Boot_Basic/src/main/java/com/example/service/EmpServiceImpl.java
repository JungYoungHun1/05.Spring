package com.example.service;

import java.util.List;
import java.util.function.Function;

import javax.transaction.Transactional;

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
	public EmpDTO getEmpByEmpno(Long empno) {
		Emp emp = empRepository.findEmpByEmpno(empno);
		if(emp !=null) {
			EmpDTO empDTO = emp.toDTO(emp);
			return empDTO;
		}
		return null;
	}

	@Override
	public void deleteEmpByEmpno(Long empno) {
		empRepository.deleteEmpByEmpno(empno);
	}
	
	
	@Override
	public void save(EmpDTO dto) {
		Emp empEntity = dto.toEntity(dto);
		empRepository.save(empEntity);
		
	}
	
	
	
	public PageResultDTO<EmpDTO, Emp> getList(PageRequestDTO pageRequestDTO) {
		Pageable pageable = pageRequestDTO.getPageable(Sort.by("empno").descending());
		
		Page<Emp> result =  empRepository.findAll(pageable);
		
		// entity -> dto
		Function<Emp, EmpDTO> function = (EmpEntity -> EmpEntity.toDTO(EmpEntity));
		
		return new PageResultDTO<EmpDTO, Emp>(result, function);
	}

	

	

}
