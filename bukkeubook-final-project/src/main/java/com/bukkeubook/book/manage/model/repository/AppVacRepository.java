package com.bukkeubook.book.manage.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bukkeubook.book.manage.model.entity.DayOff;

@Repository
// Repository랑 Service는 이름 맞출 것
public interface AppVacRepository extends JpaRepository<DayOff, Integer> {
	
	// 휴가에서 값을 꺼내서 연차에 트랜잭션 하는 부분 중 조회
	DayOff findByEmpNo(int empNo);
	
	
}
