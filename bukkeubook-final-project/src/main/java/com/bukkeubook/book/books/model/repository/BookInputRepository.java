package com.bukkeubook.book.books.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bukkeubook.book.books.model.entity.StockList;

@Repository
public interface BookInputRepository extends JpaRepository<StockList, Integer> {

}
