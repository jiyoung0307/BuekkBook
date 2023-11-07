package com.bukkeubook.book.mypage.model.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bukkeubook.book.mypage.model.entity.Calendar;

public interface CalendarRepository extends JpaRepository<Calendar, Integer>{

	List<Calendar> findAllByEmpNo(int memberCode);

}
