package com.bukkeubook.book.manage.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bukkeubook.book.manage.model.dto.joinDTO.EmpAndDeptDTO;
import com.bukkeubook.book.manage.model.entity.EmpAndDept;
@Repository
public interface EmpAndDeptRepository extends JpaRepository<EmpAndDept, Integer>{

	EmpAndDept findByEmpNo(int empNo);


}
