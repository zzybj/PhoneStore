package zzy.phoneStore.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzy.phoneStore.bean.PhoneBean;
import zzy.phoneStore.dao.PhoneDao;

public class AlterMessageServlet extends HttpServlet{

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
				req.getSession().setAttribute("pn", pbBean);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		resp.sendRedirect("edit.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
