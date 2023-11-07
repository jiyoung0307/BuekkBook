package com.bukkeubook.book.secretary.model.repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bukkeubook.book.secretary.model.entity.BoardAndEmpAndBoardCate;

public interface SecretaryBoardRepository extends JpaRepository<BoardAndEmpAndBoardCate, Integer>{

	List<BoardAndEmpAndBoardCate> findByBoardYn(String string);



	int countByBoardYnAndEmp_EmpNameContaining(String string, String searchValue);



	int countByBoardYnAndTitleContaining(String string, String searchValue);



	int countByBoardYnAndCate_CateNameContaining(String string, String searchValue);



	List<BoardAndEmpAndBoardCate> findByBoardYnAndEmp_EmpNameContaining(String string, String searchValue,
			Pageable paging);



	List<BoardAndEmpAndBoardCate> findByBoardYnAndTitleContaining(String string, String searchValue, Pageable paging);



	List<BoardAndEmpAndBoardCate> findByBoardYnAndCate_CateNameContaining(String string, String searchValue,
			Pageable paging);



	int countByBoardYn(String string);



	List<BoardAndEmpAndBoardCate> findByBoardYn(String string, Pageable paging);







}
