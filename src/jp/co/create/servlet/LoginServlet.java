package jp.co.create.servlet;

import javax.servlet.annotation.WebServlet;

import jp.co.create.dao.UserDao;
import jp.co.create.dto.User;
import jp.co.create.servlet.mate.ServletMate;
import jp.co.create.util.Utility;
@WebServlet(name="login", urlPatterns={"/login"})
public class LoginServlet extends ServletMate {

	@Override
	protected String getPageName() {
		// TODO 自動生成されたメソッド・スタブ
		return "login";
	}

	@Override
	protected String doAction() throws Exception {
		//DB接続
		Utility.connectionDb();

		//入力された項目を取得
		int id = Integer.parseInt(request.getParameter("id"));
		String pass = request.getParameter("pass");

		// 入力された情報がDBにあるか？
		User user = UserDao.doLogin(id, pass);

		//DB切断
		Utility.disConnectionDb();

		// 入力された情報がDBになかった場合
		if (user == null) {
			throw new Exception("IDまたはパスワードが間違っています");
		}

		// 取得した情報をセッションへ格納
		super.session.setAttribute("USER_DATA", user);

		return "menu";
	}
}