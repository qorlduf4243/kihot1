package org.edu.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.edu.service.IF_BoardService;
import org.edu.service.IF_MemberService;
import org.edu.util.FileDataUtil;
import org.edu.vo.BoardVO;
import org.edu.vo.MemberVO;
import org.edu.vo.PageVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
   
   @Inject
   private IF_MemberService memberService;
   
   @Inject
   private IF_BoardService boardService;
   
   @Inject
   private FileDataUtil fileDataUtil;
   
   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
   /**
    * 게시물관리 > 등록 입니다.
    * @throws Exception 
    */
   @RequestMapping(value = "/board/write", method = RequestMethod.GET)
   public String boardWrite(Locale locale, Model model) throws Exception {
      
      return "board/board_write";
   }
   @RequestMapping(value = "/board/write", method = RequestMethod.POST)
   public String boardWrite(MultipartFile file,@Valid BoardVO boardVO,Locale locale, RedirectAttributes rdat) throws Exception {
      //System.out.println("========첨부파일없이 저장===" + file.getOriginalFilename());
      if(file.getOriginalFilename() == "") {
         //첨부파일 없이 저장
         boardService.insertBoard(boardVO);
      }else {
         String[] files = fileDataUtil.fileUpload(file);
         boardVO.setFiles(files);
         boardService.insertBoard(boardVO);         
      }
      rdat.addFlashAttribute("msg", "입력");
      return "redirect:/board/list";
   }
   
   /**
    * 게시물관리 상세보기 입니다.
    * @throws Exception 
    */
   @RequestMapping(value = "/board/view", method = RequestMethod.GET)
   public String boardView(@ModelAttribute("pageVO") PageVO pageVO, @RequestParam("bno") Integer bno,Locale locale, Model model) throws Exception {
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
      model.addAttribute("pageVO", pageVO);
      model.addAttribute("extNameArray", fileDataUtil.getExtNameArray());
      return "board/board_view";
   }
   
   /**
    * 게시물관리 리스트 입니다.
    * @throws Exception 
    */
   @RequestMapping(value = "/board/list", method = RequestMethod.GET)
   public String boardList(@ModelAttribute("pageVO") PageVO pageVO, Locale locale, Model model) throws Exception {
      //PageVO pageVO = new PageVO();//매개변수로 받기전 테스트용
      if(pageVO.getPage() == null) {
         pageVO.setPage(1);//초기 page변수값 지정
      }
      pageVO.setPerPageNum(10);//1페이지당 보여줄 게시물 수 강제지정
      pageVO.setTotalCount(boardService.countBno(pageVO));//강제로 입력한 값을 쿼리로 대체OK.
      List<BoardVO> list = boardService.selectBoard(pageVO);
      //모델클래스로 jsp화면으로 boardService에서 셀렉트한 list값을 boardList변수명으로 보낸다.
      //model { list -> boardList -> jsp }
      model.addAttribute("boardList", list);
      model.addAttribute("pageVO", pageVO);
      return "board/board_list";
   }
   
   /**
    * 스프링 시큐리티 secutiry-context.xml설정한 로그인 처리 결과 화면
    * @param locale
    * @param request
    * @param rdat
    * @return
    * @throws Exception 
    */
   @RequestMapping(value = "/login_success", method = RequestMethod.GET)
   public String login_success(Locale locale,HttpServletRequest request, RedirectAttributes rdat) throws Exception {
      logger.info("Welcome login_success! The client locale is {}.", locale);
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      String userid = "";//아이디
      String levels = "";//ROLE_ANONYMOUS
      Boolean enabled = false;
      Object principal = authentication.getPrincipal();
      if (principal instanceof UserDetails) {
         //인증이 처리되는 로직(아이디,암호를 스프링시큐리티 던져주고 인증은 스프링에서 알아서 해줌.)
         enabled = ((UserDetails)principal).isEnabled();
      }
      HttpSession session = request.getSession();//세션을 초기화 시켜줌.
      if (enabled) { //인증처리가 완료된 사용자의 권한체크(아래)
         Collection<? extends GrantedAuthority>  authorities = authentication.getAuthorities();
         if(authorities.stream().filter(o -> o.getAuthority().equals("ROLE_ANONYMOUS")).findAny().isPresent())
         {levels = "ROLE_ANONYMOUS";}
         if(authorities.stream().filter(o -> o.getAuthority().equals("ROLE_USER,")).findAny().isPresent())
         {levels = "ROLE_USER,";}
         if(authorities.stream().filter(o -> o.getAuthority().equals("ROLE_ADMIN")).findAny().isPresent())
         {levels = "ROLE_ADMIN";}
         userid =((UserDetails)principal).getUsername();
         //로그인 세션 저장
         session.setAttribute("session_enabled", enabled);//인증확인
         session.setAttribute("session_userid", userid);//사용자아이디
         session.setAttribute("session_levels", levels);//사용자권한
         //=========== 상단은 스프링시큐리티에서 기본제공하는 세션 변수처리
         //=========== 하단은 우리가 추가한는 세션 변수처리
         //회원이름 구하기 추가
         MemberVO memberVO = memberService.viewMember(userid);
         session.setAttribute("session_username", memberVO.getUser_name());//사용자명
           }
      rdat.addFlashAttribute("msg", "로그인");//result 데이터를 숨겨서 전송
      return "redirect:/";//새로고침 자동 등록 방지를 위해서 아래처럼 처리
   }
   
   /**
    * 로그인 페이지 파일 입니다.
    */
   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public String login(Locale locale, Model model) {
      
      return "login";
   }
   
   /**
    * 슬라이드 페이지 파일 입니다.
    */
   @RequestMapping(value = "/sample/slide", method = RequestMethod.GET)
   public String slide(Locale locale, Model model) {
      
      return "sample/slide";
   }
   
   /**
    * CONTACT US 페이지 파일 입니다.
    */
   @RequestMapping(value = "/sample/contactus", method = RequestMethod.GET)
   public String contactus(Locale locale, Model model) {
      
      return "sample/contactus";
   }
   
   /**
    * BLOG 페이지 파일 입니다.
    */
   @RequestMapping(value = "/sample/blog", method = RequestMethod.GET)
   public String blog(Locale locale, Model model) {
      
      return "sample/blog";
   }
   
   /**
    * WORK 페이지 파일 입니다.
    */
   @RequestMapping(value = "/sample/work", method = RequestMethod.GET)
   public String work(Locale locale, Model model) {
      
      return "sample/work";
   }
   
   /**
    * we are 페이지 파일 입니다.
    */
   @RequestMapping(value = "/sample/weare", method = RequestMethod.GET)
   public String weare(Locale locale, Model model) {
      
      return "sample/weare";
   }
   
   /**
    * html5 테스트용 파일 입니다.
    */
   @RequestMapping(value = "/sample/htmltest", method = RequestMethod.GET)
   public String htmltest(Locale locale, Model model) {
      
      return "sample/htmltest";
   }
   
   /**
    * 샘플 파일 홈 입니다.
    */
   @RequestMapping(value = "/sample", method = RequestMethod.GET)
   public String sample(Locale locale, Model model) {
      
      return "sample/home";
   }
   
   /**
    * Simply selects the home view to render by returning its name.
    * @throws Exception 
    */
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String home(Locale locale, Model model) throws Exception {
      PageVO pageVO = new PageVO();
      if(pageVO.getPage() == null) {
         pageVO.setPage(1);//초기 page변수값 지정
      }
      pageVO.setPerPageNum(5);//1페이지당 보여줄 게시물 수 강제지정
      pageVO.setTotalCount(boardService.countBno(pageVO));//강제로 입력한 값을 쿼리로 대체OK.
      List<BoardVO> list = boardService.selectBoard(pageVO);
      
      //첨부파일 출력때문에 추가 Start
      List<BoardVO> boardListFiles = new ArrayList<BoardVO>();
      for(BoardVO vo:list) {
         List<String> files = boardService.selectAttach(vo.getBno());
         String[] filenames = new String[files.size()];
         int cnt = 0;
         for(String fileName : files) {
            filenames[cnt++] = fileName;
         }
         vo.setFiles(filenames);//여기까지는 view상세보기와 똑같다
         boardListFiles.add(vo);//상세보기에서 추가된 항목
      }
      model.addAttribute("extNameArray", fileDataUtil.getExtNameArray());//첨부파일이 이미지파일이 맞는지
      model.addAttribute("boardListFiles", boardListFiles);//첨부파일 출력용 jsp변수
      //첨부파일 출력때문에 추가 End
      
      model.addAttribute("boardList", list);      
      return "home";
   }
   
}