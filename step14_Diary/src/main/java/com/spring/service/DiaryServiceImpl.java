package com.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dto.DiaryDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.entity.Diary;
import com.spring.repository.DiaryRepository;

@Service
public class DiaryServiceImpl implements DiaryService {

	@Autowired
	private DiaryRepository diaryRepository;
	
	@Transactional
	@Override
	public void insertDiary(DiaryDTO diaryDTO) {
//		Diary diaryEntity = diaryDTO.toEntity(diaryDTO);
		
//		Diary diaryEntity = diaryRepository.findById(diaryDTO.getNo().orElseThrow(() -> new IllegalAccessException("ds"));
//		Diary diaryEntity = diaryRepository.findById(diaryDTO.getNo()).orElseThrow(() -> new IllegalAccessException());
		Diary diaryEntity = diaryRepository.findById(diaryDTO.getNo()).orElseThrow(()->new IllegalArgumentException());
		diaryDTO.updateTitle(diaryDTO.getTitle()).ifPresent(diaryEntity::updateTitle);

//		diaryEntity.updateTitle(diaryDTO.getTitle());
		diaryRepository.save(diaryEntity);
		
		
	}
	@Transactional
	@Override
	public void insertDiaryBatch(List<DiaryDTO> diaryDTOList) {
//		List<Diary> diaryEntityList = new ArrayList<Diary>();
		// ver1
//		for (DiaryDTO diaryDTO : diaryDTOList) {
//			Diary diaryEntity = diaryDTO.toEntity(diaryDTO);
//			diaryEntityList.add(diaryEntity);
//		}
		// ver2
//		diaryDTOList.forEach(diaryDTO -> diaryEntityList.add(diaryDTO.toEntity(diaryDTO)));
		
		//ver3
		// version3
		List<Diary> diaryEntityList = diaryDTOList.stream()
		                    .map(diaryDTO -> diaryDTO.toEntity(diaryDTO))
		                    .collect(Collectors.toList());
		diaryRepository.saveAll(diaryEntityList);
	}
	public PageResultDTO<DiaryDTO, Diary> getList(PageRequestDTO pageRequestDTO) {
		Pageable pageable = pageRequestDTO.getPageable(Sort.by("no").descending());
		
		Page<Diary> result =  diaryRepository.findAll(pageable);
		
		// entity -> dto
		Function<Diary, DiaryDTO> function = (diaryEntity -> diaryEntity.toDTO(diaryEntity));
		
		return new PageResultDTO<DiaryDTO, Diary>(result, function);
	}
	

}
