package com.bukkeubook.book.member.model.dto;

public class RoleDTO {
//	ROLE_CODE	NUMBER				// 권한코드
//	ROLE_NAME	VARCHAR2(63 BYTE)	// 권한명
//	ROLE_DESC	VARCHAR2(255 BYTE)	// 권한설명
	
	private int roleCode;
	private String roleName;
	private String roleDesc;
	
	public RoleDTO() {
	}

	public RoleDTO(int roleCode, String roleName, String roleDesc) {
		this.roleCode = roleCode;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
	}

	public int getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(int roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	@Override
	public String toString() {
		return "RoleDTO [roleCode=" + roleCode + ", roleName=" + roleName + ", roleDesc=" + roleDesc + "]";
	}
	
	
	
}
