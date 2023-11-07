package com.bukkeubook.book.manage.model.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bukkeubook.book.common.paging.SelectCriteria;
import com.bukkeubook.book.manage.model.dto.EmpDTO;
import com.bukkeubook.book.manage.model.dto.ProfPhotoDTO;
import com.bukkeubook.book.manage.model.dto.joinDTO.EmpAndDeptDTO;
import com.bukkeubook.book.manage.model.entity.Emp;
import com.bukkeubook.book.manage.model.entity.EmpAndDept;
import com.bukkeubook.book.manage.model.entity.MemberRole;
import com.bukkeubook.book.manage.model.entity.ProfPhoto;
import com.bukkeubook.book.manage.model.repository.EmpAndDeptRepository;
import com.bukkeubook.book.manage.model.repository.EmpRepository;
import com.bukkeubook.book.manage.model.repository.MemberRoleRepository;
import com.bukkeubook.book.manage.model.repository.OriginalEmpRepository;
import com.bukkeubook.book.manage.model.repository.ProfilePhotoRepository;
import com.bukkeubook.book.mypage.model.repository.EmployeeRepository;

@Service
public class EmpService {
	
	private final EmpRepository empRepository;
	private final OriginalEmpRepository originEmpRepository;
	private final ProfilePhotoRepository profilePhotoRepository;
	private final MemberRoleRepository roleRepository;
	private final EmpAndDeptRepository empAndDeptRepository;
	private final ModelMapper modelMapper;		//앤티티를 디티오로 변환 or 디티오를 엔티티로 변환
	@Autowired
	public EmpService(EmpAndDeptRepository empAndDeptRepository, EmpRepository empRepository, ModelMapper modelMapper
					 ,OriginalEmpRepository originEmpRepository, ProfilePhotoRepository profilePhotoRepository
					 ,MemberRoleRepository roleRepository) {
		this.empRepository = empRepository;
		this.modelMapper = modelMapper;
		this.originEmpRepository = originEmpRepository;
		this.profilePhotoRepository = profilePhotoRepository;
		this.roleRepository = roleRepository;
		this.empAndDeptRepository = empAndDeptRepository;
	}

	/* 사원조회 & 검색기능 & 페이징 */
	public int selectTotalCount(String searchCondition, String searchValue) {

		int count = 0;
		if(searchValue != null) {

			if("empName".equals(searchCondition)) {
				count = empRepository.countByEmpNameContaining(searchValue);
			}
			
			if("empJobCode".equals(searchCondition)) {
				count = empRepository.countByempJobCodeContaining(searchValue);
			}

		} else {
			count = (int)empRepository.count();
		}

		return count;
	}
	
	public List<EmpAndDeptDTO> searchEmpList(SelectCriteria selectCriteria) {

		int index = selectCriteria.getPageNo() - 1;
		int count = selectCriteria.getLimit();
		String searchValue = selectCriteria.getSearchValue();

		Pageable paging = PageRequest.of(index, count, Sort.by("empNo"));

		List<EmpAndDept> empList = new ArrayList<EmpAndDept>();
		if(searchValue != null) {

			if("empName".equals(selectCriteria.getSearchCondition())) {
				empList = empRepository.findByEmpNameContaining(selectCriteria.getSearchValue(), paging);
			}
			
			if("empJobCode".equals(selectCriteria.getSearchCondition())) {
				empList = empRepository.findByEmpJobCodeContaining(selectCriteria.getSearchValue(), paging);
			}
//	         if("Dept".equals(selectCriteria.getSearchCondition())) {
//	        	 empList = empRepository.findByemp_Dept_DeptNameContaining(selectCriteria.getSearchValue(), paging);
//	          }
		} else {
			empList = empRepository.findAll(paging).toList();
		}
		
		/* 자바의 Stream API와 ModelMapper를 이용하여 entity를 DTO로 변환 후 List<MenuDTO>로 반환 */
		return empList.stream().map(emp -> modelMapper.map(emp, EmpAndDeptDTO.class)).collect(Collectors.toList());
	}
		
	/* 퇴사 사원 조회 */
	public List<EmpAndDeptDTO> findLeaveEmpList(String empEndYn) {
		List<EmpAndDept> leaveEmpList = empRepository.findByEmpEndYn(empEndYn);   //List<Emp>  = 앤티티 담기
		return leaveEmpList.stream().map(emp -> modelMapper.map(emp, EmpAndDeptDTO.class)).toList(); 
	}
	
	/* 사원 상세조회 */
	public EmpAndDeptDTO searchEmpDetail(int empNo) {
		
		EmpAndDept emp = empRepository.findById(empNo).get();
		
		System.out.println("레포지토리      " + emp);
		
		return modelMapper.map(emp, EmpAndDeptDTO.class); //앤티티를 넣어달라고 요청 -> modelMapper
	}
	
	/* 퇴사사원 상세조회 */
	public EmpAndDeptDTO searchLeaveEmpDetail(int empNo) {
		
		EmpAndDept emp = empRepository.findById(empNo).get();
		
		System.out.println("레포지토리      " + emp);
		
		return modelMapper.map(emp, EmpAndDeptDTO.class); //앤티티를 넣어달라고 요청 -> modelMapper
	}

	/* 신규 사원 등록 */
	@Transactional
	public void insertNewEmp(EmpDTO emp) {
		
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		emp.setEmpPwd(bc.encode(emp.getEmpPwd()));
//		bc.encode(emp.getEmpPwd());
		System.out.println("Service                      sssssssssssss" + emp);
		
		originEmpRepository.save(modelMapper.map(emp, Emp.class));
		
		/* 신규사원 권한 등록 */
		int roleCode = emp.getDeptCode();
		int empNo = originEmpRepository.findCurrentSeqempNo();
		
		MemberRole role = new MemberRole();
		
		role.setEmpNo(empNo);
		role.setRoleCode(roleCode);
		
		roleRepository.save(modelMapper.map(role, MemberRole.class));
		
	}	
	
	/* 사원정보 수정 */
	public EmpAndDeptDTO findEmpByEmpNo(int empNo) {
		System.out.println("확인1111111111111");

		EmpAndDept emp = empAndDeptRepository.findById(empNo).get();
		System.out.println("확인222222222222222");

		
		System.out.println("레포지토리      " + emp);
		
		return modelMapper.map(emp, EmpAndDeptDTO.class); //앤티티를 넣어달라고 요청 -> modelMapper
	}
	public EmpDTO findEmpByEmpNo2(int empNo) {
		System.out.println("확인1111111111111");

		Emp emp = originEmpRepository.findById(empNo).get();
		System.out.println("확인222222222222222");

		
		System.out.println("레포지토리      " + emp);
		
		return modelMapper.map(emp, EmpDTO.class); //앤티티를 넣어달라고 요청 -> modelMapper
	}
	
	@Transactional
	public void modifyEmp(EmpDTO emp) {
		
		Emp findEmp = originEmpRepository.findById(emp.getEmpNo()).get();
		
		findEmp.setDeptCode(emp.getDeptCode());
		findEmp.setEmpAddress(emp.getEmpAddress());
		findEmp.setEmpDAddress(emp.getEmpDAddress());
		findEmp.setEmpEmail(emp.getEmpEmail());
		findEmp.setEmpTotalSal(emp.getEmpTotalSal());
		findEmp.setEmpPhone1(emp.getEmpPhone1());
		findEmp.setEmpPhone2(emp.getEmpPhone2());
		findEmp.setEmpPhone3(emp.getEmpPhone3());
		findEmp.setEmpJobCode(emp.getEmpJobCode());
		
	}
	
	/* 방금 가입한 사원 조회 */
	public List<EmpAndDeptDTO> selectLastEmp() {
		
		List<EmpAndDept> lastEmp = empRepository.findAll(Sort.by("empNo").descending());
		
		return lastEmp.stream().map(insertEmp -> modelMapper.map(insertEmp, EmpAndDeptDTO.class)).collect(Collectors.toList());
	}

	/* 회원 가입시 프로필 사진 저장*/
	@Transactional
	public void registEmpProFile(ProfPhotoDTO profile) {
		
		profilePhotoRepository.save(modelMapper.map(profile, ProfPhoto.class));
		
		
	}

	/* 사원 등록시 사원번호 조회 */
//	public List<Integer> findEmpNo(int i) {
//
//		List<Integer> emp = new ArrayList<>();
//		int empNo = originEmpRepository.findCurrentSeqEmpNo();
//		emp.add(empNo);
//		
//		return emp;
//	}

	/* 프로필 사진 수정(조회) */
	@Transactional
	public List<ProfPhotoDTO> findEmpProfile(int number) {
		
		List<ProfPhoto> empProfPhoto = profilePhotoRepository.findByEmpNo(number, Sort.by("photoNo").descending());
		
		return empProfPhoto.stream().map(profile2 -> modelMapper.map(profile2, ProfPhotoDTO.class)).collect(Collectors.toList());
	}
	
	/* 사원 수정 페이지에서 프로필 사진 수정하기 */
	@Transactional
	public void modifyProfile(ProfPhotoDTO profile) {
		
		profilePhotoRepository.save(modelMapper.map(profile, ProfPhoto.class));

	}
	
	/* 큰담 비밀번호 수정 */
	public EmpDTO findEmpByEmpNo2(int no, String password1, String password2, String password3) {
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		Emp emp = originEmpRepository.findById(no).get();
		emp.setEmpPwd(bc.encode(password2));
		originEmpRepository.save(emp);
		return modelMapper.map(emp, EmpDTO.class);
	}

	
//	/* 직원 퇴사처리 */
//	@Transactional
//	public void modifyEmpLeave(EmpDTO leaveEmp) {
//		
//		Emp foundEmp = originEmpRepository.findById(leaveEmp.getEmpNo()).get();
//		foundEmp.setEmpEndYn(leaveEmp.getEmpEndYn());
//	}
	
//	 @Transactional
//	public void modifyEmpEndY(int empNo) {
//		 Integer empNo1 = originEmpRepository.findByEmpEndYN(empNo1);
//		
//	}
//	 @Transactional 
//	public void modifyEmpEndDate(int empNo) {
//		 Integer empNo2 = originEmpRepository.findByEmpEndDate(empNo2);		
//	}
//
//	public void modifyEmpLeave(EmpDTO leaveEmp) {
//		// TODO Auto-generated method stub
//		
//	}
	
	 @Transactional 
	public void modifyEmpEndYn(EmpDTO emp, int empNo) {
		 Emp emp2 = originEmpRepository.findByEmpNo(empNo);
		 LocalDate now = LocalDate.now();
		 Date day = java.sql.Date.valueOf(now);
		 emp2.setEmpEndYn("Y");
		 emp2.setEmpEndDate(day);
		 originEmpRepository.save(emp2);
	}
	 
	 @Transactional 
	public void modifyEmpEndDate(EmpDTO emp) {
		 emp = originEmpRepository.findByEmpEndDate(emp);
		
	}

	


}
