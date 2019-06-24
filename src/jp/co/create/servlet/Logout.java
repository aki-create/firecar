package jp.co.create.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import jp.co.create.servlet.mate.ServletMate;

@WebServlet(name = "logout", urlPatterns = { "/logout" })
public class Logout extends ServletMate {

	@Override
	protected String getPageName() {
		return "logout";
	}

	@Override
	protected String doAction() throws Exception {
		//セッションの破棄
		HttpSession session = request.getSession(true);
		session.invalidate();

		//ログイン画面に戻る
		return "login";
	}
}