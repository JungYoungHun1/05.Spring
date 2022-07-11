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
import com.spring.dto.CommentDTO;
import com.spring.service.CommentServiceImpl;



@RestController
@CrossOrigin(origins = "*")
public class CommentRestController {
	@Autowired
	private CommentServiceImpl commentService;
	
//	@GetMapping("/comments/{boardNo}")
//	public List<CommentDTO> getAllComment(@PathVariable Long boardNo, @RequestBody BoardDTO dto){
//		dto.setBoardNo(boardNo);
//		return commentService.getAllComment(dto);
//	}	
	
	@PostMapping(value="/comment", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertComment(@RequestBody CommentDTO param) {
		commentService.insertComment(param);
	}
	
	@PutMapping(value="/comment/{commentNo}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateComment(@PathVariable Long commentNo, @RequestBody CommentDTO param) {
		param.setCommentNo(commentNo);
		commentService.updateComment(param);
	}
	
	@DeleteMapping(value = "/comment/{commentNo}")
	public void deleteComment(@PathVariable Long commentNo) {
		commentService.deleteCommentByCommentNo(commentNo);
	}
}
