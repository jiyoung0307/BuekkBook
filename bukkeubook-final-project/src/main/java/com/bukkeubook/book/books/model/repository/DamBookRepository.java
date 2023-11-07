package com.bukkeubook.book.books.model.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bukkeubook.book.books.model.dto.DamBookDTO;
import com.bukkeubook.book.books.model.entity.DamBook;
@Repository
public interface DamBookRepository extends JpaRepository<DamBook, Integer>  {

	DamBook findBybkNo(String no);

//	List<DamBook> findByNameContaining(String searchValue, Pageable paging);
//
//	List<DamBook> findByAuthorContaining(String searchValue, Pageable paging);
//
//	List<DamBook> findByNoContaining(String searchValue, Pageable paging);
	
}
