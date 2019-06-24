package jp.co.create.dto;

public class UserArticle {
	/** ユーザID. */
	private Integer userId;

	/** ユーザ名. */
	private String userName;

	/** ユーザパスワード. */
	private String userPass;

	/** 投稿ID. */
	private Integer articleId;

	/** 投稿タイトル. */
	private String articleName;

	/** 投稿内容. */
	private String articlePost;


	/**
	 * コンストラクタ.
	 */
	public UserArticle() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/**
	 * ユーザID を設定します.
	 *
	 * @param userId
	 *            ユーザID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * ユーザID を取得します.
	 *
	 * @return ユーザID
	 */
	public Integer getUserId() {
		return this.userId;
	}

	/**
	 * ユーザ名 を設定します.
	 *
	 * @param userName
	 *            ユーザ名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * ユーザ名 を取得します.
	 *
	 * @return ユーザ名
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * ユーザパスワード を設定します.
	 *
	 * @param userPass
	 *            ユーザパスワード
	 */
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	/**
	 * ユーザパスワード を取得します.
	 *
	 * @return ユーザパスワード
	 */
	public String getUserPass() {
		return this.userPass;
	}

	/**
	 * 投稿ID を取得します.
	 *
	 * @return 投稿ID
	 */
	public Integer getArticleId() {
		return this.articleId;
	}

	/**
	 * 投稿タイトル を設定します.
	 *
	 * @param articleName
	 *            投稿タイトル
	 */
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	/**
	 * 投稿タイトル を取得します.
	 *
	 * @return 投稿タイトル
	 */
	public String getArticleName() {
		return this.articleName;
	}

	/**
	 * 投稿内容 を設定します.
	 *
	 * @param articlePost
	 *            投稿内容
	 */
	public void setArticlePost(String articlePost) {
		this.articlePost = articlePost;
	}

	/**
	 * 投稿内容 を取得します.
	 *
	 * @return 投稿内容
	 */
	public String getArticlePost() {
		return this.articlePost;
	}
}
