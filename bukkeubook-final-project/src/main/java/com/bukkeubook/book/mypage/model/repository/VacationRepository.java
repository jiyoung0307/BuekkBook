package com.bukkeubook.book.mypage.model.repository;

import java.sql.Date;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bukkeubook.book.manage.model.entity.AppVacation;

public interface VacationRepository extends JpaRepository<AppVacation, Integer>{


	List<AppVacation> findAllByEmpNoAndVacStatus(int memberCode, String approve);

	List<AppVacation> findByEmpNoAndVacStatusAndVacStartDateBetween(int memberCode, String approve, Date startDate,
			Date endDate, Pageable paging);

	List<AppVacation> findByEmpNoAndVacStatus(int memberCode, String approve, Pageable paging);

	int countByEmpNoAndVacStatusAndVacStartDateBetween(int memberCode, String approve, Date attStart, Date attEnd);

	int countByEmpNoAndVacStatus(int memberCode, String approve);



}
