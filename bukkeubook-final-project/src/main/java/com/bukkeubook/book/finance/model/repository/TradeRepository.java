package com.bukkeubook.book.finance.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bukkeubook.book.finance.model.entity.TradeList;

@Repository
public interface TradeRepository extends JpaRepository<TradeList, Integer>{

	int countByTlDateContaining(String searchValue);

}
