# spring-boot-rest-api

<b>1. 개발환경</b><br/>
jdk1.7<br/>
MySQL<br/>
<br/><br/>

<b>2. 사전에 DB 스키마, 테이블 생성 필요</b><br/>
create schema codetest;
<br/><br/>
use codetest;
<br/><br/>
CREATE TABLE user
(
	user_id VARCHAR(20) NOT NULL PRIMARY KEY,
	user_name VARCHAR(50) NOT NULL,
	regist_dt DATETIME NULL,
	INDEX idx_uesr_user_id(user_id)
);
<br/><br/>
CREATE TABLE follow (
	from_id VARCHAR(20) NOT NULL,
	to_id VARCHAR(20) NOT NULL,
	regist_dt DATETIME NULL,
	PRIMARY KEY (from_id, to_id)
);
<br/><br/>
CREATE TABLE post
(
	seq INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(255) NOT NULL,
	content TEXT NOT NULL,
	file VARCHAR(255) NULL,
	reg_id VARCHAR(20) NOT NULL,
	regist_dt DATETIME NULL,
	update_dt DATETIME NULL,
	INDEX idx_post_reg_id(reg_id)
);
<br/><br/>
