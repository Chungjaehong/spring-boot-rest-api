package com.son.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.son.restapi.repository.FeedRepository;
import com.son.restapi.repository.vo.PostVO;

/**
 * 피딩 관련 기능
 * @author seok
 *
 */
@RestController
@RequestMapping("/feeds/{from_id}")
public class FeedController {

	@Autowired
	private FeedRepository feedRepository;
	
	/**
	 * 특정 사용자의 피드 전체 리스트
	 * <pre>
	 * support GET method
	 * ex)http://localhost:8080/feeds/seok
	 * </pre>
	 * @param from_id
	 * @return 피드 리스트
	 * @throws Exception
	 */
	@RequestMapping(value="",
			method=RequestMethod.GET,
			produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<PostVO> getFeedsAll(@PathVariable("from_id")String from_id) throws Exception {
	
		return feedRepository.getFeedsAll(from_id);
	}
	
	/**
	 * 특정 사용자의 특정 팔로잉 대상자의 피드 리스트
	 * <pre>
	 * support GET method
	 * ex)http://localhost:8080/feeds/seok/targets/hyo
	 * </pre>
	 * @param from_id
	 * @param to_id
	 * @return 피드 리스트
	 * @throws Exception
	 */
	@RequestMapping(value="targets/{to_id}",
			method=RequestMethod.GET,
			produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<PostVO> getFeeds(@PathVariable("from_id")String from_id
			  				   , @PathVariable("to_id")String to_id) throws Exception {
	
		return feedRepository.getFeeds(from_id, to_id);
	}
}
