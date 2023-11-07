package com.bukkeubook.book.manage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bukkeubook.book.manage.model.dto.joinDTO.DeptAndEmpDTO;
import com.bukkeubook.book.manage.model.service.DeptService;

@Controller
@RequestMapping("/deptCommon")
public class DeptChartController {
	
private DeptService deptService;
	
	@Autowired
	public DeptChartController(DeptService deptService) {
		this.deptService = deptService;
	}
	
	@GetMapping("/chart")
	public ModelAndView orgChartPage(HttpServletRequest request, ModelAndView mv) {
			
			List<DeptAndEmpDTO> deptList = deptService.selectDeptList();
			
			mv.addObject("deptList", deptList);
			mv.setViewName("/manage/dept/orgChart");
			
			return mv;
	}
	
	@GetMapping("/chartDetail")
	public ModelAndView detailChart(HttpServletRequest request, ModelAndView mv) {
		int deptCode = Integer.valueOf(request.getParameter("deptCode"));
		
		DeptAndEmpDTO dept = deptService.searchDeptDetail(deptCode);
		
		mv.addObject("dept", dept);
		mv.setViewName("/manage/dept/orgChartDetail");
		
		return mv;
	}
}
