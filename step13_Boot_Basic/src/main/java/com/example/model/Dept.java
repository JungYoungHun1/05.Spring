package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString(exclude = {"emps"})
public class Dept {
	@Id
	private Long deptno;
	
	private String dname;
	private String loc;
	
	@OneToMany(mappedBy = "dept")
	List<Emp> emps = new ArrayList<Emp>();
//	
	
}
