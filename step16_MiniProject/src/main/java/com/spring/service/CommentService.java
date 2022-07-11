package com.spring.service;

import java.util.List;

import com.spring.dto.BoardDTO;
import com.spring.dto.CommentDTO;

public interface CommentService {
	public List<CommentDTO> getAllComment(Long boardNo);

	public CommentDTO getCommentByCommentNo(Long commentNo);
	public void insertComment(CommentDTO CommentDTO);
	public void updateComment(CommentDTO CommentDTO);
	public void deleteCommentByCommentNo(Long CommentNo);
}
