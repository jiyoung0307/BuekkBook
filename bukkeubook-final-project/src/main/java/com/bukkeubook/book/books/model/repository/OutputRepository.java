package com.bukkeubook.book.books.model.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bukkeubook.book.books.model.entity.RelListAndEmp;
@Repository
public interface OutputRepository extends JpaRepository<RelListAndEmp, Integer> {
	
	List<RelListAndEmp> findAllByRelDateContaining(String searchValue, Pageable paging);

	List<RelListAndEmp> findAllByEmp_EmpNameContaining(String searchValue, Pageable paging);
}
