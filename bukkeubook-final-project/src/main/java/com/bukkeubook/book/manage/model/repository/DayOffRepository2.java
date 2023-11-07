package com.bukkeubook.book.manage.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bukkeubook.book.manage.model.entity.DayOff;
import com.bukkeubook.book.manage.model.entity.DayOffAndEmpAndDept;

@Repository
public interface DayOffRepository2 extends JpaRepository <DayOff, Integer> {

	DayOffAndEmpAndDept findByEmpNo(int empNo);

}
