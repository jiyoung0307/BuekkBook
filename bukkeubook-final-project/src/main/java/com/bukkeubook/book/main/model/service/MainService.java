package com.bukkeubook.book.main.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bukkeubook.book.main.model.repository.BoardRepository;
import com.bukkeubook.book.secretary.model.dto.join.BoardAndCateDTO;
import com.bukkeubook.book.secretary.model.entity.BoardAndCate;

@Service
public class MainService {
	
	private final BoardRepository boardRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public MainService(BoardRepository boardRepository, ModelMapper modelMapper) {
		this.boardRepository = boardRepository;
		this.modelMapper = modelMapper;
	}
	
	/* 최근 전사 게시판 우선순위 5개 조회 */
	public List<BoardAndCateDTO> findBoardList() {
		
			List<BoardAndCate> boardList = boardRepository.findAll(Sort.by("no").descending());
		
		return boardList.stream().map(board -> modelMapper.map(board, BoardAndCateDTO.class)).collect(Collectors.toList());
	}

}
