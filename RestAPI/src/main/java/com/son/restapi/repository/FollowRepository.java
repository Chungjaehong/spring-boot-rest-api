package com.son.restapi.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.son.restapi.repository.vo.FollowVO;

@Repository
public interface FollowRepository {

	public List<FollowVO> getFollows(@Param("from_id") String from_id) throws Exception;
	
	public int createFollow(@Param("from_id")String from_id, @Param("to_id")String to_id) throws Exception;
	
	public int deleteFollow(@Param("from_id")String from_id, @Param("to_id")String to_id) throws Exception;
}
