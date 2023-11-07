package com.bukkeubook.book.manage.model.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bukkeubook.book.manage.model.dto.SignDTO;
import com.bukkeubook.book.manage.model.dto.joinDTO.EmpAndDeptDTO;
import com.bukkeubook.book.manage.model.entity.EmpAndDept;
import com.bukkeubook.book.manage.model.entity.Sign;
import com.bukkeubook.book.manage.model.repository.EmpSignRepository;

@Service
public class SignService {
	
	private final EmpSignRepository empSignRepository;
	private ModelMapper modelMapper;
	
	@Autowired
	public SignService(ModelMapper modelMapper, EmpSignRepository empSignRepository) {
		this.empSignRepository = empSignRepository;
		this.modelMapper = modelMapper;
		
	}
	
	/*  도장 사진 등록(변경)*/
	@Transactional
	public void registSign(SignDTO sign) {
		
		empSignRepository.save(modelMapper.map(sign, Sign.class));
		
	}

	/* 도장 사진 등록(회원 가입) */
	@Transactional
	public void registEmpNameFile(SignDTO signFile) {
		
		empSignRepository.save(modelMapper.map(signFile, Sign.class));
		
	}
	
	/******************************************************************/
	/* 사원 상세페이지에서 Get으로 수정 페이지로 넘어갈 때 쓰는 서명 조회 */
	public SignDTO findEmpSign(int number) {
		Sign sign = empSignRepository.findByEmpNo(number);
		
		return modelMapper.map(sign, SignDTO.class);
	}
	
	/* 사원 정보 수정 서명 */
	@Transactional
	public void modifySign(SignDTO sign) {
		
		empSignRepository.save(modelMapper.map(sign, Sign.class));
		
		Sign empSign = empSignRepository.findByEmpNo(sign.getEmpNo());
		empSign.setSignName(sign.getSignName());
		empSign.setSignSavedName(sign.getSignSavedName());
		
	}


}

