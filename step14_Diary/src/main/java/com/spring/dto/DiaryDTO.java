package com.spring.dto;

import java.time.LocalDateTime;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

import com.spring.entity.Diary;

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
public class DiaryDTO {
	@Id
	private Long no;
	
	private String title;
	
	private String content;
	
	private LocalDateTime writtenTime;

	
	public Diary toEntity(DiaryDTO dto) {
		Diary diaryEntity = Diary.builder().no(dto.getNo()).title(dto.getTitle()).content(dto.getContent()).build();
		return diaryEntity;
	}
	
}
