package jp.co.create.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utility {
	public final static String DB_INFO = "jdbc:mysql://127.0.0.1:3306/rezodb?serverTimezone=JST";
	public final static String ACCESS_USER = "root";
	public final static String ACCESS_PASS = "p@ssw0rd";

	private static Connection con;

	public static Connection getCon() {
		return con;
	}

	/**
	 * 接続用メソッド
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void connectionDb() throws ClassNotFoundException, SQLException {
		//ドライバ読み込み
		Class.forName("com.mysql.cj.jdbc.Driver");

		//コネクション生成
		con = DriverManager.getConnection(DB_INFO, ACCESS_USER, ACCESS_PASS);

	}

	/**
	 * 切断用メソッド
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void disConnectionDb() throws ClassNotFoundException, SQLException {
		con.close();
	}

}