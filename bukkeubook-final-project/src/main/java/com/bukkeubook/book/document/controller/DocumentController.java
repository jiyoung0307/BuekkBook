package com.bukkeubook.book.document.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bukkeubook.book.document.compare.InboxListComparator;
import com.bukkeubook.book.document.model.dto.AppRootDTO;
import com.bukkeubook.book.document.model.dto.AppVacationDTO;
import com.bukkeubook.book.document.model.dto.ApproverDTO;
import com.bukkeubook.book.document.model.dto.CancelVacationDTO;
import com.bukkeubook.book.document.model.dto.DeptDTO;
import com.bukkeubook.book.document.model.dto.DocWriteInfoDTO;
import com.bukkeubook.book.document.model.dto.DocumentAndEmpAndFormCateDTO;
import com.bukkeubook.book.document.model.dto.EmpDTO;
import com.bukkeubook.book.document.model.dto.FormCateDTO;
import com.bukkeubook.book.document.model.dto.InboxListDTO;
import com.bukkeubook.book.document.model.dto.SubmitDocumentDTO;
import com.bukkeubook.book.document.model.dto.TempStoreDocumentDTO;
import com.bukkeubook.book.document.model.entity.Approver;
import com.bukkeubook.book.document.model.entity.SubmitApprover;
import com.bukkeubook.book.document.model.service.DocService;
import com.bukkeubook.book.member.model.dto.UserImpl;

@Controller
@RequestMapping("document/*")
public class DocumentController {		// 전자결재 컨트롤러
	
	private DocService docService;
	
	@Autowired
	public DocumentController(DocService docService) {
		this.docService = docService;
	}

	/* 전자결재 작성 첫화면 - 양식 고르기 */
	@GetMapping("insert")
	public ModelAndView toDocWrite(ModelAndView mv) {
		
		List<FormCateDTO> formList = docService.findDocFormList();
		mv.addObject("formList", formList);
		mv.setViewName("document/insert");
		
		return mv;
	}
	
	/* 각 양식에따른 전자결재 화면 이동 */
	@GetMapping("insertTo/{formNo}")
	public ModelAndView toSelectByFormNo(ModelAndView mv, @PathVariable String formNo) {
		
//		System.out.println("fffffffffffffffffffffffffffffffffffff" + formNo);
		
		mv.setViewName("document/insert"+formNo);
		
		return mv;
		
	}
	
	/* 수신함 리스트 조회 */
	@GetMapping("docInboxList")
	public ModelAndView toDocList(ModelAndView mv, @AuthenticationPrincipal UserImpl customUser) {
		
		int empNo = customUser.getEmpNo();
		
		List<InboxListDTO> all = docService.findInboxAllList(empNo);
		
		Collections.sort(all, new InboxListComparator().reversed());
		
//		System.out.println(all);
		mv.addObject("all", all);
		mv.setViewName("/document/docInboxList");
		
		return mv;
	}
	
	/* 수신함 상세 조회 */
	@GetMapping("indoxDetail/{docNo}")
	public ModelAndView inboxDetailView (ModelAndView mv,@PathVariable int docNo) {
		
		System.out.println(docNo);
		
		TempStoreDocumentDTO doc = docService.findByDocNo(docNo);
		
		mv.addObject("doc", doc);
		
		mv.setViewName("/document/indoxDetail");
		
		return mv;
	}
	
	/* 임시저장 리스트 조회 */
	@GetMapping("docTempList")
	public ModelAndView toTempDocList(ModelAndView mv,@AuthenticationPrincipal UserImpl customUser) {
		
		int tempEmpNo = customUser.getEmpNo();
		String docStatus = "임시저장";
		
		List<DocumentAndEmpAndFormCateDTO> tempDocList = docService.findTempDocList(tempEmpNo,docStatus);
		
//		System.out.println("ccccccccccccccc임시저장 리스트 조회cccccccccccccccc" + tempDocList);
		
		mv.addObject("tempDocList", tempDocList);
		mv.setViewName("/document/docTempList");
		
		return mv;
	}
	
	/* 전자결재 작성시 작성자 이름, 부서명, 문서번호 넣어주기 */
	@GetMapping(value = {"empInfo"}, produces="application/json;charset=UTF-8")
	@ResponseBody
	public DocWriteInfoDTO docWriteInfo(@AuthenticationPrincipal UserImpl customUser) {
		
//		System.out.println("emp     " + emp);
		int empNo = customUser.getEmpNo();
		
		System.out.println(empNo);
		
		DocWriteInfoDTO info = docService.findWriterInfo(empNo);
		
		return info;
	}
	
	/* 결재라인 지정 ajax select Tag Option Dept */
	@GetMapping(value = {"dept"}, produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<DeptDTO> findDeptList(){
		
		List<DeptDTO> list = new ArrayList<>();
		
		list = docService.findDept();
		
//		System.out.println(list);
		
		return list;
	}
	
	/* 결재라인 지정 ajax select Tag Option Emp */
	@GetMapping(value = {"emp/{deptValue}"}, produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<EmpDTO> findEmpList(@PathVariable String deptValue){
		
		System.out.println("ttttttttttttttttttttttttttttttttttttttttttttttt" + deptValue);
		
		List<EmpDTO> list = new ArrayList<>();
		
		int dept = Integer.valueOf(deptValue);
		
		list = docService.findEmp(dept);
		
		System.out.println(list);
		
		return list;
	}
	
	/* 임시저장 */
	@PostMapping("tempStore")
	public ModelAndView tempSave(TempStoreDocumentDTO newDoc, RedirectAttributes rttr, ModelAndView mv,@AuthenticationPrincipal UserImpl customUser) {
		
//		System.out.println("djhkfghdjsgkfdjdfjdffffffffffffffffffffffffffffffffffffffffff");
		String docStatus = "임시저장";
		int empNo = customUser.getEmpNo();
		
		newDoc.setDocStatus1(docStatus);
		newDoc.setEmpNo1(empNo);
		System.out.println(newDoc);
		
		boolean isInserted = docService.insertNewtempDocument(newDoc);
		
		if(isInserted) {

			rttr.addFlashAttribute("insertSuccess", "임시저장을 성공하였습니다.");
			
		} else {
			
			rttr.addFlashAttribute("insertFail", "임시저장을 성공하였습니다.");
			
		}
		
		mv.setViewName("redirect:/document/docTempList");
		
		return mv;
	}
	
	/* 임시저장 수정 페이지 접속*/
	@GetMapping("tempInfo/{docNo}")
	public ModelAndView toUpdateTempDocPage(ModelAndView mv,@PathVariable String docNo,@AuthenticationPrincipal UserImpl customUser) {
		
		int selectedDocNo = Integer.valueOf(docNo);
		int tempEmpNo = customUser.getEmpNo();
		String docStatus = "임시저장";
		System.out.println("여기컨트롤러에서 번호 잘받았니      " + selectedDocNo);
		
		DocumentAndEmpAndFormCateDTO oneTempDoc = docService.findOneTempDoc(selectedDocNo,tempEmpNo,docStatus);
		System.out.println("갔다왔니");
		System.out.println("갔다왔니");
		System.out.println(oneTempDoc);
		
		mv.addObject("oneTempDoc", oneTempDoc);

		if(oneTempDoc.getFormNo() == 1) {	// 기안서일 경우
			mv.setViewName("/document/detailTempDocDraft");
		} else {	//지결서일 경우
			mv.setViewName("/document/detailTempDocExpenditure");
		}
		
		return mv;
	}
	
	/* 임시저장 수정하기 */
	@PostMapping("tempUpdate")
	public ModelAndView updateTempDoc(ModelAndView mv, TempStoreDocumentDTO updateDoc, RedirectAttributes rttr,@AuthenticationPrincipal UserImpl customUser) {
		
		System.out.println("수정할 아이 챙겨왔니    " + updateDoc);
		int empNo = customUser.getEmpNo();
		updateDoc.setEmpNo1(empNo);
		
		boolean check = docService.updateTempDocument(updateDoc);
		
		if(check) {

			rttr.addFlashAttribute("insertSuccess", "임시저장을 성공하였습니다.");
			
		} else {
			
			rttr.addFlashAttribute("insertFail", "임시저장을 성공하였습니다.");
			
		}
		
		mv.setViewName("redirect:/document/docTempList");
		
		return mv;
	}
	
	/* 임시저장 삭제하기 */
	@GetMapping("deleteTempDoc/{num}")
	public ModelAndView deleteTempDoc(ModelAndView mv, RedirectAttributes rttr, @PathVariable String num) {
		
		System.out.println("Controller                       " + num);
		
		int docNo = Integer.valueOf(num);
		
		System.out.println("for          Controller           " + docNo);
		
		boolean check = docService.deleteTempDoc(docNo);
		
		if(check) {

			rttr.addFlashAttribute("insertSuccess", "임시저장을 성공하였습니다.");
			
		} else {
			
			rttr.addFlashAttribute("insertFail", "임시저장을 성공하였습니다.");
			
		}
		
		mv.setViewName("redirect:/document/docTempList");
		
		return mv;
		
	}
	
	/* 새로작성한 기안서, 지결서 상신하기 */
	@PostMapping("submitReport")
	public ModelAndView draftSubmitReport(ModelAndView mv,SubmitDocumentDTO newDoc, RedirectAttributes rttr
										, @RequestParam("app1") String app1, @RequestParam String approver1
										, @RequestParam String approver2, @RequestParam String approver3
										, @RequestParam String submitTitle, @AuthenticationPrincipal UserImpl customUser) {
		System.out.println("잘 가져 왔니");
		System.out.println(newDoc);
		System.out.println("number1          " + app1);
		System.out.println(approver1);
		System.out.println(approver2);
		System.out.println(approver3);
		System.out.println(submitTitle);
		String appStatus = "대기";
		String docStatus = "대기";
		int empNo = customUser.getEmpNo();
		boolean check = true;
		
		/* 일단 문서 인서트 */
		newDoc.setDocTitle2(submitTitle);
		newDoc.setDocStatus2(docStatus);
		newDoc.setEmpNo2(empNo);
		
		/* 다음은 결재경로 */
		AppRootDTO appRoot = new AppRootDTO();
		int step = Integer.valueOf(app1);
		appRoot.setStepNo(step);
		
		/* 결재자 인서트 */
		List<SubmitApprover> approverList = new ArrayList<>();
		
		/* 결재자가 한명일 때 */
		if(approver1 != "" && approver2 == "" && approver3 == "") {
			
			int appr = Integer.valueOf(approver1);
			ApproverDTO approver = new ApproverDTO();
			approver.setEmpNo(appr);
			approver.setAppStatus(appStatus);
			check = docService.insertNewDocOneAcc(newDoc,appRoot,approver);
			
		} else if(approver1 != "" && approver2 != "" && approver3 == "") {
			/* 결재자가 두명일 때 */
			int appr1 = Integer.valueOf(approver1);
			SubmitApprover appro = new SubmitApprover();
			appro.setEmpNo2(appr1);
			appro.setAppStatus2(appStatus);
			approverList.add(appro);
			
			int appr2 = Integer.valueOf(approver2);
			SubmitApprover appro2 = new SubmitApprover();
			appro2.setEmpNo2(appr2);
			appro2.setAppStatus2(appStatus);
			approverList.add(appro2);
			
			
			check = docService.insertNewDocThreeAcc(newDoc,appRoot,approverList);
			
		} else if (approver1 != "" && approver2 != "" && approver3 != "") {
			/* 결재자가 세명일 때 */
			int appr1 = Integer.valueOf(approver1);
			SubmitApprover appro = new SubmitApprover();
			appro.setEmpNo2(appr1);
			appro.setAppStatus2(appStatus);
			approverList.add(appro);
			
			int appr2 = Integer.valueOf(approver2);
			SubmitApprover appro2 = new SubmitApprover();
			appro2.setEmpNo2(appr2);
			appro2.setAppStatus2(appStatus);
			approverList.add(appro2);
			
			int appr3 = Integer.valueOf(approver3);
			SubmitApprover appro3 = new SubmitApprover();
			appro3.setEmpNo2(appr3);
			appro3.setAppStatus2(appStatus);
			approverList.add(appro3);
			
			check = docService.insertNewDocThreeAcc(newDoc,appRoot,approverList);
			
		}
		
		if(check) {

			rttr.addFlashAttribute("insertSuccess", "임시저장을 성공하였습니다.");
			
		} else {
			
			rttr.addFlashAttribute("insertFail", "임시저장을 성공하였습니다.");
			
		}
		
		mv.setViewName("redirect:/document/reqApprovalList");
		
		return mv;
	}
	
	/* 임시저장된 기안서, 지결서 상신하기 */
	@PostMapping("submitTempReport")
	public ModelAndView submitTempReport (ModelAndView mv,SubmitDocumentDTO tempDoc, RedirectAttributes rttr
										, @RequestParam("app1") String app1, @RequestParam String approver1
										, @RequestParam String approver2, @RequestParam String approver3
										, @RequestParam String submitTitle,@AuthenticationPrincipal UserImpl customUser) {
		
		System.out.println("잘 가져 왔니");
		System.out.println(tempDoc);
		System.out.println("number1          " + app1);
		System.out.println(approver1);
		System.out.println(approver2);
		System.out.println(approver3);
		System.out.println(submitTitle);
		String appStatus = "대기";
		int emoNo = customUser.getEmpNo();
		boolean check = true;
		
		/* 일단 문서 인서트 */
		tempDoc.setDocTitle2(submitTitle);
		tempDoc.setEmpNo2(emoNo);
		
		/* 다음은 결재경로 */
		AppRootDTO appRoot = new AppRootDTO();
		int step = Integer.valueOf(app1);
		appRoot.setStepNo(step);
		
		/* 결재자 인서트 */
		List<SubmitApprover> approverList = new ArrayList<>();
		
		/* 결재자가 한명일 때 */
		if(approver1 != "" && approver2 == "" && approver3 == "") {
			
			int appr = Integer.valueOf(approver1);
			ApproverDTO approver = new ApproverDTO();
			approver.setEmpNo(appr);
			approver.setAppStatus(appStatus);
			
			check = docService.submitTempDocOneAcc(tempDoc,appRoot,approver);
			
		} else if(approver1 != "" && approver2 != "" && approver3 == "") {
			/* 결재자가 두명일 때 */
			int appr1 = Integer.valueOf(approver1);
			SubmitApprover appro = new SubmitApprover();
			appro.setEmpNo2(appr1);
			appro.setAppStatus2(appStatus);
			
			int appr2 = Integer.valueOf(approver2);
			SubmitApprover appro2 = new SubmitApprover();
			appro2.setEmpNo2(appr2);
			appro2.setAppStatus2(appStatus);
			
			approverList.add(appro);
			approverList.add(appro2);
			
			check = docService.submitTempDocTwoAcc(tempDoc,appRoot,approverList);
			
		} else if (approver1 != "" && approver2 != "" && approver3 != "") {
			/* 결재자가 세명일 때 */
			int appr1 = Integer.valueOf(approver1);
			SubmitApprover appro = new SubmitApprover();
			appro.setEmpNo2(appr1);
			appro.setAppStatus2(appStatus);
			
			int appr2 = Integer.valueOf(approver2);
			SubmitApprover appro2 = new SubmitApprover();
			appro2.setEmpNo2(appr2);
			appro2.setAppStatus2(appStatus);
			
			int appr3 = Integer.valueOf(approver3);
			SubmitApprover appro3 = new SubmitApprover();
			appro3.setEmpNo2(appr3);
			appro3.setAppStatus2(appStatus);
			
			approverList.add(appro);
			approverList.add(appro2);
			approverList.add(appro3);
			
			check = docService.submitTempDocTwoAcc(tempDoc,appRoot,approverList);
		
		}
		
		if(check) {

			rttr.addFlashAttribute("insertSuccess", "임시저장을 성공하였습니다.");
			
		} else {
			
			rttr.addFlashAttribute("insertFail", "임시저장을 성공하였습니다.");
			
		}
		mv.setViewName("redirect:/document/reqApprovalList");
		
		return mv;
	}
	
	/* 상신함 전체리스트 조회 */
	@GetMapping("reqApprovalList")
	public ModelAndView toReqApprovalList(ModelAndView mv, @AuthenticationPrincipal UserImpl customUser) {
		
		int empNo = customUser.getEmpNo();
		String docStatus = "임시저장";
		
		List<DocumentAndEmpAndFormCateDTO> docList = docService.findByDocNoList(empNo,docStatus);
		mv.addObject("docList", docList);
		mv.setViewName("/document/reqApprovalList");
		
		return mv;
	}
	
	/* 상신함 상세조회 */
	@GetMapping("reqApprovalDetail/{docNo}")
	public ModelAndView reqApprovalDetail(ModelAndView mv, @PathVariable int docNo) {
		
		System.out.println(docNo);
		
		TempStoreDocumentDTO doc = docService.findByDocNo(docNo);
		
		mv.addObject("doc", doc);
		
		mv.setViewName("/document/reqApprovalDetail");
		
		return mv;
		
	}
	
	/* 휴가 리스트 조회 */
	@GetMapping("allVacationList")
	public ModelAndView allVacationList(ModelAndView mv,@AuthenticationPrincipal UserImpl customUser) {
		
		int empNo = customUser.getEmpNo();
		
		List<AppVacationDTO> vacaList = docService.allVacationList(empNo);
		
		mv.addObject("vacaList", vacaList);
		
		mv.setViewName("/document/allVacationList");
		
		return mv;
	}
	
	/* 휴가 신청 상세 조회 */
	@GetMapping("vacationDetail/{no}")
	public ModelAndView vacationDetail(ModelAndView mv, @PathVariable String no) {
		
		int vacNo = Integer.valueOf(no);
		
		AppVacationDTO vaca = docService.findByVacNo(vacNo);
		
		mv.addObject("vaca", vaca);
		mv.setViewName("/document/detailVacation");
		
		return mv;
		
	}
	
	/* 휴가취소 리스트 조회 */
	@GetMapping("allCancelVacationList")
	public ModelAndView allCancelVacationList(ModelAndView mv,@AuthenticationPrincipal UserImpl customUser) {
		
		int empNo = customUser.getEmpNo();
		
		List<CancelVacationDTO> cancelList = docService.allCancelVacationList(empNo);
		
		mv.addObject("cancelList", cancelList);
		
		mv.setViewName("/document/allCancelVacationList");
		
		return mv;
	}
	
	/* 휴가취소 상세조회 */
	@GetMapping("cancelVacationDetail/{no}")
	public ModelAndView cancelVacationDetail(ModelAndView mv, @PathVariable String no) {
		
		int vacCancNo =Integer.valueOf(no);
		
		CancelVacationDTO canc = docService.findByvacCancNo(vacCancNo);
		
		mv.addObject("canc", canc);
		
		mv.setViewName("/document/detailCancelVacation");
		
		return mv;
	}
	
	/* 휴가신청서 상신하기 */
	@PostMapping("insertNewVacationApp")
	public ModelAndView insertNewVacationApp(ModelAndView mv, RedirectAttributes rttr 
										   , AppVacationDTO vacation,@RequestParam String startDate
										   , @RequestParam String endDate,@RequestParam String date
										   , @RequestParam String num1,@RequestParam String num2
										   , @RequestParam String num3,@AuthenticationPrincipal UserImpl customUser) {
		
		System.out.println("Controller         " + vacation);
		System.out.println("Controller         " + endDate);
		System.out.println("Controller         " + startDate);
		System.out.println("Controller         " + date);
		
		String vacStatus = "대기";
		Date vacStartDate = Date.valueOf(startDate);
		Date vacEndDate = Date.valueOf(endDate);
		Date vacAppNo = Date.valueOf(date);
		int empNo = customUser.getEmpNo();
		
		vacation.setVacStartDate(vacStartDate);
		vacation.setVacEndDate(vacEndDate);
		vacation.setVacAppNo(vacAppNo);
		vacation.setVacStatus(vacStatus);
		vacation.setEmpNo(empNo);
		vacation.setVacEmer(num1+num2+num3);
		boolean check = docService.insertNewVacationApp(vacation);
		
		System.out.println("Controller         " + vacation);
		
		if(check) {

			rttr.addFlashAttribute("insertSuccess", "임시저장을 성공하였습니다.");
			
		} else {
			
			rttr.addFlashAttribute("insertFail", "임시저장을 성공하였습니다.");
			
		}
		
		mv.setViewName("redirect:/document/allVacationList");
		
		return mv;
		
	}
	
	/* 취소 신청서 작성시 자신이 작성한 휴가 신청서 리스트 조회  ajax*/
	@GetMapping(value = {"vacationList"}, produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<AppVacationDTO> vacationList(@AuthenticationPrincipal UserImpl customUser){
		
		int empNo = customUser.getEmpNo();
		
		List<AppVacationDTO> vacationList = new ArrayList<>();
		
		vacationList = docService.findByEmpNoVacationList(empNo);
		
		return vacationList;
	}
	
	/* 휴가 취소신청서 상신 */
	@PostMapping("insertNewCancelVacation")
	public ModelAndView insertNewCancelVacation(ModelAndView mv, RedirectAttributes rttr
											  , @RequestParam String date,CancelVacationDTO cancVaca
											  , @AuthenticationPrincipal UserImpl customUser) {
		
		System.out.println(cancVaca);
		
		String vacStatus = "대기";
		Date vacAppNo = Date.valueOf(date);
		int empNo = customUser.getEmpNo();
		
		cancVaca.setVacCancDate(vacAppNo);
		cancVaca.setVacCancStatus(vacStatus);
		cancVaca.setEmpNo(empNo);
		
		System.out.println(cancVaca);
		
		boolean check = docService.insertNewCancelVacation(cancVaca);
		
		if(check) {

			rttr.addFlashAttribute("insertSuccess", "임시저장을 성공하였습니다.");
			
		} else {
			
			rttr.addFlashAttribute("insertFail", "임시저장을 성공하였습니다.");
			
		}
		
		mv.setViewName("redirect:/document/allCancelVacationList");
		
		return mv;
		
	}
		
	/* 휴가서류 문서번호 조회 */
	@GetMapping(value = {"vacationInfo"}, produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<Integer> vacationInfo(@AuthenticationPrincipal UserImpl customUser){
		
		int empNo = customUser.getEmpNo();
		List<Integer> vacationInfo = docService.vacationInfo(empNo);
		
		return vacationInfo;
	}
	
	/* 결재 승인 반려 */
	@PostMapping("docApproval")
	public ModelAndView docApproval(ModelAndView mv, @RequestParam String statusApp
								  , TempStoreDocumentDTO doc, RedirectAttributes rttr
								  , @AuthenticationPrincipal UserImpl customUser) {
		
		System.out.println(doc);
		System.out.println("statusApp   " + statusApp);
		
		int empNo = customUser.getEmpNo();
		boolean check = true;
		
		if("승인".equals(statusApp)) {
			check = docService.updateDocStatusApprove(empNo,doc,statusApp);
		} else {
			check = docService.updateDocStatusRefuse(empNo,doc,statusApp);
		}
		
		if(check) {

			rttr.addFlashAttribute("insertSuccess", "임시저장을 성공하였습니다.");
			
		} else {
			
			rttr.addFlashAttribute("insertFail", "임시저장을 성공하였습니다.");
			
		}
		mv.setViewName("redirect:/document/docInboxList");
		
		return mv;
		
	}
	
	/* 결재 버튼 활성화 체크 */
	@GetMapping(value = {"checkButton/{no}"}, produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<String> checkButton(@PathVariable String no,@AuthenticationPrincipal UserImpl customUser){
		
		int empNo = customUser.getEmpNo();
		int docNo = Integer.valueOf(no);
		
		List<String> list = docService.checkDoc(docNo,empNo);
		
		return list;
	}
	
	/* 결재시 서명 도장 이름 가져오기 */
	@GetMapping(value = {"findSignName"}, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<String> findSignName(@AuthenticationPrincipal UserImpl customUser) {
		
		int empNo =  customUser.getEmpNo();
		
		List<String> signName = docService.findSignName(empNo);
		
		return signName;
	}
}
