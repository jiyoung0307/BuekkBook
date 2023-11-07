package com.bukkeubook.book.books.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bukkeubook.book.books.model.dto.BookDTO;
import com.bukkeubook.book.books.model.dto.DamBookDTO;
import com.bukkeubook.book.books.model.dto.RelBkListAndBookAndRelListDTO;
import com.bukkeubook.book.books.model.dto.RelBkListDTO;
import com.bukkeubook.book.books.model.dto.RelListAndEmpDTO;
import com.bukkeubook.book.books.model.dto.RelListDTO;
import com.bukkeubook.book.books.model.dto.StockBookListAndBookAndStockListAndEmpDTO;
import com.bukkeubook.book.books.model.dto.StockBookListDTO;
import com.bukkeubook.book.books.model.dto.StockListAndEmpDTO;
import com.bukkeubook.book.books.model.dto.StockListDTO;
import com.bukkeubook.book.books.model.service.BookService;
import com.bukkeubook.book.common.paging.Pagenation;
import com.bukkeubook.book.common.paging.SelectCriteria;
import com.bukkeubook.book.member.model.dto.UserImpl;

@Controller
@RequestMapping("/book")
public class BookController extends HttpServlet{
	
	private final BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	/* 재고 조회 페이지 출력 */
	@GetMapping("/lookupList")
	public ModelAndView searchPage(HttpServletRequest request, ModelAndView mv) {
//		500 테스트용
//		String test = "";
//		String test2 = test/3;
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
		mv.setViewName("books/bookList/lookupList");

		return mv;
	}
	
	/* 도서 상세 페이지 출력 */
	@GetMapping("/bookInfo")
	public ModelAndView bookInfo(HttpServletRequest request, String no, ModelAndView mv){
		
		no = request.getParameter("no");
		
		List<BookDTO> bookList = bookService.findBookByNo(no);
		
		mv.addObject("bookList", bookList);
		mv.setViewName("books/bookList/bookInfo");
		return mv;
	}
	
	/* 선택한 도서 수정 페이지 출력 */
	@GetMapping("/bookInfoUpdate")
	public ModelAndView updateBookInfo(BookDTO bookDTO, String no, ModelAndView mv) {
		
		List<BookDTO> bookList = bookService.findBookByNo(no);
		
		mv.addObject("bookList", bookList);
		mv.setViewName("books/bookList/bookInfoUpdate");
		return mv;
	}
	
	/* 선택한 도서정보 수정 */
	@PostMapping("/bookInfoUpdate2")
	public ModelAndView modifyBookInfo(BookDTO bookDTO, ModelAndView mv, RedirectAttributes rttr) {
		
		boolean access = bookService.modifyBookInfo(bookDTO);
		
		if(access == true) {
			rttr.addFlashAttribute("updateSuccessMessage", "성공");
		} else {
			rttr.addFlashAttribute("updateFailMessage", "실패");
		}
		
		mv.setViewName("redirect:/book/lookupList");
		return mv;
	};
	
	/* 신규 도서 추가 페이지 출력 */
	@GetMapping("/newBook")
	public ModelAndView newBookCode(ModelAndView mv) {
		String bookCode = bookService.newBookCode();
		mv.addObject("bookCode", bookCode);
		mv.setViewName("books/bookList/newBook");
		return mv;
	}
	
	/* 신규 도서 추가 */
	@PostMapping("/newBook2")
	public ModelAndView insertBook(BookDTO bookDTO, ModelAndView mv, RedirectAttributes rttr, HttpServletRequest request) {
		boolean access = bookService.insertBook(bookDTO);
		if(access == true) {
			rttr.addFlashAttribute("insertSuccessMessage", "성공");
		} else {
			rttr.addFlashAttribute("insertFailMessage", "실패");
		}
		mv.setViewName("redirect:/book/lookupList");
		return mv;
	};
	
	/* 출고 내역 조회 */
	@GetMapping("/outputList")
	public ModelAndView outputList(HttpServletRequest request, ModelAndView mv) {
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;

		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");

		int totalCount = bookService.selectTotalCount(searchCondition, searchValue);

		int limit = 10;		

		int buttonAmount = 5;

		SelectCriteria selectCriteria = null;
		if(searchValue != null && !"".equals(searchValue)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		System.out.println(selectCriteria);

		List<RelListAndEmpDTO> relListAndEmpDTO = bookService.searchBookList2(selectCriteria);

		for(RelListAndEmpDTO book : relListAndEmpDTO) {
			System.out.println(book);
		}
		
		mv.addObject("outputList", relListAndEmpDTO);
		
		mv.addObject("selectCriteria", selectCriteria);
		mv.setViewName("books/bookList/outputList");
		return mv;
	}
	
	/* 출고 내역 상세조회 */
	@GetMapping("/outputDetail")
	public ModelAndView outputDetail(HttpServletRequest request, String no, ModelAndView mv){
		int no2 = Integer.valueOf(request.getParameter("no"));
		
		List<RelBkListAndBookAndRelListDTO> outputList = bookService.outputDetail(no2);
		System.out.println("여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다" + outputList);
		mv.addObject("outputList", outputList);
		mv.setViewName("books/bookList/outputListDetail");
		return mv;
	}
	
	/* 입고 내역 조회 */
	@GetMapping("/inputList")
	public ModelAndView inputList(HttpServletRequest request, ModelAndView mv) {
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;

		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
		int totalCount = bookService.selectTotalCount(searchCondition, searchValue);

		int limit = 10;		

		int buttonAmount = 5;

		SelectCriteria selectCriteria = null;
		if(searchValue != null && !"".equals(searchValue)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		System.out.println(selectCriteria);

		List<StockListAndEmpDTO> stockListEmp = bookService.searchBookList3(selectCriteria);

		for(StockListAndEmpDTO book : stockListEmp) {
			System.out.println(book);
		}
		
		mv.addObject("inputList", stockListEmp);
		
		mv.addObject("selectCriteria", selectCriteria);
		mv.setViewName("books/bookList/inputList");
		return mv;
	}
	
	/* 입고 내역 상세조회 */
	@GetMapping("/inputDetail")
	public ModelAndView inputDetail(HttpServletRequest request, String no, ModelAndView mv){
		int no2 = Integer.valueOf(request.getParameter("no"));
		
		List<StockBookListAndBookAndStockListAndEmpDTO> inputList = bookService.inputDetail(no2);
		System.out.println("여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다여기다");
		mv.addObject("inputList", inputList);
		mv.setViewName("books/bookList/inputListDetail");
		return mv;
	}
	
	/* 출고 기능 페이지 출력 */
	@GetMapping("/output")
	public ModelAndView output(HttpServletRequest request, ModelAndView mv){
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;

		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");

		int totalCount = bookService.selectTotalCount(searchCondition, searchValue);

		int limit = 3;		

		int buttonAmount = 5;

		SelectCriteria selectCriteria = null;
		if(searchValue != null && !"".equals(searchValue)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		System.out.println(selectCriteria);

		List<BookDTO> bookList = bookService.searchBookList4(selectCriteria);

		for(BookDTO book : bookList) {
			System.out.println(book);
		}
		
		mv.addObject("bookList", bookList);
		
		mv.addObject("selectCriteria", selectCriteria);
		mv.setViewName("books/bookList/output");
		return mv;
	}
	
	/* 입고 기능 페이지 출력 */
	@GetMapping("/input")
	public ModelAndView input(HttpServletRequest request, ModelAndView mv){
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;

		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");

		int totalCount = bookService.selectTotalCount(searchCondition, searchValue);

		int limit = 3;		

		int buttonAmount = 5;

		SelectCriteria selectCriteria = null;
		if(searchValue != null && !"".equals(searchValue)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		System.out.println(selectCriteria);

		List<BookDTO> bookList = bookService.searchBookList5(selectCriteria);

		for(BookDTO book : bookList) {
			System.out.println(book);
		}
		
		mv.addObject("bookList", bookList);
		
		mv.addObject("selectCriteria", selectCriteria);
		mv.setViewName("books/bookList/input");
		return mv;
	}
	
	/* 출고 신청 */
	@PostMapping("/outputReceipt")
	public ModelAndView outputReceipt(@AuthenticationPrincipal UserImpl user, HttpServletRequest request, ModelAndView mv, RedirectAttributes rttr) {
		int rownum = Integer.valueOf(request.getParameter("rownum"));
		int empNo = user.getEmpNo();
		boolean access1 = false;
		boolean access2 = false;
		
		for(int i = 1; i <= 1; i++) {
			
			RelListDTO relList = new RelListDTO();
			RelBkListDTO relBkList = new RelBkListDTO();
			
			relList.setRelDate(new java.sql.Date(System.currentTimeMillis()));
			relList.setEmpNo(empNo);	// 사번은 로그인 구현후 변경하기
			
			int relNo = bookService.outputReceipt(relList);
			
			for(int j = 1; j <= rownum; j++) {
				if(request.getParameter("no"+ j) == null) {
					System.out.println("rownum입니다." + rownum);
				} else {
					String no = request.getParameter("no"+ j);
					int amount = Integer.valueOf(request.getParameter("amount"+ j));
					System.out.println("no입니다." + no);
					relBkList.setRelNo(relNo);
					relBkList.setBkNo(no);
					relBkList.setRelBkAmount(amount);
					
					access1 = bookService.outputReceipt2(relBkList);
					
					BookDTO bookDTO = new BookDTO();
					bookDTO.setNo(no);
					bookDTO.setWhSt(amount);
					access2 = bookService.outputReceipt3(bookDTO, amount);
				}
			}
		}
		if(access1 == true && access2 == true) {
			rttr.addFlashAttribute("outputSuccessMessage", "성공");
		} else {
			rttr.addFlashAttribute("outputFailMessage", "실패");
		}
		mv.setViewName("redirect:/book/outputList");
		return mv;
		
	}
	
	/* 입고 신청 */
	@PostMapping("/inputReceipt")
	public ModelAndView inputReceipt(@AuthenticationPrincipal UserImpl customUser, HttpServletRequest request, ModelAndView mv, RedirectAttributes rttr) {
		int empNo = customUser.getEmpNo();
		int rownum = Integer.valueOf(request.getParameter("rownum"));
		System.out.println("여기여기여기여기여기여기여기" + rownum);
		String selectInput = request.getParameter("selectInput");
		boolean access1 = false;
		boolean access2 = false;
		
		for(int i = 1; i <= 1; i++) {
			
			StockListDTO stockList = new StockListDTO();
			StockBookListDTO stockBookList = new StockBookListDTO();
			
			stockList.setStDate(new java.sql.Date(System.currentTimeMillis()));
			stockList.setStType(selectInput);
			stockList.setEmpNo(empNo);
			
			int stCode = bookService.inputReceipt(stockList);
			
			for(int j = 1; j <= rownum; j++) {
				
				if(request.getParameter("no"+ j) == null) {
					System.out.println("null입니다.");
				} else {
					String no = request.getParameter("no"+ j);
					int amount = 0;
					amount = Integer.valueOf(request.getParameter("amount"+ j));
					stockBookList.setBkNo(no);
					stockBookList.setStockBkAmount(amount);
					stockBookList.setStCode(stCode);
					System.out.println(no);
					System.out.println(amount);
					access1 = bookService.inputReceipt2(stockBookList);
					
					BookDTO bookDTO = new BookDTO();
					bookDTO.setNo(no);
					bookDTO.setWhSt(amount);
					access2 = bookService.inputReceipt3(bookDTO, amount, selectInput);
				}
					
					
			}
		}
		if(access1 == true && access2 == true) {
			rttr.addFlashAttribute("inputSuccessMessage", "성공");
		} else {
			rttr.addFlashAttribute("inputFailMessage", "실패");
		}
		mv.setViewName("redirect:/book/inputList");
		return mv;
	}
	
	/* 훼손 도서 조회 페이지 출력 */
	@GetMapping("/damageList")
	public ModelAndView damageList(HttpServletRequest request, ModelAndView mv) {
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;

		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");

		int totalCount = bookService.selectTotalCount(searchCondition, searchValue);

		int limit = 10;		

		int buttonAmount = 5;

		SelectCriteria selectCriteria = null;
		if(searchValue != null && !"".equals(searchValue)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		System.out.println(selectCriteria);

		List<BookDTO> bookDTO = bookService.searchDamageBook(selectCriteria);

		for(BookDTO book : bookDTO) {
			System.out.println(book);
		}
		
		mv.addObject("damageList", bookDTO);
		
		mv.addObject("selectCriteria", selectCriteria);
		mv.setViewName("books/bookList/damageBookList");
		return mv;
	}
	
	/* 훼손 도서 상세 페이지 */
	@GetMapping("/damageAmount")
	public ModelAndView damBookInfo(HttpServletRequest request, ModelAndView mv, RedirectAttributes rttr) {
		String no = request.getParameter("bkNo");
		List<BookDTO> bookList = bookService.findBookByNo(no);
		System.out.println(bookList);
		mv.addObject("bookList", bookList);
		mv.setViewName("books/bookList/damBookInfo");
		return mv;
	}
	
	/* 훼손 도서 수량 수정 */
	@GetMapping("/damAmountUpdate")
	public ModelAndView damAmountUpdate(HttpServletRequest request, ModelAndView mv, RedirectAttributes rttr) {
		String no = request.getParameter("no");
		int amount = Integer.valueOf(request.getParameter("amount"));
		int updateAmount = Integer.valueOf(request.getParameter("updateAmount"));
		boolean access1 = false;
		boolean access2 = false;
		
		access1 = bookService.findByNo(no, updateAmount);
		access2 = bookService.findBookByNo(no, updateAmount, amount);
		
		if(access1 == true && access2 == true) {
			rttr.addFlashAttribute("updateSuccessMessage", "성공");
		} else {
			rttr.addFlashAttribute("updateFailMessage", "실패");
		}
		mv.setViewName("redirect:/book/damageList");
		return mv;
	}
	
	@GetMapping("/getSearchList")
	@ResponseBody
	private List<BookDTO> getSearchList(@RequestParam("searchCondition") String searchCondition,
			@RequestParam("searchValue") String searchValue, Model model) throws Exception{
		
		return bookService.searchBookList(searchCondition, searchValue);
	}
}
