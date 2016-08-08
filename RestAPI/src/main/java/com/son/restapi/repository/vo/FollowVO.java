package com.son.restapi.repository.vo;

import java.sql.Timestamp;

public class FollowVO {

	private String from_id;
	private String to_id;
	private Timestamp regist_dt;
	
	public String getFrom_id() {
		return from_id;
	}
	public void setFrom_id(String from_id) {
		this.from_id = from_id;
	}
	public String getTo_id() {
		return to_id;
	}
	public void setTo_id(String to_id) {
		this.to_id = to_id;
	}
	public Timestamp getRegist_dt() {
		return regist_dt;
	}
	public void setRegist_dt(Timestamp regist_dt) {
		this.regist_dt = regist_dt;
	}
}
