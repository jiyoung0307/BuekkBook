package com.bukkeubook.book.mypage.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bukkeubook.book.manage.model.entity.EmpAndDept;

public interface EmployeeRepository extends JpaRepository<EmpAndDept, Integer>{


}
