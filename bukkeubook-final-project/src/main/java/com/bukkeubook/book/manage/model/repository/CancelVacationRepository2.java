package com.bukkeubook.book.manage.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bukkeubook.book.manage.model.entity.CancelVacation;

@Repository
public interface CancelVacationRepository2 extends JpaRepository<CancelVacation, Integer> {
	
}
