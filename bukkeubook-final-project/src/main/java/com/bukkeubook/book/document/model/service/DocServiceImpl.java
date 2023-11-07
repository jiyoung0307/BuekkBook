package com.bukkeubook.book.document.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.internal.build.AllowSysOut;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
import com.bukkeubook.book.document.model.entity.AppRoot;
import com.bukkeubook.book.document.model.entity.Approver;
import com.bukkeubook.book.document.model.entity.Dept;
import com.bukkeubook.book.document.model.entity.DocAppVacation;
import com.bukkeubook.book.document.model.entity.DocCancelVacation;
import com.bukkeubook.book.document.model.entity.DocDayOff;
import com.bukkeubook.book.document.model.entity.DocSign;
import com.bukkeubook.book.document.model.entity.Document;
import com.bukkeubook.book.document.model.entity.DocumentAndEmpAndFormCate;
import com.bukkeubook.book.document.model.entity.Emp;
import com.bukkeubook.book.document.model.entity.FormCate;
import com.bukkeubook.book.document.model.entity.SubmitApprover;
import com.bukkeubook.book.document.model.entity.SubmitDocument;
import com.bukkeubook.book.document.model.repository.AppRootRepository;
import com.bukkeubook.book.document.model.repository.AppVacationRepository;
import com.bukkeubook.book.document.model.repository.ApproverRepository;
import com.bukkeubook.book.document.model.repository.ApproverRepository2;
import com.bukkeubook.book.document.model.repository.CancelVacationRepository;
import com.bukkeubook.book.document.model.repository.DocDayOffRepository;
import com.bukkeubook.book.document.model.repository.DocDeptRepository;
import com.bukkeubook.book.document.model.repository.DocEmpFormCateRepository;
import com.bukkeubook.book.document.model.repository.DocEmpRepository;
import com.bukkeubook.book.document.model.repository.DocSignRepository;
import com.bukkeubook.book.document.model.repository.DocumentRepository;
import com.bukkeubook.book.document.model.repository.FormCateRepository;
import com.bukkeubook.book.document.model.repository.SubmitDocumentRepository;

@Service("docService")
public class DocServiceImpl implements DocService{
	
	private final DocDeptRepository docDeptRepository;
	private final DocEmpRepository docEmpRepository;
	private final FormCateRepository formRepository;
	private final DocumentRepository docRepository;
	private final SubmitDocumentRepository subDocRepository;
	private final DocEmpFormCateRepository docEmpFormCateRepository;
	private final AppRootRepository appRootRepository;
	private final ApproverRepository approverRepository;
	private final ApproverRepository2 approverRepository2;
	private final AppVacationRepository vacationRepository;
	private final CancelVacationRepository cancelVacaRepository;
	private final DocSignRepository signRepository;
	private final DocDayOffRepository dayoffRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public DocServiceImpl(DocDeptRepository docDeptRepository,
						  DocEmpRepository docEmpRepository,
						  ModelMapper modelMapper,
						  FormCateRepository formRepository,
						  DocumentRepository docRepository,
						  DocEmpFormCateRepository docEmpFormCateRepository,
						  AppRootRepository appRootRepository,
						  ApproverRepository approverRepository,
						  ApproverRepository2 approverRepository2,
						  SubmitDocumentRepository subDocRepository,
						  AppVacationRepository vacationRepository,
						  CancelVacationRepository cancelVacaRepository,
						  DocSignRepository signRepository,
						  DocDayOffRepository dayoffRepository) {
		this.docDeptRepository = docDeptRepository;
		this.modelMapper = modelMapper;
		this.formRepository = formRepository;
		this.docEmpRepository = docEmpRepository;
		this.docRepository = docRepository;
		this.docEmpFormCateRepository = docEmpFormCateRepository;
		this.appRootRepository = appRootRepository;
		this.approverRepository = approverRepository;
		this.approverRepository2 = approverRepository2;
		this.subDocRepository = subDocRepository;
		this.vacationRepository = vacationRepository;
		this.cancelVacaRepository = cancelVacaRepository;
		this.signRepository = signRepository;
		this.dayoffRepository = dayoffRepository;
	}

	/* 전자결재 작성 첫화면 - 양식 고르기 */
	@Override
	public List<FormCateDTO> findDocFormList() {

		List<FormCate> formList = formRepository.findAll(Sort.by("formNo"));
		
		return formList.stream().map(form -> modelMapper.map(form, FormCateDTO.class)).toList();
	}

	/* 결재라인 지정 ajax select Tag Option Dept */
	@Override
	public List<DeptDTO> findDept() {

		List<Dept> deptList = docDeptRepository.findAll(Sort.by("deptCode"));
		
//		System.out.println("ssssssssssssssssssssssssssssssss" + deptList);
		
		return deptList.stream().map(dept -> modelMapper.map(dept, DeptDTO.class)).toList();
	}

	/* 결재라인 지정 ajax select Tag Option Emp */
	@Override
	public List<EmpDTO> findEmp(int dept) {

		String empEndYn = "N";
		List<Emp> empList = docEmpRepository.findByDeptCodeAndEmpEndYn(dept,empEndYn,Sort.by("empNo").descending());
		
		return empList.stream().map(emp -> modelMapper.map(emp, EmpDTO.class)).toList();
//		return empList.stream().map(emp -> modelMapper.map(emp, EmpDTO.class)).toList();
	}

	/* 임시저장 */
	@Override
	@Transactional
	public boolean insertNewtempDocument(TempStoreDocumentDTO newDoc) {
		
		try {
			docRepository.save(modelMapper.map(newDoc, Document.class));
        } catch (IllegalArgumentException exception) {
            return false;
        }

        return true;
	}

	/* 임시저장 리스트 조회 */
	@Override
	public List<DocumentAndEmpAndFormCateDTO> findTempDocList(int tempEmpNo, String docStatus) {

		List<DocumentAndEmpAndFormCate> tempDocList = docEmpFormCateRepository.findByEmpNoAndDocStatus(tempEmpNo,docStatus,Sort.by("docNo").descending());
		
//		System.out.println("임시저장 리스트 조회 --------------------여기는 서비스에서 엔티티 조회했을때양" + tempDocList);
		
		return tempDocList.stream().map(tempDoc -> modelMapper.map(tempDoc, DocumentAndEmpAndFormCateDTO.class)).toList();
	}

	/* 임시저장 수정 페이지 접속*/
	@Override
	public DocumentAndEmpAndFormCateDTO findOneTempDoc(int selectedDocNo, int tempEmpNo, String docStatus) {

		DocumentAndEmpAndFormCate oneTempDoc = docEmpFormCateRepository.findDocEmpRepositoryByDocNoAndEmpNoAndDocStatus(selectedDocNo,tempEmpNo,docStatus);
		
		System.out.println("임시저장 한개만 조회 --------------------여기는 서비스에서 엔티티 조회했을때양"+oneTempDoc);
		
		return modelMapper.map(oneTempDoc, DocumentAndEmpAndFormCateDTO.class);
	}

	/* 임시저장 수정하기 */
	@Override
	@Transactional
	public boolean updateTempDocument(TempStoreDocumentDTO updateDoc) {
		
		Document foundDoc = docRepository.findById(updateDoc.getDocNo1()).get();
		
		System.out.println("서비스에서 찾은 수정할 아이  " + foundDoc);
		
		try {
			
			foundDoc.setCnt1(updateDoc.getCnt1());
			foundDoc.setTagCnt1(updateDoc.getTagCnt1());
			foundDoc.setDocTitle1(updateDoc.getDocTitle1());
			foundDoc.setWrDate1(updateDoc.getWrDate1());
			
        } catch (IllegalArgumentException exception) {
            return false;
        }

        return true;
		
	}

	/* 임시저장 삭제하기 */
	@Override
	@Transactional
	public boolean deleteTempDoc(int docNo) {

		
		try {
			
			docRepository.deleteById(docNo);
			
        } catch (IllegalArgumentException exception) {
            return false;
        }

        return true;
		
	}

	/* 새로작성한 기안서, 지결서 상신하기 - 결재자 1명일 때 */
	@Override
	@Transactional
	public boolean insertNewDocOneAcc(SubmitDocumentDTO newDoc,AppRootDTO appRoot,ApproverDTO approver) {
		
		
		try {
			
			subDocRepository.save(modelMapper.map(newDoc, SubmitDocument.class));
			
			int currentDocNo = docRepository.findCurrentSeqDoc();
			System.out.println("Service            ");
			System.out.println(currentDocNo);
			appRoot.setDocNo(currentDocNo);
			appRootRepository.save(modelMapper.map(appRoot, AppRoot.class));
			
			int currentAccRootNo = appRootRepository.findCurrentSeqAccRoot();
			System.out.println("Service            ");
			System.out.println(currentAccRootNo);
			
			approver.setAppRootNo(currentAccRootNo);
			approverRepository2.save(modelMapper.map(approver, Approver.class));
			
			
        } catch (IllegalArgumentException exception) {
            return false;
        }

        return true;
	}

	/* 새로작성한 기안서, 지결서 상신하기 - 결재자 2, 3명일 때 */
	@Override
	@Transactional
	public boolean insertNewDocThreeAcc(SubmitDocumentDTO newDoc, AppRootDTO appRoot, List<SubmitApprover> approverList) {

		
		try {
			
			subDocRepository.save(modelMapper.map(newDoc, SubmitDocument.class));
			
			int currentDocNo = docRepository.findCurrentSeqDoc();
			System.out.println("Service            ");
			System.out.println(currentDocNo);
			appRoot.setDocNo(currentDocNo);
			appRootRepository.save(modelMapper.map(appRoot, AppRoot.class));
			
			int currentAccRootNo = appRootRepository.findCurrentSeqAccRoot();
			System.out.println("Service            ");
			System.out.println(currentAccRootNo);
			
			for(int i = 0; i < approverList.size(); i++) {
				SubmitApprover app = approverList.get(i);
				app.setAppRootNo2(currentAccRootNo);
			}
			
			approverRepository.saveAll(approverList);
			
			
        } catch (IllegalArgumentException exception) {
            return false;
        }

        return true;
		
	}

	/* 임시저장된 기안서, 지결서 상신하기 - 결재자 1명일 때 */
	@Override
	@Transactional
	public boolean submitTempDocOneAcc(SubmitDocumentDTO tempDoc, AppRootDTO appRoot, ApproverDTO approver) {

		
		try {
			
			SubmitDocument foundDoc = subDocRepository.findById(tempDoc.getDocNo2()).get();
			foundDoc.setCnt2(tempDoc.getCnt2());
			foundDoc.setDocTitle2(tempDoc.getDocTitle2());
			foundDoc.setTagCnt2(tempDoc.getTagCnt2());
			foundDoc.setWrDate2(tempDoc.getWrDate2());
			foundDoc.setDocStatus2(tempDoc.getDocStatus2());
			System.out.println("Service           Document Update Success");
			
			appRoot.setDocNo(tempDoc.getDocNo2());
			appRootRepository.save(modelMapper.map(appRoot, AppRoot.class));
			
			int currentAccRootNo = appRootRepository.findCurrentSeqAccRoot();
			approver.setAppRootNo(currentAccRootNo);
			approverRepository2.save(modelMapper.map(approver, Approver.class));
			
			
        } catch (IllegalArgumentException exception) {
            return false;
        }

        return true;
		
	}

	/* 임시저장된 기안서, 지결서 상신하기 - 결재자 2명,3명 일 때 */
	@Override
	@Transactional
	public boolean submitTempDocTwoAcc(SubmitDocumentDTO tempDoc, AppRootDTO appRoot, List<SubmitApprover> approverList) {

		
		try {
			
			SubmitDocument foundDoc = subDocRepository.findById(tempDoc.getDocNo2()).get();
			foundDoc.setCnt2(tempDoc.getCnt2());
			foundDoc.setDocTitle2(tempDoc.getDocTitle2());
			foundDoc.setTagCnt2(tempDoc.getTagCnt2());
			foundDoc.setWrDate2(tempDoc.getWrDate2());
			foundDoc.setDocStatus2(tempDoc.getDocStatus2());
			System.out.println("Service           Document Update Success");
			
			appRoot.setDocNo(tempDoc.getDocNo2());
			appRootRepository.save(modelMapper.map(appRoot, AppRoot.class));
			
			int currentAccRootNo = appRootRepository.findCurrentSeqAccRoot();
			for(int i=0; i<approverList.size();i++) {
				SubmitApprover app =  approverList.get(i);
				app.setAppRootNo2(currentAccRootNo);
			}
			approverRepository.saveAll(approverList);
			
			
        } catch (IllegalArgumentException exception) {
            return false;
        }

        return true;
		
		
	}

	/* 수신함 리스트 조회 */
	@Override
	public List<InboxListDTO> findInboxAllList(int empNo) {

		List<InboxListDTO> all = new ArrayList<>();
		
		/* 사원과 맞는 결재자테이블에서 결재자 리스트 */
		List<Object[]> correctToApproverList = approverRepository2.findByApproverNoDocList(empNo);
		
		/* 결재 경로 번호들 담을 리스트 */
		List<Integer> appRootNoList = new ArrayList<>();
		
		/* 결재자가 전결한 상태 (결재상태)들 담을 리스트 */
		List<String> appStatusList = new ArrayList<>();
		
		for(Object[] appro : correctToApproverList) {
			appRootNoList.add((int)appro[0]);
			appStatusList.add((String)appro[1]);
		}
//		System.out.println(appRootNoList);
//		System.out.println(appStatusList);
		
		for(int i = 0; i < appStatusList.size(); i++) {
			InboxListDTO inbox = new InboxListDTO();
			inbox.setAppStatus(appStatusList.get(i));
			all.add(inbox);
		}
		
		/* 가져온 결재경로번호에 맞는 결재경로 리스트 */
		AppRoot root = new AppRoot();
		List<AppRoot> correctAppRootList = new ArrayList<>();
		for(int i = 0; i<appRootNoList.size(); i++) {
			root = appRootRepository.findById(appRootNoList.get(i)).get();
			correctAppRootList.add(root);
		}
//		System.out.println(correctAppRootList);
		
		/* 가져온 문서번호에 맞는 문서 가져오기 */
		Document doc = new Document();
		List<Integer> docNoList = new ArrayList<>();
		List<Integer> stepNoList = new ArrayList<>();
		List<String> stepNameList = new ArrayList<>();
		List<Document> docList = new ArrayList<>();
		for(int i = 0; i<correctAppRootList.size(); i++) {
			int docNo = correctAppRootList.get(i).getDocNo();
			docNoList.add(docNo);
			int stepNo = correctAppRootList.get(i).getStepNo();
			stepNoList.add(stepNo);
//			doc = docRepository.findById(docList.get(i).getDocNo1()).get();
		}
		
		for(int i = 0; i<stepNoList.size(); i++) {
			String name = stepNoList.get(i) + "단계" ;
			stepNameList.add(name);
		}
		
		for(int i = 0; i<stepNameList.size();i++) {
			InboxListDTO inbox = all.get(i);
			inbox.setStepName(stepNameList.get(i));
		}
//		System.out.println(stepNameList);
		
//		System.out.println(docNoList);
		for(int i = 0; i<docNoList.size(); i++) {
			int docNo = docNoList.get(i);
			doc = docRepository.findById(docNo).get();
			docList.add(doc);
		}
		/* 엔티티 타입을 DTO로 바꾸어 리턴한다. */
		List<TempStoreDocumentDTO> returnDocList = docList.stream().map(document -> modelMapper.map(document, TempStoreDocumentDTO.class)).toList();
//		System.out.println(returnDocList);
		
		for(int i = 0; i<returnDocList.size();i++) {
			InboxListDTO inbox = all.get(i);
			inbox.setDocument(returnDocList.get(i));
			if(1 == returnDocList.get(i).getFormNo1()) {
				inbox.setFormName("기안서");
			}else {
				inbox.setFormName("지출결의서");
			}
		}
		
		return all;
	}

	/* 상신함 전체리스트 조회 */
	@Override
	public List<DocumentAndEmpAndFormCateDTO> findByDocNoList(int empNo , String docStatus) {

		List<DocumentAndEmpAndFormCate> docList = docEmpFormCateRepository.findByEmpNoAndDocStatusNot(empNo,docStatus,Sort.by("docNo").descending());
		
		return docList.stream().map(doc -> modelMapper.map(doc, DocumentAndEmpAndFormCateDTO.class)).toList();
	}


	/* 수신함 상세 조회 */
	@Override
	public TempStoreDocumentDTO findByDocNo(int docNo) {

		Document doc = docRepository.findById(docNo).get();
		
		return modelMapper.map(doc, TempStoreDocumentDTO.class);
	}

	/* 전자결재 작성시 작성자 이름, 부서명, 문서번호 넣어주기 */
	@Override
	public DocWriteInfoDTO findWriterInfo(int empNo) {
		
		DocWriteInfoDTO info = new DocWriteInfoDTO();
		
		Emp emp = docEmpRepository.findById(empNo).get();
		EmpDTO e = modelMapper.map(emp, EmpDTO.class);
		info.setEmpName(e.getEmpName());
		info.setEmpJobCode(e.getEmpJobCode());
		
		int deptCode = e.getDeptCode();
		Dept dept = docDeptRepository.findById(deptCode).get();
		DeptDTO d = modelMapper.map(dept, DeptDTO.class);
		info.setDeptName(d.getDeptName());
		
		int currentDocNo = 0;
		currentDocNo = docRepository.findCurrentSeqDoc() + 1;
		
		info.setDocNo(currentDocNo);
		
		System.out.println(info);
		
		return info;
	}

	/* 휴가신청서 상신하기 */
	@Override
	@Transactional
	public boolean insertNewVacationApp(AppVacationDTO vacation) {

		
		try {

	//		int vacNo = vacationRepository.findCurrentSeq() + 10;
	//		vacation.setVacNo(vacNo);
				System.out.println("Service       " +vacation);
				
				vacationRepository.save(modelMapper.map(vacation, DocAppVacation.class));
			
		
		} catch (IllegalArgumentException exception) {
            return false;
        }

        return true;
		
	}

	/* 취소 신청서 작성시 자신이 작성한 휴가 신청서 리스트 조회 */
	@Override
	public List<AppVacationDTO> findByEmpNoVacationList(int empNo) {
		
		List<DocAppVacation> vacationByOneList = vacationRepository.findByEmpNo(empNo,Sort.by("vacAppNo").descending());
		
		return vacationByOneList.stream().map(vac -> modelMapper.map(vac, AppVacationDTO.class)).toList();
	}

	/* 휴가 취소신청서 상신 */
	@Override
	@Transactional
	public boolean insertNewCancelVacation(CancelVacationDTO cancVaca) {
		
		try {

			cancelVacaRepository.save(modelMapper.map(cancVaca, DocCancelVacation.class));
			
				} catch (IllegalArgumentException exception) {
		            return false;
		        }

		 return true;
	}

	/* 휴가서류 문서번호 조회 */
	@Override
	public List<Integer> vacationInfo(int empNo) {
		
		int vacNo = vacationRepository.findCurrentSeq() + 1;
		int cancVacNo = cancelVacaRepository.findCurrentSeq() +1;
		DocDayOff dayoff = dayoffRepository.findByEmpNo(empNo);
		int dayAmount = dayoff.getDoffAmount();
		int dayRemain = dayoff.getDoffRemain();
		List<Integer> vacationInfo = new ArrayList<>();
		
		vacationInfo.add(vacNo);
		vacationInfo.add(cancVacNo);
		vacationInfo.add(dayAmount);
		vacationInfo.add(dayRemain);
		
		return vacationInfo;
	}

	/* 휴가 리스트 조회 */
	@Override
	public List<AppVacationDTO> allVacationList(int empNo) {
		
		List<DocAppVacation> allVacationList = vacationRepository.findByEmpNo(empNo,Sort.by("vacAppNo").descending());
		
		return allVacationList.stream().map(vaca -> modelMapper.map(vaca, AppVacationDTO.class)).toList();
	}

	/* 휴가취소 리스트 조회 */
	@Override
	public List<CancelVacationDTO> allCancelVacationList(int empNo) {

		List<DocCancelVacation> cancelList = cancelVacaRepository.findByEmpNo(empNo,Sort.by("vacCancDate").descending());
		
		return cancelList.stream().map(can -> modelMapper.map(can, CancelVacationDTO.class)).toList();
	}

	/* 휴가 신청 상세 조회 */
	@Override
	public AppVacationDTO findByVacNo(int vacNo) {

		DocAppVacation vaca = vacationRepository.findById(vacNo).get();
		
		return modelMapper.map(vaca, AppVacationDTO.class);
	}

	/* 휴가취소 상세조회 */
	@Override
	public CancelVacationDTO findByvacCancNo(int vacCancNo) {

		DocCancelVacation canc = cancelVacaRepository.findById(vacCancNo).get();
		
		return modelMapper.map(canc, CancelVacationDTO.class);
	}

	/* 결재 승인 */
	@Override
	@Transactional
	public boolean updateDocStatusApprove(int empNo, TempStoreDocumentDTO doc, String statusApp) {
		
		try {
				
			/* 결재자의 결재상태 업데이트 */
			/* 해당문서 정보 조회 */
			Document document = docRepository.findById(doc.getDocNo1()).get();
			document.setTagCnt1(doc.getTagCnt1());
			
			/* 결재자가 몇단계인지 확인, 결재자 정확한 튜플 가져오기 위한 결재경로 번호 가져오기 */
			AppRoot appRoot =  appRootRepository.findByDocNo(doc.getDocNo1());
			
			AppRootDTO realAppRoot = modelMapper.map(appRoot, AppRootDTO.class);
			
			int stepNo = realAppRoot.getStepNo();
			int appRootNo = realAppRoot.getAppRootNo();
			
			if(stepNo ==1) {	// 1단계일 경우 - 1단계는 그 단계로 종료
				/* 결재자 상태 수정 */
	//			System.out.println("여기여기");
	//			System.out.println("여기여기");
	//			System.out.println("여기여기");
	//			System.out.println("여기여기");
	//			System.out.println("여기여기");
	//			System.out.println("여기여기");
	//			System.out.println("여기여기");
	//			System.out.println("1단계1단계1단계1단계1단계1단계");
				
				Approver approver = approverRepository2.findByEmpNoAndAppRootNo(empNo,appRootNo);
				approver.setAppStatus(statusApp);
				
				/* 문서상태 수정 */
				document.setDocStatus1(statusApp);
			} else if(stepNo == 2 || stepNo ==3) {		// 2단계일 경우  현재 로그인한 사람이 몇번째인지 알아야 함 
				
	//			System.out.println("여기여기");
	//			System.out.println("여기여기");
	//			System.out.println("여기여기");
	//			System.out.println("여기여기");
	//			System.out.println("여기여기");
	//			System.out.println("여기여기");
	//			System.out.println("여기여기");
				
				/* 결재자 상태 수정 */
				Approver approver = approverRepository2.findByEmpNoAndAppRootNo(empNo,appRootNo);
				approver.setAppStatus(statusApp);
				int mine = approver.getAppNo();
				
				/* 로그인한 사람을 제외한 해당 문서를 결재하는 결재자 조회 */
				List<Approver> approverList = approverRepository2.findByAppRootNoAndAppNoNot(appRootNo,mine);
				System.out.println("여기여기" + approverList);
				
				List<Integer> appNos = new ArrayList<>();
				for(int i=0; i<approverList.size(); i++) {
					int no = approverList.get(i).getAppNo();
					appNos.add(no);
				}
				
				int step = 0;					// 단계 확인
				int appNo1 = 0;					// 해당 문서의 다른 결재자의 결재자 번호1
				int appNo2 = 0;					// 해당 문서의 다른 결재자의 결재자 번호2
				
				if(appNos.size() == 0) {		// 로그인한 사람이 1단계, 다른 결재자 없음
					
	//				System.out.println("여기여기");
	//				System.out.println("여기여기");
	//				System.out.println("여기여기");
	//				System.out.println("여기여기");
	//				System.out.println("여기여기");
	//				System.out.println("여기여기");
	//				System.out.println("여기여기");
	//				System.out.println("여기여기");
	//				System.out.println("로그인한 사람이 1단계");
	//				System.out.println("로그인한 사람이 1단계     " + mine);
	//				System.out.println("로그인한 사람이 1단계     " + step);
	//				System.out.println("로그인한 사람이 1단계     " +appNos);
					
				} else if(appNos.size() == 1) {	// 다른 결재자가 1명있을 때
	//				System.out.println("여기여기");
	//				System.out.println("여기여기");
	//				System.out.println("여기여기");
	//				System.out.println("여기여기");
	//				System.out.println("여기여기");
	//				System.out.println("여기여기");
	//				System.out.println("여기여기");
	//				System.out.println("여기여기여기여기" + appNos);
	//				System.out.println(appNos);
					appNo1 = appNos.get(0);
					if(appNo1 > mine) {
	//					System.out.println("로그인한 사람이 1단계");
						step = 1;
					} else { 
	//					System.out.println("로그인한 사람이 2단계");
						step = 2;
					}
				} else {							// 다른 결재자가 2명있을 때
	//				System.out.println("여기여기");
	//				System.out.println("여기여기");
	//				System.out.println("여기여기");
	//				System.out.println("여기여기");
	//				System.out.println("여기여기");
	//				System.out.println("여기여기");
	//				System.out.println("여기여기");
	//				System.out.println("여기여기여기여기" + appNos);
	//				System.out.println(appNos);
					appNo1 = appNos.get(0);
		  			appNo2 = appNos.get(1);
					if( mine < appNo1 && mine < appNo2 ) {
	//					System.out.println("로그인한 사람이 1단계");
						step = 1;
					} else if (( mine > appNo1 && mine < appNo2 ) || ( mine < appNo1 && mine > appNo2 )) {
	//					System.out.println("로그인한 사람이 2단계");
						step = 2;
					} else if ( mine > appNo1 && mine > appNo2 ) {
	//					System.out.println("로그인한 사람이 3단계");
						step = 3;
					}
				}
				if(step == 1) {
					document.setDocStatus1("진행중");
				} else if(step == 2) {
					if(stepNo == 2) {
						document.setDocStatus1(statusApp);
					} else {
						/* 문서상태 수정 */
	//					System.out.println("진행중진행중진행중진행중진행중진행중");
						document.setDocStatus1("진행중");
					}
				} else if (step == 3) {
					document.setDocStatus1(statusApp);
				}
				
			} 
		
		} catch (IllegalArgumentException exception) {
            return false;
        }

		return true;

		
	}

	/* 결재 버튼 활성화 체크 */
	@Override
	public List<String> checkDoc(int docNo, int empNo) {

		/* 컨트롤러에 넘길 리스트 */
		List<String> list = new ArrayList<>();
		
		/* 현재 문서 상태 확인 */
		Document document = docRepository.findById(docNo).get();
		TempStoreDocumentDTO doc = modelMapper.map(document, TempStoreDocumentDTO.class);
		String docStatus = doc.getDocStatus1();
		String place = "";
		if("반려".equals(docStatus) || "승인".equals(docStatus)) {
			
			/* 이미 끝난 결재건은 바로 비활성화 처리 할 수 있게 이것만 내보낸다. */
			list.add(docStatus);
		} else {
			
			/* 아닌 경우 단계를 알아내야함 */
			/* 우선 경로 번호를 뽑아내자 */
			AppRoot appRoot =  appRootRepository.findByDocNo(doc.getDocNo1());
			int appRootNo = appRoot.getAppRootNo();
			
			/* 알아낸 경로번호와 현재 로그인한 사람의 정보로 결재자 번호 확인 */
			Approver approver = approverRepository2.findByEmpNoAndAppRootNo(empNo,appRootNo);
			int mine = approver.getAppNo();
			String mineStatus = approver.getAppStatus();
			
			System.out.println("여기여기");
			System.out.println("여기여기");
			System.out.println("여기여기");
			System.out.println("여기여기");
			System.out.println("여기여기");
			System.out.println("여기여기");
			System.out.println("여기여기");
			System.out.println(mineStatus);
			
			
			/* 로그인한 사람을 제외한 해당 문서를 결재하는 결재자 조회 */
			List<Approver> approverList = approverRepository2.findByAppRootNoAndAppNoNot(appRootNo,mine);
			System.out.println(approverList);
			
			List<Integer> appNos = new ArrayList<>();
			for(int i=0; i<approverList.size(); i++) {
				int no = approverList.get(i).getAppNo();
				appNos.add(no);
			}
			
			String preStatus = "";			// 바로 전 결재자 결재여부
			String step = "";				// 단계 확인
			int appNo1 = 0;					// 해당 문서의 다른 결재자의 결재자 번호1
			int appNo2 = 0;					// 해당 문서의 다른 결재자의 결재자 번호2
			
			if(appNos.size() == 0) {		// 로그인한 사람이 1단계, 다른 결재자 없음
				step = "0";
				place = "1";
				System.out.println(mine);
			} else if(appNos.size() == 1) {	// 다른 결재자가 1명있을 때
				System.out.println(appNos);
				appNo1 = appNos.get(0);
				if(appNo1 > mine) {
					step = "1";
					place = "1";
				} else { 
					step = "2";
					place = "2";
				}
			}else {							// 다른 결재자가 2명있을 때
				System.out.println(appNos);
				appNo1 = appNos.get(0);
	  			appNo2 = appNos.get(1);
				if( mine < appNo1 && mine < appNo2 ) {
					step = "1";
					place = "1";
				} else if (( mine > appNo1 && mine < appNo2 ) || ( mine < appNo1 && mine > appNo2 )) {
					step = "2";
					place = "2";
				} else if ( mine > appNo1 && mine > appNo2 ) {
					step = "3";
					place = "3";
				}
			}
			list.add(step);
			list.add(place);
			/* 로그인 한 사람이 결재 단계가 2, 3 일 경우 전단계 사람이 결재했는지도 확인해준다. */
			List<String> statusApps = new ArrayList<>();
			String isChecked = "대기";
			if("1".equals(step)) {
				
				if(("대기").equals(mineStatus)) {
					list.add("가능");
				} else {
					list.add("불가능");
				}
				
			} else if("2".equals(step)) {
				Approver approver2 = approverRepository2.findById(appNo1).get();
				preStatus = approver2.getAppStatus();
				
				if((isChecked.equals(approver2.getAppStatus()))) {
					list.add("불가능");
				} else if (("대기").equals(mineStatus)){
					list.add("가능");
				} else {
					list.add("불가능");
				}
				
			} else if("3".equals(step)) {
				for (int i =0; i<approverList.size(); i++) {
					String s = approverList.get(i).getAppStatus();
					statusApps.add(s);
				}
				
				if((isChecked.equals(statusApps.get(0))) && (isChecked.equals(statusApps.get(1)))) {
					list.add("불가능");
				} else if (("대기").equals(mineStatus)){
					list.add("가능");
				} else {
					list.add("불가능");
				}
			}
			
		}		
		
		
		
		return list;
	}

	/* 결재 반려 */
	@Override
	@Transactional
	public boolean updateDocStatusRefuse(int empNo, TempStoreDocumentDTO doc, String statusApp) {

		try {

		
			/* 결재자의 결재상태 업데이트 */
			/* 해당문서 정보 조회 */
			Document document = docRepository.findById(doc.getDocNo1()).get();
			document.setTagCnt1(doc.getTagCnt1());
			
			/* 결재자가 몇단계인지 확인, 결재자 정확한 튜플 가져오기 위한 결재경로 번호 가져오기 */
			AppRoot appRoot =  appRootRepository.findByDocNo(doc.getDocNo1());
			
			AppRootDTO realAppRoot = modelMapper.map(appRoot, AppRootDTO.class);
			
			int stepNo = realAppRoot.getStepNo();
			int appRootNo = realAppRoot.getAppRootNo();
			
			if(stepNo ==1) {	// 1단계일 경우 - 1단계는 그 단계로 종료
				/* 결재자 상태 수정 */
				Approver approver = approverRepository2.findByEmpNoAndAppRootNo(empNo,appRootNo);
				approver.setAppStatus(statusApp);
				
				/* 문서상태 수정 */
				document.setDocStatus1(statusApp);
			} else if(stepNo == 2 || stepNo ==3) {		// 2,3단계일 경우  현재 로그인한 사람이 몇번째인지 알아야 함 
				
				/* 결재자 상태 수정 */
				Approver approver = approverRepository2.findByEmpNoAndAppRootNo(empNo,appRootNo);
				approver.setAppStatus(statusApp);
				int mine = approver.getAppNo();
				
				/* 로그인한 사람을 제외한 해당 문서를 결재하는 결재자 조회 */
				List<Approver> approverList = approverRepository2.findByAppRootNoAndAppNoNot(appRootNo,mine);
				System.out.println("여기여기" + approverList);
				
				List<Integer> appNos = new ArrayList<>();
				for(int i=0; i<approverList.size(); i++) {
					int no = approverList.get(i).getAppNo();
					appNos.add(no);
				}
				
				int step = 0;					// 단계 확인
				int appNo1 = 0;					// 해당 문서의 다른 결재자의 결재자 번호1
				int appNo2 = 0;					// 해당 문서의 다른 결재자의 결재자 번호2
				
				if(appNos.size() == 1) {	// 다른 결재자가 1명있을 때
	//				System.out.println("여기여기여기여기" + appNos);
	//				System.out.println(appNos);
					appNo1 = appNos.get(0);
					if(appNo1 > mine) {
	//					System.out.println("로그인한 사람이 1단계");
						step = 1;
					} else { 
	//					System.out.println("로그인한 사람이 2단계");
						step = 2;
					}
				} else {							// 다른 결재자가 2명있을 때
	//				System.out.println("여기여기여기여기" + appNos);
	//				System.out.println(appNos);
					appNo1 = appNos.get(0);
		  			appNo2 = appNos.get(1);
					if( mine < appNo1 && mine < appNo2 ) {
	//					System.out.println("로그인한 사람이 1단계");
						step = 1;
					} else if (( mine > appNo1 && mine < appNo2 ) || ( mine < appNo1 && mine > appNo2 )) {
	//					System.out.println("로그인한 사람이 2단계");
						step = 2;
					} else if ( mine > appNo1 && mine > appNo2 ) {
	//					System.out.println("로그인한 사람이 3단계");
						step = 3;
					}
				}
				if(step == 1) {
					document.setDocStatus1(statusApp);
					for(int i=0; i<approverList.size(); i++) {
						approverList.get(i).setAppStatus("타전결자 반려");
					}
					
				} else if(step == 2) {
					document.setDocStatus1(statusApp);
					for(int i=0; i<approverList.size(); i++) {
						approverList.get(i).setAppStatus("타전결자 반려");
					}
					
				} else if (step == 3) {
					document.setDocStatus1(statusApp);
				}
				
			} 
		} catch (IllegalArgumentException exception) {
            return false;
        }

		return true;
		
		
	}

	/* 결재시 서명 도장 이름 가져오기 */
	@Override
	public List<String> findSignName(int empNo) {

		List<String> list = new ArrayList<>();
		
		DocSign sign = signRepository.findById(empNo).get();
		
		String signName = sign.getSignSavedName();
		list.add(signName);
		
		return list;
	}

	
}
