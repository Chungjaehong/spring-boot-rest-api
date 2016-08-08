package com.son.restapi.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.son.restapi.repository.vo.PostVO;

@Repository
public interface FeedRepository {

	public List<PostVO> getFeedsAll(@Param("from_id")String from_id) throws Exception;
	
	public List<PostVO> getFeeds(@Param("from_id")String from_id, @Param("to_id")String to_id) throws Exception;
}
