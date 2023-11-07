package com.bukkeubook.book.manage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bukkeubook.book.manage.model.dto.DeptDTO;
import com.bukkeubook.book.manage.model.dto.joinDTO.DeptAndEmpDTO;
import com.bukkeubook.book.manage.model.service.DeptService;

@Controller
@RequestMapping("/dept")
public class DeptController {
	
	private final DeptService deptService;
	
	@Autowired
	public DeptController(DeptService deptService) {
		this.deptService = deptService;
	}
	
	@GetMapping("/select")
	public ModelAndView selectDept(HttpServletRequest request, ModelAndView mv) {
		
		List<DeptAndEmpDTO> deptList = deptService.selectDeptList();
		
		mv.addObject("deptList", deptList);
		mv.setViewName("/manage/dept/departmentSelect");
		
		return mv;
	}
	
	@GetMapping("/detail")
	public ModelAndView detailDept(HttpServletRequest request, ModelAndView mv) {
		int deptCode = Integer.valueOf(request.getParameter("deptCode"));
		
		DeptAndEmpDTO dept = deptService.searchDeptDetail(deptCode);
		
		mv.addObject("dept", dept);
		mv.setViewName("/manage/dept/departmentDetail");
		
		return mv;
	}
	
//	@GetMapping("/regist")
//	public ModelAndView registPage(ModelAndView mv) {
//		mv.setViewName("/manage/dept/departmentRegist");
//		
//		return mv;
//	}
//	
//	@PostMapping("/regist")
//	public ModelAndView registDept(HttpServletRequest request, ModelAndView mv, RedirectAttributes rttr) {
//		
//		int rownum = Integer.valueOf(request.getParameter("rownum"));
//
//		List<Integer> empNo = new ArrayList<Integer>();
//		
//		for(int i = 2; i <= rownum; i++) {
//			System.out.println("i번째 : " + request.getParameter("empNo" + i));
//			
//			empNo.add(Integer.valueOf(request.getParameter("empNo" + i)));
//		}
//		
//		DeptDTO newDept = new DeptDTO();
//		
//		newDept.setDeptName(request.getParameter("deptName"));
//		newDept.setDeptRepPhone(request.getParameter("deptRepPhone"));
//		newDept.setDeptActive("Y");
//		
//		System.out.println("등록 위한 DTO 잘 들어왔나? : " + newDept);
//		
//		deptService.registDept(newDept, empNo);
//		
//		rttr.addFlashAttribute("registSuccessMessage", "부서 등록에 성공하셨습니다");
//		mv.setViewName("redirect:/dept/select");
//		
//		return mv;
//	}
//	
//	@GetMapping("/popup")
//	public ModelAndView popupPage(HttpServletRequest request, ModelAndView mv) {
//
//		String searchCondition = request.getParameter("searchCondition");
//		String searchValue = request.getParameter("searchValue");
//
//		List<EmpDTO> empList = deptService.searchEmpList(searchCondition, searchValue);
//
//		for(EmpDTO emp : empList) {
//			System.out.println(emp);
//		}
//
//		mv.addObject("empList", empList);
//		mv.setViewName("manage/dept/empPopup");
//
//		return mv;
//	}
	
	@GetMapping("/modify")
	public ModelAndView modifyPage(HttpServletRequest request, ModelAndView mv) {
		
		int deptCode = Integer.valueOf(request.getParameter("deptCode1"));
		
		DeptDTO dept = deptService.searchDeptDetailForModify(deptCode);
		
		mv.addObject("dept", dept);
		mv.setViewName("manage/dept/departmentModify");
		
		return mv;
	}
	
	@PostMapping("/modify")
	public ModelAndView modifyDept(ModelAndView mv, RedirectAttributes rttr, HttpServletRequest request) {
		
		System.out.println("Controller에서 확인");
		System.out.println("deptCode : " + request.getParameter("deptCode"));
		System.out.println("deptName : " + request.getParameter("deptName"));
		System.out.println("deptRepPhone : " + request.getParameter("deptRepPhone"));
		
		DeptDTO newDept = new DeptDTO();
		
		newDept.setDeptCode(Integer.valueOf(request.getParameter("deptCode")));
		newDept.setDeptName(request.getParameter("deptName"));
		newDept.setDeptRepPhone(request.getParameter("deptRepPhone"));
		
		deptService.modifyDept(newDept);
		
		rttr.addFlashAttribute("registSuccessMessage", "부서 정보 수정에 성공하셨습니다");
		mv.setViewName("redirect:/dept/detail/?deptCode=" + newDept.getDeptCode());
		
		return mv;
	}
	
//	@GetMapping("/getSearchList")
//	@ResponseBody
//	private List<EmpDTO> getSearchList(@RequestParam("searchCondition") String searchCondition,
//			@RequestParam("searchValue") String searchValue, Model model) throws Exception{
//		
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println("ajax 동작함");
//		System.out.println("searchCondition : " + searchCondition);
//		System.out.println("searchValue : " + searchValue);
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		
//		return deptService.searchEmpList(searchCondition, searchValue);
//	}
	
	
}
