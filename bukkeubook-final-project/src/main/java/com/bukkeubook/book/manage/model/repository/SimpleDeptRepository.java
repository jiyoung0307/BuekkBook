package com.bukkeubook.book.manage.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bukkeubook.book.document.model.entity.Emp;
import com.bukkeubook.book.manage.model.entity.Dept;

public interface SimpleDeptRepository extends JpaRepository<Dept, Integer>{

	List<Emp> findByDeptCode(int dept, Sort descending);

}
