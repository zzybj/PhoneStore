package zzy.phoneStore.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzy.phoneStore.bean.PhoneBean;
import zzy.phoneStore.dao.PhoneDao;

public class AlterMessServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String address = (String) req.getSession().getAttribute("address");
		String phonename= req.getParameter("phonename");
		phonename = new String(phonename.getBytes("iso8859-1"),"utf-8");
		double price = Double.parseDouble(req.getParameter("price"));
		PhoneBean pbBean = new PhoneBean();
		pbBean.setPhonename(phonename);
		pbBean.setPrice(price);
		pbBean.setAddress(address);
		try {
			PhoneDao.Alter(pbBean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		boolean index=false;
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("pn")){
				index=true;
				break;
			}
		}
		if(index){
			resp.sendRedirect("searchalter.jsp");
		}
		else{
			resp.sendRedirect("backcontrol.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
