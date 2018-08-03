package zzy.phoneStore.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static String driveClassName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/phonestore?useUnicode=true&characterEncoding=utf-8";

	private static String username = "root";
	private static String password = "root";

	public static Connection getConnection() {
		Connection conn = null;

		// load driver
		try {
			Class.forName(driveClassName);
		} catch (ClassNotFoundException e) {
			System.out.println("load driver failed!");
			e.printStackTrace();
		}

		// connect db
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("connect failed!");
			e.printStackTrace();
		}

		return conn;
	}

}
