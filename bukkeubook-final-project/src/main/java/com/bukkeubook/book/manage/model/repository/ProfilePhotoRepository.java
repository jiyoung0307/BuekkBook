package com.bukkeubook.book.manage.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bukkeubook.book.manage.model.entity.ProfPhoto;

@Repository
public interface ProfilePhotoRepository  extends JpaRepository<ProfPhoto, Integer>{

	/* 사원 프로필 사진 수정 */
	ProfPhoto findByEmpNo(int empNo);

	/* 수정 페이지에서 Get으로 페이지 넘어갈때 쓰는 이전 프로필 사진 조회(내림차순) */
	List<ProfPhoto> findByEmpNo(int number, Sort descending);


}
