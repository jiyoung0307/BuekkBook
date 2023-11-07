package com.bukkeubook.book.manage.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bukkeubook.book.manage.model.dto.EmpDTO;
import com.bukkeubook.book.manage.model.entity.Emp;

public interface OriginalEmpRepository extends JpaRepository<Emp, Integer>{

	List<Emp> findMemberByempNo(int empNo);

	EmpDTO findByEmpEndDate(EmpDTO emp);

	Emp findByEmpNo(int empNo);
	
	List<Emp> findByEmpNameContaining(String searchValue);

	@Query(value = "SELECT MAX(a.empNo) FROM Emp a")
	int findCurrentSeqempNo();



}
