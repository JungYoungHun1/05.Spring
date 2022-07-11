package com.spring.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.spring.entity.BoardEntity;
import com.spring.entity.UserEntity;

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
public class BoardDTO {
	@Id
	private Long boardNo;

	private String boardTitle;
	private String boardContent;
	private LocalDateTime registeredDate;
	private LocalDateTime modifiedDate;
	
	private UserDTO user;
	
	public BoardEntity toEntity(BoardDTO dto) {
		UserDTO userDTO = dto.getUser();
		BoardEntity board = BoardEntity.builder().boardNo(dto.getBoardNo())
										 .boardTitle(dto.getBoardTitle())
										 .boardContent(dto.getBoardContent())
										 .registeredDate(dto.getRegisteredDate())
										 .modifiedDate(dto.getModifiedDate())
										 .user(userDTO != null ? userDTO.toEntity(userDTO) : null)
										 .build();
		return board;
	}
	
	public BoardDTO(BoardDTO orginalDTO, BoardDTO newDTO) {
		boardNo = orginalDTO.getBoardNo();
		user = orginalDTO.getUser();
		registeredDate = orginalDTO.getRegisteredDate();
		if(newDTO.getBoardContent() != null) {
			boardContent = newDTO.getBoardContent();
		}else {
			boardContent = orginalDTO.getBoardContent();
		}
		if(newDTO.getBoardTitle() != null) {
			boardTitle = newDTO.getBoardTitle();
		}else {
			boardTitle = orginalDTO.getBoardTitle();
		}
	}
	
	
	
}
