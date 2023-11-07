package com.bukkeubook.book.manage.model.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bukkeubook.book.manage.model.entity.AppVacation;
import com.bukkeubook.book.manage.model.entity.AppVacationAndEmp;

@Repository
public interface EmpAnnualRepository extends JpaRepository<AppVacationAndEmp, Integer> {
	
	/* 휴가 신청 조회 */
	List<AppVacationAndEmp> findAll();

	/* 검색기능 & 페이징처리 */	

	int countByemp_Dept_DeptNameContaining(String searchValue);

//	int countByEmp_EmpNoContaining(String searchValue);
	
	int countByEmp_EmpNameContaining(String searchValue);

	List<AppVacationAndEmp> findByemp_Dept_DeptNameContaining(String searchValue, Pageable paging);

//	List<AppVacationAndEmp> findByEmp_EQmpNoContaining(int searchValue, Pageable paging);

	List<AppVacationAndEmp> findByEmp_EmpNameContaining(String searchValue, Pageable paging);





	

		
}
