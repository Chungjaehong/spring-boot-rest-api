package com.son.restapi.repository.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonRootName("users")
@JacksonXmlRootElement(localName="users")
public class UserListVO {
	
	private List<UserVO> userVO;
	
	public UserListVO() {}
	
	public UserListVO(List<UserVO> userVO) {
		this.userVO = userVO;
	}

	@JsonProperty(value="users")
	@JacksonXmlProperty(localName="user")
	public List<UserVO> getUserVO() {
		return userVO;
	}
	public void setUserVO(List<UserVO> userVO) {
		this.userVO = userVO;
	}

}
