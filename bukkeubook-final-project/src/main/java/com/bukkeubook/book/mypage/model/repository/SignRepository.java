package com.bukkeubook.book.mypage.model.repository;

import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;

import com.bukkeubook.book.mypage.model.entity.Sign;

public interface SignRepository extends JpaRepository<Sign, Integer>{

	Sign findByEmpNo(int memberCode);


}
