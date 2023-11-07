package com.bukkeubook.book.mypage.controller;

import java.io.File;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bukkeubook.book.manage.model.dto.EmpDTO;
import com.bukkeubook.book.manage.model.dto.joinDTO.EmpAndDeptDTO;
import com.bukkeubook.book.member.model.dto.UserImpl;
import com.bukkeubook.book.mypage.model.dto.ProfPhotoDTO;
import com.bukkeubook.book.mypage.model.dto.SignDTO;
import com.bukkeubook.book.mypage.model.service.MyInfoModifyService;


@Controller
@RequestMapping("/myInfo")
public class MyInfoModifyController {
	
	private final MyInfoModifyService myInfoModifyService;
	
	@Autowired
	public MyInfoModifyController(MyInfoModifyService myInfoModifyService) {
		this.myInfoModifyService = myInfoModifyService; 
	}
	
	
	/* 마이페이지 개인 정보 수정 화면이동 */
	@GetMapping("/updatePage")
	public ModelAndView findMyInfo(@AuthenticationPrincipal UserImpl customUser, ModelAndView mv) {
		
		/* 개인정보 조회 */
		int memberCode = customUser.getEmpNo();
		EmpAndDeptDTO myInfo = myInfoModifyService.findMyInfo(memberCode);
		System.out.println(myInfo);
		
		/* 프로필 사진 조회 */
		List<ProfPhotoDTO> profile = myInfoModifyService.findMyProfile(memberCode);
		System.out.println(profile);
		
		/* 현재 서명 조회 */
		SignDTO mySign = myInfoModifyService.findMySign(memberCode);
		System.out.println(mySign);
		
		mv.addObject("myInfo", myInfo);
		mv.addObject("profile", profile);
		mv.addObject("mySign", mySign);
		mv.setViewName("mypage/mypageInfoModify");
		
		return mv;
	}
	
	/* 마이페이지 개인 정보 수정하기 */
	@PostMapping("/modifyInfo")
	public ModelAndView modifyMyInfo(@AuthenticationPrincipal UserImpl customUser, ModelAndView mv, EmpDTO emp, RedirectAttributes rttr, Locale locale) {
		
		int memberCode = customUser.getEmpNo();
		System.out.println(emp);
		
		boolean myInfo = myInfoModifyService.modifyInfoEmp(memberCode, emp);
		
		if(myInfo) {
			rttr.addFlashAttribute("memberInfoUpdate", "회원정보를 정상적으로 수정하였습니다.");
			mv.setViewName("redirect:/main");
		}else {
			rttr.addFlashAttribute("failMessage", "실패");
			mv.setViewName("redirect:/main");
		}
		
		return mv;
	}
	
	/* 마이페이지 프로필 사진 등록 */
	@PostMapping("/profileRegist")
	public ModelAndView registMyProfile(@AuthenticationPrincipal UserImpl customUser, ModelAndView mv, HttpServletRequest request, @RequestParam("singleFile") MultipartFile singleFile, RedirectAttributes rttr) {
		
		int memberCode = customUser.getEmpNo();
		
		String root = System.getProperty("user.dir");
		System.out.println("root까지의 경로 : " + root);
		
		String filePath = root + "/src/main/resources/static/images/mypage";
		
		File mkdir = new File(filePath);	
		if(!mkdir.exists()) {
			mkdir.mkdirs();
		}
		
		String originFileName = singleFile.getOriginalFilename();
		System.out.println("원본 이름 : " + originFileName);
		String ext = originFileName.substring(originFileName.lastIndexOf("."));
		String saveName = UUID.randomUUID().toString().replace("-", "") + ext;
		System.out.println("변경한 이름 : " + saveName);
		
		try {
			singleFile.transferTo(new File(filePath + "/" + saveName));
			
			ProfPhotoDTO profile = new ProfPhotoDTO(); 
			profile.setEmpNo(memberCode);
			profile.setPhotoOrigName(originFileName);
			profile.setPhotoSavedName(saveName);
			profile.setPhotoSavedPath(filePath);
			
			myInfoModifyService.registProfile(profile);
			
			rttr.addFlashAttribute("successMessage", "프로필 사진 변경을 성공하셨습니다.");
			mv.setViewName("redirect:/main");
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			
			/* 실패 시 파일 삭제 */
			new File(filePath + "/" + saveName).delete();
			rttr.addFlashAttribute("failMessage", "프로필 사진 변경을 실패하셨습니다.");
			mv.setViewName("redirect:/main");
		}
		
		return mv;
	}
	

	
	/* 마이페이지 서명 변경 */
	@PostMapping("signModify")
	public ModelAndView modifySign(@AuthenticationPrincipal UserImpl customUser, ModelAndView mv, HttpServletRequest request, @RequestParam("singleFile") MultipartFile singleFile, RedirectAttributes rttr) {
		
		int memberCode = customUser.getEmpNo();
		
		String root = System.getProperty("user.dir");
		System.out.println("root까지의 경로 : " + root);
		
		String filePath = root + "/src/main/resources/static/images/sign";
		
		String originFileName = singleFile.getOriginalFilename();
		System.out.println("원본 이름 : " + originFileName);
		String ext = originFileName.substring(originFileName.lastIndexOf("."));
		String saveName = UUID.randomUUID().toString().replace("-", "") + ext;
		System.out.println("변경한 이름 : " + saveName);
		
		
		try {
			singleFile.transferTo(new File(filePath + "/" + saveName));
			
			SignDTO sign = new SignDTO();
			sign.setEmpNo(memberCode);
			sign.setSignName(originFileName);
			sign.setSignSavedName(saveName);
			
			myInfoModifyService.modifySign(sign);
			
			rttr.addFlashAttribute("successMessage", "서명 변경을 성공하셨습니다.");
			mv.setViewName("redirect:/main");
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			
			/* 실패 시 파일 삭제 */
			new File(filePath + "/" + saveName).delete();
			rttr.addFlashAttribute("failMessage", "서명 사진 변경을 실패하셨습니다.");
			mv.setViewName("redirect:/main");
		}
		
		
		return mv;
	}
	
	
	                     
	

}
