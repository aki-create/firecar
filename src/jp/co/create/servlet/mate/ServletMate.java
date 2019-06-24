package jp.co.create.servlet.mate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.create.dto.User;

public abstract class ServletMate extends HttpServlet {
	// -------------------------------------- プロパティ群
	/** HttpServletRequest */
	protected HttpServletRequest request;
	/** HttpServletResponse */
	protected HttpServletResponse response;
	/** HttpSession */
	protected HttpSession session;
	/** ErrorMessage */
	protected String message;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");

		this.request = req;
		this.response = res;
		this.session = req.getSession();

		/*
		 * （エラーが表示されるようになると出るバグ） エラーメッセージが残ってしまうバグ対応
		 */
		this.message = null;

		String nextPage = this.getPageName();
		try {
			// ログインチェック
			if (!"login".equals(this.getPageName())) {
				if (session != null) {
					User user = (User) session.getAttribute("USER_DATA");
					if (user == null || "".equals(user.getUserName())) {

						nextPage = "login";

						throw new Exception("不正なログイン、またはログイン有効期間が過ぎています");
					}
				}
			}

			// 画面ごとの処理
			nextPage = this.doAction();
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}

		/*
		 * エラーメッセージ表示バグの修正
		 */
		// arg0.setAttribute("message", this.message);
		req.setAttribute("errMsg", this.message);

		req.getRequestDispatcher(nextPage + ".jsp").forward(req, res);
	}

	// -------------------------------------- Utilメソッド群
	protected String[] getInputParameter(String... names) {
		String[] values = new String[names.length];
		for (int i = 0; i < names.length; i++) {
			values[i] = this.request.getParameter(names[i]);
			/*
			 * 入力チェック時に値を保持できないバグ修正
			 */
			this.request.setAttribute(names[i], values[i]);
		}
		return values;
	}

	// -------------------------------------- 抽象メソッド群
	protected abstract String getPageName();

	protected abstract String doAction() throws Exception;
}