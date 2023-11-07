package com.bukkeubook.book.document.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bukkeubook.book.document.model.entity.Dept;

public interface DocDeptRepository extends JpaRepository<Dept, Integer>{

}
