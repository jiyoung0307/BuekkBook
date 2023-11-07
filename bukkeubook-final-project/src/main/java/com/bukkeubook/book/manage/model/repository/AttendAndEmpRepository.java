package com.bukkeubook.book.manage.model.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bukkeubook.book.manage.model.entity.AttendAndEmp;


public interface AttendAndEmpRepository extends JpaRepository<AttendAndEmp, Integer> {

	int countByEmp_EmpNoAndAttDateBetween(String searchValue, Date startDate, Date endDate);

	int countByEmp_EmpNameAndAttDateBetween(String searchValue, Date startDate, Date endDate);

	int countByEmp_EmpNoContaining(String searchValue);

	int countByEmp_EmpNameContaining(String searchValue);

	int countByAttDateBetween(Date startDate, Date endDate);

	int countByEmp_EmpNameContainingAndAttDateBetween(String searchValue, Date startDate, Date endDate);

	int countByEmp_EmpNoAndAttDateBetween(int search, Date startDate, Date endDate);

	List<AttendAndEmp> findByEmp_EmpNoAndAttDateBetween(int search, Date startDate, Date endDate, Pageable paging);

	List<AttendAndEmp> findByEmp_EmpNameContainingAndAttDateBetween(String searchValue, Date startDate, Date endDate,
			Pageable paging);

	List<AttendAndEmp> findByAttDateBetween(Date startDate, Date endDate, Pageable paging);

	List<AttendAndEmp> findByEmp_EmpNoAndAttDateBetween(String searchValue, Date startDate, Date endDate,
			Pageable paging);




}
