SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS article;
DROP TABLE IF EXISTS user;




/* Create Tables */

-- 投稿された記事とその投稿者を管理するテーブル
CREATE TABLE article
(
	article_id int NOT NULL AUTO_INCREMENT,
	article_name varchar(20) NOT NULL,
	article_post int NOT NULL,
	user_id int NOT NULL,
	PRIMARY KEY (article_id)
) COMMENT = '投稿された記事とその投稿者を管理するテーブル';


-- ユーザを管理するテーブル
CREATE TABLE user
(
	user_id int NOT NULL AUTO_INCREMENT,
	user_name varchar(50),
	user_pass varchar(50) NOT NULL,
	PRIMARY KEY (user_id)
) COMMENT = 'ユーザを管理するテーブル';

-- ユーザを一人追加する
INSERT INTO user VALUES (null,"a","hoge");

