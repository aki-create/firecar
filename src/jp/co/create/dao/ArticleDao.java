package jp.co.create.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.create.dto.Article;
import jp.co.create.util.Utility;

public class ArticleDao {
	//=======================================================set
	/**
	 * Articleテーブルから取得したレコードをインスタンスに格納するメソッド.
	 * @param r テーブルの全情報
	 * @param e 1レコード分格納するインスタンス
	 * @return 1レコード分格納が終わったインスタンス
	 * @throws SQLException
	 */
	public static Article setArticle(ResultSet r, Article e) throws SQLException {
		e.setArticleId(r.getInt("article_id"));
		e.setArticleName(r.getString("article_name"));
		e.setArticlePost(r.getInt("article_post"));
		e.setUserId(r.getInt("user_id"));

		//debug
		System.out.println("----------------------------setArticle:ArticleDao:start");
		System.out.println("article_id : " + r.getInt("article_id"));
		System.out.println("article_name : " + r.getString("article_name"));
		System.out.println("article_post : " + r.getString("article_post"));
		System.out.println("user_id : " + r.getString("user_id"));
		System.out.println("----------------------------setArticle:ArticleDao:end");

		return e;
	}

	//=======================================================select

	/**
	 * ログインで入力された情報で検索を行う
	 * @param mail
	 * @param pass
	 * @return ログイン情報に合致したユーザ情報
	 */
	public static ArrayList<Article> partSearch(int userid) throws SQLException {
		Article article = new Article();
		ArrayList<Article> articleArr = new ArrayList<Article>();

		//SQL文作成
		String sqlSelect = " select * from article "
				+ " where "
				+ " user_id = ?;";

		//ステートメント生成
		PreparedStatement s = Utility.getCon().prepareStatement(sqlSelect);

		s.setInt(1, userid);

		//SELECT文実行
		ResultSet r = s.executeQuery();

		//dtoインスタンスのフィールドに値をセットする.
		while (r.next()) {
			article = new Article();
			// 値の取得
			article = setArticle(r, article);

			articleArr.add(article);
		}

		s.close();

		return articleArr;

	}

	/**
	 * 支払登録で使われるメソッド.
	 * DBにレコードを１つ追加する.
	 * @param value 摘要
	 * @param price 金額
	 * @param userId ユーザID
	 */
	public static void insertArticle(String value, int price, int userId) throws SQLException {
		String sqlInsert = " insert into article "
				+ " values "
				+ " (null, ?, ?, ?) ;";

		//ステートメント生成
		PreparedStatement s = Utility.getCon().prepareStatement(sqlInsert);

		s.setString(1, value);
		s.setInt(2, price);
		s.setInt(3, userId);

		//SQL実行
		s.executeUpdate();

	}
}