package com.example.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.model.Dept;
import com.example.model.Emp;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice.Return;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptDTO {
	@Id
	private Long deptno;
	
	private String dname;
	private String loc;
	
	public DeptDTO(Long deptno) {
		if(deptno != null) {
			this.deptno = deptno;
		}
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "dept")
	List<Emp> emps = new ArrayList<Emp>();
	
	public Dept dtoToEntity(DeptDTO deptDTO) {
		Dept deptEntity = Dept.builder()
							  .dname(deptDTO.getDname())
							  .loc(deptDTO.getLoc())
							  .build();
				
		return deptEntity;
	}
}
