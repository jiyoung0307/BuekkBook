package com.bukkeubook.book.manage.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriUtils;

import com.bukkeubook.book.common.paging.Pagenation;
import com.bukkeubook.book.common.paging.SelectCriteria;
import com.bukkeubook.book.manage.model.dto.ContFileDTO;
import com.bukkeubook.book.manage.model.dto.EmpContDTO;
import com.bukkeubook.book.manage.model.dto.joinDTO.EmpAndDeptDTO;
import com.bukkeubook.book.manage.model.dto.joinDTO.EmpContAndEmpDTO;
import com.bukkeubook.book.manage.model.service.ContractService;
import com.bukkeubook.book.member.model.dto.UserImpl;

@Controller
@RequestMapping("/cont")
public class ContractController {
	
	private final ContractService contractService;
	
	@Autowired
	public ContractController( ContractService contractService) {
		this.contractService = contractService;
	}
	
	/* 근로계약서 전체 내역 조회 */
	@GetMapping("/findCont")
	public ModelAndView findContracts(HttpServletRequest request, ModelAndView mv) {
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
		
		int totalCount = contractService.selectTotalCount(searchCondition, searchValue);
		System.out.println(totalCount);
		
		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 10;		//얘도 파라미터로 전달받아도 된다.

		/* 한 번에 보여질 페이징 버튼의 갯*/
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = null;
		if(searchValue != null && !"".equals(searchValue)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		System.out.println(selectCriteria);
		
		List<EmpContAndEmpDTO> contList = contractService.searchContractList(selectCriteria);
		System.out.println(contList);
	
		mv.addObject("contList", contList);
		mv.addObject("selectCriteria", selectCriteria);
		mv.setViewName("/manage/contract/contractSelect");
		
		return mv;
		
	}
	
	/* 근로계약서 상세 조회 */
	@GetMapping("findDetailCont")
	public ModelAndView findDetailContracts(HttpServletRequest request, String no, ModelAndView mv) {
		
		int contNo = Integer.valueOf(request.getParameter("no"));
		
		/* 근로 계약서 내역 상세조회 */
		EmpContAndEmpDTO empCont = contractService.findDetailCont(contNo);
		
		/* 해당 근로계약서 내역 파일 상세 정보 불러오기 */
		ContFileDTO file = contractService.findContFileNo(contNo);
		
		System.out.println(file);
		

		
		System.out.println(empCont);
		
		mv.addObject("empCont", empCont);
		mv.addObject("file", file);
		mv.setViewName("/manage/contract/contractDetail");
		
		return mv;
	}
	
	/* 근로계약서 등록 화면 이동 */
	@GetMapping("registPage")
	public ModelAndView moveRegistPage(ModelAndView mv) {
		
		List<EmpAndDeptDTO> empList = contractService.findAllEmpList();
		System.out.println(empList);
		
		
		
		mv.addObject("empList", empList);
		mv.setViewName("/manage/contract/registContract");
		
		return mv;
	}
	
	/* 근로계약서 등록 하기 */
	@PostMapping("/registCont")
	public ModelAndView registContractEmp(@AuthenticationPrincipal UserImpl customUser, HttpServletRequest request, 
											@RequestParam("singleFile") MultipartFile singleFile, 
											RedirectAttributes rttr, ModelAndView mv, EmpContDTO empCont) {
		
		/* 1. 근로 계약서 테이블에 전달 받은 정보 Insert */
		String memberName =  customUser.getEmpName();
		
		/* 현재 시각 sql형으로 구하기 */
		Date today = new Date();
		long time = today.getTime();
		java.sql.Date current = new java.sql.Date(time);
		
		
		
		
		empCont.setContWriter(memberName);
		empCont.setContDate(current);
		
		System.out.println(empCont);
		
		/* 근로 계약서 내역 테이블에 등록(파일 등록X) */
		boolean fileList = contractService.registNewContract(empCont);
		
		/* 2. 방금 등록한 내역 테이블의 근로계약서 번호 가져오기 */
		
		List<EmpContAndEmpDTO> contNumber = contractService.findAllContracts();
		int contractNum = contNumber.get(0).getContNo(); // 방금 등록한 근로계약서 테이블의 기본키
		
		System.out.println(contractNum);
		
		/* 3. 근로계약서 파일 업로드 */
		String root = System.getProperty("user.dir");
		System.out.println("root까지의 경로 : " + root);
		
		String filePath = root + "/src/main/resources/static/contract";
		
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
			
			if(fileList) {
				ContFileDTO contFile = new ContFileDTO();
				contFile.setCfileOrigName(originFileName);
				contFile.setCfilePath(filePath);
				contFile.setCfileSavedName(saveName);
				contFile.setContNo(contractNum);
				
				contractService.registNewFile(contFile);
				
				rttr.addFlashAttribute("successMessage", "성공");
				mv.setViewName("redirect:/cont/findCont");
			}else {
				rttr.addFlashAttribute("failMessage", "실패");
				mv.setViewName("redirect:/cont/findCont");
			}
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			new File(filePath + "/" + saveName).delete();
			rttr.addFlashAttribute("failMessage", "실패");
			mv.setViewName("redirect:/cont/findCont");
			
		}
		return mv;
	}
	
	/* 근로계약서 삭제 (내역 삭제이므로 파일에는 지장X)*/
	@GetMapping("deleteCont")
	public ModelAndView deleteContract(ModelAndView mv, RedirectAttributes rttr, String no, HttpServletRequest request) {
		
		System.out.println(no);
		int code = Integer.parseInt(request.getParameter("no"));
		System.out.println(code);
		
		/* 근로계약서 파일 조회 */
		
		ContFileDTO contFile = contractService.findContFileNo(code);
		int fileCode = contFile.getCfileNo();
		
		/* 근로계약서 파일 삭제 */
		boolean file = contractService.deleteContFile(fileCode);
		
		/* 내역 테이블 삭제 */ 
		boolean fileTable = contractService.deleteCont(code);
		
		if(file == true && fileTable == true) {
			rttr.addFlashAttribute("successMessage", "삭제 성공");
			mv.setViewName("redirect:/cont/findCont");
		}else {
			rttr.addFlashAttribute("failMessage", "실패");
			mv.setViewName("redirect:/cont/findCont");
		}
		
		return mv;
	}
	/* 근로계약서 다운로드 */
	@GetMapping("/attach/{id}")
	public ResponseEntity<Resource> downloadAttach(@PathVariable int id) throws IOException{
		
		ContFileDTO file = contractService.findPkFileCont(id);
		
		System.out.println("여기"+file.getCfilePath() + file.getCfileSavedName());
		
		UrlResource resource = new UrlResource("file:" + file.getCfilePath() + "/" + file.getCfileSavedName());
		
		String encodedFileName = UriUtils.encode(file.getCfileOrigName(), StandardCharsets.UTF_8);
		
		String contentDisposition = "attachment; filename=\"" + encodedFileName + "\"";
		
		
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,contentDisposition).body(resource);
	}
	
	
	
	

}
