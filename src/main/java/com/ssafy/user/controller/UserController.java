package com.ssafy.user.controller;

import java.io.IOException;

import com.ssafy.user.model.dao.UserDao;
import com.ssafy.user.model.dao.UserDaoImpl;
import com.ssafy.user.model.dto.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/user")
public class UserController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static UserDao instance = UserDaoImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		switch (action) {
		case "regist":
			doRegist(request,response);
			break;

		case "search":
			doSearch(request,response);
			break;
		}
	}
	private void doSearch(HttpServletRequest request, HttpServletResponse response) {
		
	}
	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		User user = new User(id, nickname, password);
		
//		HttpSession session = request.getSession();
		request.setAttribute("user", user);
		instance.insert(user);
		
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/user/regist_result.jsp");
		disp.forward(request, response);
		
		
	}
}
