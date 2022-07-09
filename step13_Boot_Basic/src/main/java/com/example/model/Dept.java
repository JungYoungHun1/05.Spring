package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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


@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = {"emps"})
public class Dept {
	@Id
	private Long deptno;
	
	private String dname;
	private String loc;
	
	@JsonIgnore
	@OneToMany(mappedBy = "dept")
	List<Emp> emps = new ArrayList<Emp>();
	
	public DeptDTO toDTO(Dept dept) {
		DeptDTO dto = DeptDTO.builder().deptno(dept.getDeptno()).dname(dept.getDname()).loc(dept.getLoc()).build();
									
		return dto;
		
	}
	
}
