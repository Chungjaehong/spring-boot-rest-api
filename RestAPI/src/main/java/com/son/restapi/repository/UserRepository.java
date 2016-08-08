package com.son.restapi.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.son.restapi.repository.vo.UserVO;

@Repository
public interface UserRepository {
	
	public List<UserVO> getUsers() throws Exception;
	
	public UserVO getUser(@Param("user_id") String user_id) throws Exception;
	
	public int createUser(UserVO userVO) throws Exception;
	
	public int updateUser(UserVO userVO) throws Exception;
	
	public int deleteUser(@Param("user_id") String user_id) throws Exception;
}
