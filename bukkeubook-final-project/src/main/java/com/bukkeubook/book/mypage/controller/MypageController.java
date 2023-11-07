package com.bukkeubook.book.mypage.controller;

import java.sql.Date;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bukkeubook.book.books.model.dto.BookDTO;
import com.bukkeubook.book.common.paging.DatePagenation;
import com.bukkeubook.book.common.paging.DateSelectCriteria;
import com.bukkeubook.book.manage.model.dto.AppVacationDTO;
import com.bukkeubook.book.manage.model.dto.AttendDTO;
import com.bukkeubook.book.manage.model.dto.DayOffDTO;
import com.bukkeubook.book.member.model.dto.UserImpl;
import com.bukkeubook.book.mypage.model.dto.CalendarDTO;
import com.bukkeubook.book.mypage.model.service.MypageService;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	private final MypageService mypageService;
	
	@Autowired
	public MypageController( MypageService mypageService) {
		this. mypageService = mypageService;
	}
	
	
	/* 캘린더 전체 조회 */
	@GetMapping("/calendar")
	public ModelAndView findMyCalendar(@AuthenticationPrincipal UserImpl customUser, ModelAndView mv) {
		
		int memberCode = customUser.getEmpNo();
		List<CalendarDTO> calendar = mypageService.findMyCalendar(memberCode);
		System.out.println(calendar);
		
			
		/* 캘린더 API 조회값 범위 수정하기 */
		for(int i = 0; i<calendar.size(); i++) {
			long endTime = calendar.get(i).getEnd().getTime() + 86400000;
			java.sql.Date end = new java.sql.Date(endTime);
			calendar.get(i).setEnd(end);
		}
		
		mv.addObject("calendar", calendar);
		mv.setViewName("mypage/calendar");
		
		return mv;
	}
	
	/* 캘린더 등록 페이지 이동 */
	@GetMapping("/registCalendar")
	public void registCalendar() {}
	
	/* 캘린더 일정 등록 */
	@PostMapping("/insertCal")
	public ModelAndView insertMyCalendar(@AuthenticationPrincipal UserImpl customUser, ModelAndView mv, CalendarDTO newCalendar, RedirectAttributes rttr, Locale locale) {
		
		int memberInfo = customUser.getEmpNo();
		newCalendar.setEmpNo(memberInfo);
		System.out.println(newCalendar);
		
		System.out.println(newCalendar.getStart());
		System.out.println(newCalendar.getEnd());
		
		if(!newCalendar.getStart().toString().equals(newCalendar.getEnd().toString())) {
			long endTime = newCalendar.getEnd().getTime() + 86390000;
			java.sql.Date end = new java.sql.Date(endTime);
			newCalendar.setEnd(end);
		}
		
		
		boolean cal = mypageService.registNewCalendar(newCalendar);
		
		if(cal) {
			rttr.addFlashAttribute("registSuccessMessage", "일정을 성공적으로 등록하셨습니다.");
			mv.setViewName("redirect:/mypage/calendar");
		}else {
			rttr.addFlashAttribute("failMessage", "작업 실패");
			mv.setViewName("redirect:/mypage/calendar");
		}
		
		return mv;
	}
	/* 캘린더 일정 상세 조회 */
	@GetMapping("/detailCal/{calCode}")
	public ModelAndView findMyCalendarDetail(ModelAndView mv, @PathVariable int calCode) {
		
		CalendarDTO detailCal = mypageService.findMyCalendarDetail(calCode);
		
		mv.addObject("detailCal", detailCal);
		mv.setViewName("/mypage/calendarDetail");
		
		return mv;
	}
	
	/* 캘린더 수정 페이지 이동 */
	@GetMapping("/calendar/update/")
	public ModelAndView updateMyCalendar(ModelAndView mv, HttpServletRequest request, String no) {
		
		
		int calCode = Integer.parseInt(request.getParameter("no"));
		
		CalendarDTO detailCal = mypageService.findMyCalendarDetail(calCode);
		
		mv.addObject("detailCal", detailCal);
		mv.setViewName("/mypage/calendarUpdate");
		
		return mv;
	}
	/* 일정 수정하기 (캘린더) */
	@PostMapping("calendar/modify")
	public ModelAndView modifyCalendar(ModelAndView mv, CalendarDTO newCalendar, RedirectAttributes rttr, Locale locale) {
		
		System.out.println(newCalendar);
		
		boolean cal = mypageService.modifyMyCalendar(newCalendar);
		
		if(cal) {
			rttr.addFlashAttribute("updateSuccessMessage", "일정을 성공적으로 수정하셨습니다.");
			mv.setViewName("redirect:/mypage/calendar");
		}else {
			rttr.addFlashAttribute("failMessage", "작업 실패");
			mv.setViewName("redirect:/mypage/calendar");
		}
		
		return mv;
	}
	
	/* 일정 삭제하기 캘린더 */
	@GetMapping("calendar/delete")
	public ModelAndView deleteCalendar(ModelAndView mv, String no, HttpServletRequest request, RedirectAttributes rttr, Locale locale) {
		
		int calCode = Integer.parseInt(request.getParameter("no"));
		boolean cal = mypageService.deleteCalendar(calCode);
		
		if(cal) {
			rttr.addFlashAttribute("deleteSuccessMessage", "일정을 성공적으로 삭제하셨습니다.");
			mv.setViewName("redirect:/mypage/calendar");
		}else {
			rttr.addFlashAttribute("failMessage", "작업 실패");
			mv.setViewName("redirect:/mypage/calendar");
		}
		
		return mv;
	}
	

	/* 마이페이지 연차 조회 */
	@GetMapping("/myAnnual")
	public ModelAndView findMyAnnualList(@AuthenticationPrincipal UserImpl customUser, ModelAndView mv, HttpServletRequest request, Date attStart, Date attEnd) {

		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		int memberCode = customUser.getEmpNo();
		String approve = "승인";
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		/* 날짜 연산처리 */
		
		java.sql.Date attEndDay = attEnd;
		if(!(attEnd == null)) {
			long endTime = attEnd.getTime() + 86399999;
			attEndDay = new java.sql.Date(endTime);
		}
		
		int totalCount = mypageService.selectTotalCount(memberCode, approve, attStart, attEndDay);
		
		int limit = 3;
		int buttonAmount = 5;
		
		java.sql.Date startDate = attStart;
		
		DateSelectCriteria dateSelectCriteria = null;
		if(startDate != null) {
			dateSelectCriteria = DatePagenation.getDateSelectCriteria(pageNo, totalCount, limit, buttonAmount, startDate, attEndDay);
		} else {
			dateSelectCriteria = DatePagenation.getDateSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		System.out.println(dateSelectCriteria);
		
		List<AppVacationDTO> vacation = mypageService.findMyVacation1(memberCode, dateSelectCriteria, approve);
		System.out.println(vacation);
		
		List<DayOffDTO> dayoffList = mypageService.findMyDayOffList(memberCode);
		System.out.println(dayoffList);
		
		mv.addObject("dayoffList", dayoffList);
		mv.addObject("vacationList", vacation);
		mv.addObject("selectCriteria", dateSelectCriteria);
		mv.setViewName("mypage/myAnnual");
		
		return mv;
	}
	

	

}
