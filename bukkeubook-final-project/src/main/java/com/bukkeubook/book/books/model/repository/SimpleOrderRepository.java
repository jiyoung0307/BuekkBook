package com.bukkeubook.book.books.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bukkeubook.book.books.model.entity.OrderList;

public interface SimpleOrderRepository extends JpaRepository<OrderList, Integer>{

}
