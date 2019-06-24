<title>支出登録確認</title>
<%@ page import="jp.co.create.dto.User"%>
<%
	//ログイン成功したとき
	User user = (User) session.getAttribute("USER_DATA");
	String kn = "ゲスト";

	//ログイン情報がないとき
	if (user != null) {
		kn = user.getUserName();
	}
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
			<h2>投稿が完了しました</h2>
			<table>
				<tr>
					<td align="right"><a href="spending.jsp" class="button">続けて登録を行う</a></td>
					<td align="right"><a href="menu.jsp" class="button">メニュー画面に戻る</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>