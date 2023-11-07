package com.bukkeubook.book.member.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bukkeubook.book.main.model.dto.EmpAndMemberRoleDTO;
import com.bukkeubook.book.main.model.dto.MemberRoleAndRoleDTO;
import com.bukkeubook.book.main.model.entity.EmpAndMemberRole;
import com.bukkeubook.book.member.model.dto.RoleDTO;
import com.bukkeubook.book.member.model.dto.UserImpl;
import com.bukkeubook.book.member.model.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{
	
	private final MemberRepository memberRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public MemberServiceImpl(ModelMapper modelMapper, MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
		this.modelMapper = modelMapper;
	}
	@Override
	public UserDetails loadUserByUsername(String empNo) throws UsernameNotFoundException {
		int empNo2 = Integer.valueOf(empNo);
		EmpAndMemberRole emp = memberRepository.findByEmpNo(empNo2);
		
		if(emp == null) {
			/* 여기서 퇴사사원 처리 */
			emp = new EmpAndMemberRole();
		}
		 
		EmpAndMemberRoleDTO emp2 = modelMapper.map(emp, EmpAndMemberRoleDTO.class);
		List<GrantedAuthority> authorities = new ArrayList<>();
		if(emp2.getMemberRoleAndRoleList() != null) {
			List<MemberRoleAndRoleDTO> roleList = emp2.getMemberRoleAndRoleList();
			
			for(int i = 0; i < roleList.size(); i++) {
				 RoleDTO role = roleList.get(i).getRole();
				 authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
			}
		}
		
		UserImpl user = new UserImpl(String.valueOf(emp.getEmpNo()), emp.getEmpPwd(), authorities);
		user.setDetails(emp2);
		System.out.println("유저정보" + user);
		
		/* 퇴사처리용 구현 중단 */
//		if(user.getEmpEndYn().equals("Y")) {
//			user = new UserImpl(empNo, empNo, authorities);
//		}
		return user;
	}
	
}
