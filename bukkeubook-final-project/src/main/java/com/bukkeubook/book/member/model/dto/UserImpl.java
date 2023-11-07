package com.bukkeubook.book.member.model.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.bukkeubook.book.main.model.dto.EmpAndMemberRoleDTO;
import com.bukkeubook.book.main.model.dto.MemberRoleAndRoleDTO;

public class UserImpl extends User{
	
	private int empNo;
	private String empName;
	private String empPhone1;
	private String empPhone2;
	private String empPhone3;
	private java.sql.Date empBirth;
	private String empGender;
	private String empEmail;   
	private String empJobCode;
	private String empAddress;
	private String empDAddress;
	private java.sql.Date empEntDate;
	private java.sql.Date empEndDate;
	private String empEndYn;
	private String empPwd;
	private int deptCode;
	
	private List<MemberRoleAndRoleDTO> memberRoleAndRoleList = new ArrayList<>();		// 회원별권한리스트
	
	public UserImpl(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public void setDetails(EmpAndMemberRoleDTO emp) {
	    this.empNo = emp.getEmpNo();
	    this.empName = emp.getEmpName();
	    this.empPhone1 = emp.getEmpPhone1();
	    this.empPhone2 = emp.getEmpPhone2();
	    this.empPhone3 = emp.getEmpPhone3();
	    this.empBirth = emp.getEmpBirth();
	    this.empGender = emp.getEmpGender();
	    this.empEmail = emp.getEmpEmail();
	    this.empJobCode = emp.getEmpJobCode();
	    this.empAddress = emp.getEmpAddress();
	    this.empDAddress = emp.getEmpDAddress();
	    this.empEntDate = emp.getEmpEntDate();
	    this.empEndDate = emp.getEmpEndDate();
	    this.empEndYn = emp.getEmpEndYn();
	    this.empPwd = emp.getEmpPwd();
	    this.deptCode = emp.getDeptCode();
	    this.memberRoleAndRoleList = emp.getMemberRoleAndRoleList();		
	}

	public int getEmpNo() {
		return empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public String getEmpPhone1() {
		return empPhone1;
	}

	public String getEmpPhone2() {
		return empPhone2;
	}

	public String getEmpPhone3() {
		return empPhone3;
	}

	public java.sql.Date getEmpBirth() {
		return empBirth;
	}

	public String getEmpGender() {
		return empGender;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public String getEmpJobCode() {
		return empJobCode;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public String getEmpDAddress() {
		return empDAddress;
	}

	public java.sql.Date getEmpEntDate() {
		return empEntDate;
	}

	public java.sql.Date getEmpEndDate() {
		return empEndDate;
	}

	public String getEmpEndYn() {
		return empEndYn;
	}

	public String getEmpPwd() {
		return empPwd;
	}

	public int getDeptCode() {
		return deptCode;
	}

	public List<MemberRoleAndRoleDTO> getMemberRoleAndRoleList() {
		return memberRoleAndRoleList;
	}

	@Override
	public String toString() {
		return "UserImpl [empNo=" + empNo + ", empName=" + empName + ", empPhone1=" + empPhone1 + ", empPhone2="
				+ empPhone2 + ", empPhone3=" + empPhone3 + ", empBirth=" + empBirth + ", empGender=" + empGender
				+ ", empEmail=" + empEmail + ", empJobCode=" + empJobCode + ", empAddress=" + empAddress
				+ ", empDAddress=" + empDAddress + ", empEntDate=" + empEntDate + ", empEndDate=" + empEndDate
				+ ", empEndYn=" + empEndYn + ", empPwd=" + empPwd + ", deptCode=" + deptCode
				+ ", memberRoleAndRoleList=" + memberRoleAndRoleList + "]";
	}

	
	
	
}
