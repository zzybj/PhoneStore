package zzy.phoneStore.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zzy.phoneStore.bean.PhoneBean;
import zzy.phoneStore.dao.PhoneDao;

public class SearchServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		String phonename = req.getParameter("littername").toLowerCase();
		List<PhoneBean> pbs = null;
		try {
			pbs = PhoneDao.findPhones();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//.......................
		boolean index=false;
		Cookie[] cookies = req.getCookies();
		Cookie cc = null;
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("pn")){
				cc = new Cookie("pn", phonename);
				System.out.println(cc.getName()+"555"+cc.getValue());
				resp.addCookie(cc);
				index=true;
				break;
			}
		}	
//.......................
		System.out.println(phonename);
		System.out.println(req.getParameter("search"));
		if(req.getParameter("search")!=null||index){
			if(index){
				phonename = cc.getValue();
			}
			List<PhoneBean> pps = new ArrayList<PhoneBean>();
			for(PhoneBean pb:pbs){
				String name = pb.getPhonename().toLowerCase();
				if(name.contains(phonename)){
					pps.add(pb);
				}
			}
			req.getSession().setAttribute("pps", pps);
			resp.sendRedirect("searchalter.jsp");
		}
		else{
			List<PhoneBean> pps = new ArrayList<PhoneBean>();
			for(PhoneBean pb:pbs){
				String name = pb.getPhonename().toLowerCase();
				if(name.contains(phonename)){
					pps.add(pb);
				}
			}
			req.getSession().setAttribute("pps", pps);
			resp.sendRedirect("search.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
