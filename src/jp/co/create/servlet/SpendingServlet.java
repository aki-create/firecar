package jp.co.create.servlet;

import javax.servlet.annotation.WebServlet;

import jp.co.create.servlet.mate.ServletMate;

@WebServlet(name="spending", urlPatterns={"/spending"})
public class SpendingServlet extends ServletMate {

	@Override
	protected String getPageName() {
		// TODO 自動生成されたメソッド・スタブ
		return "spending";
	}

	@Override
	protected String doAction() throws Exception {
		//入力された項目を取得
		String value = request.getParameter("value");
		int price = Integer.parseInt(request.getParameter("price"));

		//情報をリクエストにセット
		request.setAttribute("SPENDING_VALUE", value);
		request.setAttribute("SPENDING_PRICE", price);

		return "spendingCheck";
	}
}
