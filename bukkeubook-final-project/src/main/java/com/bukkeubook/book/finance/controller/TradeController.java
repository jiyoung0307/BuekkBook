package com.bukkeubook.book.finance.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bukkeubook.book.books.model.dto.BookDTO;
import com.bukkeubook.book.books.model.service.BookService;
import com.bukkeubook.book.common.paging.Pagenation;
import com.bukkeubook.book.common.paging.SelectCriteria;
import com.bukkeubook.book.finance.model.dto.ClientDTO;
import com.bukkeubook.book.finance.model.dto.TradeAndClientAndBookAndEmpDTO;
import com.bukkeubook.book.finance.model.dto.TradeListDTO;
import com.bukkeubook.book.finance.model.service.ClientService;
import com.bukkeubook.book.finance.model.service.TradeService;
import com.bukkeubook.book.member.model.dto.UserImpl;

@Controller
@RequestMapping("/trade")
public class TradeController {

	private final TradeService tradeService;
	private final ClientService clientService;
	private final BookService bookService;
	
	@Autowired
	public TradeController(TradeService tradeService, ClientService clientService, BookService bookService) {
		this.tradeService = tradeService;
		this.clientService = clientService;
		this.bookService = bookService;
	}
	
	@GetMapping("/select")
	public ModelAndView selectTrade(HttpServletRequest request, ModelAndView mv) {
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;

		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
		int totalCount = tradeService.selectTotalCount(searchCondition, searchValue);

		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 8;		//얘도 파라미터로 전달받아도 된다.

		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5;

		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		SelectCriteria selectCriteria = null;
		if(searchValue != null && !"".equals(searchValue)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		System.out.println(selectCriteria);

		List<TradeAndClientAndBookAndEmpDTO> tradeList = tradeService.searchTradeList(selectCriteria);
		
		for(TradeAndClientAndBookAndEmpDTO trade : tradeList) {
			System.out.println("몇 번쨰 : " + trade.getTlNo());
			System.out.println(trade);
		}

		mv.addObject("tradeList", tradeList);
		mv.addObject("selectCriteria", selectCriteria);
		mv.setViewName("finance/tradeSelect");
		
		return mv;
	}
	
	@GetMapping("/detail")
	public ModelAndView selectTradeDetail(HttpServletRequest request, ModelAndView mv) {
		
		int tlNo = Integer.valueOf(request.getParameter("tlNo"));
		
		TradeAndClientAndBookAndEmpDTO trade = tradeService.searchTradeDetail(tlNo);
		
		mv.addObject("trade", trade);
		mv.setViewName("finance/tradeDetail");
		
		return mv;
	}
	
	@GetMapping("/regist")
	public ModelAndView registPage(ModelAndView mv) {
		mv.setViewName("/finance/tradeRegist");
		
		return mv;
	}
	
	@PostMapping("/regist")
	public ModelAndView registTrade(HttpServletRequest request, ModelAndView mv, RedirectAttributes rttr, @AuthenticationPrincipal UserImpl customUser) {
		
		TradeListDTO newTrade = new TradeListDTO();
		int empNo = customUser.getEmpNo();
		
		newTrade.setEmpNo(empNo);
		newTrade.setBkNo(request.getParameter("bkNo"));
		newTrade.setCntNo(Integer.valueOf(request.getParameter("cntNo")));
		newTrade.setTlDate(java.sql.Date.valueOf(request.getParameter("tlDate")));
		newTrade.setTlAmount(Integer.valueOf(request.getParameter("tlAmount")));
		newTrade.setTlDetail(request.getParameter("tlDetail"));
		
		System.out.println(newTrade);
		
		tradeService.registTrade(newTrade);
		
		rttr.addFlashAttribute("registSuccessMessage", "거래내역 등록에 성공하셨습니다");
		mv.setViewName("redirect:/trade/select");
		
		return mv;
	}
	
	@GetMapping("/clientPopup")
	public ModelAndView clientPopupPage(HttpServletRequest request, ModelAndView mv) {
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;

		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");

		int totalCount = clientService.selectTotalCount(searchCondition, searchValue);

		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 8;		//얘도 파라미터로 전달받아도 된다.

		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5;

		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		SelectCriteria selectCriteria = null;
		if(searchValue != null && !"".equals(searchValue)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		System.out.println(selectCriteria);

		List<ClientDTO> clientList = clientService.searchClientList(selectCriteria);

		for(ClientDTO client : clientList) {
			System.out.println(client);
		}

		mv.addObject("clientList", clientList);
		mv.addObject("selectCriteria", selectCriteria);
		mv.setViewName("finance/clientPopup");
		
		return mv;
	}
	
	@GetMapping("/bookPopup")
	public ModelAndView bookPopupPage(HttpServletRequest request, ModelAndView mv) {
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;

		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");

		int totalCount = bookService.selectTotalCount(searchCondition, searchValue);

		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 10;		//얘도 파라미터로 전달받아도 된다.

		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5;

		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		SelectCriteria selectCriteria = null;
		if(searchValue != null && !"".equals(searchValue)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		System.out.println(selectCriteria);

		List<BookDTO> bookList = bookService.searchBookList(selectCriteria);

		for(BookDTO book : bookList) {
			System.out.println(book);
		}

		mv.addObject("bookList", bookList);
		mv.addObject("selectCriteria", selectCriteria);
		mv.setViewName("finance/bookPopup");

		return mv;
	}
	
	@GetMapping("/modify")
	public ModelAndView modifyPage(HttpServletRequest request, ModelAndView mv) {
		
		int tlNo = Integer.valueOf(request.getParameter("tlNo"));
		
		TradeAndClientAndBookAndEmpDTO trade = tradeService.searchTradeDetail(tlNo);
		
		mv.addObject("tlNo", tlNo);
		mv.addObject("trade", trade);
		mv.setViewName("/finance/tradeModify");
		
		return mv;
	}
	
	@PostMapping("/modify")
	public ModelAndView modifyClient(ModelAndView mv, RedirectAttributes rttr, HttpServletRequest request) {
		
		System.out.println(request.getParameter("tlNo1"));
		System.out.println(request.getParameter("bkNo1"));
		System.out.println(request.getParameter("cntNo1"));
		System.out.println(request.getParameter("tlDate"));
		System.out.println(request.getParameter("tlAmount"));
		System.out.println(request.getParameter("tlDetail"));
		
		int tlNo = Integer.valueOf(request.getParameter("tlNo1"));
		
		TradeListDTO trade = new TradeListDTO();
		
		trade.setBkNo(request.getParameter("bkNo1"));
		trade.setCntNo(Integer.valueOf(request.getParameter("cntNo1")));
		trade.setTlDate(java.sql.Date.valueOf(request.getParameter("tlDate")));
		trade.setTlAmount(Integer.valueOf(request.getParameter("tlAmount")));
		trade.setTlDetail(request.getParameter("tlDetail"));
		
		tradeService.modifyTrade(tlNo, trade);
		
		rttr.addFlashAttribute("registSuccessMessage", "거래내역 정보 수정에 성공하셨습니다");
		mv.setViewName("redirect:/trade/detail/?tlNo=" + tlNo);
		
		return mv;
	}
}











