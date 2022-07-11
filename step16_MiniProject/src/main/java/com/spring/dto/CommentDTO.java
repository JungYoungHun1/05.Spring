package com.spring.dto;


import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import com.spring.entity.BoardEntity;
import com.spring.entity.CommentEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDTO {
	@Id
	private Long commentNo;
	
	private String commenter;
	private String commentContent;
	private Date registerdDate;
	private Date modifiedDate;
	
	private BoardDTO board;
	
	public CommentEntity toEntity(CommentDTO dto) {
		BoardDTO boardDTO = dto.getBoard();
		CommentEntity commentEntity = CommentEntity.builder()
				 .commentNo(dto.getCommentNo())
				 .commenter(dto.getCommenter())
				 .commentContent(dto.getCommentContent())
				 .registerdDate(dto.getRegisterdDate())
				 .modifiedDate(dto.getModifiedDate())
				 .board(boardDTO.toEntity(boardDTO))
				 .build();
		return commentEntity;
	}
	
	public CommentDTO(CommentDTO orginalDTO, CommentDTO newDTO) {
		commentNo = orginalDTO.getCommentNo();
		board = orginalDTO.getBoard();
		commenter = orginalDTO.getCommenter();
		registerdDate = orginalDTO.getRegisterdDate();
		if(newDTO.getCommentContent() != null) {
			commentContent = newDTO.getCommentContent();
		}else {
			commentContent = orginalDTO.getCommentContent();
		}
	}
	
}
