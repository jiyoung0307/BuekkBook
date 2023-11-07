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

import com.bukkeubook.book.books.model.dto.OrderAndEmpAndBookDTO;
import com.bukkeubook.book.books.model.entity.OrderAndEmpAndBook;
import com.bukkeubook.book.common.paging.SelectCriteria;
import com.bukkeubook.book.finance.model.dto.ClientDTO;
import com.bukkeubook.book.finance.model.entity.Client;
import com.bukkeubook.book.finance.model.repository.ClientRepository;

@Service
public class ClientService {

	private final ClientRepository clientRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public ClientService(ClientRepository clientRepository, ModelMapper modelMapper) {
		this.clientRepository = clientRepository;
		this.modelMapper = modelMapper;
	}

	@Transactional
	public int selectTotalCount(String searchCondition, String searchValue) {
		int count = 0;
		if(searchValue != null) {
			count = clientRepository.countByCntTradeYnContaining(searchValue);
		} else {
			count = (int)clientRepository.count();
		}

		return count;
	}

	@Transactional
	public List<ClientDTO> searchClientList(SelectCriteria selectCriteria) {

		int index = selectCriteria.getPageNo() - 1;
		int count = selectCriteria.getLimit();
		String searchValue = selectCriteria.getSearchValue();

		Pageable paging = PageRequest.of(index, count, Sort.by("cntNo"));

		List<Client> clientList = new ArrayList<Client>();
		if(searchValue != null) {
			clientList = clientRepository.findByCntNameContaining(searchValue, paging);
		} else {
			clientList = clientRepository.findAll(paging).toList();
		}

		/* 자바의 Stream API와 ModelMapper를 이용하여 entity를 DTO로 변환 후 List<MenuDTO>로 반환 */
		return clientList.stream().map(Client -> modelMapper.map(Client, ClientDTO.class)).collect(Collectors.toList());
	}

	@Transactional
	public ClientDTO searchClientDetail(int cntNo) {

		Client client = clientRepository.findById(cntNo).get();
		
		return modelMapper.map(client, ClientDTO.class);
	}

	@Transactional
	public void registClient(ClientDTO newClient) {
		
		clientRepository.save(modelMapper.map(newClient, Client.class));
	}

	@Transactional
	public void modifyClient(int cntNo, ClientDTO client) {

		Client foundClient = clientRepository.findById(cntNo).get();

		foundClient.setCntName(client.getCntName());
		foundClient.setCntCate(client.getCntCate());
		foundClient.setCntType(client.getCntType());
		foundClient.setCntRepName(client.getCntRepName());
		foundClient.setCntAddress(client.getCntAddress());
		foundClient.setCntPhone(client.getCntPhone());
		foundClient.setCntManaName(client.getCntManaName());
		foundClient.setCntEmail(client.getCntEmail());
		foundClient.setCntManaPhone(client.getCntManaPhone());
		foundClient.setCntFax(client.getCntFax());
		foundClient.setCntManaEmail(client.getCntManaEmail());
	}

	@Transactional
	public void stopClient(int cntNo) {
		
		Client foundClient = clientRepository.findById(cntNo).get();
		
		System.out.println("Service 에서 Client : " +foundClient);
		
		foundClient.setCntTradeYn("N");
		
	}

	@Transactional
	public void startClient(int cntNo) {
		
		Client foundClient = clientRepository.findById(cntNo).get();
		
		System.out.println("Service 에서 Client : " +foundClient);
		
		foundClient.setCntTradeYn("Y");
		
	}

}
