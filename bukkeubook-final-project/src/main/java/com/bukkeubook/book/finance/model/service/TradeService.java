package com.bukkeubook.book.finance.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bukkeubook.book.books.model.entity.Book;
import com.bukkeubook.book.common.paging.SelectCriteria;
import com.bukkeubook.book.finance.model.dto.TradeAndClientAndBookAndEmpDTO;
import com.bukkeubook.book.finance.model.dto.TradeListDTO;
import com.bukkeubook.book.finance.model.entity.Client;
import com.bukkeubook.book.finance.model.entity.TradeAndClientAndBookAndEmp;
import com.bukkeubook.book.finance.model.entity.TradeList;
import com.bukkeubook.book.finance.model.repository.TradeJoinRepository;
import com.bukkeubook.book.finance.model.repository.TradeRepository;

@Service
public class TradeService {

	private final TradeRepository tradeRepository;
	private final TradeJoinRepository tradeJoinRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public TradeService(TradeRepository tradeRepository, TradeJoinRepository tradeJoinRepository, ModelMapper modelMapper) {
		this.tradeRepository = tradeRepository;
		this.tradeJoinRepository = tradeJoinRepository;
		this.modelMapper = modelMapper;
	}

	@Transactional
	public int selectTotalCount(String searchCondition, String searchValue) {
		int count = 0;
		if(searchValue != null) {
			if("client".equals(searchCondition)) {
				count = tradeJoinRepository.countByClient_CntNameContaining(searchValue);
			}

			if("book".equals(searchCondition)) {
				count = tradeJoinRepository.countByBook_NameContaining(searchValue);
			}
			
			if("emp".equals(searchCondition)) {
				count = tradeJoinRepository.countByEmp_EmpNameContaining(searchValue);
			}
		} else {
			count = (int)tradeJoinRepository.count();
		}

		return count;
	}

	@Transactional
	public List<TradeAndClientAndBookAndEmpDTO> searchTradeList(SelectCriteria selectCriteria) {
		
		int index = selectCriteria.getPageNo() - 1;
		int count = selectCriteria.getLimit();
		String searchValue = selectCriteria.getSearchValue();

		Pageable paging = PageRequest.of(index, count, Sort.by("tlDate").descending());

		List<TradeAndClientAndBookAndEmp> tradeList = new ArrayList<TradeAndClientAndBookAndEmp>();
		if(searchValue != null) {

			if("client".equals(selectCriteria.getSearchCondition())) {
				tradeList = tradeJoinRepository.findAllByClient_CntNameContaining(selectCriteria.getSearchValue(), paging);
			}

			if("book".equals(selectCriteria.getSearchCondition())) {
				tradeList = tradeJoinRepository.findAllByBook_NameContaining(selectCriteria.getSearchValue(), paging);
			}
			
			if("emp".equals(selectCriteria.getSearchCondition())) {
				tradeList = tradeJoinRepository.findAllByEmp_EmpNameContaining(selectCriteria.getSearchValue(), paging);
			}
		} else {
			tradeList = tradeJoinRepository.findAll(paging).toList();
		}

		/* 자바의 Stream API와 ModelMapper를 이용하여 entity를 DTO로 변환 후 List<MenuDTO>로 반환 */
		return tradeList.stream().map(TradeAndClientAndBookAndEmp -> modelMapper.map(TradeAndClientAndBookAndEmp, TradeAndClientAndBookAndEmpDTO.class)).collect(Collectors.toList());
	}

	@Transactional
	public TradeAndClientAndBookAndEmpDTO searchTradeDetail(int tlNo) {

		TradeAndClientAndBookAndEmp trade = tradeJoinRepository.findById(tlNo).get();
		
		return modelMapper.map(trade, TradeAndClientAndBookAndEmpDTO.class);
	}

	@Transactional
	public void registTrade(TradeListDTO newTrade) {
		
		tradeRepository.save(modelMapper.map(newTrade, TradeList.class));
		
	}

	@Transactional
	public void modifyTrade(int tlNo, TradeListDTO trade) {
		
		TradeList foundTrade = tradeRepository.findById(tlNo).get();
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("trade : " + trade);
		System.out.println("Service : " + foundTrade);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		foundTrade.setBkNo(trade.getBkNo());
		foundTrade.setCntNo(trade.getCntNo());
		foundTrade.setTlDate(trade.getTlDate());
		foundTrade.setTlAmount(trade.getTlAmount());
		foundTrade.setTlDetail(trade.getTlDetail());
		
	}
}
