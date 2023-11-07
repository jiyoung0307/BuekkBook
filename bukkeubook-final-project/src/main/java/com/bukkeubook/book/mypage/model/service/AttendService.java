package com.bukkeubook.book.mypage.model.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bukkeubook.book.common.paging.DateSelectCriteria;
import com.bukkeubook.book.manage.model.dto.AttendDTO;
import com.bukkeubook.book.manage.model.entity.Attend;
import com.bukkeubook.book.mypage.model.repository.AttendRepository;

@Service
public class AttendService {
	
	private final AttendRepository attendRepository;
	private ModelMapper modelMapper;
	
	@Autowired
	public AttendService(AttendRepository attendRepository, ModelMapper modelMapper) {
		this.attendRepository = attendRepository;
		this.modelMapper = modelMapper;
	}
	
	/* 검색 시 페이지 표시되는 값 갯수 */
	public int selectTotalCount(int memberCode, AttendDTO attendDTO) {
		
		int count = 0;

			if(attendDTO.getAttStart()!=null && attendDTO.getAttEnd()!=null) {
				count = attendRepository.countByEmpNoAndAttDateBetween(memberCode, attendDTO.getAttStart(), attendDTO.getAttEnd());
				}else {
					count = (int)attendRepository.countByEmpNo(memberCode);
		}
		
		return count;
	}
	/* 마이페이지 출퇴근 내역 조회 */
	public List<AttendDTO> findMyAttend(int memberCode, DateSelectCriteria dateSelectCriteria) {
		
		int index = dateSelectCriteria.getPageNo() - 1;			// Pageble객체를 사용시 페이지는 0부터 시작(1페이지가 0)
		int count = dateSelectCriteria.getLimit();
		java.sql.Date startDate = dateSelectCriteria.getStartDate();
		java.sql.Date endDate = dateSelectCriteria.getEndDate();
		
		/* 페이징 처리와 정렬을 위한 객체 생성 */
		Pageable paging = PageRequest.of(index, count, Sort.by("attDate").descending());
		
		List<Attend> attendList1 = new ArrayList<Attend>();
		if(startDate != null) {
			
			attendList1 = attendRepository.findByEmpNoAndAttDateBetween(memberCode, dateSelectCriteria.getStartDate(), dateSelectCriteria.getEndDate(), paging);
			
		}else {
			attendList1 = attendRepository.findByEmpNo(memberCode, paging);
		}
		
		return attendList1.stream().map(attend -> modelMapper.map(attend, AttendDTO.class)).collect(Collectors.toList());

	}
	
	/* 마이페이지에서 출근 등록하기 */
	@Transactional
	public boolean registCheckIn(AttendDTO attend) {
		
		try {
			attendRepository.save(modelMapper.map(attend, Attend.class));
		}catch(IllegalArgumentException exception) {
            return false;
		}
		
		return true;
	}
	
	/* 퇴근 시간 리셋용 */
	public void resetCheckOut(AttendDTO attend, int memberInfo, long noTime) {
		
		Attend modifyCheckOut = attendRepository.findByEmpNoAndAttDateLike(memberInfo, attend.getAttDate());
		
		java.sql.Date noToday = new java.sql.Date(noTime);
		modifyCheckOut.setAttEnd(noToday);
		
		
	}
	
	/* 마이페이지에서 퇴근 등록하기 */
	@Transactional
	public boolean modifyCheckOut(AttendDTO attend, int memberInfo, long time, long noTime) {
		
		
		Attend modifyCheckOut = attendRepository.findByEmpNoAndAttDateLike(memberInfo, attend.getAttDate());
		
		java.sql.Date today = new java.sql.Date(time);
		java.sql.Date noToday = new java.sql.Date(noTime);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf2.format(today)); 
		modifyCheckOut.setAttEnd(noToday);
		
		try {
			modifyCheckOut.setAttEnd(today);
		}catch(IllegalArgumentException exception) {
            return false;
		}
		
		return true;
	}

	
	/* 출퇴근 버튼용 */
	public List<AttendDTO> findMyAttend1(int memberCode) {
		
		List<Attend> attendList1 = attendRepository.findByEmpNo(memberCode, Sort.by("attDate").descending());
		
		return attendList1.stream().map(attend -> modelMapper.map(attend, AttendDTO.class)).collect(Collectors.toList());
	}
	
	

	
	
	
	

}
