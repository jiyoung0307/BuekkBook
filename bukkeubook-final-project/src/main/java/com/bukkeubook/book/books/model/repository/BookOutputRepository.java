package com.bukkeubook.book.books.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bukkeubook.book.books.model.entity.RelList;

public interface BookOutputRepository extends JpaRepository<RelList, Integer>{

}
