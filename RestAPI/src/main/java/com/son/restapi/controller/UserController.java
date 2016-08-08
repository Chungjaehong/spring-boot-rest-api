package com.son.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.son.restapi.repository.UserRepository;
import com.son.restapi.repository.vo.ResultVO;
import com.son.restapi.repository.vo.UserListVO;
import com.son.restapi.repository.vo.UserVO;

/**
 * 사용자 관련 기능
 * @author seok
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private CommonController commonController;
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 사용자 전체 리스트
	 * <pre>
	 * support GET method
	 * ex)http://localhost:8080/users
	 * </pre>
	 * @return 사용자 리스트
	 * @throws Exception
	 */
	@RequestMapping(value="", method=RequestMethod.GET,
			produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public UserListVO getUsers() throws Exception {
		
		List<UserVO> userVO = userRepository.getUsers();
		
		return (new UserListVO(userVO));
		//return userRepository.getUsers();
	}
	
	/**
	 * 사용자 정보 조회
	 * <pre>
	 * support GET method
	 * ex)http://localhost:8080/users/seok
	 * </pre>
	 * @param user_id
	 * @return 사용자 정보
	 * @throws Exception
	 */
	@RequestMapping(value="{user_id}", method=RequestMethod.GET,
			produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public UserVO getUser(@PathVariable("user_id")String user_id) throws Exception {
		
		return userRepository.getUser(user_id);
	}
	
	/**
	 * 사용자 등록
	 * <pre>
	 * support POST method
	 * ex)http://localhost:8080/users
	 * </pre>
	 * @param userVO
	 * @return 사용자 등록 결과
	 * @throws Exception
	 */
	@RequestMapping(value="", method=RequestMethod.POST,
			produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResultVO createUser(@ModelAttribute UserVO userVO) throws Exception {
		
		int result = userRepository.createUser(userVO);
		
		return commonController.returnResult(result, "Insert User");
	}
	
	/**
	 * 사용자 수정
	 * <pre>
	 * support PATCH method
	 * ex)http://localhost:8080/users
	 * </pre>
	 * @param userVO
	 * @return 사용자 수정 결과
	 * @throws Exception
	 */
	@RequestMapping(value="", method=RequestMethod.PATCH,
					produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResultVO updateUser(@ModelAttribute UserVO userVO) throws Exception {
		
		int result = userRepository.updateUser(userVO);
		
		return commonController.returnResult(result, "Update User");
	}
	
	/**
	 * 사용자 삭제
	 * <pre>
	 * support DELETE method
	 * ex)http://localhost:8080/users/seok
	 * </pre>
	 * @param user_id
	 * @return 사용자 삭제 결과
	 * @throws Exception
	 */
	@RequestMapping(value="{user_id}", method=RequestMethod.DELETE,
					produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResultVO deleteUser(@PathVariable("user_id")String user_id) throws Exception {
		
		int result = userRepository.deleteUser(user_id);
		
		return commonController.returnResult(result, "Delete User");
	}
}
