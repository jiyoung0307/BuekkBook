package com.bukkeubook.book.manage.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bukkeubook.book.manage.model.entity.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Object>{

	List<Salary> findByEmpNo(int empNo, Sort sort);

}
