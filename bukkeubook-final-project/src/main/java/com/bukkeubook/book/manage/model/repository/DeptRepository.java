package com.bukkeubook.book.manage.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bukkeubook.book.manage.model.entity.DeptAndEmp2;

@Repository
public interface DeptRepository extends JpaRepository<DeptAndEmp2, Integer>{

}
