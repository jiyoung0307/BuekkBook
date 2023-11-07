package com.bukkeubook.book.secretary.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bukkeubook.book.secretary.model.entity.AppVacationAndEmpCal;

public interface VacListRepository extends JpaRepository<AppVacationAndEmpCal, Integer>{

	List<AppVacationAndEmpCal> findByVacStatus(String string);

}
