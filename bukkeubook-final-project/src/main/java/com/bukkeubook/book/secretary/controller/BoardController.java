package com.bukkeubook.book.secretary.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bukkeubook.book.common.paging.Pagenation;
import com.bukkeubook.book.common.paging.SelectCriteria;
import com.bukkeubook.book.member.model.dto.UserImpl;
import com.bukkeubook.book.secretary.model.dto.AppVacationAndEmpDTO;
import com.bukkeubook.book.secretary.model.dto.BoardDTO;
import com.bukkeubook.book.secretary.model.dto.join.BoardAndEmpAndBoardCateDTO;
import com.bukkeubook.book.secretary.model.service.BoardService;

@Controller
@RequestMapping("/secretary")
public class BoardController {
	
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	/* 총무부 전사게시판 전체 조회 */
	@GetMapping("/board")
	public ModelAndView boardManageList(HttpServletRequest request, ModelAndView mv) {
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
		
		
		int totalCount = boardService.selectTotalCount(searchCondition, searchValue);
		
		int limit = 10;
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = null;
		if(searchValue != null && !"".equals(searchValue)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		System.out.println(selectCriteria);
		List<BoardAndEmpAndBoardCateDTO> boardList = boardService.findSearchBoardList(selectCriteria);
		
		
		mv.addObject("boardList", boardList);
		mv.addObject("selectCriteria", selectCriteria);
		mv.setViewName("/secretary/board");
		return mv;
	}
	
	/* 공용 전사게시판 전체 조회하기 */
	@GetMapping("/commonBoard")
	public ModelAndView commonBoardList(HttpServletRequest request, ModelAndView mv) {
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
		
		int totalCount = boardService.selectTotalCount(searchCondition, searchValue);
		System.out.println(totalCount);
		
		int limit = 10;
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = null;
		if(searchValue != null && !"".equals(searchValue)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		System.out.println(selectCriteria);
		
		List<BoardAndEmpAndBoardCateDTO> boardList = boardService.findSearchBoardList(selectCriteria);
		
		mv.addObject("boardList", boardList);
		mv.addObject("selectCriteria", selectCriteria);
		mv.setViewName("/secretary/commonBoard");
		return mv;
	}
	
	/* 총무부 전사게시판 상세 조회 */
	@GetMapping("/boardDetail")
	public ModelAndView secBoardDetail(HttpServletRequest request, String no, ModelAndView mv) {
		
		int boardNo = Integer.valueOf(request.getParameter("no"));
		BoardAndEmpAndBoardCateDTO board = boardService.findBoardDetail(boardNo);
		
		System.out.println(board);
		mv.addObject("board", board);
		mv.setViewName("/secretary/boardDetail");
		return mv;
		
	}
	
	/* 총무부 전사게시판 수정 화면 이동 */
	@GetMapping("/boardUpdate")
	public ModelAndView moveUpdateBoard(ModelAndView mv, HttpServletRequest request, String no) {
		
		int boardNo = Integer.parseInt(request.getParameter("no"));
		BoardAndEmpAndBoardCateDTO board = boardService.findBoardDetail(boardNo);
		mv.addObject("board", board);
		mv.setViewName("/secretary/boardUpdate");
		
		return mv;
	}
	/* 총무부 전사게시판 수정 */
	@PostMapping("modifyBoard")
	public ModelAndView modifyBoardContent(ModelAndView mv, RedirectAttributes rttr, BoardAndEmpAndBoardCateDTO board ) {
		
		System.out.println(board);
		
		boolean boardList = boardService.modifyBoardContent(board);
		
		if(boardList) {
			rttr.addFlashAttribute("successMessage", "정상적으로 처리되었습니다.");
			mv.setViewName("redirect:/secretary/board");
		}else {
			rttr.addFlashAttribute("failMessage", "실패");
			mv.setViewName("redirect:/secretary/board");
		}
		
		
		return mv;
	}
	
	/* 총무부 전사게시판 등록 화면 이동 */
	@GetMapping("/boardRegist")
	public void boardRegist() {}
	
	
	/* 총무부 게시판 등록하기 */
	@PostMapping("/registBoard")
	public ModelAndView registBoardContent(@AuthenticationPrincipal UserImpl customUser, ModelAndView mv, BoardDTO board, RedirectAttributes rttr) {
		
		System.out.println(board);
		
		Date today = new Date();
		long time = today.getTime();
		java.sql.Date now = new java.sql.Date(time);
		
		
		int memberInfo = customUser.getEmpNo();
		board.setEmpNo(memberInfo);  	// 작성자
		board.setDate(now);     		// 현재 시간
		board.setHits(0);  				// 초기 조회수
		board.setBoardYn("N");  		// 삭제 여부
		
		boolean boardList = boardService.registBoardContent(board);
		
		if(boardList) {
			rttr.addFlashAttribute("successMessage", "게시글을 성공적으로 등록하셨습니다.");
			mv.setViewName("redirect:/secretary/board");
		}else {
			rttr.addFlashAttribute("failMessage", "실패");
			mv.setViewName("redirect:/secretary/board");
		}
		
		
		return mv;
	}
	
	/* 총무부에서 전사 게시판 삭제하기 */
	@GetMapping("/deleteBoard")
	public ModelAndView deleteBoardContent(ModelAndView mv, String no, HttpServletRequest request, RedirectAttributes rttr) {
		
		int boardNo = Integer.parseInt(request.getParameter("no"));
		String boardYn = "Y";
		
		boolean boardList = boardService.deleteBoardContent(boardNo, boardYn);
		
		if(boardList) {
			rttr.addFlashAttribute("successMessage", "게시글을 성공적으로 삭제하셨습니다.");
			mv.setViewName("redirect:/secretary/board");
		}else {
			rttr.addFlashAttribute("failMessage", "실패");
			mv.setViewName("redirect:/secretary/board");
		}
		
		return mv;
	}
	
	@GetMapping("/vacListSelect")
	public ModelAndView findVacList(ModelAndView mv) {
		
		List<AppVacationAndEmpDTO> vacList = boardService.findVacList();
		System.out.println(vacList);
		
		mv.addObject("vacList", vacList);
		mv.setViewName("secretary/vacList");
		
		return mv;
	}
	
	
	
}
