package org.edu.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.edu.service.IF_BoardService;
import org.edu.service.IF_MemberService;
import org.edu.vo.BoardVO;
import org.edu.vo.MemberVO;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminController {
	
	@Inject
	private IF_BoardService boardService;
	
	@Inject
	private IF_MemberService memberService;
	//첨부파일 업로드 경로 변수값으로 가져옴 servlet-context.xml
	@Resource(name="uploadPath")
	private String uploadPath;
	
	/**
	 * 게시물 상세보기에서 첨부파일 다운로드 메서드 구현
	 */
	@RequestMapping(value="/download", method=RequestMethod.GET)
	@ResponseBody
	public FileSystemResource fileDownload(@RequestParam("filename") String fileName, HttpServletResponse response) {
		File file = new File(uploadPath + "/" + fileName);
		response.setContentType("application/download; utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		return new FileSystemResource(file);
	}
	
	/**
	 * 게시물관리 리스트 입니다.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/admin/board/list", method = RequestMethod.GET)
	public String boardList(Locale locale, Model model) throws Exception {
		List<BoardVO> list = boardService.selectBoard();
		//모델클래스로 jsp화면으로 boardService에서 셀렉트한 list값을 boardList변수명으로 보낸다.
		//model { list -> boardList -> jsp }
		model.addAttribute("boardList", list);
		return "admin/board/board_list";
	}
	/**
	 * 게시물관리 상세보기 입니다.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/admin/board/view", method = RequestMethod.GET)
	public String boardView(@RequestParam("bno") Integer bno,Locale locale, Model model) throws Exception {
		BoardVO boardVO = boardService.viewBoard(bno);
		//여기서 부터 첨부파일명 때문에 추가
		List<String> files = boardService.selectAttach(bno);
		String[] filenames = new String[files.size()];
		int cnt = 0;
		for(String fileName : files) {
			filenames[cnt++] = fileName;
		}
		//여러개 파일에서 1개 파일만 받는 것으로 변경
		//String[] filenames = new String[] {files};
		boardVO.setFiles(filenames);//String[]
		//여기까지 첨부파일때문에 추가
		model.addAttribute("boardVO", boardVO);
		return "admin/board/board_view";
	}
	
	/**
	 * 게시물관리 > 등록 입니다.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/admin/board/write", method = RequestMethod.GET)
	public String boardWrite(Locale locale, Model model) throws Exception {
		
		return "admin/board/board_write";
	}
	@RequestMapping(value = "/admin/board/write", method = RequestMethod.POST)
	public String boardWrite(MultipartFile file,BoardVO boardVO,Locale locale, RedirectAttributes rdat) throws Exception {
		//System.out.println("========첨부파일없이 저장===" + file.getOriginalFilename());
		if(file.getOriginalFilename() == "") {
			//첨부파일 없이 저장
			boardService.insertBoard(boardVO);
		}else {
			String originalName = file.getOriginalFilename();//jsp에서 전송받은 파일의 이름 가져옴
			UUID uid = UUID.randomUUID();//랜덤문자 구하기
			String saveName = uid.toString() + "." + originalName.split("\\.")[1];//한글 파일명 처리 때문에...
			String[] files = new String[] {saveName};//형변환
			boardVO.setFiles(files);
			boardService.insertBoard(boardVO);
			//이 위는 DB에 첨부파일명을 저장하기 까지
			//이 아래 부터 실제 파일을 폴더에 저장하기 시작
			byte[] fileData = file.getBytes();
			File target = new File(uploadPath, saveName);
			FileCopyUtils.copy(fileData, target);
			
		}
		rdat.addFlashAttribute("msg", "입력");
		return "redirect:/admin/board/list";
	}
	
	/**
	 * 게시물관리 > 수정 입니다.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/admin/board/update", method = RequestMethod.GET)
	public String boardUpdate(@RequestParam("bno") Integer bno, Locale locale, Model model) throws Exception {
		BoardVO boardVO = boardService.viewBoard(bno);
		model.addAttribute("boardVO", boardVO);
		return "admin/board/board_update";
	}
	@RequestMapping(value = "/admin/board/update", method = RequestMethod.POST)
	public String boardUpdate(BoardVO boardVO,Locale locale, RedirectAttributes rdat) throws Exception {
		boardService.updateBoard(boardVO);
		rdat.addFlashAttribute("msg", "수정");
		return "redirect:/admin/board/view?bno=" + boardVO.getBno();
	}
	
	/**
	 * 게시물관리 > 삭제 입니다.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/admin/board/delete", method = RequestMethod.POST)
	public String boardDelete(@RequestParam("bno") Integer bno, Locale locale, RedirectAttributes rdat) throws Exception {
		List<String> files = boardService.selectAttach(bno);
		boardService.deleteBoard(bno);
		
		//첨부파일 삭제
		for(String fileName : files) {
			//삭제 명령문 추가(아래)
			File target = new File(uploadPath, fileName);
			if(target.exists()) {
				target.delete();
			}
		}
		rdat.addFlashAttribute("msg", "삭제");
		return "redirect:/admin/board/list";
	}
	
	
	/**
	 * 회원관리 리스트 입니다.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/admin/member/list", method = RequestMethod.GET)
	public String memberList(Locale locale, Model model) throws Exception {
		List<MemberVO> list = memberService.selectMember();
		//모델클래스로 jsp화면으로 memberService에서 셀렉트한 list값을 memberList변수명으로 보낸다.
		//model { list -> memberList -> jsp }
		model.addAttribute("memberList", list);
		return "admin/member/member_list";
	}
	
	/**
	 * 회원관리 상세보기 입니다.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/admin/member/view", method = RequestMethod.GET)
	public String memberView(@RequestParam("user_id") String user_id, Locale locale, Model model) throws Exception {
		MemberVO memberVO = memberService.viewMember(user_id);
		model.addAttribute("memberVO", memberVO);
		return "admin/member/member_view";
	}
	
	/**
	 * 회원관리 > 등록 입니다.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/admin/member/write", method = RequestMethod.GET)
	public String memberWrite(Locale locale, Model model) throws Exception {
		
		return "admin/member/member_write";
	}
	@RequestMapping(value = "/admin/member/write", method = RequestMethod.POST)
	public String memberWrite(MemberVO memberVO, Locale locale, RedirectAttributes rdat) throws Exception {
		memberService.insertMember(memberVO);
		rdat.addFlashAttribute("msg", "입력");
		return "redirect:/admin/member/list";
	}
	
	/**
	 * 회원관리 > 수정 입니다.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/admin/member/update", method = RequestMethod.GET)
	public String memberUpdate(@RequestParam("user_id") String user_id, Locale locale, Model model) throws Exception {
		MemberVO memberVO = memberService.viewMember(user_id);
		model.addAttribute("memberVO", memberVO);
		return "admin/member/member_update";
	}
	@RequestMapping(value = "/admin/member/update", method = RequestMethod.POST)
	public String memberUpdate(MemberVO memberVO, Locale locale, RedirectAttributes rdat) throws Exception {
		memberService.updateMember(memberVO);
		rdat.addFlashAttribute("msg", "수정");
		return "redirect:/admin/member/view?user_id=" + memberVO.getUser_id();
	}
	
	/**
	 * 회원관리 > 삭제 입니다.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/admin/member/delete", method = RequestMethod.POST)
	public String memberDelete(@RequestParam("user_id") String user_id, Locale locale, RedirectAttributes rdat) throws Exception {
		memberService.deleteMember(user_id);
		rdat.addFlashAttribute("msg", "삭제");
		return "redirect:/admin/member/list";
	}
	
	/**
	 * 관리자 홈 입니다.
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "admin/home";
	}
	
}