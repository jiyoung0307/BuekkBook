package com.bukkeubook.book.manage.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bukkeubook.book.common.paging.Pagenation;
import com.bukkeubook.book.common.paging.SelectCriteria;
import com.bukkeubook.book.manage.model.dto.SalaryDTO;
import com.bukkeubook.book.manage.model.dto.SalaryEmpDTO;
import com.bukkeubook.book.manage.model.dto.joinDTO.PayAndEmpAndDeptDTO;
import com.bukkeubook.book.manage.model.service.EmpPayService;

@Controller
@RequestMapping("/empPay")
public class EmpPayController {
	
	private final EmpPayService empPayService;
	
	 @Autowired
	   public EmpPayController(EmpPayService empPayService) {
		 this.empPayService = empPayService;
	 }
	
	@GetMapping("/empPayList")
	/* 급여계산내역 조회 , 페이징, 검색기능 */
	public ModelAndView searchPage(HttpServletRequest request, ModelAndView mv) {  //ModelAndView 뷰 리졸버의 역할 _리턴할 페이지 설정 , 보내는객체
		System.out.println("ddddddddddddddddddddddddddddddddddddd");
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;

		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");

		int totalCount = empPayService.selectTotalCount(searchCondition, searchValue);

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

		List<PayAndEmpAndDeptDTO> payList = empPayService.searchPayList(selectCriteria);
		
		for(PayAndEmpAndDeptDTO pay : payList) {
			System.out.println(pay);
		}
		
		mv.addObject("payList", payList);  //보내는 객체 설정
		mv.addObject("selectCriteria", selectCriteria);
		mv.setViewName("manage/empPay/empPayList"); //리턴할 페이지 설정
		
		return mv;
	}
	
	/* 상세 급여지급내역 조회 */
	@GetMapping("/oneEmpPay/{salNo}")
	public ModelAndView empPayDetail(ModelAndView mv, @PathVariable String salNo) {
		
		int number = Integer.valueOf(salNo);
		
		PayAndEmpAndDeptDTO pay = empPayService.searchEmpPayDetail(number);
		
		mv.addObject("pay", pay);
		mv.setViewName("manage/empPay/empPayDetail");
		return mv;
	}
	
	/* 급여등록 페이지 접속*/
	@GetMapping("empPayInsert")
	public ModelAndView empInsertPage(ModelAndView mv) {
		
		mv.setViewName("/manage/empPay/empPayInsert");
		
		return mv;
	}
	
	/* 급여 등록 */
	@PostMapping("insertSalary")
	public ModelAndView empSalaryInsert(ModelAndView mv, @RequestParam String date, SalaryDTO salary, RedirectAttributes rttr) {
		
		System.out.println(salary);
		System.out.println(date);
		
		Date salmonth = Date.valueOf(date);
		
		salary.setSalMonth(salmonth);
		
		System.out.println(salary);
		
		empPayService.insertNewSalary(salary);
		
		rttr.addFlashAttribute("message", "성공");
		
		mv.setViewName("redirect:/empPay/empPayList");
		
		return mv;
	}
	
	/* 부서선택- 사원선택지정 ajax select Tag Option Dept */
	@GetMapping(value = {"dept"}, produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<com.bukkeubook.book.manage.model.dto.DeptDTO> findDeptList(){
		
		List<com.bukkeubook.book.manage.model.dto.DeptDTO> list = new ArrayList<>();
		
		list = empPayService.findDept();
		
//		System.out.println(list);
		
		return list;
	}
	
	/* 전월 급여 내역 조회 */
	@GetMapping(value = {"payInfo/{emp}"}, produces="application/json;charset=UTF-8")
	@ResponseBody
	public SalaryEmpDTO findByEmpNoSalary(@PathVariable String emp){
		
		int empNo = Integer.valueOf(emp);
		
		SalaryEmpDTO salaryInfo = empPayService.findByEmpNoSalary(empNo);
		
		return salaryInfo;
		
	}
	
	/* 급여내역 삭제 */
	@GetMapping("paydelete/{num}")
	public ModelAndView deleteSalary(ModelAndView mv, @PathVariable String num, RedirectAttributes rttr) {
		
		int salNo = Integer.valueOf(num);

		empPayService.deleteSalary(salNo);
		
		rttr.addFlashAttribute("message", "성공");
		
		mv.setViewName("redirect:/empPay/empPayList");
		
		return mv;
		
	}
		
}
