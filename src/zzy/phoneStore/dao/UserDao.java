package zzy.phoneStore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import zzy.phoneStore.bean.UserBean;
import zzy.phoneStore.utils.DBUtil;

public class UserDao {

	public static void addUser(UserBean user) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql = "insert into users(username,password,email,phone,address,id) value(?,?,?,?,?,?)";
		PreparedStatement pp = conn.prepareStatement(sql);
		pp.setString(1, user.getUsername());
		pp.setString(2, user.getPassword());
		pp.setString(3, user.getEmail());
		pp.setString(4, user.getPhone());
		pp.setString(5, user.getAddress());
		pp.setString(6, "user");
		pp.execute();
		pp.close();
		conn.close();
	}
	
	
	public static UserBean findUser(String username) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql = "select * from users where username=?";
		PreparedStatement pp = conn.prepareStatement(sql);
		pp.setString(1, username);		
		ResultSet rs =  pp.executeQuery();
		UserBean user = new UserBean();
		if(!rs.next()){
			return null;
		}
		else{
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
			user.setEmail(rs.getString(3));
			user.setPhone(rs.getString(4));
			user.setAddress(rs.getString(5));
			user.setId(rs.getString(6));
		}
		pp.close();
		conn.close();
		return user;
	}
	
}
