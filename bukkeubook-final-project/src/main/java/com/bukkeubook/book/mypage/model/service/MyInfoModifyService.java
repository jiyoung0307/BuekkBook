package com.bukkeubook.book.mypage.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bukkeubook.book.manage.model.dto.EmpDTO;
import com.bukkeubook.book.manage.model.dto.joinDTO.EmpAndDeptDTO;
import com.bukkeubook.book.manage.model.entity.EmpAndDept;
import com.bukkeubook.book.mypage.model.dto.ProfPhotoDTO;
import com.bukkeubook.book.mypage.model.dto.SignDTO;
import com.bukkeubook.book.mypage.model.entity.ProfPhoto;
import com.bukkeubook.book.mypage.model.entity.Sign;
import com.bukkeubook.book.mypage.model.repository.EmployeeRepository;
import com.bukkeubook.book.mypage.model.repository.ProfileRepository;
import com.bukkeubook.book.mypage.model.repository.SignRepository;

@Service
public class MyInfoModifyService {
	
	private final EmployeeRepository employeeRepository;
	private final ProfileRepository profileRepository;
	private final SignRepository signRepository;
	private ModelMapper modelMapper;
	
	@Autowired
	public MyInfoModifyService(EmployeeRepository employeeRepository, ModelMapper modelMapper, ProfileRepository profileRepository, SignRepository signRepository) {
		this.employeeRepository = employeeRepository;
		this.profileRepository = profileRepository;
		this.signRepository = signRepository;
		this.modelMapper = modelMapper;
		
	}
	
	/* 마이페이지 개인정보 수정 화면 이동 */
	public EmpAndDeptDTO findMyInfo(int memberCode) {
		
		EmpAndDept myInfo = employeeRepository.findById(memberCode).get();
		
		return modelMapper.map(myInfo, EmpAndDeptDTO.class);
	}

	/* 마이페이지 개인정보 수정하기 */
	@Transactional
	public boolean modifyInfoEmp(int memberCode, EmpDTO emp) {
		
		try {
			EmpAndDept myInfo = employeeRepository.findById(memberCode).get();
			myInfo.setEmpEmail(emp.getEmpEmail());
			myInfo.setEmpAddress(emp.getEmpAddress());
			myInfo.setEmpDAddress(emp.getEmpDAddress());
			myInfo.setEmpPhone1(emp.getEmpPhone1());
			myInfo.setEmpPhone2(emp.getEmpPhone2());
			myInfo.setEmpPhone3(emp.getEmpPhone3());
			
		}catch(IllegalArgumentException exception) {
            return false;
		}
		
		return true;
		
	}
	
	/* 프로필 사진 등록(변경)*/
	@Transactional
	public void registProfile(ProfPhotoDTO profile) {
		
		profileRepository.save(modelMapper.map(profile, ProfPhoto.class));
		
	}
	
	/* 프로필 사진 조회 */
	public List<ProfPhotoDTO> findMyProfile(int memberCode) {
		
		List<ProfPhoto> myProfile = profileRepository.findByEmpNo(memberCode, Sort.by("photoNo").descending());
		
		return myProfile.stream().map(profile -> modelMapper.map(profile, ProfPhotoDTO.class)).collect(Collectors.toList());
	}
	
	/* 현재 서명 조회 */
	public SignDTO findMySign(int memberCode) {
		Sign mySign = signRepository.findByEmpNo(memberCode);
		
		return modelMapper.map(mySign, SignDTO.class);
	}
	
	/* 마이페이지에서 서명 수정하기 */
	@Transactional
	public void modifySign(SignDTO sign) {
		
		Sign mySign = signRepository.findByEmpNo(sign.getEmpNo());
		mySign.setSignName(sign.getSignName());
		mySign.setSignSavedName(sign.getSignSavedName());
		
		
	}
	

}
