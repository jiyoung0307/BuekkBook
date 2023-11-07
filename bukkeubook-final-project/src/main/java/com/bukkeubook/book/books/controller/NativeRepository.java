package com.bukkeubook.book.books.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bukkeubook.book.books.model.entity.Book;

public interface NativeRepository extends JpaRepository<Book, Integer>{
	
	@Query(value = "SELECT 'BOOK-'||(TO_NUMBER(SUBSTR(MAX(BK_NO), 6, 2))+1) FROM TBL_BOOK", nativeQuery = true)
	String newBookCode();
	
	@Query(value = "SELECT SEQ_REL_NO.CURRVAL FROM DUAL", nativeQuery = true)
	int newRelNo();
	
	@Query(value = "SELECT SEQ_ST_CODE.CURRVAL FROM DUAL", nativeQuery = true)
	int newStCode();
	
	
}
