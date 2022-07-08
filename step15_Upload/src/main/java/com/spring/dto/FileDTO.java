package com.spring.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.spring.entity.FileEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileDTO {
	private Long id;
	
	private String originalFilename;
	
	private String filename;
	
	private String filePath;
	
	public FileEntity toEntity(FileDTO fileDTO) {
		FileEntity fileEntity = FileEntity.builder()
										  .filename(fileDTO.getFilename())
										  .originalFilename(fileDTO.getOriginalFilename())
										  .filePath(fileDTO.getFilePath())
										  .build();
		return fileEntity;
	}
}
