package com.bukkeubook.book.finance.model.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bukkeubook.book.finance.model.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

	int countByCntTradeYnContaining(String searchValue);

	List<Client> findByCntNameContaining(String searchValue, Pageable paging);

}
