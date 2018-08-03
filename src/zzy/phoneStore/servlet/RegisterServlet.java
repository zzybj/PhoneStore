package zzy.phoneStore.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzy.phoneStore.bean.UserBean;
import zzy.phoneStore.dao.UserDao;

public class RegisterServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String password2 = req.getParameter("password2");
		String email = req.getParameter("email"); 
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String verfi = req.getParameter("verfi"); 

		UserBean user = new UserBean(username,password,password2,email,phone,address);
		req.getSession().setAttribute("user", user);
		if(username.trim().equals("")){
			req.getSession().setAttribute("error", "1");
			resp.sendRedirect("register.jsp");
			return;
		}	
		try {
			UserBean userBean = UserDao.findUser(username);
			if(userBean!=null){
				req.getSession().setAttribute("error", "2");
				resp.sendRedirect("register.jsp");
				return;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		if(password.trim().equals("")){
			req.getSession().setAttribute("error", "3");
			resp.sendRedirect("register.jsp");
			return;
		}	
		if(password2.trim().equals("")){
			req.getSession().setAttribute("error", "3");
			resp.sendRedirect("register.jsp");
			return;
		}
		if(!password.equals(password2)){
			req.getSession().setAttribute("error", "4");
			resp.sendRedirect("register.jsp");
			return;
		}
		if(!verfi.equals(req.getSession().getAttribute("verfi"))){
			req.getSession().setAttribute("error", "5");
			resp.sendRedirect("register.jsp");
			return;
		}
		UserBean user2 = new UserBean(username,password,email,phone,address);
		try {
			UserDao.addUser(user2);
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
