package com.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.common.CommonCMD;
import com.web.dto.BoardDTO;
import com.web.service.BoardService;


@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardService();   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonCMD.getCmd(request);
		if ("board-list".equals(cmd)) {
			List<BoardDTO> boards = boardService.selectBoards(null);
			request.setAttribute("boards", boards);
			
		}else if("board-view".equals(cmd) || "board-update".equals(cmd)) {
			int biNum = Integer.parseInt(request.getParameter("biNum"));
			BoardDTO board = boardService.selectBoard(biNum);
			request.setAttribute("board", board);
		}
		CommonCMD.viewsForward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonCMD.getCmd(request);
		request.setCharacterEncoding("UTF-8");
		if ("insert".equals(cmd)) {
			BoardDTO board = new BoardDTO();
			board.setBiTitle(request.getParameter("biTitle"));
			board.setBiContent(request.getParameter("biContent"));
			board.setUiNum(Integer.parseInt(request.getParameter("uiNum")));

			int result = boardService.insertBoard(board);
			System.out.println("삽입 결과 : " + result);

		} else if ("update".equals(cmd)) {
			BoardDTO board = new BoardDTO();
			board.setBiNum(Integer.parseInt(request.getParameter("biNum")));
			board.setBiTitle(request.getParameter("biTitle"));
			board.setBiContent(request.getParameter("biContent"));

			int result = boardService.updateBoard(board);
			System.out.println("수정 결과 : " + result);

		} else if ("delete".equals(cmd)) {
			int biNum = Integer.parseInt(request.getParameter("biNum"));
			int result = boardService.deleteBoard(biNum);
			System.out.println("삭제 결과 : " + result);
		}
		response.sendRedirect(request.getContextPath() + "/board/board-list");
	}

}
