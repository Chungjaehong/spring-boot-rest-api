package com.son.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.son.restapi.repository.FollowRepository;
import com.son.restapi.repository.vo.FollowVO;
import com.son.restapi.repository.vo.ResultVO;

/**
 * 팔로잉 관련 기능
 * @author seok
 */
@RestController
@RequestMapping("/follows/{from_id}")
public class FollowController {
	
	@Autowired
	private CommonController commonController;
	
	@Autowired
	FollowRepository followRepository;

	/**
	 * 특정 사용자의 팔로잉 전체 리스트
	 * <pre>
	 * support GET Method
	 * ex)http://localhost:8080/follows/seok
	 * </pre>
	 * @return 팔로잉 리스트
	 * @throws Exception
	 */
	@RequestMapping(value="", method=RequestMethod.GET,
			produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<FollowVO> getFollows(@PathVariable("from_id")String from_id) throws Exception {
		
		return followRepository.getFollows(from_id);
	}
	
	/**
	 * 팔로잉 등록
	 * <pre>
	 * support POST method
	 * ex)http://localhost:8080/follows/seok/targets/hyo
	 * </pre>
	 * @param from_id
	 * @param to_id
	 * @return 팔로잉 등록 결과
	 * @throws Exception
	 */
	@RequestMapping(value="targets/{to_id}", method=RequestMethod.POST,
					produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResultVO createFollow(@PathVariable("from_id")String from_id
							   , @PathVariable("to_id")String to_id) throws Exception {
		
		int result = followRepository.createFollow(from_id, to_id);
		
		return commonController.returnResult(result, "Insert Follow");
	}
	
	/**
	 * 팔로잉 삭제
	 * <pre>
	 * support DELETE method
	 * ex)http://localhost:8080/follows/seok/targets/hyo
	 * </pre>
	 * @param from_id
	 * @param to_id
	 * @return 팔로잉 삭제 결과
	 * @throws Exception
	 */
	@RequestMapping(value="targets/{to_id}", method=RequestMethod.DELETE,
					produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResultVO deleteFollow(@PathVariable("from_id")String from_id
							   , @PathVariable("to_id")String to_id) throws Exception {
		
		int result = followRepository.deleteFollow(from_id, to_id);
		
		return commonController.returnResult(result, "Delete Follow");
	}
}
