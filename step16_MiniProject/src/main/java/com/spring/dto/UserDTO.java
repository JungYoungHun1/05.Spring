package com.spring.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

import org.apache.catalina.User;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.spring.entity.UserEntity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.AllArgsConstructor;

import lombok.Getter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
	@Id
	private String userEmail;
	
	private String userName;
	private String userPassword;
	private Date registeredDate;
	private Date modifiedDate;
	
	
	public UserEntity toEntity(UserDTO dto) {
		UserEntity user = UserEntity.builder()
									   .userEmail(dto.getUserEmail())
									   .userName(dto.getUserName())
									   .userPassword(dto.getUserPassword())
									   .registeredDate(dto.getRegisteredDate())
									   .modifiedDate(dto.getModifiedDate())
									   .build();
		return user;
	}
}
