package com.son.restapi.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.son.restapi.repository.vo.PostVO;

@Repository
public interface PostRepository {

	public List<PostVO> getPosts() throws Exception;
	
	public PostVO getPost(@Param("seq") int seq) throws Exception;
	
	public int createPost(PostVO postVO) throws Exception;
	
	public int updatePost(PostVO postVO) throws Exception;
	
	public int deletePost(@Param("seq") int seq) throws Exception;
	
}
