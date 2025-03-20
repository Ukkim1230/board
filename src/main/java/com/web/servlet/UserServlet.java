package com.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.common.CommonCMD;
import com.web.dto.UserDTO;
import com.web.service.UserService;


@WebServlet(urlPatterns = "/user/*")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonCMD.getCmd(request);
		if("user-list".equals(cmd)) {
			List<UserDTO> users = userService.selectUsers(null);
			request.setAttribute("users", users);
		}else if("user-view".equals(cmd) || "user-update".equals(cmd)) {
			int uiNum = Integer.parseInt(request.getParameter("uiNum"));
			UserDTO user = userService.selectUser(uiNum);
			request.setAttribute("user", user);
		}
		CommonCMD.viewsForward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
