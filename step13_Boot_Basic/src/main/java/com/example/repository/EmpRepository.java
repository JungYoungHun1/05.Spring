package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Dept;
import com.example.model.Emp;
@Repository
public interface EmpRepository extends JpaRepository<Emp, Long>{
	public List<Emp> findAll();
	public Emp findEmpByEmpno(Long empno);
	
	@Transactional
	public void deleteEmpByEmpno(Long empno);
	
	Page<Emp> findByEmpnoBetween(long from, long to, Pageable pageable);

}
