package com.bukkeubook.book.mypage.model.service;

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
import org.springframework.transaction.annotation.Transactional;

import com.bukkeubook.book.common.paging.DateSelectCriteria;
import com.bukkeubook.book.manage.model.dto.AppVacationDTO;
import com.bukkeubook.book.manage.model.dto.DayOffDTO;
import com.bukkeubook.book.manage.model.entity.AppVacation;
import com.bukkeubook.book.manage.model.entity.DayOff;
import com.bukkeubook.book.mypage.model.dto.CalendarDTO;
import com.bukkeubook.book.mypage.model.entity.Calendar;
import com.bukkeubook.book.mypage.model.repository.CalendarRepository;
import com.bukkeubook.book.mypage.model.repository.DayOffRepository;
import com.bukkeubook.book.mypage.model.repository.VacationRepository;

@Service
public class MypageService {

	private final VacationRepository vacationRepository;
	private final DayOffRepository dayOffRepository;
	private final CalendarRepository calendarRepository;
	private final ModelMapper modelMapper;

	@Autowired
	public MypageService(VacationRepository vacationRepository, DayOffRepository dayOffRepository,
			CalendarRepository calendarRepository, ModelMapper modelMapper) {
		this.vacationRepository = vacationRepository;
		this.dayOffRepository = dayOffRepository;
		this.calendarRepository = calendarRepository;
		this.modelMapper = modelMapper;
	}

	/* 마이페이지 연차 횟수 조회 */
	public List<DayOffDTO> findMyDayOffList(int memberCode) {

		List<DayOff> dayOffList = dayOffRepository.findAllByEmpNo(memberCode);

		return dayOffList.stream().map(dayOff -> modelMapper.map(dayOff, DayOffDTO.class)).collect(Collectors.toList());
	}

	/* 일정 전체 조회 */
	public List<CalendarDTO> findMyCalendar(int memberCode) {

		List<Calendar> calendarList = calendarRepository.findAllByEmpNo(memberCode);

		return calendarList.stream().map(calendar -> modelMapper.map(calendar, CalendarDTO.class))
				.collect(Collectors.toList());
	}

	/* 일정 등록 */
	@Transactional
	public boolean registNewCalendar(CalendarDTO newCalendar) {
		
		try {
			calendarRepository.save(modelMapper.map(newCalendar, Calendar.class));
		}catch(IllegalArgumentException exception) {
            return false;
		}
		
		return true;
	}

	/* 일정 상세 조회 */
	public CalendarDTO findMyCalendarDetail(int calCode) {

		Calendar CalendarDetail = calendarRepository.findById(calCode).get();

		return modelMapper.map(CalendarDetail, CalendarDTO.class);
	}

	/* 일정 수정 */
	@Transactional
	public boolean modifyMyCalendar(CalendarDTO newCalendar) {

		try {
			Calendar updateCal = calendarRepository.findById(newCalendar.getCode()).get();
			updateCal.setTitle(newCalendar.getTitle());
			updateCal.setStart(newCalendar.getStart());
			updateCal.setEnd(newCalendar.getEnd());
			updateCal.setContent(newCalendar.getContent());
		}catch(IllegalArgumentException exception) {
            return false;
		}
		
		return true;
	}

	/* 일정 삭제 */
	public boolean deleteCalendar(int calCode) {
		
		try {
			calendarRepository.deleteById(calCode);
			
		}catch(IllegalArgumentException exception) {
            return false;
		}
		
		return true;

	}

	/* 마이페이지 연차(휴가) 사용 내역 기간 검색 후 조회 총 갯수 */
	public int selectTotalCount(int memberCode, String approve, Date attStart, Date attEnd) {

		int count = 0;
		System.out.println(attStart);
		System.out.println(attEnd+ " 값있냐?");

		if (attStart != null && attEnd != null) {
			count = vacationRepository.countByEmpNoAndVacStatusAndVacStartDateBetween(memberCode, approve, attStart,
					attEnd);

			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 서비스 계층 : " + count);
		}else {
			count = vacationRepository.countByEmpNoAndVacStatus(memberCode, approve);
		}

		return count;
	}

	/*
	 * 마이페이지 연차(휴가) 사용 내역 조회 public List<AppVacationDTO> findMyAnnualList(int
	 * memberCode, String approve){
	 * 
	 * List<AppVacation> vacationList =
	 * vacationRepository.findAllByEmpNoAndVacStatus(memberCode, approve);
	 * 
	 * return vacationList.stream().map(vacation -> modelMapper.map(vacation,
	 * AppVacationDTO.class)).collect(Collectors.toList());
	 * 
	 * }
	 */

	/* 마이페이지 연차(휴가) 사용 내역 조회 페이징 처리 */
	public List<AppVacationDTO> findMyVacation1(int memberCode, DateSelectCriteria dateSelectCriteria, String approve) {

		int index = dateSelectCriteria.getPageNo() - 1; // Pageble객체를 사용시 페이지는 0부터 시작(1페이지가 0)
		int count = dateSelectCriteria.getLimit();
		
		System.out.println("아아아ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ" + index + " mmmmmmmmmmmm" + count);

		Pageable paging = PageRequest.of(index, count, Sort.by("vacStartDate").descending());

		List<AppVacation> vacationList1 = new ArrayList<AppVacation>();
		if (dateSelectCriteria.getStartDate() != null) {

			vacationList1 = vacationRepository.findByEmpNoAndVacStatusAndVacStartDateBetween(memberCode, approve,
					dateSelectCriteria.getStartDate(), dateSelectCriteria.getEndDate(), paging);
		} else {
			vacationList1 = vacationRepository.findByEmpNoAndVacStatus(memberCode, approve, paging);
		}

		return vacationList1.stream().map(vacation -> modelMapper.map(vacation, AppVacationDTO.class))
				.collect(Collectors.toList());
	}
}
