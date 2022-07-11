package com.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.swing.text.AbstractDocument.Content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.spring.dto.BoardDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.entity.BoardEntity;
import com.spring.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired BoardRepository boardRepository;

	@Override
	public List<BoardDTO> getAllBoards() {
		List<BoardEntity> boardEntities = boardRepository.findAll();
		List<BoardDTO> boardDTOs = new ArrayList<BoardDTO>();
		for (BoardEntity boardEntity : boardEntities) {
			boardDTOs.add(boardEntity.toDTO(boardEntity));
		}
		return boardDTOs;
	}
	
	public PageResultDTO<BoardDTO, BoardEntity> getList(PageRequestDTO pageRequestDTO) {
		Pageable pageable = pageRequestDTO.getPageable(Sort.by("boardNo").descending());
		
		Page<BoardEntity> result =  boardRepository.findAll(pageable);
		
		// entity -> dto
		Function<BoardEntity, BoardDTO> function = (BoardEntity -> BoardEntity.toDTO(BoardEntity));
		
		return new PageResultDTO<BoardDTO, BoardEntity>(result, function);
	}
	
	@Override
	public BoardDTO getBoardByBoardNo(Long boardNo) {
		BoardEntity entity = boardRepository.findBoardByBoardNo(boardNo);
		BoardDTO dto = entity.toDTO(entity);
		return dto;
	}

	@Override
	public void insertBoard(BoardDTO boardDTO) {
		BoardEntity entity = boardRepository.findBoardByBoardNo(boardDTO.getBoardNo());
		if(entity == null) {
			entity = boardDTO.toEntity(boardDTO);
			boardRepository.save(entity);
		}
	}

	@Override
	public void updateBoard(BoardDTO boardDTO) {
		//제목, 내용, 작성자, 등록일, 수정일
		BoardDTO orginalDTO = getBoardByBoardNo(boardDTO.getBoardNo());
		if(orginalDTO != null) {
			BoardDTO newDTO = new BoardDTO(orginalDTO, boardDTO);
			boardRepository.save(newDTO.toEntity(newDTO));
			
		}
	}

	@Override
	public void deleteBoardByBoardNo(Long boardNo) {
		boardRepository.deleteBoardByBoardNo(boardNo);
	}

	


	
	
	
}
