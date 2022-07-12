package com.spring.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.spring.dto.BoardDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.entity.BoardEntity;
import com.spring.service.BoardServiceImpl;

@RestController
@CrossOrigin(origins = "*")
public class BoardRestController {
	
	@Autowired
	private BoardServiceImpl boardService;
	
	@GetMapping("/boards")
	public PageResultDTO<BoardDTO, BoardEntity> getEmps(PageRequestDTO pageDTO){
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(pageDTO.getPage()).size(10).build();
		
		PageResultDTO<BoardDTO, BoardEntity> pageResultDTO = boardService.getList(pageRequestDTO);
		
		List<BoardDTO> resultBoards = new ArrayList<BoardDTO>(); 
		pageResultDTO.getDtoList().forEach(BoardDTO -> resultBoards.add(BoardDTO));
		
		return pageResultDTO;
		
	}
	
	@GetMapping(value = "/board/{boardNo}")
	public BoardDTO getBoardByBoardNo(@PathVariable Long boardNo){
		return boardService.getBoardByBoardNo(boardNo);
	}
	
	@PostMapping(value="/board", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertBoard(@RequestBody BoardDTO param) {
		boardService.insertBoard(param);
	}
	
	@PutMapping(value="/board/{boardNo}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateBoard(@PathVariable Long boardNo, @RequestBody BoardDTO param) {
		param.setBoardNo(boardNo);
		boardService.updateBoard(param);
	}
	
	@DeleteMapping(value = "/board/{boardNo}")
	public void deleteBoard(@PathVariable Long boardNo) {
		boardService.deleteBoardByBoardNo(boardNo);
	}
}
