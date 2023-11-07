package com.bukkeubook.book.manage.model.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bukkeubook.book.document.model.entity.Emp;


@Repository
public interface SimpleEmpRepository extends JpaRepository<Emp, Integer>{

	int countByEmpNameContaining(String searchValue);

	int countByEmpJobCodeContaining(String searchValue);

	List<Emp> findByEmpNameContaining(String searchValue, Pageable paging);

	List<Emp> findByEmpJobCodeContaining(String searchValue, Pageable paging);

	List<Emp> findByEmpNameContaining(String searchValue, Sort by);

	List<Emp> findByEmpJobCodeContaining(String searchValue, Sort by);

}
