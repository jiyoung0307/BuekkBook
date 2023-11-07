package com.bukkeubook.book.books.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bukkeubook.book.books.model.entity.RelBkListAndBookAndRelList;
import com.bukkeubook.book.books.model.entity.StockBookListAndBookAndStockListAndEmp;

@Repository
public interface StockBookListAndBookAndStockListAndEmpRepository extends JpaRepository<StockBookListAndBookAndStockListAndEmp, Integer>  {

	List<StockBookListAndBookAndStockListAndEmp> findBystockListEmp_stCode(int no2);

}
