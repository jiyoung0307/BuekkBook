package com.bukkeubook.book.manage.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bukkeubook.book.manage.model.entity.LaborContFile;

public interface LaborContFileRepository extends JpaRepository<LaborContFile, Integer>{


	LaborContFile findByContNo(int code);

	LaborContFile findBycfileNo(int id);

}
