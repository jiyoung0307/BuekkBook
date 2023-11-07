package com.bukkeubook.book.books.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bukkeubook.book.books.model.entity.RelBkList;

@Repository
public interface BookOutputRepository2 extends JpaRepository<RelBkList, Integer>{

}
