package zzy.phoneStore.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ImageDemo {

	// ��ͼƬ�������ݿ�
	public static void readImageDB() throws Exception {
		String path = "D:/PhoneStore/apple/2.jpg";
		Connection conn = null;
		PreparedStatement pp = null;
		FileInputStream fis = null;

		fis = ImageUtil.readImage(path);
		conn = DBUtil.getConnection();
		String sql = "insert into phones(phonename,price,image) value(?,?,?)";
		pp = conn.prepareStatement(sql);
		pp.setString(1, "Apple/ƻ�� iPhone 6");
		pp.setDouble(2, 2299.00);
		pp.setBinaryStream(3, fis, fis.available());
		int count = pp.executeUpdate();
		if (count > 0) {
			System.out.println("��ӳɹ�������");
		} else {
			System.out.println("���ʧ�ܣ�����");
		}
		pp.close();
		conn.close();
	}

	// �����ݿ��ȡͼƬ
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
