package com.example.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Data
@Entity
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
	
	

}
