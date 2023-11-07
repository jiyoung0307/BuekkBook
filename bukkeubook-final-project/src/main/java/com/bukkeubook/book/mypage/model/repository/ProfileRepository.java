package com.bukkeubook.book.mypage.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bukkeubook.book.mypage.model.entity.ProfPhoto;

public interface ProfileRepository extends JpaRepository<ProfPhoto, Integer>{

	List<ProfPhoto> findByEmpNo(int memberCode, Sort descending);

}
