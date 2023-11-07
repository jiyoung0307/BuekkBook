package com.bukkeubook.book.manage.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bukkeubook.book.common.paging.SelectCriteria;
import com.bukkeubook.book.manage.model.dto.DeptDTO;
import com.bukkeubook.book.manage.model.dto.EmpDTO;
import com.bukkeubook.book.manage.model.dto.SalaryDTO;
import com.bukkeubook.book.manage.model.dto.SalaryEmpDTO;
import com.bukkeubook.book.manage.model.dto.joinDTO.EmpAndDeptDTO;
import com.bukkeubook.book.manage.model.dto.joinDTO.PayAndEmpAndDeptDTO;
import com.bukkeubook.book.manage.model.entity.Dept;
import com.bukkeubook.book.manage.model.entity.Emp;
import com.bukkeubook.book.manage.model.entity.EmpAndDept;
import com.bukkeubook.book.manage.model.entity.PayAndEmpAndDept;
import com.bukkeubook.book.manage.model.entity.Salary;
import com.bukkeubook.book.manage.model.repository.EmpPayRepository;
import com.bukkeubook.book.manage.model.repository.EmpRepository;
import com.bukkeubook.book.manage.model.repository.OriginalEmpRepository;
import com.bukkeubook.book.manage.model.repository.SalaryRepository;
import com.bukkeubook.book.manage.model.repository.SimpleDeptRepository;


@Service
public class EmpPayService {
   
   private final ModelMapper modelMapper;
   private final EmpPayRepository empPayRepository;
   private final EmpRepository empRepository;
   private final SimpleDeptRepository simpleDeptRepository;
   private final SalaryRepository salaryRepository;
   private final OriginalEmpRepository originEmpRepository;
   
   @Autowired
   public EmpPayService(EmpPayRepository empPayRepository
		   			  , EmpRepository empRepository
		   			  , SimpleDeptRepository simpleDeptRepository
		   			  , SalaryRepository salaryRepository
		   			  , OriginalEmpRepository originEmpRepository
		   			  , ModelMapper modelMapper) {
      this.empPayRepository = empPayRepository;
      this.empRepository = empRepository;
      this.simpleDeptRepository = simpleDeptRepository;
      this.salaryRepository = salaryRepository;
      this.originEmpRepository = originEmpRepository;
      this.modelMapper = modelMapper;
   }
   
   
   /* 급여계산내역 조회 & 검색기능 & 페이징 */
	public int selectTotalCount(String searchCondition, String searchValue) {

		int count = 0;;
		if(searchValue != null) {

//			if("empName".equals(searchCondition)) {
//				count = empPayRepository.countByEmpNameContaining(searchValue);
//			}
			
			if("salMonth".equals(searchCondition)) {
				count = empPayRepository.countBySalMonthContaining(searchValue);
			}

		} else {
			count = (int)empPayRepository.count();
		}

		return count;
	}
	
	public List<PayAndEmpAndDeptDTO> searchPayList(SelectCriteria selectCriteria) {

		int index = selectCriteria.getPageNo() - 1;
		int count = selectCriteria.getLimit();
		String searchValue = selectCriteria.getSearchValue();

		Pageable paging = PageRequest.of(index, count, Sort.by("salMonth").descending());

		List<PayAndEmpAndDept> payList = new ArrayList<PayAndEmpAndDept>();
		if(searchValue != null) {

			if("deptName".equals(selectCriteria.getSearchCondition())) {
				
				payList = empPayRepository.findAllByEmpInfo_Dept_DeptNameContaining(selectCriteria.getSearchValue(), paging);
			}
			
			if("empName".equals(selectCriteria.getSearchCondition())) {
				
				payList = empPayRepository.findAllByEmpInfo_EmpNameContaining(selectCriteria.getSearchValue(), paging);
			}
			
		} else {
			payList = empPayRepository.findAll(paging).toList();
		}
		
		/* 자바의 Stream API와 ModelMapper를 이용하여 entity를 DTO로 변환 후 List<MenuDTO>로 반환 */
		return payList.stream().map(salary -> modelMapper.map(salary, PayAndEmpAndDeptDTO.class)).collect(Collectors.toList());
	}
	
	/* 상세 급여지급내역 조회 */
	public PayAndEmpAndDeptDTO searchEmpPayDetail(int salNo) {
		
		PayAndEmpAndDept pay = empPayRepository.findById(salNo).get();
		
		return modelMapper.map(pay, PayAndEmpAndDeptDTO.class);
				
	}

	/* 급여계산내역 수정 페이지 연결*/
	public PayAndEmpAndDeptDTO findEmpPayBySalNo(int salNo) {
		
		PayAndEmpAndDept pay = empPayRepository.findById(salNo).get();

		return modelMapper.map(pay, PayAndEmpAndDeptDTO.class);
		
	}

	/* 부서선택- 사원선택지정 ajax select Tag Option Dept */
	public List<DeptDTO> findDept() {
		
		List<Dept> deptList = simpleDeptRepository.findAll(Sort.by("deptCode"));
				
		return deptList.stream().map(dept -> modelMapper.map(dept, DeptDTO.class)).toList();
	}


	/* 전월 급여 내역 조회 */
	public SalaryEmpDTO findByEmpNoSalary(int empNo) {

		List<Salary> salary = salaryRepository.findByEmpNo(empNo, Sort.by("salMonth").descending());
		
		List<SalaryDTO> salList = salary.stream().map(sal -> modelMapper.map(sal, SalaryDTO.class)).toList();
		
		SalaryDTO currentSal = salList.get(0);
		
		Emp empInfo = originEmpRepository.findById(empNo).get();
		
		int totalSal = empInfo.getEmpTotalSal();
		
		SalaryEmpDTO emp = new SalaryEmpDTO();
		
		emp.setSalary(currentSal);
		emp.setEmpTotalSal(totalSal);
		
		return emp;
	}

	/* 급여 등록 */
	@Transactional
	public void insertNewSalary(SalaryDTO salary) {

		salaryRepository.save(modelMapper.map(salary, Salary.class));
		
	}

	/* 급여내역 삭제 */
	@Transactional
	public void deleteSalary(int salNo) {

		salaryRepository.deleteById(salNo);
		
	}


	
  
	

		












}


