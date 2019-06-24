<title>支出登録</title>
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
			<form action="spending">
				<table>
					<tr>
						<td colspan="2">
							<div class="cp_iptxt">
								<input class="ef" name="value" type="text" placeholder=""
									required> <label>摘要</label> <span class="focus_line"></span>
							</div>

						</td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="cp_iptxt">
								<input class="ef" name="price" type="tel" placeholder=""
									required> <label>金額</label> <span class="focus_line"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td></td>
						<td align="right"><input type="submit" value="登録"
							class="button"></td>
					</tr>

				</table>
			</form>
		</div>
	</div>
</body>
</html>