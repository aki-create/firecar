<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="jp.co.create.dto.Article"%>
<title>支出一覧</title>
<%
	//検索結果
	ArrayList<Article> articles = (ArrayList<Article>) request.getAttribute("SPENDING_LIST");
	int tmp = 0;
	for (Article article : articles) {
		tmp += article.getArticlePost();
	}
%>
<style>
table {
	border-collapse: collapse;
}

td, th {
	border-top: 1px solid #666;
	padding: 10px;
}

tr:last-child td, tr:last-child th {
	border-bottom: 1px solid #666;
}
</style>
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
			<h2>支出一覧</h2>
			<p>
				支出合計 : ￥<%=tmp%></p>
			<table>
				<tr>
					<th>摘要</th>
					<th>値段</th>
				</tr>
				<%
					for (Article article : articles) {
				%>
				<tr>
					<td><%=article.getArticleName()%></td>
					<td>￥<%=article.getArticlePost()%></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
	</div>
</body>
</html>