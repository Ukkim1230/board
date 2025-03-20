package com.web.service;

import java.util.List;

import com.web.dto.BoardDTO;
import com.web.dto.UserDTO;
import com.web.repository.BoardRepository;

public class BoardService {
private BoardRepository boardRepo = new BoardRepository();
	
	public List<BoardDTO> selectBoards(BoardDTO board){
		return boardRepo.selectBoards(board);
	}
	public BoardDTO selectBoard(int biNum) {
		return boardRepo.selectBoard(biNum);
	}
	public int insertBoard(BoardDTO board) {
		return boardRepo.insertBoard(board);
	}
	public int updateBoard(BoardDTO board) {
		return boardRepo.updateBoard(board);
	}
	public int deleteBoard(int biNum) {
		return boardRepo.deleteBoard(biNum);
	}
}