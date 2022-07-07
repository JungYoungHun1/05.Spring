package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Data
@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"emps"})
public class Dept {
	@Id
	private Long deptno;
	
	private String dname;
	private String loc;
	
	@JsonIgnore
	@OneToMany(mappedBy = "dept")
	List<Emp> emps = new ArrayList<Emp>();
	
	
}
