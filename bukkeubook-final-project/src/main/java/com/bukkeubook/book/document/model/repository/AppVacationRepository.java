package com.bukkeubook.book.document.model.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bukkeubook.book.document.model.entity.DocAppVacation;

public interface AppVacationRepository extends JpaRepository<DocAppVacation, Object>{
	
	@Query(value = "SELECT MAX(a.vacNo) FROM DocAppVacation a")
	int findCurrentSeq();

	List<DocAppVacation> findByEmpNo(int empNo, Sort sort);

	int countByVacStartDateContaining(Date searchValue);

	int countByVacEndDateContaining(Date searchValue);

	int countByVacAppNoContaining(Date searchValue);
}
