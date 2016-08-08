package com.son.restapi.repository.vo;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class PostVO {

	private int seq;
	private String title;
	private String content;
	private String file;
	private String reg_id;
	private Timestamp regist_dt;
	private Timestamp update_dt;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public Timestamp getRegist_dt() {
		return regist_dt;
	}
	public void setRegist_dt(Timestamp regist_dt) {
		this.regist_dt = regist_dt;
	}
	public Timestamp getUpdate_dt() {
		return update_dt;
	}
	public void setUpdate_dt(Timestamp update_dt) {
		this.update_dt = update_dt;
	}
	
	//@JsonIgnore
	private MultipartFile attach;

	public MultipartFile getAttach() {
		return attach;
	}
	public void setAttach(MultipartFile attach) {
		this.attach = attach;
	}
}
