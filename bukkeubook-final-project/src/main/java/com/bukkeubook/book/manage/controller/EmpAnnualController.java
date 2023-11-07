package com.bukkeubook.book.manage.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bukkeubook.book.common.paging.Pagenation;
import com.bukkeubook.book.common.paging.SelectCriteria;
import com.bukkeubook.book.manage.model.dto.AppVacationDTO;
import com.bukkeubook.book.manage.model.dto.joinDTO.AppVacationAndEmpDTO;
import com.bukkeubook.book.manage.model.dto.joinDTO.CancelVacationAndAppVacationDTO;
import com.bukkeubook.book.manage.model.service.EmpAnnualService;
import com.bukkeubook.book.manage.model.service.EmpDayOffService;

@Controller
@RequestMapping("/empAnnual")
public class EmpAnnualController {

	/* 다른 객체 바꿔치기를 방지 및 서비스 연결 */
	private final EmpAnnualService empAnnualService;
	private final EmpDayOffService empDayOffService;

	/* 의존성 자동 주입 */
	@Autowired
	public EmpAnnualController(EmpAnnualService empAnnualService, EmpDayOffService empDayOffService) {
		this.empAnnualService = empAnnualService;
		this.empDayOffService = empDayOffService;
	}

	/* 휴가 신청 조회 */
	@GetMapping("/restSelect")
	public ModelAndView findRestList(HttpServletRequest request, ModelAndView mv) {

		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;

		if (currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
//      System.out.println("출력 확인 : " + searchCondition);
		int totalCount = empAnnualService.selectTotalCount(searchCondition, searchValue);

		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 3;

		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5;

		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		SelectCriteria selectCriteria = null;
		if (searchValue != null && !"".equals(searchValue)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, 
														buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		System.out.println(selectCriteria);

		List<AppVacationAndEmpDTO> restList = empAnnualService.findRestList(selectCriteria);

		mv.addObject("restList", restList);
		mv.addObject("selectCriteria", selectCriteria);
		mv.setViewName("manage/empAnnual/restSelect");

		return mv;
	}

	/* 휴가 신청 상세 내역 조회 */
	@GetMapping("/restDetailSelect")
	public ModelAndView restDetail(HttpServletRequest request, ModelAndView mv) {

		int vacNo = Integer.valueOf(request.getParameter("vacNo"));

		AppVacationAndEmpDTO appvacAndEmp = empAnnualService.restDetailSelect(vacNo);

		mv.addObject("appvacAndEmp", appvacAndEmp);
		mv.setViewName("manage/empAnnual/restDetailSelect");

		return mv;
	}

	/* 휴가 신청 승인시 연차 횟수 감소하는 트랜잭션 */
	@GetMapping("/dayOffUpdate")
	public ModelAndView dayOffUpdate(HttpServletRequest request, ModelAndView mv, RedirectAttributes rttr)
			throws ParseException {

		int empNo = Integer.valueOf(request.getParameter("empNo")); // 사원 번호
		int vacNo = Integer.valueOf(request.getParameter("vacNo"));
		String vacStartDate = request.getParameter("vacStartDate");
		String vacEndDate = request.getParameter("vacEndDate");

		empDayOffService.findDayOffEmpNo(empNo, vacNo, vacStartDate, vacEndDate);

		rttr.addFlashAttribute("updateSuccessMessage", "성공");
		mv.setViewName("redirect:/empAnnual/restSelect");
		return mv;

	}

	/*****************************************************************************************/
	/* 휴가 취소 신청 조회 */
	@GetMapping("/restCancelSelect")
	public ModelAndView findCancelVacList(HttpServletRequest request, ModelAndView mv) {
//		  System.out.println("여기는 휴가 취소 리스트 컨트롤러");

		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;

		if (currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
//	      System.out.println("출력 확인 구문 : " + searchCondition);

		int totalCount = empAnnualService.selectCancelTotalCount(searchCondition, searchValue);

		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 4;

		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5;

		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		SelectCriteria selectCriteria = null;
		if (searchValue != null && !"".equals(searchValue)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition,
					searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		System.out.println(selectCriteria);

		List<CancelVacationAndAppVacationDTO> cancelVacList = empAnnualService.findCancelRestList(selectCriteria);

		for (CancelVacationAndAppVacationDTO cancelVac : cancelVacList) {
			System.out.println(cancelVac);
		}

		mv.addObject("cancelVacList", cancelVacList);
		mv.addObject("selectCriteria", selectCriteria);
		mv.setViewName("manage/empAnnual/restCancelSelect");

		return mv;
	}
	
	/* 휴가 취소 신청 상세 내역 조회 */
	@GetMapping("/restCancleDetailSelect/{vacCancNo}")
	public ModelAndView restCancleDetail (ModelAndView mv, @PathVariable String vacCancNo) {
		
		int number = Integer.valueOf(vacCancNo);
		
		CancelVacationAndAppVacationDTO cancelVacDetail = empAnnualService.restCancelDetailSelect(number);
		
		mv.addObject("cancelVacDetail", cancelVacDetail);
		mv.setViewName("manage/empAnnual/restCancleDetailSelect");
		
		return mv;
	}
	
	/* 휴가 취소 신청 승인시 연차 횟수 증가하는 트랜잭션 */
	@GetMapping("/cancDayOffUpdate")
	public ModelAndView dayOffUpdate2(HttpServletRequest request, 
			ModelAndView mv, RedirectAttributes rttr) throws ParseException {
		
		int vacCancNo = Integer.valueOf(request.getParameter("vacCancNo")); // 휴가 취소 번호
		int vacNo = Integer.valueOf(request.getParameter("vacNo"));
		int empNo = Integer.valueOf(request.getParameter("empNo")); // 사원 번호
		String vacStartDate = request.getParameter("vacStartDate");
		String vacEndDate = request.getParameter("vacEndDate");
		
		empDayOffService.findDayOffEmpNo(vacCancNo, vacNo, empNo, vacStartDate, vacEndDate);
		
		rttr.addFlashAttribute("updateSuccessMessage", "성공");
		mv.setViewName("redirect:/empAnnual/restCancelSelect");
		
		return mv;
	}
	
	
	/* 휴가 신청 반려 사유 */
	@GetMapping("/reasonAdd/{reasonAdds}/{no}")
	public ModelAndView reasonAdd(@PathVariable String reasonAdds, @PathVariable String no, ModelAndView mv, RedirectAttributes rttr) {
		String delayReson = reasonAdds;
		int vacNo = Integer.valueOf(no);
		
		Boolean check = empAnnualService.findByVacNo(delayReson, vacNo);
		if(check) {
			rttr.addFlashAttribute("successMessage", "성공");
		} else {
			rttr.addFlashAttribute("failMessage", "실패");
		}
		mv.setViewName("redirect:/empAnnual/restSelect");
		return mv;
	}
}
