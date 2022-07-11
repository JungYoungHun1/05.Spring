package com.spring.entity;


import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@ToString
@EntityListeners(AuditingEntityListener.class)
@Table(name = "comment")
public class CommentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentNo;
	
	private String commenter;
	
	private String commentContent;
	
	@CreatedDate
	private Date registerdDate;
	
	@LastModifiedDate
	private Date modifiedDate;
	
	@ManyToOne
	@JoinColumn(name="boardNo")
	private BoardEntity board;
	
	public CommentDTO toDTO(CommentEntity commentEntity) {
		BoardEntity boardEntity = commentEntity.getBoard();
		CommentDTO dto = CommentDTO.builder().commentNo(commentEntity.getCommentNo())
											 .commenter(commentEntity.getCommenter())
											 .commentContent(commentEntity.getCommentContent())
											 .registerdDate(commentEntity.getRegisterdDate())
											 .modifiedDate(commentEntity.getModifiedDate())
											 .board(boardEntity.toDTO(boardEntity))
											 .build();
		return dto;
	}
}
