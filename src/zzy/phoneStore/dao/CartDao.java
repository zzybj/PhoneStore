package zzy.phoneStore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zzy.phoneStore.bean.CartBean;
import zzy.phoneStore.utils.DBUtil;

public class CartDao {
	
	public static void addPhone(CartBean phone) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql = "insert into cart(username,phonename,price,num,address) value(?,?,?,?,?)";
		PreparedStatement pp = conn.prepareStatement(sql);
		pp.setString(1, phone.getUsername());
		pp.setString(2, phone.getPhonename());
		pp.setDouble(3, phone.getPrice());
		pp.setInt(4, phone.getNum());
		pp.setString(5, phone.getAddress());
		
		pp.execute();
		pp.close();
		conn.close();
	}
	
	public static void addNum(CartBean cb) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql = "update cart set num = ? where phonename=? ";
		PreparedStatement pp = conn.prepareStatement(sql);
		pp.setInt(1, cb.getNum()+1);
		pp.setString(2, cb.getPhonename());
		
		pp.execute();
		pp.close();
		conn.close();
	}
	
	public static void delNum(CartBean cb) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql = "update cart set num = ? where phonename=? ";
		String ss = "delete from cart  where phonename=? ";
		PreparedStatement pp = null;
		if(cb.getNum()<=1){
			pp = conn.prepareStatement(ss);
			pp.setString(1, cb.getPhonename());
		}
		else{
			pp = conn.prepareStatement(sql);
			pp.setInt(1, cb.getNum()-1);
			pp.setString(2, cb.getPhonename());
		}	
		pp.execute();
		pp.close();
		conn.close();
	}
	
	public static void delNum(CartBean cb,int num) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql = "delete from cart  where phonename=? ";
		PreparedStatement pp = null;
		pp = conn.prepareStatement(sql);
		pp.setString(1, cb.getPhonename());
		pp.execute();
		pp.close();
		conn.close();
	}

	public static CartBean findPhone(String phonename,String username,int num)  throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from cart where phonename = ? and username = ? ";
		PreparedStatement pp = conn.prepareStatement(sql);
		pp.setString(1, phonename);
		pp.setString(2, username);
		ResultSet rs =  pp.executeQuery();
		CartBean cb = new CartBean(); 
		while(rs.next()){
			cb.setUsername(rs.getString("username"));
			cb.setPhonename(rs.getString("phonename"));
			cb.setPrice(rs.getDouble("price"));
			cb.setNum(rs.getInt("num"));
			cb.setAddress(rs.getString("address"));
		}
		rs.close();
		pp.close();
		conn.close();
		return cb;
	}
	
	public static List<CartBean> findPhone()  throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from cart";
		PreparedStatement pp = conn.prepareStatement(sql);
		ResultSet rs =  pp.executeQuery();
		List<CartBean> cbs = new ArrayList<CartBean>(); 
		while(rs.next()){
			CartBean cb = new CartBean(); 
			cb.setPhonename(rs.getString("phonename"));
			cb.setPrice(rs.getDouble("price"));
			cb.setNum(rs.getInt("num"));
			cb.setAddress(rs.getString("address"));
			cbs.add(cb);
		}
		rs.close();
		pp.close();
		conn.close();
		return cbs;
	}
	
	public static List<CartBean> findPhone(String username,int num)  throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from cart where username = ? ";
		PreparedStatement pp = conn.prepareStatement(sql);
		pp.setString(1, username);
		ResultSet rs =  pp.executeQuery();
		List<CartBean> cbs = new ArrayList<CartBean>(); 
		while(rs.next()){
			CartBean cb = new CartBean(); 
			cb.setPhonename(rs.getString("phonename"));
			cb.setPrice(rs.getDouble("price"));
			cb.setNum(rs.getInt("num"));
			cb.setAddress(rs.getString("address"));
			cbs.add(cb);
		}
		rs.close();
		pp.close();
		conn.close();
		return cbs;
	}
	
}
