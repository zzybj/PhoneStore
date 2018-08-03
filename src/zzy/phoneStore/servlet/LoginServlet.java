package zzy.phoneStore.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzy.phoneStore.bean.UserBean;
import zzy.phoneStore.dao.UserDao;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String verfi = req.getParameter("verfi");
		UserBean userBean  = new UserBean(username,password);
		req.getSession().setAttribute("user", userBean);
		if(req.getParameter("change")!=null){
			resp.sendRedirect("login.jsp");
			return;
		}
		if(username.trim().equals("")){
			req.getSession().setAttribute("loginerror", "1");
			resp.sendRedirect("login.jsp");
			return;
		}	
		if(password.trim().equals("")){
			req.getSession().setAttribute("loginerror", "2");
			resp.sendRedirect("login.jsp");
			return;
		}		
		if(!verfi.equals(req.getSession().getAttribute("verfi"))){
			req.getSession().setAttribute("loginerror", "3");
			resp.sendRedirect("login.jsp");
			return;
		}
		try {
			UserBean user = UserDao.findUser(username);
			if(user==null){
				req.getSession().setAttribute("loginerror", "4");
				resp.sendRedirect("login.jsp");
				return;
			}
			if(!user.getPassword().equals(password)){
				req.getSession().setAttribute("loginerror", "5");
				resp.sendRedirect("login.jsp");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getSession().setAttribute("success", "success");
		resp.sendRedirect("main.jsp");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
