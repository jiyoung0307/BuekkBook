package com.bukkeubook.book.books.model.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bukkeubook.book.books.model.entity.StockListAndEmp;

public interface InputRepository extends JpaRepository<StockListAndEmp, Integer>  {

	List<StockListAndEmp> findAllByEmp_EmpNameContaining(String searchValue, Pageable paging);
	
	@Query(value = "SELECT A.ST_DATE FROM TBL_STOCK_LIST A WHERE A.ST_DATE LIKE :searchValue", nativeQuery = true)
	List<StockListAndEmp> searchDate(@Param("searchValue")String searchValue, Pageable paging);
//	List<StockListAndEmp> findAllByStDateContaining(String searchValue, Pageable paging);
	
	@Query(value = "SELECT COUNT(ST_DATE) FROM TBL_STOCK_LIST WHERE ST_DATE LIKE :searchValue", nativeQuery = true)
	int countBystDateContaining(@Param("searchValue")String searchValue);
	
}
