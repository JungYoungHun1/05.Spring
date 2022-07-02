package com.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeptDTO {
	private int deptno;
	private String dname;
	private String loc;
}
