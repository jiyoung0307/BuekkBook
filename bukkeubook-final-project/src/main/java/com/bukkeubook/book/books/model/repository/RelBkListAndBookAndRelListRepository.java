package com.bukkeubook.book.books.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bukkeubook.book.books.model.entity.RelBkListAndBookAndRelList;
@Repository
public interface RelBkListAndBookAndRelListRepository extends JpaRepository<RelBkListAndBookAndRelList, Integer> {
	
	
	@Query(value="SELECT A\r\n"
			
//			+ "       A.relBkCode\r\n"
//			+ "     , B.BK_NO\r\n"
//			+ "     , B.BK_NAME\r\n"
//			+ "     , A.REL_BK_AMOUNT    \r\n"
			+ "  FROM RelBkListAndBookAndRelList A\r\n")
//			+ "  JOIN TBL_BOOK B ON(B.BK_NO = A.BK_NO)\r\n"
//			+ "  JOIN TBL_REL_LIST C ON(A.REL_NO = C.REL_NO)\r\n"
//			+ " WHERE C.REL_NO = 20")
	List<RelBkListAndBookAndRelList> findAll();

	List<RelBkListAndBookAndRelList> findByrelListEmp_relNo(int no2);
	
}
