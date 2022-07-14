package com.spring.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.spring.dto.DiaryDTO;

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
public class Diary implements Persistable<Long>{
	@Id 
	private Long no;
	
	private String title;
	
	private String content;
	
	@CreatedDate
	private LocalDateTime writtenTime;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return no;
	}

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return writtenTime == null;
	}
	
	public DiaryDTO toDTO(Diary diary) {
		DiaryDTO dto = DiaryDTO.builder().no(diary.getNo()).title(diary.getTitle()).content(diary.getContent()).writtenTime(diary.getWrittenTime()).build();
		return dto;
		
	}
	
//	public void updateEntity(DiaryDTO diaryDTO) {
//		this.title = diaryDTO.getTitle();
//		this.content = diaryDTO.getContent();
//	}
	
	public void updateTitle(String title) {
		this.title = title;
	}
}
