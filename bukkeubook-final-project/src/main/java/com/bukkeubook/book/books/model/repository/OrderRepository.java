package com.bukkeubook.book.books.model.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bukkeubook.book.books.model.entity.OrderAndEmpAndBook;
import com.bukkeubook.book.books.model.entity.OrderList;

@Repository
public interface OrderRepository extends JpaRepository<OrderAndEmpAndBook, Integer>{

	int countByOrderApprYnContaining(String searchValue);

	List<OrderAndEmpAndBook> findByOrderApprYnContaining(String searchValue, Pageable paging);

}
