package com.bukkeubook.book.manage.controller;

import java.io.File;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bukkeubook.book.common.paging.Pagenation;
import com.bukkeubook.book.common.paging.SelectCriteria;
import com.bukkeubook.book.manage.model.dto.EmpDTO;
import com.bukkeubook.book.manage.model.dto.ProfPhotoDTO;
import com.bukkeubook.book.manage.model.dto.SignDTO;
import com.bukkeubook.book.manage.model.dto.joinDTO.EmpAndDeptDTO;
import com.bukkeubook.book.manage.model.service.EmpService;
import com.bukkeubook.book.manage.model.service.SignService;
import com.bukkeubook.book.mypage.model.service.MyInfoModifyService;

@Controller
@RequestMapping("/manage") 
public class EmployeeController {

private final EmpService empService;
private final SignService signService;
private final MyInfoModifyService myInfoModifyService;
	
	@Autowired
	public EmployeeController(EmpService empService, SignService signService, MyInfoModifyService myInfoModifyService) {
		this.empService = empService;
		this.signService = signService;
		this.myInfoModifyService = myInfoModifyService;

	}
	
	/* 사원조회 , 페이징, 검색기능 */
	@GetMapping("/empList")
	public ModelAndView searchPage(HttpServletRequest request, ModelAndView mv) {  //ModelAndView 뷰 리졸버의 역할 _리턴할 페이지 설정 , 보내는객체
//		System.out.println("ddddddddddddddddddddddddddddddddddddd");
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;

		if (currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");

		int totalCount = empService.selectTotalCount(searchCondition, searchValue);

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

		List<EmpAndDeptDTO> empList = empService.searchEmpList(selectCriteria);
		
		for(EmpAndDeptDTO emp : empList) {
			System.out.println(emp);
		}
		
		mv.addObject("empList", empList);  //보내는 객체 설정
		mv.addObject("selectCriteria", selectCriteria);
		mv.setViewName("manage/employee/empList"); //리턴할 페이지 설정
		
		return mv;
	}
	
	/* 퇴사 사원 조회 (퇴사여부 Y) */
	@GetMapping("leaveEmpList")
	public ModelAndView findLeaveEmpList(ModelAndView mv) {  

		String empEndYn = "Y";
		List<EmpAndDeptDTO> leaveEmpList = empService.findLeaveEmpList(empEndYn);
		System.out.println("leaveEmpList" + leaveEmpList);
		mv.addObject("leaveEmpList", leaveEmpList);  //보내는 객체 설정
		mv.setViewName("manage/employee/leaveEmpList"); //리턴할 페이지 설정
		
		return mv;
	}
		
	/* 사원 상세조회 */
	@GetMapping("/oneEmp/{empNo}")
	public ModelAndView empDetail(ModelAndView mv, @PathVariable String empNo){
		
		int number = Integer.valueOf(empNo);
		
//		System.out.println("컨트롤러에서       " + empNo);
//		System.out.println("컨트롤러에서       " + number);
		
		/* 회원 개인의 정보 가져와서 상세페이지에 뿌리기 */
		EmpAndDeptDTO emp  = empService.searchEmpDetail(number);
		
		/* 마이페이지 service에서 사원 사진 조회 */
		List<com.bukkeubook.book.mypage.model.dto.ProfPhotoDTO> profile = myInfoModifyService.findMyProfile(number);
		
		/* 마이페이지 service에서 도장 사진 조회, 같은 이름으로 임포트 불가능해서 이렇게 설정.*/
		com.bukkeubook.book.mypage.model.dto.SignDTO mySign = myInfoModifyService.findMySign(number);
		
		mv.addObject("emp", emp);
		mv.addObject("profile", profile);
		mv.addObject("mySign", mySign);
		mv.setViewName("manage/employee/empDetail");
		return mv;
		
	}
	
	/* 퇴사사원 상세조회 */
	@GetMapping("/oneLeaveEmp/{empNo}")
	public ModelAndView leaveEmpDetail(ModelAndView mv, @PathVariable String empNo){
		
		int number = Integer.valueOf(empNo);
		
		System.out.println("컨트롤러에서       " + empNo);
		System.out.println("컨트롤러에서       " + number);
		
		EmpAndDeptDTO emp  = empService.searchEmpDetail(number);
		
		System.out.println("컨트롤러에서       " + emp);
		
		mv.addObject("emp", emp);
		mv.setViewName("/manage/employee/leaveEmpDetail");
		return mv;
	}
	
	/* 사원정보 수정 */
	@GetMapping("detailUpdate/{empNo}")
	public ModelAndView empUpdatePage(ModelAndView mv, @PathVariable String empNo) {
		
		int number = Integer.valueOf(empNo);
		
		EmpAndDeptDTO emp = empService.findEmpByEmpNo(number);
		System.out.println("1231231523" + emp);

		/* 프로필 사진 조회 */
		List<ProfPhotoDTO> profile = empService.findEmpProfile(number);
//		System.out.println("111111111111111" + profile);
		
		/* 현재 서명 조회 */
		SignDTO mySign = signService.findEmpSign(number);
//		System.out.println("2222222222222222" + empSign);
		
		mv.addObject("emp", emp);
		mv.addObject("profile", profile);
		mv.addObject("mySign", mySign);
		mv.setViewName("manage/employee/empDetail" + "Update");

		return mv; 

	}
	
	   @PostMapping("/empDetailUpdate")
	   public ModelAndView modifyEmp(ModelAndView mv, RedirectAttributes rttr, EmpDTO emp, @RequestParam String deptCode2, @RequestParam String empJobCode2 ) {
		  
		  /* 기존 정보 */
		 System.out.println(emp);
		 System.out.println(" deptCode2      :     " + deptCode2);
		 
		 if ((deptCode2 == "" || deptCode2 == null)&&(empJobCode2 == "" || empJobCode2 == null)) {
			 empService.modifyEmp(emp);
		 } else if((empJobCode2 == "" || empJobCode2 == null) && (deptCode2 != null)){
			 int deptCode = Integer.valueOf(deptCode2);
			 emp.setDeptCode(deptCode);
			 empService.modifyEmp(emp);
		 } else if((deptCode2 == "" || deptCode2 == null) && (empJobCode2 != null)) {
			 emp.setEmpJobCode(empJobCode2);
			 empService.modifyEmp(emp);
		 } else {
			 int deptCode = Integer.valueOf(deptCode2);
			 emp.setDeptCode(deptCode);
			 emp.setEmpJobCode(empJobCode2);
			 empService.modifyEmp(emp);
		 }
		   
		   
	      rttr.addFlashAttribute("updateSuccessMessage", "직원정보 수정 성공");
	      mv.setViewName("redirect:/manage/empList");
	      return mv;
	      
	   }

		/* 도장 사진 수정 */
		@PostMapping("detailUpdate23")
		public ModelAndView modifySign(ModelAndView mv, HttpServletRequest request,
				@RequestParam("singleFile") MultipartFile singleFile, RedirectAttributes rttr) {
			
			int empNo = Integer.valueOf(request.getParameter("empNo"));
			
			String root = System.getProperty("user.dir");
			System.out.println("root까지의 경로 : " + root);
			
			/* 유찬님이랑 경로 맞출 것 */
			String filePath = root + "/src/main/resources/static/images/sign";
			
			String originFileName = singleFile.getOriginalFilename();
			System.out.println("원본 이름 : " + originFileName);
			String ext = originFileName.substring(originFileName.lastIndexOf("."));
			String saveName = UUID.randomUUID().toString().replace("-", "") + ext;
			System.out.println("변경한 이름 : " + saveName);

			try {
				singleFile.transferTo(new File(filePath + "/" + saveName));
				
				SignDTO sign = new SignDTO();
				sign.setEmpNo(empNo);
				sign.setSignName(originFileName);
				sign.setSignSavedName(saveName);
				sign.setSignPath(filePath);
				
				signService.modifySign(sign);
				
				rttr.addFlashAttribute("signsuccessMessage", "서명 변경을 성공하셨습니다.");
				mv.setViewName("redirect:/manage/empList");
				
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				
				/* 실패 시 파일 삭제 */
				new File(filePath + "/" + saveName).delete();
				rttr.addFlashAttribute("signsuccessMessage", "서명 사진 변경을 실패하셨습니다.");
				mv.setViewName("redirect:/main");
			}
			
			return mv;
		}
		
		/* 프로필 사진 수정 */
		@PostMapping("detailUpdate2")
		public ModelAndView modifyProfile(ModelAndView mv, HttpServletRequest request, 
				@RequestParam("singleFile") MultipartFile singleFile, RedirectAttributes rttr) {
			
			int empNo = Integer.valueOf(request.getParameter("empNo"));
			
			String root = System.getProperty("user.dir");
			System.out.println("root까지의 경로 : " + root);
			
			String filePath = root + "/src/main/resources/static/images/mypage";
			
			String originFileName = singleFile.getOriginalFilename();
			System.out.println("원본 이름 : " + originFileName);
			String ext = originFileName.substring(originFileName.lastIndexOf("."));
			String saveName = UUID.randomUUID().toString().replace("-", "") + ext;
			System.out.println("변경한 이름 : " + saveName);
			
			/* 프로필 사진 저장 처리 */
			try {
				singleFile.transferTo(new File(filePath + "/" + saveName));
				
				/* DB에 저장할 파일 정보를 DTO에 담기 */
				ProfPhotoDTO profile = new ProfPhotoDTO();
				profile.setEmpNo(empNo);
				profile.setPhotoOrigName(originFileName);
				profile.setPhotoSavedName(saveName);
				profile.setPhotoSavedPath(filePath);

				/* Service로 보내서 DB로 전송 */
				empService.modifyProfile(profile);
				
				rttr.addFlashAttribute("profilesuccessMessage", "프로필 변경을 성공하셨습니다.");
				mv.setViewName("redirect:/manage/empList");
				
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				
				/* 실패 시 파일 삭제 */
				new File(filePath + "/" + saveName).delete();
				rttr.addFlashAttribute("successMessage", "서명 사진 변경을 실패하셨습니다.");
				mv.setViewName("redirect:/main");
			}
			
			return mv;
		}
		
		/* 신규사원등록 기능 페이지 연결(insert) */
		@GetMapping("empInsert")
		public ModelAndView empInsertPage(ModelAndView mv) {
			
			mv.setViewName("/manage/employee/empInsert");
			
			return mv;
		}

		/* 신규 직원 등록  insert (개인정보,서명,프로필,비밀번호 비크립트) */
		@PostMapping("insert")
		public ModelAndView insertEmp(EmpDTO empDTO, ModelAndView mv, HttpServletRequest request, 
											@RequestParam("proFile") MultipartFile proFile,  
											@RequestParam("nameFile") MultipartFile nameFile,  
											RedirectAttributes rttr) 
		{
			
			String empAddress = "주소";
			empDTO.setEmpAddress(empAddress);	
			System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeee " + empDTO);
			
			/* 입력받은 사원 초기비밀번호 비크립트화 */
			
			
			/* 프로필 사진, 도장 사진을 제외한 나머지 회원 정보 insert */
//			empService.insertNewEmp(empDTO);
			empService.insertNewEmp(empDTO);
			
			/* 방금 등록한 회원에 대해 기본키 가져오기 */
			List<EmpAndDeptDTO> lastEmp = empService.selectLastEmp();
			
			System.out.println(lastEmp.get(0).getEmpNo());  // 방금 등록한 회원의 번호 추출
			
			int registEmp = lastEmp.get(0).getEmpNo();
			
			/* 민님 이틀 갈아넣어서 만든 프로젝트 내부 저장 방식 소스 */
			String root = System.getProperty("user.dir");
			System.out.println("root까지의 경로 : " + root);
			
			String filePath = root + "/src/main/resources/static/images/mypage";  // 프사 저장 루트
			String signPath = root + "/src/main/resources/static/images/sign"; 	  // 서명 저장 루트
			
			/* 파일 없으면 만들어줌 */
			File mkdir = new File(filePath);	
			if(!mkdir.exists()) {
				mkdir.mkdirs();
			}
			File mkdir1 = new File(signPath);	
			if(!mkdir1.exists()) {
				mkdir1.mkdirs();
			}
			
			/* 원본이랑 저장되는 값 이름이 같으면 안됨 -> 그래서 변경된 값으로 새로 프로젝트에 저장*/
			String originFileName = proFile.getOriginalFilename();
			String originFileName1 = nameFile.getOriginalFilename();
			System.out.println("프로필 사진 원본 이름 : " + originFileName);
			System.out.println("서명 사진 원본 이름 : " + originFileName1);
			
			String ext = originFileName.substring(originFileName.lastIndexOf("."));
			String ext1 = originFileName1.substring(originFileName1.lastIndexOf("."));
			
			String saveName = UUID.randomUUID().toString().replace("-", "") + ext;
			String saveName1 = UUID.randomUUID().toString().replace("-", "") + ext1;
			
			System.out.println("변경한 이름 : " + saveName);
			System.out.println("변경한 이름 : " + saveName1);
			
			/* 프로필 사진 저장 처리 */
			try {
				proFile.transferTo(new File(filePath + "/" + saveName));
				
				/* DB에 저장할 파일 정보를 DTO에 담기 */
				ProfPhotoDTO profile = new ProfPhotoDTO();
				profile.setEmpNo(registEmp);
				profile.setPhotoOrigName(originFileName);
				profile.setPhotoSavedName(saveName);
				profile.setPhotoSavedPath(filePath);
				
				/* 서비스로 보내서 DB로 전송 */
				empService.registEmpProFile(profile);
				
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				
				/* 실패 시 파일 삭제 */
				new File(filePath + "/" + saveName).delete();
			}
			
			
			/* 서명 사진 저장 처리 */
			try {
				nameFile.transferTo(new File(signPath + "/" + saveName1));
				/* DB에 저장할 파일 정보를 DTO에 담기 */
				SignDTO signFile = new SignDTO();
				signFile.setEmpNo(registEmp);
				signFile.setSignName(originFileName1);
				signFile.setSignSavedName(saveName1);
				signFile.setSignPath(signPath);
				
				/* 서비스로 보내서 DB로 전송(signService) */
				signService.registEmpNameFile(signFile);
				
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				
				/* 실패 시 파일 삭제 */
				new File(signPath + "/" + saveName1).delete();
			}
			
			rttr.addFlashAttribute("insertSuccessMessage", "성공"); //addFlashAttribute 한번만 보여주고 감
			mv.setViewName("redirect:/manage/empList");
			return mv;
		}
		
		/* 사원 퇴사처리 */
		@PostMapping("/empLeave")
		public ModelAndView modifyEmpLeave(ModelAndView mv, RedirectAttributes rttr, HttpServletRequest request, EmpDTO emp, 
				Date empEndDate, String empEndYn) {
			
			/* 퇴사할 사원의 번호 가져오기 */
			int empNo = Integer.valueOf(request.getParameter("empNo"));
			
			/* 퇴사 여부 수정 */
			empService.modifyEmpEndYn(emp, empNo);

			rttr.addFlashAttribute("leaveUpdateSuccessMessage", "퇴사처리 성공");
			mv.setViewName("redirect:/manage/leaveEmpList");
			return mv;
		}
	}