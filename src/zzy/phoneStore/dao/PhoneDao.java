package zzy.phoneStore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zzy.phoneStore.bean.PhoneBean;
import zzy.phoneStore.utils.DBUtil;

public class PhoneDao {

	public static List<PhoneBean> findPhones() throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from phones";
		PreparedStatement pp = conn.prepareStatement(sql);
		ResultSet rs = pp.executeQuery();
		List<PhoneBean> ph = new ArrayList<PhoneBean>();
		while (rs.next()) {
			PhoneBean pbn = new PhoneBean();
			pbn.setPhonename(rs.getString("phonename"));
			pbn.setPrice(rs.getDouble("price"));
			pbn.setImage(rs.getBlob("image"));
			pbn.setAddress(rs.getString("address"));
			pbn.setNum(rs.getInt("num"));
			pbn.setItcalss(rs.getString("class"));
			ph.add(pbn);
		}
		rs.close();
		pp.close();
		conn.close();
		return ph;
	}

	public static List<PhoneBean> findPhones(String name) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from " + name;
		PreparedStatement pp = conn.prepareStatement(sql);
		ResultSet rs = pp.executeQuery();
		List<PhoneBean> ph = new ArrayList<PhoneBean>();
		while (rs.next()) {
			PhoneBean pbn = new PhoneBean();
			pbn.setPhonename(rs.getString("phonename"));
			pbn.setPrice(rs.getDouble("price"));
			pbn.setImage(rs.getBlob("image"));
			pbn.setAddress(rs.getString("address"));
			pbn.setItcalss(rs.getString("class"));
			ph.add(pbn);
		}
		rs.close();
		pp.close();
		conn.close();
		return ph;
	}

	public static PhoneBean findPhones(String address, String method)
			throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from " + method + " where address=? ";
		PreparedStatement pp = conn.prepareStatement(sql);
		pp.setString(1, address);
		ResultSet rs = pp.executeQuery();
		PhoneBean pb = new PhoneBean();
		while (rs.next()) {
			pb.setPhonename(rs.getString("phonename"));
			pb.setPrice(rs.getDouble("price"));
			pb.setImage(rs.getBlob("image"));
			pb.setAddress(rs.getString("address"));
			pb.setItcalss(rs.getString("class"));
		}
		rs.close();
		pp.close();
		conn.close();
		return pb;
	}

	public static PhoneBean findPhones(String name, int num)
			throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from phones where phonename = ?";
		PreparedStatement pp = conn.prepareStatement(sql);
		pp.setString(1, name);
		ResultSet rs = pp.executeQuery();
		PhoneBean pbn = new PhoneBean();
		while (rs.next()) {
			pbn.setPhonename(rs.getString("phonename"));
			pbn.setPrice(rs.getDouble("price"));
			pbn.setImage(rs.getBlob("image"));
			pbn.setAddress(rs.getString("address"));
			pbn.setNum(rs.getInt("num"));
			pbn.setItcalss(rs.getString("class"));
		}
		rs.close();
		pp.close();
		conn.close();
		return pbn;
	}

	public static List<PhoneBean> findPhones(String lipn,int num1,int num2) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from phones";
		PreparedStatement pp = conn.prepareStatement(sql);
		ResultSet rs = pp.executeQuery();
		List<PhoneBean> ph = new ArrayList<PhoneBean>();
		while (rs.next()) {
			PhoneBean pbn = new PhoneBean();
			pbn.setPhonename(rs.getString("phonename"));
			pbn.setPrice(rs.getDouble("price"));
			pbn.setImage(rs.getBlob("image"));
			pbn.setAddress(rs.getString("address"));
			pbn.setNum(rs.getInt("num"));
			pbn.setItcalss(rs.getString("class"));
			ph.add(pbn);
		}
		rs.close();
		pp.close();
		conn.close();
		return ph;
	}
	
	public static void addNum(PhoneBean pb) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "update phones set num = ? where phonename=? ";
		PreparedStatement pp = conn.prepareStatement(sql);
		pp.setInt(1, pb.getNum() + 1);
		pp.setString(2, pb.getPhonename());

		pp.execute();
		pp.close();
		conn.close();
	}

	public static void delNum(PhoneBean pb) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "update phones set num = ? where phonename=? ";
		String ss = "delete from phones  where phonename=? ";
		PreparedStatement pp = null;
		if (pb.getNum() <= 1) {
			System.out.println(333);
			pp = conn.prepareStatement(ss);
			pp.setString(1, pb.getPhonename());
			delPhone(pb);
		} else {
			System.out.println(666);
			pp = conn.prepareStatement(sql);
			pp.setInt(1, pb.getNum() - 1);
			pp.setString(2, pb.getPhonename());
		}
		pp.execute();
		pp.close();
		conn.close();
	}

	public static void delPhone(PhoneBean pb) throws SQLException {
		System.out.println(pb);
		Connection conn = DBUtil.getConnection();
		String ss = "delete from "+pb.getItcalss()+"  where phonename = ? ";
		PreparedStatement pp = null;
		pp = conn.prepareStatement(ss);
		pp.setString(1, pb.getPhonename());
		pp.execute();
		pp.close();
		conn.close();
	}

	public static void delNum(PhoneBean pb, int num) throws SQLException {
		System.out.println(pb);
		delPhone(pb);
		Connection conn = DBUtil.getConnection();
		String sql = "delete from phones  where phonename=? ";
		PreparedStatement pp = null;
		pp = conn.prepareStatement(sql);
		pp.setString(1, pb.getPhonename());
		pp.execute();
		pp.close();
		conn.close();
	}

	public static void Alter(PhoneBean pb) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "update phones set phonename = ? , price = ?  where address=? ";
		PreparedStatement pp = null;
		pp = conn.prepareStatement(sql);
		pp.setString(1, pb.getPhonename());
		pp.setDouble(2, pb.getPrice());
		pp.setString(3, pb.getAddress());
		pp.execute();
		pp.close();
		conn.close();
	}

}
