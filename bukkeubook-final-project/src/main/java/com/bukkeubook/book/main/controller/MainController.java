package com.bukkeubook.book.main.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bukkeubook.book.document.compare.InboxListComparator;
import com.bukkeubook.book.document.model.dto.InboxListDTO;
import com.bukkeubook.book.document.model.service.DocService;
import com.bukkeubook.book.main.model.service.MainService;
import com.bukkeubook.book.member.model.dto.UserImpl;
import com.bukkeubook.book.mypage.model.dto.CalendarDTO;
import com.bukkeubook.book.mypage.model.service.MypageService;
import com.bukkeubook.book.secretary.model.dto.join.BoardAndCateDTO;
import com.bukkeubook.book.secretary.model.dto.join.BoardAndEmpAndBoardCateDTO;
import com.bukkeubook.book.secretary.model.service.BoardService;

@Controller
public class MainController {
	
	private final MainService mainService;
	private final MypageService mypageService;
	private final BoardService boardService;
	private DocService docService;
	
	@Autowired
	public MainController(MainService mainService, MypageService mypageService, BoardService boardService, DocService docService) {
		this.mainService = mainService;
		this.boardService = boardService;
		this.mypageService = mypageService;
		this.docService = docService;
	}
	

	@PostMapping("/main")
	public ModelAndView main(@AuthenticationPrincipal UserImpl customUser, ModelAndView mv) {
		int memberCode = customUser.getEmpNo();
		
		/* 최근 전사게시판 우선순위 5개 조회 */
		List<BoardAndCateDTO> boardList = mainService.findBoardList();
		System.out.println(boardList);
		
		/* 주간 캘린더 일정 전체 조회 (마이페이지 Service 재활용)*/
		List<CalendarDTO> calendar = mypageService.findMyCalendar(memberCode);
		System.out.println(calendar);
		
		/* 전자결재 수신함 간편 조회 */
		List<InboxListDTO> all = docService.findInboxAllList(memberCode);
		
		Collections.sort(all, new InboxListComparator().reversed());
		
		mv.addObject("all", all);
		mv.addObject("boardList", boardList);
		mv.addObject("calendar", calendar);
		mv.setViewName("redirect:/main");
		return mv;
	}
	
	@GetMapping("/")
	public String login() {
		AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();
		if (trustResolver.isAnonymous(SecurityContextHolder.getContext().getAuthentication())) {
			return "/member/login";		// 권한 없을 때
		} else {
			return "redirect:/main";	// 권한 있을 때
		}
	};
	
	@GetMapping("/main")
	public ModelAndView main2(@AuthenticationPrincipal UserImpl customUser, ModelAndView mv) {
		int memberCode = customUser.getEmpNo();
		
		/* 최근 전사게시판 우선순위 5개 조회 */
		List<BoardAndCateDTO> boardList = mainService.findBoardList();
		System.out.println(boardList);
		
		/* 주간 캘린더 일정 전체 조회 (마이페이지 Service 재활용)*/
		List<CalendarDTO> calendar = mypageService.findMyCalendar(memberCode);
		System.out.println(calendar);
		
		/* 전자결재 수신함 간편 조회 */
		List<InboxListDTO> all = docService.findInboxAllList(memberCode);
		
		Collections.sort(all, new InboxListComparator().reversed());
		
		mv.addObject("all", all);
		mv.addObject("boardList", boardList);
		mv.addObject("calendar", calendar);
		mv.setViewName("/main");
		return mv;
	}
	
	@GetMapping("/mainBoardDetail")
	public ModelAndView mainBoardDetail(HttpServletRequest request, String no, ModelAndView mv) {
		
		int boardNo = Integer.valueOf(request.getParameter("no"));
		BoardAndEmpAndBoardCateDTO board = boardService.findBoardDetail(boardNo);
		mv.addObject("board", board);
		mv.setViewName("/secretary/mainBoardDetail");

		
		return mv;
	}
	
}
