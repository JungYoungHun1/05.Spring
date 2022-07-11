package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.BoardDTO;
import com.spring.dto.CommentDTO;
import com.spring.entity.BoardEntity;
import com.spring.entity.CommentEntity;
import com.spring.repository.BoardRepository;
import com.spring.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired CommentRepository commentRepository;
	
	@Autowired BoardRepository boardRepository;
	
	@Override
	public List<CommentDTO> getAllComment(Long boardNo) {
		BoardEntity boardEntity = boardRepository.findBoardByBoardNo(boardNo);
		List<CommentEntity> commentEntities = commentRepository.findCommentByBoard(boardEntity);
		List<CommentDTO> commentDTOs = new ArrayList<CommentDTO>();
		for (CommentEntity commentEntity : commentEntities) {
			commentDTOs.add(commentEntity.toDTO(commentEntity));
		}
		return commentDTOs;
	}

	
	@Override
	public CommentDTO getCommentByCommentNo(Long commentNo) {
		CommentEntity entity = commentRepository.findCommentByCommentNo(commentNo);
		CommentDTO dto = entity.toDTO(entity);
		return dto;
	}
	

	@Override
	public void insertComment(CommentDTO commentDTO) {
		CommentEntity entity = commentRepository.findCommentByCommentNo(commentDTO.getCommentNo());
		if(entity == null) {
			entity = commentDTO.toEntity(commentDTO);
			commentRepository.save(entity);
		}
	}

	@Override
	public void updateComment(CommentDTO commentDTO) {
		CommentDTO orginalDTO = getCommentByCommentNo(commentDTO.getCommentNo());
		if(orginalDTO != null) {
			CommentDTO newDTO = new CommentDTO(orginalDTO, commentDTO);
			commentRepository.save(newDTO.toEntity(newDTO));
			
		}
	}

	@Override
	public void deleteCommentByCommentNo(Long commentNo) {
		commentRepository.deleteCommentByCommentNo(commentNo);
	}

	

}
