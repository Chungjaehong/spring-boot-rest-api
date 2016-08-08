package com.son.restapi.controller;

import org.springframework.stereotype.Controller;

import com.son.restapi.repository.vo.ResultVO;

/**
 * 공통 기능
 * @author seok
 */
@Controller
public class CommonController {

	/**
	 * 트랜잭션 처리 결과 Return
	 * @param code
	 * @param message
	 * @return 트랜잭션 처리 결과
	 */
	public ResultVO returnResult(int code, String message) {
		
		ResultVO resultVO = new ResultVO();
		resultVO.setCode(Integer.toString(code));
		if (code == 1)
			resultVO.setMesage("Success "+message);
		else
			resultVO.setMesage("Fail "+message);
		
		return resultVO;
	}
}
