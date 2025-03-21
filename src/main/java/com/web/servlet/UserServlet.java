package com.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.web.common.CommonCMD;
import com.web.common.CommonView;
import com.web.dto.UserDTO;
import com.web.service.UserService;

@WebServlet(urlPatterns = "/user/*")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = CommonCMD.getCmd(request);
		if ("user-list".equals(cmd)) {
			List<UserDTO> users = userService.selectUsers(null);
			request.setAttribute("users", users);
		} else if ("user-view".equals(cmd) || "user-update".equals(cmd)) {
			int uiNum = Integer.parseInt(request.getParameter("uiNum"));
			UserDTO user = userService.selectUser(uiNum);
			request.setAttribute("user", user);
		}
		CommonCMD.viewsForward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = CommonView.getCmd(request);
		UserDTO user = new UserDTO();
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		String url = "";
		String msg = "";
		if ("join".equals(cmd)) {
			int result = userService.insertUser(user);
			msg = "회원가입에 성공하였습니다.";
			url = "/views/user/login";
			if (result == -1) {
				msg = "이미 존재하는 아이디입니다.";
				url = "/views/user/join";
			} else if ("login".equals(cmd)) {
				user = userService.selectUserByIdAndPwd(user);
				if (user != null) {
					request.getSession().setAttribute("user", user);
					msg = "로그인에 성공하였습니다.";
					url = "/views/user/list";
				} else {
					msg = "로그인에 실패하였습니다.";
					url = "/views/user/login";
				}
			}

			CommonView.forwardMsg(request, response, msg, url);
		}

	}
}
