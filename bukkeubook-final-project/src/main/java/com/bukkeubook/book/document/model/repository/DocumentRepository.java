package com.bukkeubook.book.document.model.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bukkeubook.book.document.model.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Object>{

	@Query(value = "SELECT MAX(d.docNo1) FROM Document d")
	int findCurrentSeqDoc();

}
