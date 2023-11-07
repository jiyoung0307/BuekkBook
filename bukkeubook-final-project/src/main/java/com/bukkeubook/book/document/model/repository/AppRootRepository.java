package com.bukkeubook.book.document.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bukkeubook.book.document.model.entity.AppRoot;

public interface AppRootRepository extends JpaRepository <AppRoot,Object>{

	@Query(value = "SELECT MAX(a.appRootNo) FROM AppRoot a")
	int findCurrentSeqAccRoot();

	AppRoot findByDocNo(int docNo1);
	
}
