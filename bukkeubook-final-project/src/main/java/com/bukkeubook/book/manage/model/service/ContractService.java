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
import com.bukkeubook.book.manage.model.dto.ContFileDTO;
import com.bukkeubook.book.manage.model.dto.EmpContDTO;
import com.bukkeubook.book.manage.model.dto.joinDTO.EmpAndDeptDTO;
import com.bukkeubook.book.manage.model.dto.joinDTO.EmpContAndEmpDTO;
import com.bukkeubook.book.manage.model.entity.EmpAndDept;
import com.bukkeubook.book.manage.model.entity.EmpCont;
import com.bukkeubook.book.manage.model.entity.EmpContAndEmp;
import com.bukkeubook.book.manage.model.entity.LaborContFile;
import com.bukkeubook.book.manage.model.repository.EmpContAndEmpRepository;
import com.bukkeubook.book.manage.model.repository.EmpContRepository;
import com.bukkeubook.book.manage.model.repository.EmpRepository;
import com.bukkeubook.book.manage.model.repository.LaborContFileRepository;


@Service
public class ContractService {
	
	private final EmpContAndEmpRepository empContAndEmpRepository;
	private final EmpContRepository empContRepository;
	private final LaborContFileRepository laborContFileRepository;
	private final EmpRepository empRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public ContractService(EmpContAndEmpRepository empContAndEmpRepository, ModelMapper modelMapper, EmpContRepository empContRepository, LaborContFileRepository laborContFileRepository, EmpRepository empRepository) {
		this.empContAndEmpRepository = empContAndEmpRepository;
		this.empContRepository = empContRepository;
		this.laborContFileRepository = laborContFileRepository;
		this.empRepository = empRepository;
		this.modelMapper = modelMapper;
	}
	
	/* 근로계약서 내역 전체 조회 */
	public List<EmpContAndEmpDTO> findAllContracts() {
		
		List<EmpContAndEmp> contList = empContAndEmpRepository.findAll(Sort.by("contNo").descending());
		
		return contList.stream().map(list -> modelMapper.map(list, EmpContAndEmpDTO.class)).collect(Collectors.toList());
	}

	/* 근로계약서 내역 상세 조회 */
	public EmpContAndEmpDTO findDetailCont(int contNo) {
		
		EmpContAndEmp empContDetail = empContAndEmpRepository.findBycontNo(contNo);
		
		return modelMapper.map(empContDetail, EmpContAndEmpDTO.class);
	}
	
	/* 근로계약서 테이블 insert */
	@Transactional
	public boolean registNewContract(EmpContDTO empCont) {
		
		try {
			empContRepository.save(modelMapper.map(empCont, EmpCont.class));
		}catch(IllegalArgumentException exception) {
            return false;
		}
		
		return true;
	}
	
	/* 근로계약서 파일 업로드 */
	@Transactional
	public void registNewFile(ContFileDTO contFile) {
		
		laborContFileRepository.save(modelMapper.map(contFile, LaborContFile.class));
		
	}
	
	/* 근로계약서 내역 삭제 */
	@Transactional
	public boolean deleteCont(int No) {
		
		try {
			empContRepository.deleteByContNo(No);
		}catch(IllegalArgumentException exception) {
            return false;
		}
		
		return true;
	}
	
	/* 근로계약서 파일 조회 */
	public ContFileDTO findContFileNo(int code) {

		LaborContFile contFileNo = laborContFileRepository.findByContNo(code);
		
		return modelMapper.map(contFileNo, ContFileDTO.class);
	}
	
	/* 근로계약서 파일 삭제 */
	public boolean deleteContFile(int fileCode) {
		
		try {
			laborContFileRepository.deleteById(fileCode);
		}catch(IllegalArgumentException exception) {
            return false;
		}
		
		return true;
	}
	
	/* 검색 시 출력 갯수 구하기 */
	public int selectTotalCount(String searchCondition, String searchValue) {
		
		int count = 0;
			if(searchValue != null) {
				if("empName".equals(searchCondition)) {
					count = empContAndEmpRepository.countByEmp_EmpNameContaining(searchValue);
				}
				if("contName".equals(searchCondition)) {
					count = empContAndEmpRepository.countByContNameContaining(searchValue);
				}
			}else {
				count = (int) empContAndEmpRepository.count();
			}
		
		return count;
	}
	
	/* 페이징 처리 */
	public List<EmpContAndEmpDTO> searchContractList(SelectCriteria selectCriteria) {
		
		int index = selectCriteria.getPageNo() - 1;
		int count = selectCriteria.getLimit();
		String searchValue = selectCriteria.getSearchValue();
		
		Pageable paging = PageRequest.of(index, count, Sort.by("contNo").descending());
		
		List<EmpContAndEmp> contList = new ArrayList<EmpContAndEmp>();
		if(searchValue != null) {
			
			if("empName".equals(selectCriteria.getSearchCondition())) {
				contList = empContAndEmpRepository.findByEmp_EmpNameContaining(selectCriteria.getSearchValue(), paging);
			}
			if("contName".equals(selectCriteria.getSearchCondition())) {
				contList = empContAndEmpRepository.findByContNameContaining(selectCriteria.getSearchValue(), paging);
			}
		}else {
			contList = empContAndEmpRepository.findAll(paging).toList();
		}
		
		return contList.stream().map(cont -> modelMapper.map(cont, EmpContAndEmpDTO.class)).collect(Collectors.toList());
	}
	
	/* 전체 사원 조회 */
	public List<EmpAndDeptDTO> findAllEmpList() {
		
		List<EmpAndDept> empList = empRepository.findAll();
		
		return empList.stream().map(list -> modelMapper.map(list, EmpAndDeptDTO.class)).collect(Collectors.toList());
	}

	/* 근로계약서 기본키로 파일 조회 */
	public ContFileDTO findPkFileCont(int id) {
		
		LaborContFile contFile = laborContFileRepository.findBycfileNo(id);
		
		
		return modelMapper.map(contFile, ContFileDTO.class);
	}
	
	

}
