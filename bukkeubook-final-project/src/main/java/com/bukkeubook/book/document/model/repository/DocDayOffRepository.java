package com.bukkeubook.book.document.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bukkeubook.book.document.model.entity.DocDayOff;

public interface DocDayOffRepository extends JpaRepository <DocDayOff, Object>{

	DocDayOff findByEmpNo(int empNo);

}
