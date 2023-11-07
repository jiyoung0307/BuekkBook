package com.bukkeubook.book.manage.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bukkeubook.book.manage.model.entity.EmpCont;


public interface EmpContRepository extends JpaRepository<EmpCont, Integer>{

	void deleteByContNo(int No);

}
