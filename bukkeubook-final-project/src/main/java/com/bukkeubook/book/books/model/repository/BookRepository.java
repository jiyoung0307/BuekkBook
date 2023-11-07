package com.bukkeubook.book.books.model.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bukkeubook.book.books.model.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	int countByNameContaining(String searchValue);

	int countByAuthorContaining(String searchValue);

	int countByNoContaining(String searchValue);
	
	List<Book> findByNameContaining(String searchValue, Pageable paging);

	List<Book> findByAuthorContaining(String searchValue, Pageable paging);

	List<Book> findByNoContaining(String searchValue, Pageable paging);

	List<Book> findBookByNo(String no);
	
	Book findByNo(String no);

	List<Book> findAllByNoContaining(String searchValue, Pageable paging);

	List<Book> findAllByNameContaining(String searchValue, Pageable paging);

	List<Book> findAllByAuthorContaining(String searchValue, Pageable paging);

	List<Book> findByNameContaining(String searchValue, Sort by);

	List<Book> findByAuthorContaining(String searchValue, Sort by);

	List<Book> findByNoContaining(String searchValue, Sort by);
	
	

	
	


		
		
	
	
	
}
