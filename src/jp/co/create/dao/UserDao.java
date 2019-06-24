package jp.co.create.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.create.dto.User;
import jp.co.create.util.Utility;

public class UserDao {
	//=======================================================set
	/**
	 * UserInfoテーブルの1レコード格納用
	 * @param r　テーブルの全情報
	 * @param e　1レコード分格納するインスタンス
	 * @return　1レコード分格納が終わったインスタンス
	 * @throws SQLException
	 */
	public static User setUser(ResultSet r, User e) throws SQLException {
		e.setUserId(r.getInt("user_id"));
		e.setUserName(r.getString("user_name"));
		e.setUserPass(r.getString("user_pass"));

		//debug
		System.out.println("----------------------------setUserInfo:UserDao:start");
		System.out.println("user_id:" + r.getInt("user_id"));
		System.out.println("user_name:" + r.getString("user_name"));
		System.out.println("user_pass:" + r.getString("user_pass"));
		System.out.println("----------------------------setUserInfo:UserDao:end");

		return e;
	}

	//=======================================================select

	/**
	 * ログインで入力された情報で検索を行う
	 * @param mail
	 * @param pass
	 * @return ログイン情報に合致したユーザ情報
	 */
	public static User doLogin(int id, String pass) throws SQLException {

		User user = new User();

		//SQL文作成
		String sqlSelect = " select * from user "
				+ " where user_id = ? and user_pass = ?;";

		//ステートメント生成
		PreparedStatement s = Utility.getCon().prepareStatement(sqlSelect);

		s.setInt(1, id);
		s.setString(2, pass);

		//SELECT文実行
		ResultSet r = s.executeQuery();

		//dtoインスタンスのフィールドに値をセットする.
		while (r.next()) {
			// 値の取得
			user = setUser(r, user);
		}

		s.close();

		return user;

	}
}
