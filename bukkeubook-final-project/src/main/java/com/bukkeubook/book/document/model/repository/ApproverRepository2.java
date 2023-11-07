package com.bukkeubook.book.document.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bukkeubook.book.document.model.entity.Approver;
import com.bukkeubook.book.document.model.entity.SubmitApprover;

public interface ApproverRepository2 extends JpaRepository<Approver, Object>{

	@Query("SELECT a.appRootNo, a.appStatus FROM Approver a WHERE a.empNo = ?1")
	List<Object[]> findByApproverNoDocList(int empNo);

	Approver findByEmpNoAndAppRootNo(int empNo, int appRootNo);

	Approver findByAppRootNoAndAppStatus(int appRootNo, String app);

	List<Approver> findByAppRootNoAndAppNoNot(int appRootNo, int mine);


	
}
