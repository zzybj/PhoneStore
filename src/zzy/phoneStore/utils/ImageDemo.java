package zzy.phoneStore.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ImageDemo {

	// 将图片插入数据库
	public static void readImageDB() throws Exception {
		String path = "D:/PhoneStore/apple/2.jpg";
		Connection conn = null;
		PreparedStatement pp = null;
		FileInputStream fis = null;

		fis = ImageUtil.readImage(path);
		conn = DBUtil.getConnection();
		String sql = "insert into phones(phonename,price,image) value(?,?,?)";
		pp = conn.prepareStatement(sql);
		pp.setString(1, "Apple/苹果 iPhone 6");
		pp.setDouble(2, 2299.00);
		pp.setBinaryStream(3, fis, fis.available());
		int count = pp.executeUpdate();
		if (count > 0) {
			System.out.println("添加成功！！！");
		} else {
			System.out.println("添加失败！！！");
		}
		pp.close();
		conn.close();
	}

	// 从数据库读取图片
	public static void readDBImage() throws Exception {
		String path = "D:/PhoneStore/apple/one.jpg";
		Connection conn = null;
		PreparedStatement pp = null;
		ResultSet rs = null;

		conn = DBUtil.getConnection();
		String sql = "select * from phones where phonename = ? ";
		pp = conn.prepareStatement(sql);
		pp.setString(1, "1");
		rs =  pp.executeQuery();
		while(rs.next()){
			InputStream is = rs.getBinaryStream("image");
			ImageUtil.readBinImage(is, path);
		}
		pp.close();
		conn.close();
	}
	
	public static void main(String[] args) {
		try {
			readImageDB();
//			readDBImage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
