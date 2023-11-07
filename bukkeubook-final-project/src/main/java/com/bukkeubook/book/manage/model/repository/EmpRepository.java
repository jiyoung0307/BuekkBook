package com.bukkeubook.book.manage.model.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import com.bukkeubook.book.manage.model.dto.EmpDTO;
import com.bukkeubook.book.manage.model.entity.Dept;
import com.bukkeubook.book.manage.model.entity.Emp;
import com.bukkeubook.book.manage.model.entity.EmpAndDept;

@Repository
public interface EmpRepository extends JpaRepository<EmpAndDept, Integer>{
	
	/* 퇴사여부 Y 인 사원 조회 */
	List<EmpAndDept> findByEmpEndYn(String empEndYn);

	/* 검색기능 & 페이징처리 */
	int countByEmpNameContaining(String searchValue);
	
	int countByempJobCodeContaining(String searchValue);
	
//	int countByemp_Dept_DeptNameContaining(String searchValue);

	List<EmpAndDept> findByEmpNameContaining(String searchValue, Pageable paging);

	List<EmpAndDept> findByEmpJobCodeContaining(String searchValue, Pageable paging);

//	List<EmpAndDept> findByemp_Dept_DeptNameContaining(String searchValue, Pageable paging);
	

	/* 신규사원 등록 */
//	@Query(value = "SELECT (TO_NUMBER(SUBSTR(MAX(EMP_NO), 6, 2))+1) FROM TBL_EMP", nativeQuery = true)
//	int empNo();
	
	/* // /* 급여 계산을 위한 퇴사여부 n 인 직원 리스트 */
//
//	List<EmpAndDept> findByNameContaining(String searchValue, Sort by);
//
//	List<EmpAndDept> findByJobCodeContaining(String searchValue, Sort by);









	
}

