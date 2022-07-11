package com.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.BoardEntity;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long>{
	
	public List<BoardEntity> findAll();
	
	public BoardEntity findBoardByBoardNo(Long boardNo);
	
	@Transactional
	public void deleteBoardByBoardNo(Long boardNo);
}
