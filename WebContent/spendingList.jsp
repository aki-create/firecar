<title>支出一覧</title>
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
			<h2>支出の一覧を表示します.よろしいですか?</h2>
			<p>データの検索を行う為, 時間がかかることがあります.</p>
			<form action="spendingList">
				<table>
					<tr>
						<td align="right"><input type="submit" value="表示"
							class="button"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>