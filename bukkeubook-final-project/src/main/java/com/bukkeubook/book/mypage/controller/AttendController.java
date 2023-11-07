package com.bukkeubook.book.mypage.controller;


import java.text.SimpleDateFormat;
import java.util .Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bukkeubook.book.common.paging.DatePagenation;
import com.bukkeubook.book.common.paging.DateSelectCriteria;
import com.bukkeubook.book.manage.model.dto.AttendDTO;
import com.bukkeubook.book.member.model.dto.UserImpl;
import com.bukkeubook.book.mypage.model.service.AttendService;

@Controller
@RequestMapping("/attend")
public class AttendController {
	
	private final AttendService attendService;
	
	@Autowired
	public AttendController(AttendService attendService) {
		this.attendService = attendService;
	}
	
	/* 근태 조회 페이지 이동 */
	@GetMapping("/findPage")
	public ModelAndView findMyAttend(@AuthenticationPrincipal UserImpl customUser, ModelAndView mv, HttpServletRequest request, AttendDTO attendDTO) {
			
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		int memberCode = customUser.getEmpNo();
		
		System.out.println(attendDTO.getAttStart());
		System.out.println(attendDTO.getAttEnd());
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		/* 날짜 연산처리 */
		if(!(attendDTO.getAttEnd() == null)) {
			long endTime = attendDTO.getAttEnd().getTime() + 86399999;
			java.sql.Date endDate1 = new java.sql.Date(endTime);
			attendDTO.setAttEnd(endDate1);
		}
		
		
		int totalCount = attendService.selectTotalCount(memberCode, attendDTO);
		System.out.println(totalCount);
		
		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 5;		//얘도 파라미터로 전달받아도 된다.

		/* 한 번에 보여질 페이징 버튼의 갯*/
		int buttonAmount = 5;
		java.sql.Date startDate = attendDTO.getAttStart();
		java.sql.Date endDate = attendDTO.getAttEnd();
		
		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		DateSelectCriteria dateSelectCriteria = null;
		if(startDate != null) {
			dateSelectCriteria = DatePagenation.getDateSelectCriteria(pageNo, totalCount, limit, buttonAmount, startDate, endDate);
		} else {
			dateSelectCriteria = DatePagenation.getDateSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		System.out.println(dateSelectCriteria);
		
		List<AttendDTO> attend = attendService.findMyAttend(memberCode, dateSelectCriteria);
		
		/* 출근 및 퇴근을 위한 데이터 넘기기 */
		List<AttendDTO> attend1 = attendService.findMyAttend1(memberCode);
		System.out.println(attend);
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String format = sdf.format(date);
		
		mv.addObject("attend", attend);
		mv.addObject("attend1", attend1);
		mv.addObject("selectCriteria", dateSelectCriteria);
		mv.addObject("currentDate", format);
		mv.setViewName("mypage/myAttend");
		
		return mv;
		
		
	}
	
	/* 출근 등록 버튼 */
	@PostMapping("/checkIn")
	public ModelAndView registCheckIn(@AuthenticationPrincipal UserImpl customUser, ModelAndView mv, RedirectAttributes rttr, Locale locale){
		
		
		Date today = new Date();
		long time = today.getTime();
		java.sql.Date startDate = new java.sql.Date(time);
		

		int memberInfo = customUser.getEmpNo();
		
		AttendDTO attend = new AttendDTO();
		
		attend.setAttDate(startDate);
		attend.setAttStart(startDate);
		attend.setEmpNo(memberInfo);
		

		boolean att = attendService.registCheckIn(attend);
		
		if(att){
			rttr.addFlashAttribute("successMessage", "출근 등록이 정상적으로 처리 되었습니다.");
			mv.setViewName("redirect:/attend/findPage");
		}else {
			rttr.addFlashAttribute("failMessage", "작업 실패");
			mv.setViewName("redirect:/main");
		}
		 
		
		return mv;
	}
	
	/* 퇴근 등록 버튼 */
	@PostMapping("/checkOut")
	public ModelAndView updateCheckOut(@AuthenticationPrincipal UserImpl customUser, ModelAndView mv, RedirectAttributes rttr, Locale locale) {
		
		AttendDTO attend = new AttendDTO();
		
		Date today = new Date();
		long time = today.getTime();
		long noTime = today.getTime() - 900000000;
		java.sql.Date startDate = new java.sql.Date(time);
		
		attend.setAttDate(startDate);
		
		int memberInfo = customUser.getEmpNo();
		
		System.out.println(attend);
		
		attendService.resetCheckOut(attend, memberInfo, noTime);
		
		boolean att = attendService.modifyCheckOut(attend, memberInfo, time, noTime);
		
		if(att) {
			rttr.addFlashAttribute("successMessage", "퇴근 등록이 정상적으로 처리 되었습니다.");
			mv.setViewName("redirect:/attend/findPage");
		}else {
			rttr.addFlashAttribute("failMessage", "작업 실패");
			mv.setViewName("redirect:/main");
		}
		
		
		return mv;
		
	}
	
}
