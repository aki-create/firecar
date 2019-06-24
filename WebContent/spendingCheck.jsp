<title>支出登録確認</title>
<%@ page import="jp.co.create.dto.User"%>
<%
	//ログイン成功したとき
	User user = (User) session.getAttribute("LOGIN_DATA");
	//String user = (String) session.getAttribute("LOGIN_DATA");
	String kn = "ゲスト";
	//ログイン情報がないとき
	if (user != null) {
		kn = user.getUserName();
		//kn = user;
	}
	String value = (String) request.getAttribute("SPENDING_VALUE");
	int price = (int) request.getAttribute("SPENDING_PRICE");
%>
</head>
<body>
	<div class="wrapper">

		<ul class="topnav">
			<li><a class="active" href="menu.jsp">Home</a></li>
			<li><a href="spending.jsp">支出登録</a></li>
			<li><a href="spendingList.jsp">支出一覧</a></li>
			<li class="right"><a href="logout.jsp">ログアウト</a></li>
		</ul>
		<div class="sample">
			<h2>この内容でよろしいですか？</h2>
			<form action="spendingCheck">
				<table>
					<tr>
						<td colspan="2">
							<div class="cp_iptxt">
								<input class="ef" type="text" name="value" placeholder=""
									value="<%=value%>" readonly> <label>摘要</label> <span
									class="focus_line"></span>
							</div>

						</td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="cp_iptxt">
								<input class="ef" type="tel" name="price" placeholder=""
									value="<%=price%>" readonly> <label>金額</label> <span
									class="focus_line"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td align="right"><a href="spending.jsp" class="button">投稿内容修正</a></td>
						<td align="right"><input type="submit" value="登録"
							class="button"></td>
					</tr>

				</table>
			</form>
		</div>
	</div>
</body>
</html>