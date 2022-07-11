package com.example.model;

import java.sql.Date;



import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.dto.DeptDTO;
import com.example.dto.EmpDTO;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Emp {
	@Id
	private Long empno;
	
	private String ename;
	private String job;
	private Integer mgr;
	private Date hiredate;
	private Double sal;
	private Double comm;
//	private Integer deptno;
	
	
	@ManyToOne
	@JoinColumn(name="deptno")
	private Dept dept;

	
public EmpDTO toDTO(Emp emp) {
	Dept dept = emp.getDept();
	EmpDTO dto = EmpDTO.builder().empno(emp.getEmpno())
								 .ename(emp.getEname())
								 .job(emp.getJob())
								 .mgr(emp.getMgr())
								 .hiredate(emp.getHiredate())
								 .sal(emp.getSal())
								 .comm(emp.getComm())
								 .dept(dept.toDTO(dept))
								 .build();
	return dto;
	
}

}
