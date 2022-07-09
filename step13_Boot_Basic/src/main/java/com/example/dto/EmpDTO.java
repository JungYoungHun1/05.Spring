package com.example.dto;

import java.sql.Date;


import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.model.Dept;
import com.example.model.Emp;
import com.example.model.Emp.EmpBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpDTO {
//	@Id
	private Long empno;
	
	private String ename;
	private String job;
	private Integer mgr;
	private Date hiredate;
	private Double sal;
	private Double comm;
//	private Integer deptno;
	
	
//	@ManyToOne
//	@JoinColumn(name="deptno")
	private DeptDTO dept;
	
	public Emp toEntity(EmpDTO dto) {
		DeptDTO deptDTO = dto.getDept();
		Emp EmpEntity = Emp.builder().empno(dto.getEmpno())
				 .ename(dto.getEname())
				 .job(dto.getJob())
				 .mgr(dto.getMgr())
				 .hiredate(dto.getHiredate())
				 .sal(dto.getSal())
				 .comm(dto.getComm())
				 .dept(deptDTO.ToEntity(deptDTO))
				 .build();
		return EmpEntity;
	}

	
}
