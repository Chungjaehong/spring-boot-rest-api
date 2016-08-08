# spring-boot-rest-api

<br/> <b>1. 개발환경</b>
<br/> jdk1.7
<br/> MySQL
<br/>
<br/>
<br/> <b>2. 사전에 DB 스키마, 테이블 생성 필요</b>
<br/> create schema codetest;
<br/>
<br/> use codetest;
<br/>
<br/> CREATE TABLE user
<br/> (
<br/> 	user_id VARCHAR(20) NOT NULL PRIMARY KEY,
<br/> 	user_name VARCHAR(50) NOT NULL,
<br/> 	regist_dt DATETIME NULL,
<br/> 	INDEX idx_uesr_user_id(user_id)
<br/> );
<br/>
<br/> CREATE TABLE follow (
<br/> 	from_id VARCHAR(20) NOT NULL,
<br/> 	to_id VARCHAR(20) NOT NULL,
<br/> 	regist_dt DATETIME NULL,
<br/> 	PRIMARY KEY (from_id, to_id)
<br/> );
<br/>
<br/> CREATE TABLE post
<br/> (
<br/> 	seq INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
<br/> 	title VARCHAR(255) NOT NULL,
<br/> 	content TEXT NOT NULL,
<br/> 	file VARCHAR(255) NULL,
<br/> 	reg_id VARCHAR(20) NOT NULL,
<br/> 	regist_dt DATETIME NULL,
<br/> 	update_dt DATETIME NULL,
<br/> 	INDEX idx_post_reg_id(reg_id)
<br/> );
<br/>
