package com.bukkeubook.book.finance.model.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bukkeubook.book.finance.model.entity.TradeAndClientAndBookAndEmp;

@Repository
public interface TradeJoinRepository extends JpaRepository<TradeAndClientAndBookAndEmp, Integer>{

	List<TradeAndClientAndBookAndEmp> findAllByClient_CntNameContaining(String searchValue, Pageable paging);

	List<TradeAndClientAndBookAndEmp> findAllByBook_NameContaining(String searchValue, Pageable paging);

	List<TradeAndClientAndBookAndEmp> findAllByEmp_EmpNameContaining(String searchValue, Pageable paging);

	int countByClient_CntNameContaining(String searchValue);

	int countByBook_NameContaining(String searchValue);

	int countByEmp_EmpNameContaining(String searchValue);
	
	
}
