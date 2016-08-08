package com.son.restapi.repository.vo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonRootName("user")
@JacksonXmlRootElement(localName="user")
public class UserVO {

	private String user_id;
	private String user_name;
	private Timestamp regist_dt;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Timestamp getRegist_dt() {
		return regist_dt;
	}
	public void setRegist_dt(Timestamp regist_dt) {
		this.regist_dt = regist_dt;
	}
}
