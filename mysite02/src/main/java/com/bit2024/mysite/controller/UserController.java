package com.bit2024.mysite.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit2024.mysite.dao.UserDao;
import com.bit2024.mysite.vo.UserVo;


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("a");
		
		if(action.equals("joinform")) {
			request
				.getRequestDispatcher("/WEB-INF/views/user/joinform.jsp")
				.forward(request, response);
		} else if(action.equals("joinsuccess")) {
			request
				.getRequestDispatcher("/WEB-INF/views/user/joinsuccess.jsp")
				.forward(request, response);
		} else if(action.equals("join")) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			
			UserVo vo = new UserVo();
			vo.setName(name);
			vo.setEmail(email);
			vo.setPassword(password);
			vo.setGender(gender);
			
			UserDao userDao = new UserDao();
			userDao.insert(vo);
			
			//response
			response.sendRedirect("/mysite02/user?a=joinsuccess");
		} else if(action.equals("loginform")) {
			request
				.getRequestDispatcher("/WEB-INF/views/user/loginform.jsp")
				.forward(request, response);
		} else if(action.equals("login")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			UserVo authUser = new UserDao().findByEmailAndPassword(email, password);
			if(authUser == null) {
				request.setAttribute("email", email);
				request.setAttribute("result", "fail");
				request
					.getRequestDispatcher("/WEB-INF/views/user/loginform.jsp")
					.forward(request, response);
				return;
			}
			/* login 처리 */
			System.out.println("로그인 처리!!!");
			HttpSession session = request.getSession(true);
			session.setAttribute("authUser", authUser);
			
			response.sendRedirect("/mysite02/main");
		} else if(action.equals("logout")) {
			HttpSession session = request.getSession();
			session.removeAttribute("authUser");
			session.invalidate();
			
			response.sendRedirect("/mysite02/main");
		} else if(action.equals("updateform")) {
		    HttpSession session = request.getSession();
		    UserVo authUser = (UserVo) session.getAttribute("authUser");
		    Long no = authUser.getNo();
			UserVo userVo = new UserDao().findByNo(no);
			System.out.println(userVo.toString());
			request.setAttribute("userVo", userVo);
			request
			.getRequestDispatcher("/WEB-INF/views/user/updateform.jsp")
			.forward(request, response);
		} else if(action.equals("update")) {
		    HttpSession session = request.getSession();
		    UserVo authUser = (UserVo) session.getAttribute("authUser");
		    Long no = authUser.getNo();
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			
			UserVo vo = new UserVo();
			vo.setNo(no);
			vo.setName(name);
			vo.setEmail(email);
			vo.setPassword(password);
			vo.setGender(gender);
			
			UserDao userDao = new UserDao();
			if(vo.getPassword() != "" || vo.getPassword() != null){
				userDao.update(vo);
			} else {
				userDao.updateNopassowrd(vo);
			}
			
			response.sendRedirect("/mysite02/user?a=updateform");
		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
