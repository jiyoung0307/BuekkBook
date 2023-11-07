package com.bukkeubook.book.mypage.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bukkeubook.book.manage.model.entity.DayOff;

public interface DayOffRepository extends JpaRepository<DayOff, Integer>{

	List<DayOff> findAllByEmpNo(int memberCode);
	
}
