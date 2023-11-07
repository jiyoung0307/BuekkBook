package com.bukkeubook.book.manage.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bukkeubook.book.common.paging.AttendPagenation;
import com.bukkeubook.book.common.paging.AttendSelectCriteria;
import com.bukkeubook.book.manage.model.dto.joinDTO.AttendAndEmpDTO;
import com.bukkeubook.book.manage.model.service.AttendManageService;


@Controller
@RequestMapping("check")
public class AttendManageController {
	
	private final AttendManageService attendManageService;
	
	@Autowired
	public AttendManageController(AttendManageService attendManageService) {
		this.attendManageService = attendManageService;
	}
	
	
	@GetMapping("/findCheck")
	public ModelAndView findAttendListManage(HttpServletRequest request, ModelAndView mv, Date attStart, Date attEnd) {

		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		/* 날짜 연산처리 */
		java.sql.Date attEndDay = attEnd;
		if(!(attEnd == null)) {
			long endTime = attEnd.getTime() + 86399999;
			attEndDay = new java.sql.Date(endTime);
		}
		
		int totalCount = attendManageService.selectTotalCount(searchCondition, searchValue, attStart, attEndDay);
		
		int limit = 10;
		int buttonAmount = 5;
		
		AttendSelectCriteria attendSelectCriteria = null;
		if(attStart != null && attEnd != null) {
			if(!"".equals(searchValue)) {
				attendSelectCriteria = AttendPagenation.getAttendSelectCriteria(pageNo, totalCount, limit, buttonAmount, attStart, attEndDay, searchCondition, searchValue);
			}else {
				attendSelectCriteria = AttendPagenation.getAttendSelectCriteria(pageNo, totalCount, limit, buttonAmount, attStart, attEndDay, null, null);
			}
		} else {
			attendSelectCriteria = AttendPagenation.getAttendSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		System.out.println(attendSelectCriteria);
		
		
		List<AttendAndEmpDTO> attendList = attendManageService.searchAttendList(attendSelectCriteria);
		
		
		System.out.println(attendSelectCriteria);
		System.out.println(attendList);

		System.out.println("검색 값의 갯수 :" +totalCount);
		System.out.println("검색 조건 : " + searchCondition);
		System.out.println("검색 값 : " + searchValue);


		
		mv.addObject("attendList", attendList);
		mv.addObject("selectCriteria", attendSelectCriteria);
		mv.setViewName("/manage/empAnnual/empAttendanceList");
		return mv;
	}
	
	


}
