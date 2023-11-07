package com.bukkeubook.book.mypage.model.repository;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bukkeubook.book.manage.model.dto.AttendDTO;
import com.bukkeubook.book.manage.model.entity.AppVacation;
import com.bukkeubook.book.manage.model.entity.Attend;

public interface AttendRepository extends JpaRepository<Attend, Integer>{


	Attend findByAttDateLike(Date attDate);

	int countByAttDateContaining(String searchValue);

	List<Attend> findByAttDateAndEmpNoContaining(String searchValue, int memberCode, Pageable paging);

	List<Attend> findByEmpNo(int memberCode, Pageable paging);

	int countByEmpNo(int memberCode);

	List<Attend> findByEmpNo(int memberCode, Sort descending);


	int countByEmpNoAndAttDateBetween(int memberCode, Date attStart, Date attEnd);

	List<Attend> findByEmpNoAndAttDateBetween(int memberCode, Date startDate, Date endDate, Pageable paging);

	Attend findByEmpNoAndAttDateLike(int memberInfo, Date attDate);





















	


	

}
