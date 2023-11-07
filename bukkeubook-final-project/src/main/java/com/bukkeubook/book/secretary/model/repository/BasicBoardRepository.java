package com.bukkeubook.book.secretary.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bukkeubook.book.secretary.model.entity.Board;


public interface BasicBoardRepository extends JpaRepository<Board, Integer>{

}
