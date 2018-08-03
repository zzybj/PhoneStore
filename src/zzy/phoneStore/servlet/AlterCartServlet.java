package zzy.phoneStore.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzy.phoneStore.bean.CartBean;
import zzy.phoneStore.bean.PhoneBean;
import zzy.phoneStore.bean.UserBean;
import zzy.phoneStore.dao.CartDao;

public class AlterCartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PhoneBean pb = (PhoneBean) req.getSession().getAttribute("phone");
		if(req.getSession().getAttribute("user")==null){
			resp.sendRedirect("login.jsp");
			return;
		}
		UserBean userBean = (UserBean)req.getSession().getAttribute("user");
		if(req.getParameter("phonename")!=null){
			try {
				String phonename = req.getParameter("phonename");
				phonename = new String(phonename.getBytes("iso8859-1"),"utf-8");
				CartBean phoneBean = (CartBean) CartDao.findPhone(phonename,userBean.getUsername(),1);
				if(req.getParameter("sty").equals("less")){
					CartDao.delNum(phoneBean);
				}
				else if(req.getParameter("sty").equals("add")){
					CartDao.addNum(phoneBean);
				}
				else if(req.getParameter("sty").equals("del")){
					CartDao.delNum(phoneBean,1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else{
			try {
				CartBean cb = CartDao.findPhone(pb.getPhonename(),userBean.getUsername(),1);
				if(cb.getPhonename()!=null){
					CartDao.addNum(cb);
				}
				else{
					cb.setUsername(userBean.getUsername());
					cb.setPhonename(pb.getPhonename());
				cb.setPrice(pb.getPrice());
					cb.setNum(1);
					cb.setAddress(pb.getAddress());
					CartDao.addPhone(cb);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		resp.sendRedirect("cart.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
