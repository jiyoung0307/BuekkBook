package com.bukkeubook.book.member.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bukkeubook.book.main.model.entity.EmpAndMemberRole;
import com.bukkeubook.book.manage.model.entity.Emp;

public interface MemberRepository extends JpaRepository<EmpAndMemberRole, Integer> {

	EmpAndMemberRole findByEmpNo(int empNo2);

}
