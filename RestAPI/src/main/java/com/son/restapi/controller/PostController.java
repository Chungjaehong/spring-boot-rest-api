package com.son.restapi.controller;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.son.restapi.repository.PostRepository;
import com.son.restapi.repository.vo.PostVO;
import com.son.restapi.repository.vo.ResultVO;

/**
 * 포스팅 관련 기능
 * @author seok
 */
@Controller
@RequestMapping("/posts")
public class PostController {
	
	public static final String FILE_UPLOAD_ROOT = "C:\\codetest";
	
	@Autowired
	private CommonController commonController;
	
	@Autowired
	private PostRepository postRepository;
	
	/**
	 * 포스팅 전체 리스트
	 * <pre>
	 * support GET method
	 * ex)http://localhost:8080/posts
	 * </pre>
	 * @return 포스팅 리스트
	 * @throws Exception
	 */
	@RequestMapping(value="",
					method=RequestMethod.GET,
					produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public List<PostVO> getPosts() throws Exception {
	
		return postRepository.getPosts();
	}
	
	/**
	 * 포스팅 정보 조회
	 * <pre>
	 * support GET method
	 * ex)http://localhost:8080/posts/1
	 * </pre>
	 * @param seq
	 * @return 포스팅 정보
	 * @throws Exception
	 */
	@RequestMapping(value="{seq}",
					method=RequestMethod.GET,
					produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public PostVO getPost(@PathVariable("seq")int seq) throws Exception {
	
		return postRepository.getPost(seq);
	}
	
	/**
	 * 포스팅 등록 화면
	 * <pre>
	 * support GET method
	 * ex)http://localhost:8080/posts/form
	 * </pre>
	 * @param model
	 * @return 포스팅 등록 뷰 화면
	 * @throws Exception
	 */
	@RequestMapping(value="form", method=RequestMethod.GET)
    public String createPostForm(Model model) throws Exception{
		PostVO postVO = new PostVO();
		model.addAttribute("post", postVO);
        
		return "post";
	}
	
	/**
	 * 포스팅 수정 화면
	 * <pre>
	 * support GET method
	 * ex)http://localhost:8080/posts/1/form
	 * </pre>
	 * @param seq
	 * @param model
	 * @return 포스팅 수정 뷰 화면
	 * @throws Exception
	 */
	@RequestMapping(value="{seq}/form", method=RequestMethod.GET)
    public String updatePostForm(@PathVariable("seq")int seq, Model model) throws Exception{
		
		PostVO postVO = postRepository.getPost(seq);
		model.addAttribute("post", postVO);
        
		return "post";
	}
	
	/**
	 * 포스팅 등록,수정
	 * <pre>
	 * support POST method
	 * ex)http://localhost:8080/posts
	 * </pre>
	 * @param postVO
	 * @return 포스팅 등록,수정 결과
	 * @throws Exception
	 */
	@RequestMapping(value="", method=RequestMethod.POST)
	@ResponseBody
	public ResultVO postPost(@ModelAttribute PostVO postVO) throws Exception {
		
		// 파일 업로드
		if (!postVO.getAttach().getOriginalFilename().isEmpty()) {
			Path path = FileSystems.getDefault().getPath(FILE_UPLOAD_ROOT, "");
			if (Files.notExists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}))
				Files.createDirectory(path);
			
			Files.copy(postVO.getAttach().getInputStream(),
						Paths.get(FILE_UPLOAD_ROOT, postVO.getAttach().getOriginalFilename()));
			
			postVO.setFile(postVO.getAttach().getOriginalFilename());
		}
		
		int result = 0;
		if (postVO.getSeq() > 0)
			result = postRepository.updatePost(postVO);
		else
			result = postRepository.createPost(postVO);
		
		return commonController.returnResult(result, "Posting Post");
	}
	
	/**
	 * 포스팅 수정
	 * <pre>
	 * support PATCH method
	 * ex)http://localhost:8080/posts
	 * </pre>
	 * @param postVO
	 * @return 포스팅 수정 결과
	 * @throws Exception
	 *//*
	@RequestMapping(value="", method=RequestMethod.POST,
			produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ResultVO updatePost(@ModelAttribute PostVO postVO) throws Exception {
		
		if (!postVO.getAttach().isEmpty()) {
			postVO.setFile(postVO.getAttach().getOriginalFilename());
		}
		int result = postRepository.updatePost(postVO);
		
		return commonController.returnResult(result, "Update Post");
	}*/
	
	/**
	 * 포스팅 삭제
	 * <pre>
	 * support DELETE method
	 * ex)http://localhost:8080/posts/1
	 * </pre>
	 * @param seq
	 * @return 포스팅 삭제 결과
	 * @throws Exception
	 */
	@RequestMapping(value="{seq}",
			method=RequestMethod.DELETE,
			produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ResultVO deleteUser(@PathVariable("seq")int seq) throws Exception {
		
		int result = postRepository.deletePost(seq);
		
		return commonController.returnResult(result, "Delete Post");
	}
}
