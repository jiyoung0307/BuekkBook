package com.bukkeubook.book.books.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bukkeubook.book.books.model.dto.BookDTO;
import com.bukkeubook.book.books.model.dto.OrderAndEmpAndBookDTO;
import com.bukkeubook.book.books.model.dto.OrderListDTO;
import com.bukkeubook.book.books.model.entity.Book;
import com.bukkeubook.book.books.model.entity.OrderAndEmpAndBook;
import com.bukkeubook.book.books.model.entity.OrderList;
import com.bukkeubook.book.books.model.repository.BookRepository;
import com.bukkeubook.book.books.model.repository.OrderRepository;
import com.bukkeubook.book.books.model.repository.SimpleOrderRepository;
import com.bukkeubook.book.common.paging.SelectCriteria;

@Service
public class OrderService {

	private final OrderRepository orderRepository;
	private final SimpleOrderRepository simpleOrderRepository;
	private final BookRepository bookRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public OrderService(OrderRepository orderRepository, SimpleOrderRepository simpleOrderRepository, BookRepository bookRepository, ModelMapper modelMapper) {
		this.orderRepository = orderRepository;
		this.simpleOrderRepository = simpleOrderRepository;
		this.bookRepository = bookRepository;
		this.modelMapper = modelMapper;
	}
	
	@Transactional
	public int selectTotalCount(String searchCondition, String searchValue) {
		int count = 0;
		if(searchValue != null) {
			count = orderRepository.countByOrderApprYnContaining(searchValue);
		} else {
			count = (int)orderRepository.count();
		}

		return count;
	}

	@Transactional
	public List<OrderAndEmpAndBookDTO> searchOrderList(SelectCriteria selectCriteria) {

		int index = selectCriteria.getPageNo() - 1;
		int count = selectCriteria.getLimit();
		String searchValue = selectCriteria.getSearchValue();

		Pageable paging = PageRequest.of(index, count, Sort.by("orderDate").descending());

		List<OrderAndEmpAndBook> orderHistoryList = new ArrayList<OrderAndEmpAndBook>();
		if(searchValue != null) {
			orderHistoryList = orderRepository.findByOrderApprYnContaining(selectCriteria.getSearchValue(), paging);
		} else {
			orderHistoryList = orderRepository.findAll(paging).toList();
		}

		/* 자바의 Stream API와 ModelMapper를 이용하여 entity를 DTO로 변환 후 List<MenuDTO>로 반환 */
		return orderHistoryList.stream().map(OrderList -> modelMapper.map(OrderList, OrderAndEmpAndBookDTO.class)).collect(Collectors.toList());
	}

	@Transactional
	public OrderAndEmpAndBookDTO searchOrderDetail(int orderNo) {
		
		OrderAndEmpAndBook order = orderRepository.findById(orderNo).get();
		
		return modelMapper.map(order, OrderAndEmpAndBookDTO.class);
	}

	@Transactional
	public Boolean registOrder(OrderListDTO order) {
		
		try{
			simpleOrderRepository.save(modelMapper.map(order, OrderList.class));
		} catch(IllegalArgumentException e){
			return false;
		}
		
		return true;
	}

	public List<BookDTO> searchOrderList(String searchCondition, String searchValue) {
		
		List<Book> bookList = new ArrayList<Book>();
		if(searchValue != null) {

			if("name".equals(searchCondition)) {
				bookList = bookRepository.findByNameContaining(searchValue, Sort.by("no"));
			}

			if("author".equals(searchCondition)) {
				bookList = bookRepository.findByAuthorContaining(searchValue, Sort.by("no"));
			}
			
			if("no".equals(searchCondition)) {
				bookList = bookRepository.findByNoContaining(searchValue, Sort.by("no"));
			}
		} else {
			bookList = bookRepository.findAll(Sort.by("no"));
		}
		
		/* 자바의 Stream API와 ModelMapper를 이용하여 entity를 DTO로 변환 후 List<MenuDTO>로 반환 */
		return bookList.stream().map(Book -> modelMapper.map(Book, BookDTO.class)).collect(Collectors.toList());
	}

}
