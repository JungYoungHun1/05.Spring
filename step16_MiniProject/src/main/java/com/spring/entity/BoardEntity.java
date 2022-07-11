package com.spring.entity;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.dto.BoardDTO;
import com.spring.dto.CommentDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"comments"})
@EntityListeners(AuditingEntityListener.class)
@Table(name = "board")
public class BoardEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boardNo;
	
	private String boardTitle;
	
	private String boardContent;
	
	@CreatedDate
	private LocalDateTime registeredDate;
	
	@LastModifiedDate
	private LocalDateTime modifiedDate;
	
	@ManyToOne
	@JoinColumn(name="userEmail")
	private UserEntity user;
	
	@JsonIgnore
	@OneToMany(mappedBy = "board")
	List<CommentEntity> comments = new ArrayList<CommentEntity>();
	
	public BoardDTO toDTO(BoardEntity board) {
		UserEntity userEntity = board.getUser();
		BoardDTO dto = BoardDTO.builder().boardNo(board.getBoardNo())
										 .boardTitle(board.getBoardTitle())
										 .boardContent(board.getBoardContent())
										 .registeredDate(board.getRegisteredDate())
										 .modifiedDate(board.getModifiedDate())
										 .user(userEntity.toDTO(userEntity))
										 .build();
		return dto;
	}
}
