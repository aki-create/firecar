package jp.co.create.servlet;

import javax.servlet.annotation.WebServlet;

import jp.co.create.dao.ArticleDao;
import jp.co.create.dto.User;
import jp.co.create.servlet.mate.ServletMate;
import jp.co.create.util.Utility;

@WebServlet(name = "spendingCheck", urlPatterns = { "/spendingCheck" })
public class SpendingCheckServlet extends ServletMate {

	@Override
	protected String getPageName() {
		// TODO 自動生成されたメソッド・スタブ
		return "spendingCheck";
	}

	@Override
	protected String doAction() throws Exception {
		//DB接続
		Utility.connectionDb();

		//入力された項目を取得
		String value = request.getParameter("value");
		int price = Integer.parseInt(request.getParameter("price"));
		User user = (User) session.getAttribute("USER_DATA");
		int userId = user.getUserId();

		// 入力された情報をDBに挿入
		ArticleDao.insertArticle(value, price, userId);

		//DB切断
		Utility.disConnectionDb();

		return "spendingResult";
	}
}
