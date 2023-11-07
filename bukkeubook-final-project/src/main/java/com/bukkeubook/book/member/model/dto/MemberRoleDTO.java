package com.bukkeubook.book.member.model.dto;

public class MemberRoleDTO {
//	EMP_NO	NUMBER		사원번호
//	ROLE_CODE	NUMBER	권한코드
	
	private int empNo;
	private int roleCode;
	
	private RoleDTO role;

	public MemberRoleDTO() {
	}

	public MemberRoleDTO(int empNo, int roleCode, RoleDTO role) {
		this.empNo = empNo;
		this.roleCode = roleCode;
		this.role = role;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public int getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(int roleCode) {
		this.roleCode = roleCode;
	}

	public RoleDTO getRole() {
		return role;
	}

	public void setRole(RoleDTO role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "MemberRoleDTO [empNo=" + empNo + ", roleCode=" + roleCode + ", role=" + role + "]";
	}
	
	
	
}
