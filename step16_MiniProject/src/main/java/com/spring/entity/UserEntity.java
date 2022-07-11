package com.spring.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.dto.UserDTO;

import lombok.Builder;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.AllArgsConstructor;

import lombok.Getter;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"boards"})
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
public class UserEntity {
	@Id
	private String userEmail;
	
	private String userName;
	private String userPassword;
	
	@CreatedDate
	private Date registeredDate;
	
	@LastModifiedDate
	private Date modifiedDate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	List<BoardEntity> boards = new ArrayList<BoardEntity>();
	
	public UserDTO toDTO(UserEntity user) {
		UserDTO dto = UserDTO.builder().userEmail(user.getUserEmail())
									   .userName(user.getUserName())
									   .userPassword(user.getUserPassword())
									   .registeredDate(user.getRegisteredDate())
									   .modifiedDate(user.getModifiedDate())
									   .build();
		return dto;
	}
	
}
