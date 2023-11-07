package com.bukkeubook.book.manage.model.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import com.bukkeubook.book.manage.model.entity.EmpAndDept;
import com.bukkeubook.book.manage.model.entity.PayAndEmpAndDept;


@Repository
public interface EmpPayRepository extends JpaRepository<PayAndEmpAndDept, Integer> {

	int countBySalMonthContaining(String searchValue);

	List<PayAndEmpAndDept> findAllByEmpInfo_EmpNameContaining(String searchValue, Pageable paging);

	List<PayAndEmpAndDept> findAllByEmpInfo_Dept_DeptNameContaining(String searchValue, Pageable paging);






}