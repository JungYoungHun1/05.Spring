package com.spring.service;

import com.spring.dto.FileDTO;
import com.spring.entity.FileEntity;

public interface FileService {
	public Long saveFile(FileDTO fileDTO);
}
