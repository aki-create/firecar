package jp.co.create.servlet;

import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;

import jp.co.create.dao.ArticleDao;
import jp.co.create.dto.Article;
import jp.co.create.dto.User;
import jp.co.create.servlet.mate.ServletMate;
import jp.co.create.util.Utility;

@WebServlet(name="spendingList", urlPatterns={"/spendingList"})
public class SpendingList extends ServletMate {

	@Override
	protected String getPageName() {
		// TODO 自動生成されたメソッド・スタブ
		return "spendingList";
	}

	@Override
	protected String doAction() throws Exception {
		//DBに接続
		Utility.connectionDb();

		//ログインしているユーザのIDを取得
		User user = (User) session.getAttribute("USER_DATA");
		int userId = user.getUserId();

		//結果格納用リストを作成
		ArrayList<Article> articles = new ArrayList<Article>();

		//ログインしているユーザの投稿内容を全件取得
		articles = ArticleDao.partSearch(userId);

		//DBを切断
		Utility.disConnectionDb();

		//情報をリクエストにセット
		request.setAttribute("SPENDING_LIST", articles);

		return "spendingListResult";
	}
}
