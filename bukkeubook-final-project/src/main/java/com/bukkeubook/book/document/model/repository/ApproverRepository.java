package com.bukkeubook.book.document.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bukkeubook.book.document.model.entity.Approver;
import com.bukkeubook.book.document.model.entity.SubmitApprover;

public interface ApproverRepository extends JpaRepository<SubmitApprover, Integer>{


}
