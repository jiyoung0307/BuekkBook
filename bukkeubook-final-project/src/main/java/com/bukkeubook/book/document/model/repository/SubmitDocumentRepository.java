package com.bukkeubook.book.document.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bukkeubook.book.document.model.entity.Document;
import com.bukkeubook.book.document.model.entity.SubmitDocument;

public interface SubmitDocumentRepository extends JpaRepository<SubmitDocument, Integer>{

	@Query(value = "SELECT MAX(d.docNo2) FROM SubmitDocument d")
	int findCurrentSeqDoc();

}
