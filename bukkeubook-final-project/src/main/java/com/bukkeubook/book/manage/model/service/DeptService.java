package com.bukkeubook.book.manage.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bukkeubook.book.manage.model.dto.DeptDTO;
import com.bukkeubook.book.manage.model.dto.joinDTO.DeptAndEmpDTO;
import com.bukkeubook.book.manage.model.entity.Dept;
import com.bukkeubook.book.manage.model.entity.DeptAndEmp2;
import com.bukkeubook.book.manage.model.repository.DeptRepository;
import com.bukkeubook.book.manage.model.repository.SimpleDeptRepository;
import com.bukkeubook.book.manage.model.repository.SimpleEmpRepository;

@Service
public class DeptService {
	
	private final DeptRepository deptRepository;
	private final SimpleEmpRepository empRepository;
	private final SimpleDeptRepository simpleDeptRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public DeptService(DeptRepository deptRepository, SimpleEmpRepository empRepository, SimpleDeptRepository simpleDeptRepository, ModelMapper modelMapper) {
		this.deptRepository = deptRepository;
		this.empRepository = empRepository;
		this.simpleDeptRepository = simpleDeptRepository;
		this.modelMapper = modelMapper;
	}

	@Transactional
	public List<DeptAndEmpDTO> selectDeptList() {

		List<DeptAndEmp2> deptList = new ArrayList<DeptAndEmp2>();
		
		deptList = deptRepository.findAll(Sort.by("deptCode"));
		
		return deptList.stream().map(DeptAndEmp2 -> modelMapper.map(DeptAndEmp2, DeptAndEmpDTO.class)).collect(Collectors.toList());
	}

	@Transactional
	public DeptAndEmpDTO searchDeptDetail(int deptCode) {
		DeptAndEmp2 dept = deptRepository.findById(deptCode).get();
		
		return modelMapper.map(dept, DeptAndEmpDTO.class);
	}

//	@Transactional
//	public void registDept(DeptDTO newDept, List<Integer> empNo) {
//
//		simpleDeptRepository.save(modelMapper.map(newDept, Dept.class));
//		List<Dept> deptList = simpleDeptRepository.findAll();
//		int deptCode = 0;
//		
//		for(int i = 0; i < deptList.size(); i++) {
//			
//			int code = deptList.get(i).getDeptCode();;
//			
//			if(i == 0) {
//				deptCode = code;
//			} else {
//				if(deptCode < code) {
//					deptCode = code;
//				}
//			}
//		}
//		
//		System.out.println("Service에서 신규 부서번호 확인 : " + deptCode);
//		
//		for(int i = 0; i < empNo.size(); i++) {
//			empRepository.findById(empNo.get(i)).get().setDeptCode(deptCode);
//		}
//		
//	}
//
//	@Transactional
//	public int selectTotalCount(String searchCondition, String searchValue) {
//
//		int count = 0;
//		if(searchValue != null) {
//			if("empName".equals(searchCondition)) {
//				count = empRepository.countByEmpNameContaining(searchValue);
//			}
//
//			if("empJobCode".equals(searchCondition)) {
//				count = empRepository.countByEmpJobCodeContaining(searchValue);
//			}
//		} else {
//			count = (int)empRepository.count();
//		}
//
//		return count;
//	}
//
//	@Transactional
//	public List<EmpDTO> searchEmpList(SelectCriteria selectCriteria) {
//
//		int index = selectCriteria.getPageNo() - 1;
//		int count = selectCriteria.getLimit();
//		String searchValue = selectCriteria.getSearchValue();
//
//		Pageable paging = PageRequest.of(index, count, Sort.by("empNo"));
//
//		List<Emp> empList = new ArrayList<Emp>();
//		if(searchValue != null) {
//
//			if("empName".equals(selectCriteria.getSearchCondition())) {
//				empList = empRepository.findByEmpNameContaining(selectCriteria.getSearchValue(), paging);
//			}
//
//			if("empJobCode".equals(selectCriteria.getSearchCondition())) {
//				empList = empRepository.findByEmpJobCodeContaining(selectCriteria.getSearchValue(), paging);
//			}
//			
//		} else {
//			empList = empRepository.findAll(paging).toList();
//		}
//
//		/* 자바의 Stream API와 ModelMapper를 이용하여 entity를 DTO로 변환 후 List<MenuDTO>로 반환 */
//		return empList.stream().map(Emp -> modelMapper.map(Emp, EmpDTO.class)).collect(Collectors.toList());
//	}

	@Transactional
	public DeptDTO searchDeptDetailForModify(int deptCode) {
		Dept dept = simpleDeptRepository.findById(deptCode).get();
		
		return modelMapper.map(dept, DeptDTO.class);
	}

	@Transactional
	public void modifyDept(DeptDTO newDept) {

		Dept foundDept = simpleDeptRepository.findById(newDept.getDeptCode()).get();
		
		foundDept.setDeptName(newDept.getDeptName());
		foundDept.setDeptRepPhone(newDept.getDeptRepPhone());
	}

//	public List<EmpDTO> searchEmpList(String searchCondition, String searchValue) {
//
//		List<Emp> empList = new ArrayList<Emp>();
//		if(searchValue != null) {
//
//			if("empName".equals(searchCondition)) {
//				empList = empRepository.findByEmpNameContaining(searchValue, Sort.by("empNo"));
//			}
//
//			if("empJobCode".equals(searchCondition)) {
//				empList = empRepository.findByEmpJobCodeContaining(searchValue, Sort.by("empNo"));
//			}
//			
//		} else {
//			empList = empRepository.findAll(Sort.by("empNo"));
//		}
//
//		/* 자바의 Stream API와 ModelMapper를 이용하여 entity를 DTO로 변환 후 List<MenuDTO>로 반환 */
//		return empList.stream().map(Emp -> modelMapper.map(Emp, EmpDTO.class)).collect(Collectors.toList());
//	}
	
}
