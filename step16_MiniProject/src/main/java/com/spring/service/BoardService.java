package com.spring.service;

import java.util.List;

import com.spring.dto.BoardDTO;

public interface BoardService {
	public List<BoardDTO> getAllBoards();
	public BoardDTO getBoardByBoardNo(Long boardNo);
	public void insertBoard(BoardDTO boardDTO);
	public void updateBoard(BoardDTO boardDTO);
	public void deleteBoardByBoardNo(Long boardNo);
}
