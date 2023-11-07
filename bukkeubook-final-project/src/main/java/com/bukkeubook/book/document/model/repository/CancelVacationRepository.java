package com.bukkeubook.book.document.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bukkeubook.book.document.model.entity.DocCancelVacation;

public interface CancelVacationRepository extends JpaRepository<DocCancelVacation, Object>{

	@Query(value = "SELECT MAX(a.vacCancNo) FROM DocCancelVacation a")
	int findCurrentSeq();

	List<DocCancelVacation> findByEmpNo(int empNo, Sort sort);
}
