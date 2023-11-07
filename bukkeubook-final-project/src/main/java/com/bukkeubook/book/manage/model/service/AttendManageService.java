package com.bukkeubook.book.manage.model.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bukkeubook.book.common.paging.AttendSelectCriteria;
import com.bukkeubook.book.manage.model.dto.joinDTO.AttendAndEmpDTO;
import com.bukkeubook.book.manage.model.entity.AttendAndEmp;
import com.bukkeubook.book.manage.model.repository.AttendAndEmpRepository;

@Service
public class AttendManageService {
	
	private final AttendAndEmpRepository attendAndEmpRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public AttendManageService(AttendAndEmpRepository attendAndEmpRepository, ModelMapper modelMapper) {
		this.attendAndEmpRepository = attendAndEmpRepository;
		this.modelMapper = modelMapper;
		}
	
	/* 전체 사원의 출근 기록 조회 */
	public List<AttendAndEmpDTO> findAllAttendList() {
		
		List<AttendAndEmp> attendList = attendAndEmpRepository.findAll(Sort.by("attNo").descending());
		
		return attendList.stream().map(list -> modelMapper.map(list, AttendAndEmpDTO.class)).collect(Collectors.toList());
	}
	
	/* 페이징 처리 갯수 구하기 */
	public int selectTotalCount(String searchCondition, String searchValue, Date startDate, Date endDate) {
		
		
		int count = 0;
			
			if(startDate!=null && endDate!=null) {
				if(!"".equals(searchValue)) {
					if("empNo".equals(searchCondition)) {
						int search = Integer.parseInt(searchValue);
						count = attendAndEmpRepository.countByEmp_EmpNoAndAttDateBetween(search, startDate, endDate);
						}
					if("empName".equals(searchCondition)) {
						count = attendAndEmpRepository.countByEmp_EmpNameContainingAndAttDateBetween(searchValue, startDate, endDate);
						}
				}else{
					count = attendAndEmpRepository.countByAttDateBetween(startDate, endDate);
				}
			}else {
				count = (int)attendAndEmpRepository.count();
			}
			
		
				
		
		return count;
	}
	
	/* 페이징 처리 */
	public List<AttendAndEmpDTO> searchAttendList(AttendSelectCriteria attendSelectCriteria) {
		
		int index = attendSelectCriteria.getPageNo() - 1;
		int count = attendSelectCriteria.getLimit();
		Pageable paging = PageRequest.of(index, count, Sort.by("attDate").descending());
		
		java.sql.Date startDate = attendSelectCriteria.getStartDate();
		java.sql.Date endDate = attendSelectCriteria.getEndDate();
		String searchValue = attendSelectCriteria.getSearchValue();
		
		List<AttendAndEmp> attend = new ArrayList<AttendAndEmp>();
		if(startDate!=null && endDate!=null) {
			if(searchValue != null) {
				if("empNo".equals(attendSelectCriteria.getSearchCondition())) {
					int search = Integer.parseInt(searchValue);
					attend = attendAndEmpRepository.findByEmp_EmpNoAndAttDateBetween(search, startDate, endDate, paging);
				}
				if("empName".equals(attendSelectCriteria.getSearchCondition())) {
					attend = attendAndEmpRepository.findByEmp_EmpNameContainingAndAttDateBetween(searchValue, startDate, endDate, paging);
				}
			}else {
				attend = attendAndEmpRepository.findByAttDateBetween(startDate, endDate, paging);
			} 
		}else {
			attend = attendAndEmpRepository.findAll(paging).toList();
		}
		
		return attend.stream().map(list -> modelMapper.map(list, AttendAndEmpDTO.class)).collect(Collectors.toList());
	}

}
