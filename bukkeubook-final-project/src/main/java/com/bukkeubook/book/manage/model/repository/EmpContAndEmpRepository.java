package com.bukkeubook.book.manage.model.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bukkeubook.book.manage.model.entity.EmpContAndEmp;


public interface EmpContAndEmpRepository extends JpaRepository<EmpContAndEmp, Integer>{

	EmpContAndEmp findBycontNo(int contNo);


	int countByEmp_EmpNameContaining(String searchValue);

	int countByContNameContaining(String searchValue);


	List<EmpContAndEmp> findByEmp_EmpNameContaining(String searchValue, Pageable paging);


	List<EmpContAndEmp> findByContNameContaining(String searchValue, Pageable paging);



	

		

}
