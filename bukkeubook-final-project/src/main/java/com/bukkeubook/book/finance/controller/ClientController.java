package com.bukkeubook.book.finance.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bukkeubook.book.common.paging.Pagenation;
import com.bukkeubook.book.common.paging.SelectCriteria;
import com.bukkeubook.book.finance.model.dto.ClientDTO;
import com.bukkeubook.book.finance.model.service.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

	private final ClientService clientService;
	
	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@GetMapping("/select")
	public ModelAndView searchClient(HttpServletRequest request, ModelAndView mv) {
		
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
		mv.setViewName("finance/clientSelect");
		
		return mv;
	}
	
	@GetMapping("/detail")
	public ModelAndView selectClientDetail(HttpServletRequest request, ModelAndView mv) {
		
		String no = request.getParameter("cntNo");
		int cntNo = Integer.valueOf(no);
		
		ClientDTO client = clientService.searchClientDetail(cntNo);
		
		mv.addObject("client", client);
		mv.setViewName("finance/clientDetail");
		
		return mv;
	}
	
	@GetMapping("/regist")
	public ModelAndView registPage(ModelAndView mv) {
		mv.setViewName("/finance/clientRegist");
		
		return mv;
	}
	
	@PostMapping("/regist")
	public ModelAndView registClient(ModelAndView mv, ClientDTO newClient, RedirectAttributes rttr) {
		
		newClient.setCntStartDate(new java.sql.Date(System.currentTimeMillis()));
		newClient.setCntTradeYn("Y");
		
		System.out.println(newClient);
		
		clientService.registClient(newClient);
		
		rttr.addFlashAttribute("registSuccessMessage", "거래처 등록에 성공하셨습니다");
		mv.setViewName("redirect:/client/select");
		
		return mv;
	}
	
	@GetMapping("/modify")
	public ModelAndView modifyPage(HttpServletRequest request, ModelAndView mv) {
		
		int cntNo = Integer.valueOf(request.getParameter("cntNo"));
		
		ClientDTO client = clientService.searchClientDetail(cntNo);
		
		mv.addObject("client", client);
		mv.setViewName("/finance/clientModify");
		
		return mv;
	}
	
	@PostMapping("/modify")
	public ModelAndView modifyClient(ModelAndView mv, @ModelAttribute ClientDTO client, RedirectAttributes rttr, HttpServletRequest request) {
		
		int cntNo = Integer.valueOf(request.getParameter("cntNo"));
		
		clientService.modifyClient(cntNo, client);
		
		rttr.addFlashAttribute("registSuccessMessage", "거래처 정보 수정에 성공하셨습니다");
		mv.setViewName("redirect:/client/detail/?cntNo=" + cntNo);
		
		return mv;
	}
	
	@GetMapping("/stop")
	public ModelAndView stopClient(ModelAndView mv, RedirectAttributes rttr, HttpServletRequest request) {
		
		int cntNo = Integer.valueOf(request.getParameter("cntNo"));
		
		clientService.stopClient(cntNo);
		
		rttr.addFlashAttribute("registSuccessMessage", "거래처 거래 중지 처리에 성공하셨습니다");
		mv.setViewName("redirect:/client/detail/?cntNo=" + cntNo);
		
		return mv;
	}
	
	@GetMapping("/start")
	public ModelAndView startClient(ModelAndView mv, RedirectAttributes rttr, HttpServletRequest request) {
		
		int cntNo = Integer.valueOf(request.getParameter("cntNo"));
		
		clientService.startClient(cntNo);
		
		rttr.addFlashAttribute("registSuccessMessage", "거래처 거래 재개에 성공하셨습니다");
		mv.setViewName("redirect:/client/detail/?cntNo=" + cntNo);
		
		return mv;
	}
}
