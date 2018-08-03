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

public class AlterPhoneServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		if(req.getParameter("phonename")!=null){
			try {
				String phonename = req.getParameter("phonename");
				phonename = new String(phonename.getBytes("iso8859-1"),"utf-8");
				PhoneBean pbBean = (PhoneBean) PhoneDao.findPhones(phonename,1);
				System.out.println(pbBean);
				if(req.getParameter("sty").equals("less")){
					PhoneDao.delNum(pbBean);
				}
				else if(req.getParameter("sty").equals("add")){
					PhoneDao.addNum(pbBean);
				}
				else if(req.getParameter("sty").equals("del")){
					PhoneDao.delNum(pbBean,1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
//		try {
//			pbs = PhoneDao.findPhones();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
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
			System.out.println(777);
			resp.sendRedirect("backcontrol.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
