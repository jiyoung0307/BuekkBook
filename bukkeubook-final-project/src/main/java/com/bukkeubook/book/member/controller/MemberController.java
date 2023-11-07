package com.bukkeubook.book.member.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bukkeubook.book.manage.model.dto.EmpDTO;
import com.bukkeubook.book.manage.model.service.EmpService;

@Controller
public class MemberController {
	
	private EmpService empService;
	
	@Autowired
	public MemberController(EmpService empService) {
		this.empService = empService;
	}
	
	@GetMapping("/common/denied")
	public ModelAndView denied(ModelAndView mv, RedirectAttributes rttr) {
		
		rttr.addFlashAttribute("accessDeniedMessage", "성공");
		mv.setViewName("/common/denied");
		return mv;
	}
	
	@GetMapping("/common/leaveMember")
	public ModelAndView leaveMember(ModelAndView mv, RedirectAttributes rttr) {
		
		rttr.addFlashAttribute("LeaveMemberMessage", "성공");
		mv.setViewName("/common/leaveMember");
		return mv;
	}
	
	@GetMapping("/member/loginFail")
	public void loginFail(HttpServletRequest request, ModelAndView mv, RedirectAttributes rttr) throws UnsupportedEncodingException {
		String message = request.getParameter("exception");
		System.out.println(message);
//		rttr.addFlashAttribute("loginFailMessage", message);
//		mv.addObject("loginFailMessage", message);
//		mv.setViewName("redirect:/member/loginFail");
//		return mv;
	}
	
	@GetMapping("/logout")
	public String memberLogout() {
		return "/member/login";
	}
	
	@GetMapping("/member/login")
	public String memberLogin() {
		return "redirect:/";
	}
	
	@GetMapping("/member/changePw")
	public String changePw() {
		return "/member/changePw";
	}
	
	@PostMapping("/member/changePw")
	public ModelAndView changePw(HttpServletRequest request, ModelAndView mv, RedirectAttributes rttr) {
		int no = Integer.valueOf(request.getParameter("username"));
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String password3 = request.getParameter("password3");
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		EmpDTO emp = empService.findEmpByEmpNo2(no);
		System.out.println(emp.getEmpPwd());
		System.out.println(bc.matches(password1, emp.getEmpPwd()));
		if(!bc.matches(password1, emp.getEmpPwd())) {
			rttr.addFlashAttribute("notMatched", "정보조회실패");
			mv.setViewName("redirect:/member/changePw");
			return mv;
		} else if(!password2.equals(password3)) {
			rttr.addFlashAttribute("fail", "실패");
			mv.setViewName("redirect:/member/changePw");
			return mv;
		} else if(bc.matches(password1, emp.getEmpPwd())) {
			EmpDTO emp2 = empService.findEmpByEmpNo2(no, password1, password2, password3);
			rttr.addFlashAttribute("updateSuccessMessage", "성공");
			mv.setViewName("redirect:/member/changePw");
			return mv;
		}
		return mv;
	}
}
