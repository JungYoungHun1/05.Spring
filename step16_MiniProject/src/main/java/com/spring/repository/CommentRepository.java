package com.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.dto.BoardDTO;
import com.spring.entity.BoardEntity;
import com.spring.entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
//	
//	public List<CommentEntity> findAll(BoardEntity boardEntity);
//	public CommentEntity findCommentByBoardNo(Long boardNo);
	
	public CommentEntity findCommentByCommentNo(Long commentNo);

	@Transactional
	public void deleteCommentByCommentNo(Long commentNo);
}
